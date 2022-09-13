import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateServlet extends HttpServlet{
	
	Database D;
	@Override
		public void init() throws ServletException {
			
		 D=new Database();
		
		}

	
	
	
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String Name=(String) req.getAttribute("n");
	String Mobile=(String) req.getAttribute("m");
	String Password=(String) req.getAttribute("p");
	String confirm_password=(String) req.getAttribute("c");
	
	
	
	
	
	if(!Name.isEmpty() && Mobile.length()==10 && Password.compareTo(confirm_password)==0) {
		System.out.println("Validated");
		boolean choice=D.add(Name, Mobile,Password);
		if(choice) {
		resp.setContentType("text/html");
		RequestDispatcher rd1=req.getRequestDispatcher("/ADD-TODO.jsp");
			rd1.forward(req, resp);}
		else {
			resp.setContentType("text/html");
			RequestDispatcher rd1=req.getRequestDispatcher("/sign up.jsp");
				rd1.forward(req, resp);
			
		}
	}
	else {
		resp.setContentType("text/html");
		RequestDispatcher rd1=req.getRequestDispatcher("/sign up.jsp");
			rd1.forward(req, resp);
	}
	
}
}
