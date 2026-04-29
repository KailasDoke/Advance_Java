<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Demo</title>
</head>
<body>

<%!
    int a = 10;
    String name = "Kailas";

    int square() {
        return a * a;
    }
%>

<%
    out.println("a: " + a + "<br>");
    out.println("Name: " + name + "<br>");
    out.println("method: " + square() + "<br>");

    int b = 10;

    if (b < 100) {
        out.println("b is smaller than 100<br>");
    } else {
        out.println("b is greater than 100<br>");
    }
%>

<br>
Today's Date: <%= LocalDate.now() %>

</body>
</html>