<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title> Records Web</title>
</head>
<body>
    <h1>Athlete Management</h1>
    <h2>
        <a href="athlete-form.jsp">Add New Athlete</a>
        &nbsp;&nbsp;&nbsp;
        <a href="athlete-list">List All Athletes</a>

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
                <c:if test="${athlete != null}">
                    <input type="hidden" name="name" value="<c:out value='${athlete.name}' />" />
                </c:if>
                <tr>
                    <th>Athlete Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${athlete.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                <th>Athlete Rank: </th>
                <td>
                    <input type="text" name="rank" size="45"
                           value="<c:out value='${athlete.rank}' />"
                    />
                </td>
                </tr>
                <tr>
                    <th>Mark: </th>
                    <td>
                        <input type="text" name="mark" size="45"
                               value="<c:out value='${athlete.mark}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Date: </th>
                    <td>
                        <input type="text" name="date" size="15"
                               value="<c:out value='${athlete.date}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Location: </th>
                    <td>
                        <input type="text" name="location" size="45"
                               value="<c:out value='${athlete.location}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>