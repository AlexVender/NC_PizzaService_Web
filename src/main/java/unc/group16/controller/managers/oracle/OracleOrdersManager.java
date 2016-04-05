package unc.group16.controller.managers.oracle;

import unc.group16.controller.interfaces.AbstractDatabaseManager;
import unc.group16.data.entity.Order;

import javax.ejb.Stateless;
import java.util.Arrays;

@Stateless
public class OracleOrdersManager extends AbstractDatabaseManager<Order> {
    public Long create(Order order){
        return getJDBC().insert(order);
    }
    
    public Order read(Long id) {
        return (Order) getJDBC().select(new Order().setId(id));
    }

    public Order[] readAll() {
        Object[] objects = getJDBC().selectAll(Order.class);
        return Arrays.copyOf(objects, objects.length, Order[].class);
    }
    
    public boolean update(Order order) {
        return getJDBC().update(order);
    }
    
    public boolean delete(Long id) {
        return getJDBC().delete(new Order().setId(id));
    }
}