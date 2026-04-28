package in.kd.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Handle GET request (to avoid 405 error)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.sendRedirect("Index.html"); // redirect to login page
    }

    // Handle POST request (form submission)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String myemail = req.getParameter("name");
        String pass = req.getParameter("password");
        PrintWriter out = resp.getWriter();

        if ("kailasdoke100@gmail.com".equals(myemail) && "123".equals(pass)) {

            req.setAttribute("key-name", "kailas");

            RequestDispatcher rd = req.getRequestDispatcher("Profilepg.jsp");
            rd.forward(req, resp);

        } else {
        	out.print(" email and pass not match ");
        	resp.setContentType("text/html"	);
            RequestDispatcher rd = req.getRequestDispatcher("Index.html");
            rd.include(req, resp);
        }
    }
}