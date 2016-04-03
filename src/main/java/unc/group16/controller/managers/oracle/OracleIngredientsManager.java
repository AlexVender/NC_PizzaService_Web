package unc.group16.controller.managers.oracle;

import unc.group16.controller.interfaces.AbstractDatabaseManager;
import unc.group16.data.entity.Ingredient;

import javax.ejb.Stateless;
import java.util.Arrays;

@Stateless
public class OracleIngredientsManager extends AbstractDatabaseManager<Ingredient> {
    public Long create(Ingredient ingredient){
        return getJDBC().insert(ingredient);
    }
    
    public Ingredient read(Long id) {
        return (Ingredient) getJDBC().select(new Ingredient().setId(id));
    }

    public Ingredient[] readAll(){
        return (Ingredient[]) getJDBC().selectAll(Ingredient.class);
    }
    
    public boolean update(Ingredient ingredient) {
        return getJDBC().update(ingredient);
    }
    
    public boolean delete(Long id) {
        return getJDBC().delete(new Ingredient().setId(id));
    }
}