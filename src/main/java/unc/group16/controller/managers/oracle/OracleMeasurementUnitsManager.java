package unc.group16.controller.managers.oracle;

import unc.group16.controller.interfaces.AbstractDatabaseManager;
import unc.group16.data.entity.MeasurementUnit;

import javax.ejb.Stateless;
import java.util.Arrays;

@Stateless
public class OracleMeasurementUnitsManager extends AbstractDatabaseManager<MeasurementUnit> {
    public Long create(MeasurementUnit measurementUnit){
        return getJDBC().insert(measurementUnit);
    }
    
    public MeasurementUnit read(Long id) {
        return (MeasurementUnit) getJDBC().select(new MeasurementUnit().setId(id));
    }

    public MeasurementUnit[] readAll() {
        Object[] objects = getJDBC().selectAll(MeasurementUnit.class);
        return Arrays.copyOf(objects, objects.length, MeasurementUnit[].class);
    }

    public boolean update(MeasurementUnit measurementUnit) {
        return getJDBC().update(measurementUnit);
    }
    
    public boolean delete(Long id) {
        return getJDBC().delete(new MeasurementUnit().setId(id));
    }
}
