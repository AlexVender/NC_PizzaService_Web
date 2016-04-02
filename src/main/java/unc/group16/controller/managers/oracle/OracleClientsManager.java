package unc.group16.controller.managers.oracle;

import unc.group16.controller.interfaces.AbstractDatabaseManager;
import unc.group16.data.entity.Client;

import javax.ejb.Stateless;
import java.util.Arrays;

@Stateless
public class OracleClientsManager extends AbstractDatabaseManager<Client> {
    public Long create(Client client){
        return getJDBC().insert(client);
    }

    public Client read(Long id) {
        return (Client) getJDBC().select(new Client().setId(id));
    }

    public Client[] read(Client client){
        Object[] objects = getJDBC().selectAll(client);
        return Arrays.copyOf(objects, objects.length, Client[].class);
    }

    public boolean update(Client client) {
        return getJDBC().update(client);
    }

    public boolean delete(Long id) {
        return getJDBC().delete(new Client().setId(id));
    }
}
