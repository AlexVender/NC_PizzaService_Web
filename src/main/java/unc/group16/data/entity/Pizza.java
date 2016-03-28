package unc.group16.data.entity;

import unc.group16.data.annotations.Column;
import unc.group16.data.annotations.Table;
import unc.group16.data.interfaces.TableRecord;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement
@Table(name = "PIZZAS", columns = 6)
public class Pizza implements TableRecord {
    @Column(id = 1, name = "PZ_ID", isKey = true)
    private Long id;

    @Column(id = 2, name = "TITLE")
    private String title;

    @Column(id = 3, name = "TYPE")
    private String type;

    @Column(id = 4, name = "WEIGHT")
    private Integer weight;

    @Column(id = 5, name = "PRICE")
    private BigDecimal price;

    @Column(id = 6, name = "DESCRIPTION")
    private String description;

    public Pizza() {}

    public Pizza(String title, String type, Integer weight, BigDecimal price, String description) {
        this.title = title;
        this.type = type;
        this.weight = weight;
        this.price = price;
        this.description = description;
    }

    public Pizza(Long id, String title, String type, Integer weight, BigDecimal price, String description) {
        this(title, type, weight, price, description);
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    @XmlElement
    public Pizza setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    @XmlElement
    public Pizza setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getType() {
        return type;
    }

    @XmlElement
    public Pizza setType(String type) {
        this.type = type;
        return this;
    }

    public Integer getWeight() {
        return weight;
    }

    @XmlElement
    public Pizza setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @XmlElement
    public Pizza setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Pizza setComments(String description) {
        this.description = description;
        return this;
    }


    @Override
    public Object clone() {
        Pizza result = null;
        try {
            result = (Pizza) super.clone();
        } catch (CloneNotSupportedException ignored) {
        }
        return result;
    }
}
