package in.demo.kailas;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/submitform")
public class demo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name1");
		String email = req.getParameter("email");
		
		System.out.println("Name :"+name); // Print on console ---------------	
		System.out.println("email : "+email);
		
		PrintWriter out = resp.getWriter();
		out.println("Name :"+name ); // Print on browser------- 
		out.println("email :"+email);

	}
}
