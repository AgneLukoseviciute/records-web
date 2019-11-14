package com.lukoseviciute.programming.web;

import com.lukoseviciute.programming.dao.AthleteDaoImpl;
import com.lukoseviciute.programming.models.Athlete;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HammerWomen")
public class HammerWomen extends HttpServlet {

    private AthleteDaoImpl athleteDao;

    public void init() {
        athleteDao = new AthleteDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertAthlete(request, response);
                    break;
                case "/delete":
                    deleteAthlete(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateAthlete(request, response);
                    break;
                default:
                    listAthletes(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listAthletes(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Athlete> listAthlete = athleteDao.getAllAthletes();
        request.setAttribute("listAthlete", listAthlete);
        RequestDispatcher dispatcher = request.getRequestDispatcher("athlete-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("athlete-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        Athlete existingAthlete = athleteDao.selectAthlete(name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("athlete-form.jsp");
        request.setAttribute("athlete", existingAthlete);
        dispatcher.forward(request, response);

    }

    private void insertAthlete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String rank = request.getParameter("rank");
        String mark = request.getParameter("mark");
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String location = request.getParameter("location");
        Athlete newAthlete = new Athlete(rank, mark, name, date, location);
        athleteDao.insertAthlete(newAthlete);
        response.sendRedirect("athlete-list");
    }

    private void updateAthlete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String rank = request.getParameter("rank");
        String mark = request.getParameter("mark");
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String location = request.getParameter("location");

        Athlete athlete = new Athlete(rank, mark, name, date, location);
        athleteDao.updateAthlete(athlete);
        response.sendRedirect("athlete-list");
    }

    private void deleteAthlete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        athleteDao.deleteAthlete(name);
        response.sendRedirect("athlete-list");

    }


}
