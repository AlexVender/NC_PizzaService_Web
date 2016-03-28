package unc.group16.data.entity;

import unc.group16.data.annotations.Column;
import unc.group16.data.annotations.Table;
import unc.group16.data.interfaces.TableRecord;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement
@Table(name = "SAUCES", columns = 4)
public class Sauce implements TableRecord {
    @Column(id = 1, name = "SC_ID", isKey = true)
    private Long id;

    @Column(id = 2, name = "PRICE")
    private BigDecimal price;

    @Column(id = 3, name = "TITLE")
    private String title;

    @Column(id = 4, name = "DESCRIPTION")
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
    public Sauce setId(Long id) {
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
