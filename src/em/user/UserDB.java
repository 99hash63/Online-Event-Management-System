package em.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDB {

	private static Connection c;
	private static Statement stmt;
	private static ResultSet rsR;
	private static int rsI;
	private static boolean status;
	

	//Validating user
	public static boolean validate(String userName, String password){
			 
		try {
				
			//connecting to DB
			c = DatabaseConnection.getConnection();
			stmt = c.createStatement();
			String sqlStatement = "select * from user where username='"+userName+"'and password='"+password+"'";
			rsR = stmt.executeQuery(sqlStatement);
				
			//if rs returns true
			if(rsR.next()) {
				status = true;
					
			}
			//else
			else {
				status = false;
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return status;
		
	}
		
	//adding new event manager(register)
	public static boolean addUser(UserDetails newUser){
						
		//getting attributes of UserDetails class with relevant data
		 int id = newUser.getId();
		 String name = newUser.getName(); 
		 String email = newUser.getEmail();
		 String address = newUser.getAddress();
		 String phone = newUser.getPhone(); 
		 String username = newUser.getUsername(); 
		 String password = newUser.getPassword();
			
		try {
		
			 //connecting to DB
		     c = DatabaseConnection.getConnection();
			 stmt = c.createStatement();
			 String sqlStatement = "insert into user values('"+id+"','"+name+"','"+email+"','"+address+"','"+phone+"','"+username+"','"+password+"')";
			 rsI = stmt.executeUpdate(sqlStatement);
				
			 if(rsI>0) {
				 status = true;
			 }
			
			 else {
				 status = false;	
			 }
					
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return status;
	}
	
//	method for viewing user profile(Retrieving user datails )
	public static List<UserDetails> getUser(String userName){
		
		ArrayList<UserDetails> useDT = new ArrayList<>();
		String un = userName;
		
		try {
			
			//connecting to DB
			c = DatabaseConnection.getConnection();
			stmt = c.createStatement();
			String sqlQuery = "select * from user where userName = '"+un+"'";
			rsR = stmt.executeQuery(sqlQuery);
			
			if(rsR.next()) {
				
				//assigning values from database to variables
				int id = rsR.getInt(1);
				String name = rsR.getString(2); 
				String email = rsR.getString(3);
				String address = rsR.getString(4);
				String phone = rsR.getString(5); 
				String username = rsR.getString(6); 
				String password = rsR.getString(7);
					
				UserDetails getUser = new UserDetails(id,name,email,address,phone,username,password);
				useDT.add(getUser);
				
			}else {
				return null;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return useDT;
		
	}
}
