import unc.group16.controller.interfaces.Manager;
import unc.group16.controller.managers.oracle.OracleDrinksManager;
import unc.group16.data.entity.Drink;

public class Main {
    public static void main(String[] args){
        Manager<Drink> manager = new OracleDrinksManager();
        Drink drink = manager.read(1L);
        System.out.println("ID: " + drink.getId());
        System.out.println("Price: " + drink.getPrice());
    }
}
