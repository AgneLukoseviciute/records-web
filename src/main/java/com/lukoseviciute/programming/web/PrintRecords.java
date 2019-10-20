package com.lukoseviciute.programming.web;

import com.lukoseviciute.programming.models.Athlete;
import com.lukoseviciute.programming.util.CSVFileReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "PrintRecords")
public class PrintRecords extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        CSVFileReader csvRead = new CSVFileReader();
        List<Athlete> csvAthleteList;
        csvAthleteList = csvRead.intoObjects("assets/records.csv");
        out.println("csv stuff: "+ csvAthleteList.get(0).getName());
        out.println("executing doPostupdate");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("executing doGet");
    }
}
