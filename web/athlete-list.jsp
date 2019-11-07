<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019-10-30
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Records-web</title>
</head>
<body>
    <h1 style="text-align: center">Athlete Management</h1>
    <h2 style="text-align: center">
        <a href="athlete-form.jsp">Add New Athlete</a>
        &nbsp;&nbsp;&nbsp;
        <a href="athlete-list">List All Athletes</a>

    </h2>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Athletes</h2></caption>
        <tr>
            <th>Rank</th>
            <th>Mark</th>
            <th>Name</th>
            <th>Date</th>
            <th>Location</th>
        </tr>
        <c:forEach var="athlete" items="${listAthlete}">
            <tr>
                <td><c:out value="${athlete.rank}" /></td>
                <td><c:out value="${athlete.mark}" /></td>
                <td><c:out value="${athlete.name}" /></td>
                <td><c:out value="${athlete.date}" /></td>
                <td><c:out value="${athlete.location}" /></td>
                <td>
                    <a href="edit?name=<c:out value='${athlete.name}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?name=<c:out value='${athlete.name}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
