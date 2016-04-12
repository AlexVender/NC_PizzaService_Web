package unc.group16.data.entity.entities;

import unc.group16.data.entity.Order;
import unc.group16.data.interfaces.TableRecord;
import unc.group16.data.interfaces.TableRecords;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement
public class Orders implements TableRecords
{
    private Order[] orders;

    public Orders(){}
    public Orders(TableRecord[] tableRecord){
        this.setOrders(Arrays.copyOf(tableRecord, tableRecord.length, Order[].class));
    }



    public Order[] getOrders() {
        return orders;
    }

    @XmlElement(name = "order")
    public void setOrders(Order[] orders) {
        this.orders = orders;
    }
}
