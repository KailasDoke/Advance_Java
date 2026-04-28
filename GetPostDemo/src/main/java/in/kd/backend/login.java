package in.kd.backend;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginForm")
public class login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String pass = req.getParameter("pass");

//        res.setContentType("text/html");
//        PrintWriter out = res.getWriter();

        if ("kailasdoke100@gmail.com".equals(email) && "1223".equals(pass)) {
            System.out.println("Success");
        } 
        else {
            System.out.println("Fail");
        }
    }
}