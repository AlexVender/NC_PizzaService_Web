package unc.group16.data.entity;

import unc.group16.data.annotations.DisplayName;
import unc.group16.data.interfaces.AbstractTableRecord;
import unc.group16.data.interfaces.TableRecord;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
@Entity
@Table(name = "orders")
public class Order extends AbstractTableRecord {
    @Id
    @Column(name = "ORD_ID")
    @DisplayName(name = "ID")
    private Long id;

    @Column(name = "CLNT_CLNT_ID")
    @DisplayName(name = "Client")
    private Long clientId;

    @Column(name = "ORDER_DATE")
    @DisplayName(name = "Order date")
    private Date orderDate;

    @Column(name = "DELIVERY_DATE")
    @DisplayName(name = "Delivery date")
    private Date deliveryDate;

    @Column(name = "Description")
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
    public TableRecord setId(Long id) {
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
        this.orderDate = (Date) orderDate.clone();
        return this;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    @XmlElement
    public Order setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = (Date) deliveryDate.clone();
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
