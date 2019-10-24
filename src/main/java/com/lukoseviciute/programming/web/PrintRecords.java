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
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@WebServlet(name = "PrintRecords")
public class PrintRecords extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        CSVFileReader csvRead = new CSVFileReader();

        List<Athlete> athletes = csvRead.intoObjects(new BufferedReader(new InputStreamReader(getServletContext().getResourceAsStream("/WEB-INF/records.csv"))));
        for(Athlete athlete: athletes){
            out.print(athlete.getRank() + " ");
            out.print(athlete.getName() + " ");
            out.print(athlete.getLocation() + " ");
            out.print(athlete.getDate() + " ");
            out.println(athlete.getMark() + " ");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
