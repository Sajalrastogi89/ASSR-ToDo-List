import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String Name=req.getParameter("name");
		String Mobile=req.getParameter("mobile");
		String Password=req.getParameter("password");
		String confirm_password=req.getParameter("confirm password");
		
		req.setAttribute( "n",Name);
		req.setAttribute("m",Mobile);
		req.setAttribute( "p",Password);
		req.setAttribute( "c",confirm_password);
		
		
		
		RequestDispatcher rq=req.getRequestDispatcher("/Validate");
		rq.forward(req, resp);
	}
	
	
}
