package unc.group16.data.interfaces;

import unc.group16.data.annotations.DisplayName;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public abstract class AbstractTableRecord implements TableRecord {
    private Integer columnsCnt = 0;
    private String[] columnNames;
    private String[] displayColumnNames;

    public Integer getColumnsCnt() {
        if (columnsCnt == 0) {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                Column columnAnnotation = field.getDeclaredAnnotation(Column.class);
                if (columnAnnotation != null) {
                    columnsCnt++;
                }
            }
        }
        return columnsCnt;
    }

    public String getColumnName(Integer index) {
        List<String> columnNamesList = new ArrayList<>();
        if (columnNames == null) {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                Column columnAnnotation = field.getDeclaredAnnotation(Column.class);
                if (columnAnnotation != null) {
                    columnNamesList.add(columnAnnotation.name());
                }
            }
            columnNames = columnNamesList.toArray(new String[columnsCnt]);
        }
        return columnNames[index];
    }

    public String getDisplayColumnName(Integer index) {
        List<String> displayColumnNamesList = new ArrayList<>();
        if (displayColumnNames == null) {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                Column columnAnnotation = field.getDeclaredAnnotation(Column.class);
                if (columnAnnotation != null) {
                    DisplayName displayNameAnnotation = field.getDeclaredAnnotation(DisplayName.class);
                    if (displayNameAnnotation != null) {
                        displayColumnNamesList.add(displayNameAnnotation.name());
                    } else {
                        displayColumnNamesList.add(columnAnnotation.name());
                    }
                }
            }
            displayColumnNames = displayColumnNamesList.toArray(new String[columnsCnt]);
        }
        return displayColumnNames[index];
    }
}
