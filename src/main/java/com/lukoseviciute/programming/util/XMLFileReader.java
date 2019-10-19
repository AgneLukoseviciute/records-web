package com.lukoseviciute.programming.util;

import com.lukoseviciute.appLogic.models.Athlete;
import com.lukoseviciute.appLogic.models.XMLRoot;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLFileReader implements FileReaderI {

    ArrayList<Athlete> xmlAthleteList = new ArrayList<Athlete>();

    public XMLFileReader(){

    }

    @Override
    public List<Athlete> intoObjects(String xmlStr){
        File xmlFile = new File(xmlStr);

        JAXBContext jaxbContext = null;
        XMLRoot root = null;
        try {
            jaxbContext = JAXBContext.newInstance(XMLRoot.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            root = (XMLRoot) unmarshaller.unmarshal(xmlFile);
            xmlAthleteList = root.getArray();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return xmlAthleteList;
    }

}
