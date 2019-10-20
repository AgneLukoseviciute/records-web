package com.lukoseviciute.programming.util.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlElement;

public class Athlete {

    public Athlete(){

    }

    public Athlete(int rank, String mark, String name, String date, String location) {
        this.rank = rank;
        this.mark = mark;
        this.name = name;
        this.date = date;
        this.location = location;
    }

    // Overriding equals() to return true if names are equal.
    @Override
    public boolean equals(Object o) {

        if(this == o) return true;

        if(!(o instanceof Athlete)) return false;

        Athlete oAthlete = (Athlete)o;

        return this.name.equals(oAthlete.name);
    }

    @SerializedName("Rank")
    @Expose
    @XmlElement(name = "Rank")
    private int rank;
    @SerializedName("Mark")
    @Expose
    @XmlElement(name = "Mark")
    private String mark;
    @SerializedName("Athlete")
    @Expose
    @XmlElement(name = "Athlete")
    private String name;
    @SerializedName("Date")
    @Expose
    @XmlElement(name = "Date")
    private String date;
    @SerializedName("Location")
    @Expose
    @XmlElement(name = "Location")
    private String location;

    public int getRank() {
        return rank;
    }

    public String getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

}

