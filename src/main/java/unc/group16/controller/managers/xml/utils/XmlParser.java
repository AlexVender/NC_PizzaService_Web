package unc.group16.controller.managers.xml.utils;

import org.apache.log4j.Logger;
import unc.group16.data.interfaces.TableRecords;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;


public class XmlParser {
    public static Long fileCounter = 1L;
    public static final Logger log = Logger.getLogger(XmlParser.class);

    public File marshal(TableRecords tableRecords){
        try {
            final String entityName = tableRecords.getClass().getSimpleName();

            File dir = new File("./web/xml/" + entityName);

            if (!dir.exists()) {
                boolean makeDir = dir.mkdirs();
                if (!makeDir){
                    log.error("Failed to create directory");
                }
                else{
                    log.info("Directory created");
                }
            }
//            log.info("entityName: " + entityName);
//
            File file = new File(dir + "/" + entityName + "_" + fileCounter++ + ".xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(tableRecords.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "windows-1251");
            jaxbMarshaller.marshal(tableRecords, file);

//            jaxbMarshaller.marshal(tableRecords, System.out);
            return file;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}