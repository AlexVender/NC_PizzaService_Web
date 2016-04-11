package unc.group16.data.interfaces;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public class AbstractTableRecords implements TableRecords{
    private TableRecord[] entities;

    public TableRecord[] getEntities() {
        return entities;
    }

    public void setEntities(TableRecord[] entities) {
        this.entities = entities;
    }
}
