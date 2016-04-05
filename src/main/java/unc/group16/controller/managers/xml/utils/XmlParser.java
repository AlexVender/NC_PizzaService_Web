package unc.group16.controller.managers.xml.utils;

import org.apache.log4j.Logger;
import unc.group16.data.entity.Drink;
import unc.group16.data.interfaces.TableRecord;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;


public class XmlParser {
    public static Long fileCounter = 0L;
    public static final Logger log = Logger.getLogger(XmlParser.class);

    public void marshal(TableRecord objectToXML){
        try {
            final String entityName = objectToXML.getClass().getSimpleName();
            File dir = new File("./web/xml/" + entityName + "s/");

            if (!dir.exists()) {
                boolean makeDir = dir.mkdirs();
                if (!makeDir){
                    log.error("Failed to create directory");
                }
            }

            Long id = objectToXML.getId();
            File file = new File(dir + "/" + entityName + "_" + id + ".xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(Drink.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(objectToXML, file);

//            jaxbMarshaller.marshal(objectToXML, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
