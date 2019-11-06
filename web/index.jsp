<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019-10-08
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Record Viewer</title>
</head>
<body>
<%
  Date date = new Date();
  out.print("<h2>" + date.toString() + "<h2>");
%>
<h1>Welcome </h1>
<h2> Click to see records.</h2>
<form action = "/records_web_war_exploded/csvrecords" method = "post">
  <input type ="submit" style="color:green;" value = "CSV records" >
</form>
<form action = "/records_web_war_exploded/dbrecords" method = "post">
  <input type ="submit" style="color:green;" value = "DB records" >
</form>
<form action = "/records_web_war_exploded/athlete-list" method = "post">
  <input type ="submit" style="color:green;" value = "See Athlete List" >
</form>
</body>
</html>

