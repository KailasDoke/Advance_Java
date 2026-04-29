<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>
</head>
<body>
	<%
	 String myname = (String)session.getAttribute("key-name");
	%>

<h1>Welcome: <%= myname %> </h1>
<a href="home.jsp">home</a>
<a href="about-us.jsp">aboutus</a>
<a href="logout">logout</a>
</body>
</html>