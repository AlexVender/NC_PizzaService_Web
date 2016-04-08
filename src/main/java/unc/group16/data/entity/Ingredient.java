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


@XmlRootElement
@Entity
@Table(name = "ingredients")
public class Ingredient extends AbstractTableRecord {
    @Id
    @Column(name = "INGRD_ID")
    @DisplayName(name = "ID")
    private Long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    public Ingredient() {}

    public Ingredient(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Ingredient(Long id, String title, String description) {
        this(title, description);
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

    public String getTitle() {
        return title;
    }

    @XmlElement
    public Ingredient setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement
    public Ingredient setDescription(String description) {
        this.description = description;
        return this;
    }


    @Override
    public Object clone() {
        Ingredient result = null;
        try {
            result = (Ingredient) super.clone();
        } catch (CloneNotSupportedException ignored) {
        }
        return result;
    }
}
