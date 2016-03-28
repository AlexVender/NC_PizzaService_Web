package unc.group16.data.entity;

import unc.group16.data.annotations.Column;
import unc.group16.data.annotations.Table;
import unc.group16.data.interfaces.TableRecord;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
@Table(name = "ORDERS", columns = 5)
public class Order implements TableRecord {
    @Column(id = 1, name = "ORD_ID", isKey = true)
    private Long id;

    @Column(id = 2, name = "CLNT_CLNT_ID")
    private Long clientId;

    @Column(id = 3, name = "ORDER_DATE")
    private Date orderDate;

    @Column(id = 4, name = "DELIVERY_DATE")
    private Date deliveryDate;

    @Column(id = 5, name = "DESCRIPTION")
    private String description;

    public Order() {}

    public Order(Long clientId, Date orderDate, Date deliveryDate, String description) {
        this.clientId = clientId;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.description = description;
    }

    public Order(Long id, Long clientId, Date orderDate, Date deliveryDate, String description) {
        this(clientId, orderDate, deliveryDate, description);
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    @XmlElement
    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getClientId() {
        return clientId;
    }

    @XmlElement
    public Order setClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    @XmlElement
    public Order setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    @XmlElement
    public Order setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement
    public Order setDescription(String description) {
        this.description = description;
        return this;
    }


    @Override
    public Object clone() {
        Order result = null;
        try {
            result = (Order) super.clone();
        } catch (CloneNotSupportedException ignored) {
        }
        return result;
    }
}
