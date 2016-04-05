package unc.group16.data.entity;

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
@Table(name = "clients")
public class Client extends AbstractTableRecord {
    @Id
    @Column(name = "CLNT_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE_NUMBER")
    private String phone;

    public Client() {}
    
    public Client(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Client(Long id, String name, String address, String phone) {
        this(name, address, phone);
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

    public String getName() {
        return name;
    }

    @XmlElement
    public Client setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    @XmlElement
    public Client setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    @XmlElement
    public Client setPhone(String phone) {
        this.phone = phone;
        return this;
    }


    @Override
    public Object clone() {
        Client result = null;
        try {
            result = (Client) super.clone();
        } catch (CloneNotSupportedException ignored) {
        }
        return result;
    }
}
