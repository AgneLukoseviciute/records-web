package com.lukoseviciute.programming.web;

import com.lukoseviciute.programming.models.Athlete;
import com.lukoseviciute.programming.dao.AthleteDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PrintFromDB")
public class PrintFromDB extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        List<Athlete> dbAthletes;

        AthleteDaoImpl dbInfo = new AthleteDaoImpl();
        try {
            dbAthletes = dbInfo.getAllAthletes();
            for(Athlete athlete: dbAthletes){
                out.print(athlete.getRank() + " ");
                out.print(athlete.getName() + " ");
                out.print(athlete.getLocation() + " ");
                out.print(athlete.getDate() + " ");
                out.println(athlete.getMark() + " ");
            }
        } catch (SQLException e){
            out.println("db error");
            e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
