package unc.group16.controller.managers.ManagerFactory;

import unc.group16.controller.interfaces.AbstractDatabaseManager;
import unc.group16.controller.managers.oracle.OracleClientsManager;
import unc.group16.data.entity.Client;

public class ClientsManagerCreator extends Creator {
    @Override
    public AbstractDatabaseManager<Client> factoryMethod() { return new OracleClientsManager(); }
}
