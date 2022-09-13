

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.usermanagement.bean.User;

public class UserDao {

	
	private String jdbcURL="jdbc:mysql://localhost:3306/ASSR";
	private String jdbcUsername="root";
	private String jdbcPassword="rootpasswordgiven";
	private String jdbcDriver="com.mysql.jdbc.Driver";
	
	
	
private static final String INSERT_USERS_SQL = "INSERT INTO users" + " (name,email) values " + " (?,?);";
private static final String SELECT_USER_BY_ID="select id,name,email from users where id=?";
private static final String SELECT_ALL_USERS ="select * from users";
private static final String DELETE_USERS_SQL="delete from users where id=?;";
private static final String UPDATE_USERS_SQL="update users set name=?,email=? where id=?;";




public UserDao() {
}

protected Connection getConnection() {
	
			Connection connection=null;
			try {
				Class.forName("jdbcDriver");
				connection=DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				// TODO: handl
				e.printStackTrace(); 
			}
			
	
	
	return connection;
}



// insert user
public void insertUser(User user) throws SQLException{
	System.out.println(INSERT_USERS_SQL);
	try(Connection connection=getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
		preparedStatement.setString(1, user.getName());
		preparedStatement.setString(2, user.getEmail());
		System.out.println(preparedStatement);
		preparedStatement.executeUpdate();
	}catch (SQLException e) {
		// TODO: handle exception
		printSQLException(e);
		
		
	}
}
//select user by id
public User selectUser(int id) {
	User user=null;
	try (Connection connection = getConnection();
	PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);){
		preparedStatement.setInt(1, id);
		System.out.println(preparedStatement);
		
		
		ResultSet rs=preparedStatement.executeQuery();
		while(rs.next()) {
			String name=rs.getString("name");
			String email=rs.getString("email");
			user=new User(id,name,email);
		}
		
	} catch (SQLException e) {
		// TODO: handle exception
		printSQLException(e);
	}
	return user;
}


// Select all users
public List<User> selectAllUsers(){
	List<User> users=new ArrayList<>();
	try(Connection connection = getConnection();
	PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);){
		System.out.println(preparedStatement);
		ResultSet rs=preparedStatement.executeQuery();
		while(rs.next()) {
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String email=rs.getString("email");
			users.add(new User(id, name, email));
		}
	}
		catch (SQLException e) {
			// TODO: handle exception
		printSQLException(e);	
		}
	return users;
	}


//Update user
public boolean updateUser(User user) throws SQLException{
	boolean rowUpdated;
	try(Connection connection = getConnection();
	PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);){
		System.out.println("Update User: "+statement);
		statement.setString(1, user.getName());
		statement.setString(2, user.getEmail());
		statement.setInt(3, user.getId());
		
		rowUpdated = statement.executeUpdate() > 0;
		
	}
	return rowUpdated;
	
	
}


// delete user
public boolean deleteUser(int id) throws SQLException {
	boolean rowDeleted;
	try (Connection connection = getConnection();
	PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);){
		statement.setInt(1, id);
		rowDeleted = statement.executeUpdate() > 0;
	}
	return rowDeleted;
}
 




private void printSQLException(SQLException ex) {
	for(Throwable e:ex) {
		if(e instanceof SQLException) {
			e.printStackTrace();
			System.err.println("SQLState: " + ((SQLException) e).getSQLState());
			System.out.println("Error Code: " + ((SQLException) e) .getErrorCode());
			System.out.println("Message: " + e.getMessage());
			Throwable t=ex.getCause();
			while(t!=null) {
				System.out.println("Cause: "+ t);
				t=t.getCause();
			}
		}
		
	}
}


}
