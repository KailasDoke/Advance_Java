package in.kd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.kd.dbcon.DBconnection;
import in.kd.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")

public class Login extends HttpServlet{
private static final long serialVersionUID = 1L;

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("Login.html"); 	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		String myemail = req.getParameter("email1");
		String mypass = req.getParameter("password1");
		 
		try {
			Connection con = DBconnection.getConnection();
			
			String select_query = "SELECT * FROM register WHERE email=? AND password=?";
			PreparedStatement ps = con.prepareStatement(select_query);
			ps.setString(1, myemail);
			ps.setString(2, mypass);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				User ur = new User();
				ur.setName(rs.getString("name"));
				ur.setEmail(rs.getString("email"));
				ur.setCity(rs.getString("city"));
				
				HttpSession session = req.getSession();
				session.setAttribute("session",ur);
				
				RequestDispatcher 	rd = req.getRequestDispatcher("/Profile.jsp");
				rd.forward(req, resp);
			}
			else
			{
				out.print("<h1 style='color:red'> registration Failed</h1>");
				
				RequestDispatcher rd = req.getRequestDispatcher("/Login.html");
				rd.include(req, resp);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
