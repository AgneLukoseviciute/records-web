package com.lukoseviciute.programming.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lukoseviciute.programming.models.Athlete;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JSONFileReader implements FileReaderI {

    ArrayList<Athlete> jsonAthleteList = new ArrayList<Athlete>();

    public JSONFileReader() {

    }

   // @Override
    public List<Athlete> intoObjects(String fileStr) {
        Gson gson = new Gson();
        File jsonFile = new File (fileStr);
        Reader jsonReader;

        try {
            jsonReader = new FileReader(jsonFile);

            //creates an array of Athlete objects storing JSON data
            jsonAthleteList = gson.fromJson(jsonReader, new TypeToken<ArrayList<Athlete>>(){}.getType());


            jsonReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonAthleteList;
    }


    @Override
    public List<Athlete> intoObjects(BufferedReader reader) {
        return null;
    }
}