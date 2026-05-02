package in.kd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import in.kd.dbcon.DBconnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Registration")
public class Register extends HttpServlet{
private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    resp.sendRedirect("Registration.html"); // or your form page
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		String myname = req.getParameter("name1"); 
		String myemail = req.getParameter("email1");
		String mypass = req.getParameter("password1");
		String mycity = req.getParameter("city1");
		
		try {
			
			Connection con = DBconnection.getConnection();
			String sqlquery = "Insert into register values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sqlquery);
			ps.setString(1,myname);
			ps.setString(2, myemail);
			ps.setString(3, mypass);
			ps.setString(4, mycity);
			int count = ps.executeUpdate();
			
			
			if(count>0)
			{
				out.print("<h2 style='color:green'>Registration Succesfull</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/Login.html");
				rd.include(req, resp);
			}
			else
			{
				out.print("<h3 style='color:red'>Registration Faild</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/Registration.html");
				rd.include(req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace(out);
			System.out.println("error");
		}
		}
}
