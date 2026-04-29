<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	 String myname = (String)session.getAttribute("key-name");
	%>

<h1>Welcome: <%= myname %> </h1>
<a href="home.jsp">home</a>
<a href="Profilepg.jsp">Profile</a>
</body>
</html>

</body>
</html>