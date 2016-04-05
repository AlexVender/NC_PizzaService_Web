package unc.group16.data.interfaces;

import javax.persistence.Column;
import java.lang.reflect.Field;


public abstract class AbstractTableRecord implements TableRecord {
    private static Integer columnsCnt = 0;
    private static String[] columnNames;
    public AbstractTableRecord() {
        if (columnsCnt == 0) {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    columnsCnt++;
                }
            }
        }
    }

    public  Integer getColumnsCnt() {
        return columnsCnt;
    }

    public String getColumnName(Integer index) {
        int i = 0;
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Column columnAnnotation = field.getDeclaredAnnotation(Column.class);
            if (columnAnnotation != null) {
                i++;
                if (i == index) {
                    return field.getName();
                }
            }
        }
        throw new RuntimeException("There is no column with index " + index);
    }
}
