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
	 String myname = (String)request.getAttribute("key-name");
	%>

<h1>Welcome: <%= myname %> </h1>
<a href="Profilepg.jsp">Profile</a>
<a href="about-us.jsp">aboutus</a>
</body>
</html>

</body>
</html>