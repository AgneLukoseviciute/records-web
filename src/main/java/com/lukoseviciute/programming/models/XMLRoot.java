package com.lukoseviciute.programming.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "List")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLRoot {

    @XmlElement(name="Item")
    private ArrayList<Athlete> XmlAthletes;

    public ArrayList<Athlete> getArray(){
        return XmlAthletes;
    }

}
