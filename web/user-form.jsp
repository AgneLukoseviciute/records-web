<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019-10-31
  Time: 20:55
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
    <h1>Athlete Management</h1>
    <h2>
        <a href="new">Add New Athlete</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List All Athletes</a>

    </h2>
<div align="center">
    <c:if test="${athlete != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${athlete == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${athlete != null}">
                            Edit Athlete
                        </c:if>
                        <c:if test="${athlete == null}">
                            Add New Athlete
                        </c:if>
                    </h2>
                </caption>
                
            </table>
        </form>
</div>
</body>
</html>
