package unc.group16.controller.managers.oracle;

import unc.group16.controller.interfaces.AbstractDatabaseManager;
import unc.group16.data.entity.Drink;

import javax.ejb.Stateless;
import java.util.Arrays;


@Stateless
public class OracleDrinksManager extends AbstractDatabaseManager<Drink> {
    public Long create(Drink drink){
        return getJDBC().insert(drink);
    }

    public Drink read(Long id) {
        return (Drink) getJDBC().select(new Drink().setId(id));
    }
    public Drink[] read(Drink drink){
        Object[] objects = getJDBC().selectAll(drink);
        return Arrays.copyOf(objects, objects.length, Drink[].class);
    }

    public boolean update(Drink drink) {
        return getJDBC().update(drink);
    }

    public boolean delete(Long id) {
        return getJDBC().delete(new Drink().setId(id));
    }
}
