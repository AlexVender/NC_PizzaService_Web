package unc.group16.controller.managers.ManagerFactory;

import unc.group16.controller.interfaces.AbstractDatabaseManager;
import unc.group16.controller.managers.oracle.OracleDrinksManager;
import unc.group16.data.entity.Drink;

public class DrinksManagerCreator extends Creator {
    @Override
    public AbstractDatabaseManager<Drink> factoryMethod() { return new OracleDrinksManager(); }
}
