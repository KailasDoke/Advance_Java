<%@ page import="in.kd.model.User" %>

<%
User ur = (User) session.getAttribute("session");
%>

<h2>Welcome</h2>

<%
if (ur != null) {
%>
    <h3>Name : <%= ur.getName() %></h3>
    <h3>Email : <%= ur.getEmail() %></h3>
    <h3>City : <%= ur.getCity() %></h3>
<%
} else {
%>
    <h3>Session expired or invalid login</h3>
<%
}
%>

<a href="logout">Logout</a>