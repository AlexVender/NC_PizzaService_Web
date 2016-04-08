package unc.group16.data.interfaces;

public interface TableRecord extends Cloneable {
    Long getId();
    TableRecord setId(Long id);

    Integer getColumnsCnt();
    String getColumnName(Integer index);
    String getDisplayColumnName(Integer index);
}
