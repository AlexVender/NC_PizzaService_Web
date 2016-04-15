package unc.group16.data.entity.entities;

import javafx.scene.control.Tab;
import unc.group16.data.entity.Drink;
import unc.group16.data.interfaces.TableRecord;
import unc.group16.data.interfaces.TableRecords;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement
public class Entities
{
    private TableRecord[] records;

    public Entities(){}
    public Entities(TableRecord[] tableRecord){
        this.setRecords(Arrays.copyOf(tableRecord, tableRecord.length, TableRecord[].class));
    }



    public TableRecord[] getRecords() {
        return records;
    }

    @XmlElement
    public void setRecords(TableRecord[] records) {
        this.records = records;
    }
}
