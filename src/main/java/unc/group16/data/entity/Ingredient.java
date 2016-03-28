package unc.group16.data.entity;

import unc.group16.data.annotations.Column;
import unc.group16.data.annotations.Table;
import unc.group16.data.interfaces.TableRecord;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;


@XmlRootElement
@Table(name = "INGREDIENTS", columns = 3)
public class Ingredient implements TableRecord {
    @Column(id = 1, name = "INGRD_ID", isKey = true)
    private Long id;

    @Column(id = 2, name = "TITLE")
    private String title;

    @Column(id = 3, name = "DESCRIPTION")
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
    public Ingredient setId(Long id) {
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
