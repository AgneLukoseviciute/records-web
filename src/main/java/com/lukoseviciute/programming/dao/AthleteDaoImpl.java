package com.lukoseviciute.programming.dao;

import com.lukoseviciute.programming.models.Athlete;
import com.lukoseviciute.programming.util.GetDBConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AthleteDaoImpl implements AthleteDao {

    private static Logger logger = Logger.getLogger(AthleteDaoImpl.class.getName());

    private static final String INSERT_USERS_SQL = "INSERT INTO hammer_women (rank, mark, athlete_name, date, location) VALUES (?, ?, ?, ?, ?)";

    private static final String SELECT_ATHLETE_BY_NAME = "select rank, mark, date, location from hammer_women where athlete_name = ?";

    private static final String SELECT_ALL_ATHLETES = "select * from hammer_women";
    private static final String DELETE_ATHLETE_SQL = "delete from hammer_women where athlete_name = ?";
    private static final String UPDATE_ATHLETE_SQL = "update hammer_women set rank = ?, mark = ?, date = ?, location = ? where athlete_name = ?";


    List<Athlete> athletes;

    public AthleteDaoImpl(){}

    //retrieves list of students from the database
    @Override
    public List<Athlete> getAllAthletes() throws SQLException {

        Connection conn = null;

        try {
            conn = GetDBConnection.getInstance().getConnection();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL_ATHLETES);

        List<Athlete> athletes = new ArrayList<>();

        while (resultSet.next()){
            int rank = resultSet.getInt(2);
            String mark = resultSet.getString(3);
            String name = resultSet.getString(4);
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

        try (Connection connection = GetDBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {

            preparedStatement.setInt(1, athlete.getRank());
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
    public Athlete selectAthlete(String name){
        Athlete athlete = null;

        try (Connection connection = GetDBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ATHLETE_BY_NAME);) {

            preparedStatement.setString(1, name);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int rank = rs.getInt(1);
                String mark = rs.getString(2);
                String date = rs.getString(3);
                String location = rs.getString(4);
                athlete = new Athlete(rank, mark, name, date, location);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (IOException e){
            e.printStackTrace();
        }
        return athlete;
    }

    @Override
    public boolean deleteAthlete(String name) throws SQLException{
        boolean rowDeleted = false;
        try (Connection connection = GetDBConnection.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_ATHLETE_SQL);) {
            statement.setString(1, name);
            rowDeleted = statement.executeUpdate() > 0;
        } catch(IOException e){
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateAthlete(Athlete athlete) throws SQLException{
        boolean rowUpdated = false;
        try (Connection connection = GetDBConnection.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_ATHLETE_SQL);) {
            statement.setInt(1, athlete.getRank());
            statement.setString(2, athlete.getMark());
            statement.setString(3, athlete.getDate());
            statement.setString(4, athlete.getLocation());

            rowUpdated = statement.executeUpdate() > 0;
        }catch (SQLException e){
            printSQLException(e);
        }catch (IOException e){
            e.printStackTrace();
        }
        return rowUpdated;
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
