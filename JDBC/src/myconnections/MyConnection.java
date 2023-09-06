package myconnections;

import java.sql.Connection;		
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	
	Connection con;
	String user = "root";
	String password = "MyMySQL.123";
	String url = "jdbc:mysql://localhost:3306/javajdbc";
	
	public Connection getMyConection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} 
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
