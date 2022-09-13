import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet{
	Database d=new Database();
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String Todo=req.getParameter("todo");
	String Status=req.getParameter("status");
	
   boolean check1= d.add1(Todo, Status);
	if(check1) {
		resp.setContentType("text/html");
		RequestDispatcher rd1=req.getRequestDispatcher("/home1.jsp");
			rd1.forward(req, resp);}
	}
}
