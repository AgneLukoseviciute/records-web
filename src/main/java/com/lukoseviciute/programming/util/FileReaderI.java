package com.lukoseviciute.programming.util;

import com.lukoseviciute.programming.models.Athlete;

import java.util.List;

public interface FileReaderI {
    List<Athlete> intoObjects(String fileStr);

}