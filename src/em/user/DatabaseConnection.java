package em.user;

import java.sql.Connection;
import java.sql.DriverManager; 

//creating db connection
public class DatabaseConnection {
	 
	private static String url = "jdbc:mysql://localhost:3306/event_planning";
	private static String userName = "root";
	private static String password = "hash_99_HMDN";
	private static Connection con;
	
	//creating method to return connection
	public static Connection getConnection() {
		
		try {
			//connecting to the DB
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,userName,password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
}
