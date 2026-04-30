package in.kd.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/regForm")
public class Register extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    resp.sendRedirect("Register.jsp"); // or your form page
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		String myname = req.getParameter("name");
		String myemail = req.getParameter("email");
		String mypass = req.getParameter("pass");
		String mycity = req.getParameter("city");
		String mygender = req.getParameter("gender");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","Kailas@2004" );
			PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?)");
			ps.setString(1, myname);
			ps.setString(2, myemail);
			ps.setString(3, mypass);
			ps.setString(4, mycity);
			ps.setString(5, mygender);
			
			int count = ps.executeUpdate();
			
			if(count>0)
			{
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'> user register successfully<h3>");
				
				RequestDispatcher rd = req.getRequestDispatcher("/Register.jsp");
				rd.include(req, resp);
				
			}
			else
			{
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'> user register Unsuccessfully<h3>");
				
				RequestDispatcher rd = req.getRequestDispatcher("/Register.jsp");
				rd.include(req, resp);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'> user register failed<h3>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/Register.jsp");
			rd.include(req, resp);
		}
		{
			
		}
		
	}
}
