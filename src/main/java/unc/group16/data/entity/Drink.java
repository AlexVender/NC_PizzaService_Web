package unc.group16.data.entity;

import unc.group16.data.annotations.Column;
import unc.group16.data.annotations.Table;
import unc.group16.data.interfaces.TableRecord;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;


@XmlRootElement
@Table(name = "DRINKS", columns = 5)
public class Drink implements TableRecord {
    @Column(id = 1, name = "DRNK_ID", isKey = true)
    private Long id;

    @Column(id = 2, name = "VOLUME")
    private Integer volume;

    @Column(id = 3, name = "PRICE")
    private BigDecimal price;

    @Column(id = 4, name = "TITLE")
    private String title;

    @Column(id = 5, name = "DESCRIPTION")
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
    public Drink setId(Long id) {
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
