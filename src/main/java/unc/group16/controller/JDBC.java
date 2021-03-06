package unc.group16.controller;

import org.apache.log4j.Logger;
import unc.group16.data.interfaces.TableRecord;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


@SuppressWarnings("Duplicates")
public class JDBC {
    public static final Logger log = Logger.getLogger(JDBC.class);

    private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String user = "PIZZADB";
    private static final String password = "PIZZADB";

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            log.fatal("Oracle JDBC Driver not found", e);
        }

        /* Выставляем локаль для устранения ошибки
           ORA-00604: error occurred at recursive SQL level 1
           ORA-12705: Cannot access NLS entity files or invalid environment specified */
        Locale.setDefault(new Locale("EN", "US"));
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            log.error("Unable to connect");
            throw e;
        }
    }


    public Long insert(TableRecord record) {
        Long result = null;

        try (Connection connection = getConnection()) {
            result = insert(record, connection);
        } catch (SQLException e) {
            log.error("Inserting failed", e);
        }

        return result;
    }

    public Long insert(TableRecord record, Connection con) {
        Table tableInfo = record.getClass().getDeclaredAnnotation(Table.class);

        String sql = "INSERT INTO " + tableInfo.name() + " VALUES (null" + new String(new char[record.getColumnsCnt()-1]).replace("\0", ", ?") + ")";

        try ( PreparedStatement ps = con.prepareStatement(sql, new int[] {1}) ) {
            Field[] fields = record.getClass().getDeclaredFields();
            int i = 0;
            for (Field field : fields) {
                Column columnAnnotation = field.getDeclaredAnnotation(Column.class);
                boolean isKey = field.isAnnotationPresent(Id.class);
                if (columnAnnotation != null && !isKey) {
                    try {
                        field.setAccessible(true);
                        Object data = field.get(record);
                        if (data instanceof Date) {
                            data = new Timestamp(((Date) data).getTime());
                        }
                        ps.setObject(++i, data);
                    } catch (IllegalAccessException e) {
                        log.error("Could not get access to field " + field.getName(), e);
                    }
                }
            }

            int rows = ps.executeUpdate();
            if (rows > 0) {
                log.debug("Inserted successfully");

                // Получение id записи
                try ( ResultSet generatedKeys = ps.getGeneratedKeys() ) {
                    if (generatedKeys != null && generatedKeys.next()) {
                        return generatedKeys.getLong(1);
                    } else {
                        log.error("Unable to return id");
                    }
                } catch (SQLException e) {
                    log.error("Unable to return id", e);
                }
            }
        } catch (SQLException e) {
            log.error("Inserting failed", e);
        }

        return null;
    }


    public TableRecord select(TableRecord record) {
        TableRecord result = null;

        try (Connection connection = getConnection()) {
            if (connection != null) {
                result = select(record, connection);
            }
        } catch (SQLException e) {
            log.error("Selecting failed", e);
        }

        return result;
    }

    public TableRecord select(TableRecord record, Connection con) {
        Table tableInfo = record.getClass().getDeclaredAnnotation(Table.class);

        StringBuilder sql = new StringBuilder("SELECT * FROM ")
                .append(tableInfo.name())
                .append(" WHERE ");

        Field[] fields = record.getClass().getDeclaredFields();
        for (Field field : fields) {
            Column columnAnnotation = field.getDeclaredAnnotation(Column.class);
            boolean isKey = field.isAnnotationPresent(Id.class);
            if (columnAnnotation != null && isKey) {
                try {
                    field.setAccessible(true);
                    sql.append(columnAnnotation.name())
                            .append("=")
                            .append(field.get(record));
                } catch (IllegalAccessException e) {
                    log.error("Could not get access to field " + field.getName(), e);
                }
                break;
            }
        }

        try ( PreparedStatement ps = con.prepareStatement(sql.toString()) ) {

            TableRecord[] result = executePreparedQuery(record.getClass(), ps);

            if (result.length > 0) {
                log.debug("Selected successfully");
                return result[0];
            } else {
                log.error("Unable to find record");
                return null;
            }


        } catch (SQLException e) {
            log.error("Selecting failed", e);
        } catch (IllegalAccessException e) {
            log.error("Selecting failed: illegal access", e);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }

    public TableRecord[] selectAll(Class<? extends TableRecord> table) {
        TableRecord[] result = null;

        try (Connection connection = getConnection()) {
            result = selectAll(table, connection);
        } catch (SQLException e) {
            log.error("Selecting failed", e);
        }

        return result;
    }

    public TableRecord[] selectAll(Class<? extends TableRecord> table, Connection con) {
        Table tableInfo = table.getDeclaredAnnotation(Table.class);

        String sql = "SELECT * FROM " + tableInfo.name();

        try ( PreparedStatement ps = con.prepareStatement(sql) ) {
            TableRecord[] result = executePreparedQuery(table, ps);
            log.debug("Selected successfully");
            return result;

        } catch (SQLException e) {
            log.error("Selecting failed", e);
        } catch (IllegalAccessException e) {
            log.error("Selecting failed: illegal access", e);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }


    public boolean update(TableRecord record) {
        boolean result = false;

        try (Connection connection = getConnection()) {
            result = update(record, connection);
        } catch (SQLException e) {
            log.error("Updating failed", e);
        }

        return result;
    }

    public boolean update(TableRecord record, Connection con) {
        Table tableInfo = record.getClass().getDeclaredAnnotation(Table.class);

        StringBuilder sql = new StringBuilder("UPDATE ")
                .append(tableInfo.name())
                .append(" SET");
        StringBuilder whereStatement = new StringBuilder(" WHERE ");

        Field[] fields = record.getClass().getDeclaredFields();
        int colCnt = 0;
        for (Field field : fields) {
            Column columnAnnotation = field.getDeclaredAnnotation(Column.class);
            if (columnAnnotation == null) {
                continue;
            }

            try {
                field.setAccessible(true);
                boolean isKey = field.isAnnotationPresent(Id.class);
                if (!isKey) {
                    if (field.get(record) == null) {
                        continue;
                    }
                    if (colCnt >= 1) {
                        sql.append(",");
                    }
                    sql.append(" ")
                            .append(columnAnnotation.name())
                            .append("=?");
                    colCnt++;
                } else {
                    if (field.get(record) == null) {
                        log.error("Key value must be not null");
                        return false;
                    }
                    whereStatement.append(columnAnnotation.name())
                            .append("=")
                            .append(field.get(record));
                }

            } catch (IllegalAccessException e) {
                log.error("Could not get access to field " + field.getName(), e);
            }
        }
        if (colCnt == 0) {
            log.error("At least one non key argument must be not null");
            return false;
        }
        sql.append(whereStatement);

        try (PreparedStatement ps = con.prepareStatement(sql.toString())) {
            int id = 0;
            for (Field field : fields) {
                Column columnAnnotation = field.getDeclaredAnnotation(Column.class);
                boolean isKey = field.isAnnotationPresent(Id.class);
                Object data = field.get(record);
                if (!isKey && data != null) {
                    if (data instanceof Date) {
                        data = new Timestamp(((Date) data).getTime());
                    }
                    ps.setObject(++id, data);
                }
            }
            int rows = ps.executeUpdate();
            if (rows > 0) {
                log.debug("Updating successful");
                return true;
            } else {
                log.error("Unable to find a record");
            }
        }
        catch (SQLException e) {
            log.error("Updating failed", e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean delete(TableRecord record) {
        boolean result = false;

        try (Connection connection = getConnection()) {
            result = delete(record, connection);
        } catch (SQLException e) {
            log.error("Deleting failed", e);
        }

        return result;
    }

    public boolean delete(TableRecord record, Connection con) {
        Table tableInfo = record.getClass().getDeclaredAnnotation(Table.class);

        StringBuilder sql = new StringBuilder("DELETE FROM ")
                .append(tableInfo.name())
                .append(" WHERE ");
        Field[] fields = record.getClass().getDeclaredFields();
        for (Field field : fields) {
            Column columnAnnotation = field.getDeclaredAnnotation(Column.class);
            boolean isKey = field.isAnnotationPresent(Id.class);
            if (columnAnnotation != null && isKey) {
                try {
                    field.setAccessible(true);
                    sql.append(columnAnnotation.name())
                            .append("=")
                            .append(field.get(record));
                } catch (IllegalAccessException e) {
                    log.error("Could not get access to field " + field.getName(), e);
                }
                break;
            }
        }

        try (PreparedStatement ps = con.prepareStatement(sql.toString())) {
            int rows = ps.executeUpdate();
            if (rows > 0) {
                log.debug("Deleting successful");
                return true;
            } else {
                log.error("Unable to find a record");
            }
        }
        catch (SQLException e) {
            log.error("Deleting failed", e);
        }

        return false;
    }


    private TableRecord[] executePreparedQuery(Class<? extends TableRecord> table, PreparedStatement ps) throws SQLException, InstantiationException, IllegalAccessException {
        ResultSet rs = ps.executeQuery();

        ArrayList<TableRecord> result = new ArrayList<>();
        Field[] fields = table.getDeclaredFields();
        while (rs.next()) {
            TableRecord record = table.newInstance();

            int index = 0;
            for (Field field : fields) {
                Column columnAnnotation = field.getDeclaredAnnotation(Column.class);
                if (columnAnnotation != null) {
                    field.setAccessible(true);
                    index++;
                    Object data;
                    if (field.getType() == Long.class) {
                        data = rs.getLong(index);
                    } else if (field.getType() == Integer.class) {
                        data = rs.getInt(index);
                    } else if (field.getType() == Double.class) {
                        data = rs.getDouble(index);
                    } else if (field.getType() == Date.class) {
                        data = new Date(rs.getTimestamp(index).getTime());
                    } else {
                        data = rs.getObject(index);
                    }
                    field.set(record,  data);
                }
            }

            result.add(record);
        }
        return result.toArray(new TableRecord[result.size()]);
    }
}
