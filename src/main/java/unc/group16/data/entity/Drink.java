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
import java.math.BigDecimal;


@XmlRootElement
@Entity
@Table(name = "drinks")
public class Drink extends AbstractTableRecord {
    @Id
    @Column(name = "DRNK_ID")
    @DisplayName(name = "ID")
    private Long id;

    @Column(name = "Volume")
    private Integer volume;

    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    public Drink() {}

    public Drink(Integer volume, BigDecimal price, String title, String description) {
        this.volume = volume;
        this.price = price;
        this.title = title;
        this.description = description;
    }

    public Drink(Long id, Integer volume, BigDecimal price, String title, String description) {
        this(volume, price, title, description);
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

    public Integer getVolume() {
        return volume;
    }

    @XmlElement
    public Drink setVolume(Integer volume) {
        this.volume = volume;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @XmlElement
    public Drink setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getTitle() {
        return title;
    }

    @XmlElement
    public Drink setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Drink setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public Object clone() {
        Drink result = null;
        try {
            result = (Drink) super.clone();
        } catch (CloneNotSupportedException ignored) {
        }
        return result;
    }
}
