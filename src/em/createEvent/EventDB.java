package em.createEvent;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import em.user.DatabaseConnection;

public class EventDB {
	            
	//attributes for getting connection and executing sql query
	private static boolean status;
	private static Connection c;
	private static Statement stmt;
	private static int ri;
	private static ResultSet rr;
	
	
	//method returns user ID when user name is passed as parameter
	public static int getUID(String userName) {
		
		int id = 0;
		
		try {
			
			//getting user id of the current loged in user
			c = DatabaseConnection.getConnection();
			stmt = c.createStatement();
			String sqlQuery = "select id from user where userName = '"+userName+"'";
			rr = stmt.executeQuery(sqlQuery);
			
			if(rr.next()) {
			//id of the current loged in user
				id = rr.getInt(1);
			}
			
			else {
				id = 0;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	//adding new event with relevant user id
	public static boolean addEvent(String name, String type, Date sd, Date ed, Time st, Time et, double budget, int noOfTickets, double ticketPrice, int id) {
	
		
		try {
			
			//inserting new event to the public_event table
			c = DatabaseConnection.getConnection();
			stmt = c.createStatement();			
			String sqlStatement = "insert into public_event(eventID,name,type,startDate,endDate,startTime,endTime,budget,ticketPrice,ticketsIssued,userID) values(0,'"+name+"','"+type+"','"+sd+"','"+ed+"','"+st+"','"+et+"','"+budget+"','"+noOfTickets+"','"+ticketPrice+"','"+id+"')";
			ri =  stmt.executeUpdate(sqlStatement);
			
			if(ri>0) {
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
	
	//method to retrieve all events of relevant event manager when user ID is given as parameter
	public static List<EventDetails> viewMyEvents(int uID) {
		
		ArrayList<EventDetails> myEvents = new ArrayList<>();
		
		try {
			
			//getting name and type of all events of the relevant event manager
			c = DatabaseConnection.getConnection();
			stmt = c.createStatement();
			String sqlSt = "select name,type from public_event where userID = '"+uID+"'";
			rr = stmt.executeQuery(sqlSt);
			
			while(rr.next()) {
				
				String name = rr.getString(1); 
				String type = rr.getString(2);
					
				EventDetails ed = new EventDetails(name,type);
				myEvents.add(ed);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return myEvents;
	
	
	}
	
	//method returns all details of event when event name is given as parameter
	public static List<EventDetails> getEventDetails(String eName){
		
		ArrayList<EventDetails> eventDetails = new ArrayList<>();
		
		try {
			
			//getting details of event
			c = DatabaseConnection.getConnection();
			stmt = c.createStatement();
			String sqlSt = "select * from public_event where name = '"+eName+"'";
			rr = stmt.executeQuery(sqlSt);
			
			if(rr.next()) {
				
				 int eID = rr.getInt(1); 
				 String name = rr.getString(2);  
				 String type = rr.getString(3);
				 java.util.Date sd = rr.getDate(4);
				 java.util.Date st = rr.getTime(5); 
				 java.util.Date ed = rr.getDate(6); 
				 java.util.Date et = rr.getTime(7);
				 Double budget = rr.getDouble(8); 
				 Double tp = rr.getDouble(9); 
				 int ti = rr.getInt(10); 
				 int ts = rr.getInt(11); 
				 int uID = rr.getInt(12);
					
				EventDetails detailObject = new EventDetails(eID, name, type, sd, st, ed, et, budget, tp, ti, ts, uID);
				eventDetails.add(detailObject);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return eventDetails;
	
	}
	
	//method to update an existing event
	public static boolean updateEvent(String name, String type, Date sd, Date ed, Time st, Time et, double budget, int noOfTickets, double ticketPrice, int id) {
	
		
		try {
			
			//updating all data of the event with the given id 
			c = DatabaseConnection.getConnection();
			stmt = c.createStatement();			
			String sqlStatement = "UPDATE event_planning.public_event SET name='"+name+"', type='"+type+"', startDate='"+sd+"', startTime='"+st+"', endDate='"+ed+"', endTime='"+et+"', budget='"+budget+"', ticketPrice='"+ticketPrice+"', ticketsIssued='"+noOfTickets+"' WHERE eventID='"+id+"'";
			ri =  stmt.executeUpdate(sqlStatement);
			
			if(ri>0) {
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

	
	
	//method to delete an event when id is given as parameter
	public static boolean deleteEvent(int id) {
	
		try {
			
			//deletes row according to the relevant event ID
			c = DatabaseConnection.getConnection();
			stmt = c.createStatement();			
			String sqlStatement = "DELETE FROM event_planning.public_event WHERE eventID = '"+id+"';";
			ri =  stmt.executeUpdate(sqlStatement);
			
			if(ri>0) {
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

}
	

