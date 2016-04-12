package unc.group16.data.entity.entities;

import unc.group16.data.entity.MeasurementUnit;
import unc.group16.data.interfaces.TableRecord;
import unc.group16.data.interfaces.TableRecords;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement
public class MeasurementUnits implements TableRecords
{
    private MeasurementUnit[] measurementUnits;

    public MeasurementUnits(){}
    public MeasurementUnits(TableRecord[] tableRecord){
        this.setMeasurementUnits(Arrays.copyOf(tableRecord, tableRecord.length, MeasurementUnit[].class));
    }



    public MeasurementUnit[] getMeasurementUnits() {
        return measurementUnits;
    }

    @XmlElement(name = "measurementUnit")
    public void setMeasurementUnits(MeasurementUnit[] measurementUnits) {
        this.measurementUnits = measurementUnits;
    }
}
