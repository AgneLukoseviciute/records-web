package com.lukoseviciute.programming.web;

import com.lukoseviciute.programming.models.Athlete;
import com.lukoseviciute.programming.util.CSVFileReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "PrintRecords")
public class PrintRecords extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("executing doPostupdate");
        CSVFileReader csvRead = new CSVFileReader();
       // List<Athlete> csvAthleteList;
       // csvAthleteList = csvRead.intoObjects("assets/records.csv");


        List<Athlete> athletes = csvRead.intoObjects(new BufferedReader(new InputStreamReader(getServletContext().getResourceAsStream("/WEB-INF/records.csv"))));
        out.println("csv stuff: "+ athletes.get(0).getName());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("executing doGet");
    }
}
