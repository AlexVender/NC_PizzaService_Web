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
@Table(name = "measurement_units")
public class MeasurementUnit extends AbstractTableRecord {
    @Id
    @Column(name = "MSRU_ID")
    @DisplayName(name = "ID")
    private Long id;

    @Column(name = "Title")
    private String title;

    public MeasurementUnit() {}

    public MeasurementUnit(String title) {
        this.title = title;
    }

    public MeasurementUnit(Long id, String title) {
        this(title);
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
    public MeasurementUnit setTitle(String title) {
        this.title = title;
        return this;
    }


    @Override
    public Object clone() {
        MeasurementUnit result = null;
        try {
            result = (MeasurementUnit) super.clone();
        } catch (CloneNotSupportedException ignored) {
        }
        return result;
    }
}
