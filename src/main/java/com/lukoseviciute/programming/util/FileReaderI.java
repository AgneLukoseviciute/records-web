package com.lukoseviciute.programming.util;

import com.lukoseviciute.programming.models.Athlete;

import java.io.BufferedReader;
import java.util.List;

public interface FileReaderI {
    List<Athlete> intoObjects(BufferedReader reader);

}