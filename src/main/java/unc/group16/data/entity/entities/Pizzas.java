package unc.group16.data.entity.entities;

import unc.group16.data.entity.Pizza;
import unc.group16.data.interfaces.TableRecord;
import unc.group16.data.interfaces.TableRecords;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement
public class Pizzas implements TableRecords
{
    private Pizza[] pizzas;

    public Pizzas(){}
    public Pizzas(TableRecord[] tableRecord){
        this.setPizzas(Arrays.copyOf(tableRecord, tableRecord.length, Pizza[].class));
    }



    public Pizza[] getPizzas() {
        return pizzas;
    }

    @XmlElement
    public void setPizzas(Pizza[] pizzas) {
        this.pizzas = pizzas;
    }
}
