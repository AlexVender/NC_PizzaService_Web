package unc.group16.data.entity.entities;

import unc.group16.data.entity.Drink;
import unc.group16.data.interfaces.TableRecord;
import unc.group16.data.interfaces.TableRecords;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement
public class Drinks implements TableRecords
{
    private Drink[] drinks;

    public Drinks(){}
    public Drinks(TableRecord[] tableRecord){
        this.setDrinks(Arrays.copyOf(tableRecord, tableRecord.length, Drink[].class));
    }



    public Drink[] getDrinks() {
        return drinks;
    }

    @XmlElement
    public void setDrinks(Drink[] drinks) {
        this.drinks = drinks;
    }
}
