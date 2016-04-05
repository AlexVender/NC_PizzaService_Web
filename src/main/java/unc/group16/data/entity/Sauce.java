package unc.group16.data.entity;

import unc.group16.data.interfaces.AbstractTableRecord;
import unc.group16.data.interfaces.TableRecord;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement
@Table(name = "sauces")
public class Sauce extends AbstractTableRecord {
    @Id
    @Column(name = "SC_ID")
    private Long id;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    public Sauce() {}

    public Sauce(BigDecimal price, String title, String description) {
        this.price = price;
        this.title = title;
        this.description = description;
    }

    public Sauce(Long id, BigDecimal price, String title, String description) {
        this(price, title, description);
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

    public BigDecimal getPrice() {
        return price;
    }

    @XmlElement
    public Sauce setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getTitle() {
        return title;
    }

    @XmlElement
    public Sauce setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement
    public Sauce setDescription(String description) {
        this.description = description;
        return this;
    }


    @Override
    public Object clone() {
        Sauce result = null;
        try {
            result = (Sauce) super.clone();
        } catch (CloneNotSupportedException ignored) {
        }
        return result;
    }
}
