package unc.group16.controller.managers.ManagerFactory;

import unc.group16.controller.interfaces.AbstractDatabaseManager;
import unc.group16.data.interfaces.TableRecord;

public abstract class Creator {
    public abstract AbstractDatabaseManager<? extends TableRecord> factoryMethod();
}
