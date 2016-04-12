package unc.group16.data.entity.entities;

import unc.group16.data.entity.Sauce;
import unc.group16.data.interfaces.TableRecord;
import unc.group16.data.interfaces.TableRecords;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement
public class Sauces implements TableRecords
{
    private Sauce[] sauces;

    public Sauces(){}
    public Sauces(TableRecord[] tableRecord){
        this.setSauces(Arrays.copyOf(tableRecord, tableRecord.length, Sauce[].class));
    }



    public Sauce[] getSauces() {
        return sauces;
    }

    @XmlElement
    public void setSauces(Sauce[] sauces) {
        this.sauces = sauces;
    }
}
