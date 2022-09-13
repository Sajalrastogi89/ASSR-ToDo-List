import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Name=req.getParameter("name");
		String Mobile=req.getParameter("mobile");
		String Password=req.getParameter("password");
		
		
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ASSR","root","6386406886@S");
        PreparedStatement pstm=conn.prepareStatement("select * from ASSR1 where name=? and mobile=? and password=?");	
	pstm.setString(1, Name);
	pstm.setString(2, Mobile);
	pstm.setString(3, Password);
	ResultSet rs=pstm.executeQuery();
	if(rs.next()) {
		resp.setContentType("text/html");
		RequestDispatcher rd1=req.getRequestDispatcher("/ADD-TODO.jsp");
			rd1.forward(req, resp);
	}
	else {
		resp.setContentType("text/html");
		RequestDispatcher rd1=req.getRequestDispatcher("/sign up.jsp");
			rd1.forward(req, resp);
		
	}
	
	
	}
		catch (Exception e) {
			
		}
	}

}
