package unc.group16.controller.managers.xml.utils;

import unc.group16.data.entity.entities.Drinks;
import unc.group16.data.interfaces.TableRecord;
import unc.group16.data.interfaces.TableRecords;

public class EntitiesFactory {
    public TableRecords getManager(String name, TableRecord[] selectedArr) {
        switch (name.toLowerCase()) {
//            case "client":          return new OracleClientsManager();
            case "drink":           return new Drinks(selectedArr);
//            case "ingredient":      return new OracleIngredientsManager();
//            case "measurementunit": return new OracleMeasurementUnitsManager();
//            case "order":           return new OracleOrdersManager();
//            case "pizza":           return new OraclePizzasManager();
//            case "sauce":           return new OracleSaucesManager();

            default:                throw new RuntimeException("No such entity: " + name);
        }
    }
}
