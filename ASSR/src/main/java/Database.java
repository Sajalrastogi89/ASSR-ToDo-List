import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Database {
   
	Connection conn=null;
	Statement stm=null;
	ResultSet rs=null;
public Database() {
	
	
			
			
try {
	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ASSR","root","6386406886@S");
	conn.createStatement();
	System.out.println("Connected");
} catch (Exception e) {
	// TODO Auto-generated catch block
	System.out.println("Not Connected");
}
			
		
}
	
	
	
	
	
	public boolean add(String Name,String  Mobile,String Password){
		try {
			
			String insert="insert into ASSR1(Name,Mobile,Password) values(?,?,?)";
			PreparedStatement pstm=conn.prepareStatement(insert);
			pstm.setString(1, Name);
			pstm.setString(2, Mobile);
			pstm.setString(3, Password);
			pstm.execute();
			
			
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Data Not Inserted" + e);
			System.out.println();
			return false;
		}
	}
		public boolean add1(String todo,String  status){
			try {
				
				String insert="insert into users(todo,status) values(?,?)";
				PreparedStatement pstm=conn.prepareStatement(insert);
				pstm.setString(1, todo);
				pstm.setString(2, status);
			
				pstm.execute();
				
				
				
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Data Not Inserted" + e);
				System.out.println();
				return false;
			}
		
		
		
		
	}
		
	
	
	
	
	
	
	
}
