package unc.group16.data.entity.entities;

import unc.group16.data.entity.Ingredient;
import unc.group16.data.interfaces.TableRecord;
import unc.group16.data.interfaces.TableRecords;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement
public class Ingredients implements TableRecords
{
    private Ingredient[] ingredient;

    public Ingredients(){}
    public Ingredients(TableRecord[] tableRecord){
        this.setIngredients(Arrays.copyOf(tableRecord, tableRecord.length, Ingredient[].class));
    }



    public Ingredient[] getIngredients() {
        return ingredient;
    }

    @XmlElement(name = "ingredient")
    public void setIngredients(Ingredient[] ingredient) {
        this.ingredient = ingredient;
    }
}
