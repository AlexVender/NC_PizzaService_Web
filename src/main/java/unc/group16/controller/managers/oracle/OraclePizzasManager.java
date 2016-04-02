package unc.group16.controller.managers.oracle;

import unc.group16.controller.interfaces.AbstractDatabaseManager;
import unc.group16.data.entity.Pizza;

import javax.ejb.Stateless;
import java.util.Arrays;

@Stateless
public class OraclePizzasManager extends AbstractDatabaseManager<Pizza> {
    public Long create(Pizza pizza){
        return getJDBC().insert(pizza);
    }
    
    public Pizza read(Long id) {
        return (Pizza) getJDBC().select(new Pizza().setId(id));
    }

    public Pizza[] read(Pizza pizza){
        Object[] objects = getJDBC().selectAll(pizza);
        return Arrays.copyOf(objects, objects.length, Pizza[].class);
    }
    
    public boolean update(Pizza pizza) {
        return getJDBC().update(pizza);
    }
    
    public boolean delete(Long id) {
        return getJDBC().delete(new Pizza().setId(id));
    }
}
