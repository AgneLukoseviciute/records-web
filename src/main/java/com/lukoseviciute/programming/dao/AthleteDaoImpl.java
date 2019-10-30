package com.lukoseviciute.programming.dao;

import com.lukoseviciute.programming.models.Athlete;
import com.lukoseviciute.programming.util.GetDBConnection;
import com.sun.xml.bind.v2.TODO;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AthleteDaoImpl implements AthleteDao {

    //TODO: remove?
    private static Logger logger = Logger.getLogger(AthleteDaoImpl.class.getName());

    private static final String INSERT_USERS_SQL = "INSERT INTO hammer_women " +
        "(rank, mark, athlete_name, date, location) VALUES (?, ?, ?, ?, ?);";

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
            String rank = resultSet.getString(2);
            String mark = resultSet.getString(3);
            String name = resultSet.getString("athlete_name");
            String date = resultSet.getString(5);
            String location = resultSet.getString(6);

            athletes.add(new Athlete(rank, mark, name, date, location));
        }

        resultSet.close();
        conn.close();
        return athletes;

    }

    @Override
    public void insertAthlete(Athlete athlete) throws SQLException{

        try (Connection connection = GetDBConnection.getInstance().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, athlete.getRank());
            preparedStatement.setString(2, athlete.getMark());
            preparedStatement.setString(3, athlete.getName());
            preparedStatement.setString(4, athlete.getDate());
            preparedStatement.setString(5, athlete.getLocation());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Athlete selectAthlete(int id){
    
    }

    @Override
    public boolean deleteAthlete(int id) throws SQLException{

    }

    @Override
    public boolean updateAthlete(Athlete athlete) throws SQLException{

    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
