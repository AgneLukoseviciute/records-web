package com.lukoseviciute.programming.util;

import com.lukoseviciute.programming.models.Athlete;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class AthleteDaoImpl implements AthleteDao {

    private static Logger logger = Logger.getLogger(AthleteDaoImpl.class.getName());

    List<Athlete> athletes;

    public AthleteDaoImpl(){}

    //retrieves list of students from the database
    @Override
    public List<Athlete> getAllAthletes() throws SQLException {

        Connection conn = null;

        try {
            conn = GetDBConnection.getInstance().getConnection();
        } catch (IOException  e) {
            e.printStackTrace();
        }
        Statement statement = conn.createStatement();
        String sqlStr = "select * from athletes1.hammer_women";
        ResultSet resultSet = statement.executeQuery(sqlStr);

        List<Athlete> athletes = new ArrayList<>();

        while (resultSet.next()){
            int rank = resultSet.getInt(2);
            String mark = resultSet.getString(3);
            String name = resultSet.getString("athlete_name");
          //  logger.log(INFO, "athlete_name: " + name) ;

            String date = resultSet.getString(5);
            String location = resultSet.getString(6);

            athletes.add(new Athlete(rank, mark, name, date, location));
        }

        resultSet.close();
        conn.close();
        return athletes;

    }
}
