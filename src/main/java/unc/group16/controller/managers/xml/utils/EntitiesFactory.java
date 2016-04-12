package unc.group16.controller.managers.xml.utils;

import unc.group16.data.entity.entities.*;
import unc.group16.data.interfaces.TableRecord;
import unc.group16.data.interfaces.TableRecords;

public class EntitiesFactory {
    public TableRecords getManager(String name, TableRecord[] selectedArr) {
        switch (name.toLowerCase()) {
            case "client":          return new Clients(selectedArr);
            case "drink":           return new Drinks(selectedArr);
            case "ingredient":      return new Ingredients(selectedArr);
            case "measurementunit": return new MeasurementUnits(selectedArr);
            case "order":           return new Orders(selectedArr);
            case "pizza":           return new Pizzas(selectedArr);
            case "sauce":           return new Sauces(selectedArr);

            default:                throw new RuntimeException("No such entity: " + name);
        }
    }
}
