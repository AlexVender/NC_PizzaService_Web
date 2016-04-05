package unc.group16.controller.managers.oracle;

import unc.group16.controller.interfaces.AbstractDatabaseManager;
import unc.group16.data.entity.Sauce;

import javax.ejb.Stateless;
import java.util.Arrays;

@Stateless
public class OracleSaucesManager extends AbstractDatabaseManager<Sauce> {
    public Long create(Sauce sauce){
        return getJDBC().insert(sauce);
    }
    
    public Sauce read(Long id) {
        return (Sauce) getJDBC().select(new Sauce().setId(id));
    }

    public Sauce[] readAll() {
        Object[] objects = getJDBC().selectAll(Sauce.class);
        return Arrays.copyOf(objects, objects.length, Sauce[].class);
    }
    
    public boolean update(Sauce sauce) {
        return getJDBC().update(sauce);
    }
    
    public boolean delete(Long id) {
        return getJDBC().delete(new Sauce().setId(id));
    }
}
