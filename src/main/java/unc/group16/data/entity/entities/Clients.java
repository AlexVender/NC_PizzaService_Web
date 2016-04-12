package unc.group16.data.entity.entities;

import unc.group16.data.entity.Client;
import unc.group16.data.interfaces.TableRecords;
import unc.group16.data.interfaces.TableRecord;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement
public class Clients implements TableRecords {
    private Client[] clients;

    public Clients(){}
    public Clients(TableRecord[] tableRecord){
        this.setClients(Arrays.copyOf(tableRecord, tableRecord.length, Client[].class));
    }



    public Client[] getClients() {
        return clients;
    }

    @XmlElement(name = "client")
    public void setClients(Client[] clients) {
        this.clients = clients;
    }
}
