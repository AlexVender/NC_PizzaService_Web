package unc.group16.controller.managers.oracle;

import unc.group16.controller.interfaces.Manager;
import unc.group16.data.entity.*;
import unc.group16.data.interfaces.TableRecord;


public class OracleManagerFactory {
    public Manager getManager(String name) {
        switch (name.toLowerCase()) {
            case "client":          return new OracleClientsManager();
            case "drink":           return new OracleDrinksManager();
            case "ingredient":      return new OracleIngredientsManager();
            case "measurementunit": return new OracleMeasurementUnitsManager();
            case "order":           return new OracleOrdersManager();
            case "pizza":           return new OraclePizzasManager();
            case "sauce":           return new OracleSaucesManager();

            default:                throw new RuntimeException("No such manager: " + name);
        }
    }

    public TableRecord getRecord(String name) {
        switch (name.toLowerCase()) {
            case "client":          return new Client();
            case "drink":           return new Drink();
            case "ingredient":      return new Ingredient();
            case "measurementunit": return new MeasurementUnit();
            case "order":           return new Order();
            case "pizza":           return new Pizza();
            case "sauce":           return new Sauce();

            default:                throw new RuntimeException("No such table: " + name);
        }
    }
}
