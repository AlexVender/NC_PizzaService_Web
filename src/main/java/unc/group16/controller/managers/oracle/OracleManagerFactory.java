package unc.group16.controller.managers.oracle;

import unc.group16.controller.interfaces.Manager;


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
}
