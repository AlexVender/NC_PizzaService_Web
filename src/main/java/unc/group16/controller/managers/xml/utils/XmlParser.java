package unc.group16.controller.managers.xml.utils;

import org.apache.log4j.Logger;
import unc.group16.data.entity.Drink;
import unc.group16.data.entity.entities.Drinks;
import unc.group16.data.interfaces.TableRecords;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;


public class XmlParser {
    public static Long fileCounter = 1L;
    public static final Logger log = Logger.getLogger(XmlParser.class);

    public void marshal(TableRecords tableRecords){
        try {
            final String entityName = tableRecords.getClass().getSimpleName();
            String currentDir = new File("").getAbsolutePath();
            System.out.println(currentDir);

            File dir = new File("./web/xml/" + entityName);
//            File file = new File("text.xml");
//            File newFile = new File("G:/newfile.txt");
//
//            try{
//                if (newFile.createNewFile()) {
//                    System.out.println("Новый файл создан");
//                } else {
//                    System.out.println("Файл уже существует");
//                }
//            }
//            catch (java.io.IOException e){
//                log.error("Ошибка при создании файла: " + e);
//            }



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

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}