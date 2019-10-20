package util;

import com.lukoseviciute.programming.util.models.Athlete;

import java.util.List;

public interface FileReaderI {
    List<Athlete> intoObjects(String fileStr);

}