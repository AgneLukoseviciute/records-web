package com.lukoseviciute.programming.dao;

import com.lukoseviciute.programming.models.Athlete;

import java.sql.SQLException;
import java.util.List;

public interface AthleteDao {

    List<Athlete> getAllAthletes() throws SQLException;

    public void insertAthlete(Athlete athlete) throws SQLException;

    public Athlete selectAthlete(String name);

    public boolean deleteAthlete(String name) throws SQLException;

    public boolean updateAthlete(Athlete athlete) throws SQLException;

}
