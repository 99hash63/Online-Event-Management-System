package em.createEvent;

import java.io.IOException;
//import java.util.Date;
//import java.sql.Date;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EventController
 */
@WebServlet("/EventController")
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static boolean success;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//session management
		HttpSession session = request.getSession();
		String un = session.getAttribute("userSession").toString();
	
		
		//import statement for js code
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		try {
			
			//getting parameters from update event UI form inputs
			String name = request.getParameter("name");
			String type = request.getParameter("eventT");
			
			//passing date inputs into java.util.Date type variables 
			Date stDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("sd"));
			Date enDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ed"));
			
			//Converting java.util.Date to java.sql.date
			java.sql.Date sDate = new java.sql.Date(stDate.getTime());
			java.sql.Date eDate = new java.sql.Date(enDate.getTime());
	
			//passing time inputs into java.util.Date type variables
			Date stTime = new SimpleDateFormat("HH:mm").parse(request.getParameter("st"));
			Date enTime = new SimpleDateFormat("HH:mm").parse(request.getParameter("et"));
			
			//Converting java.util.Date to java.sql.Time
			java.sql.Time sTime = new java.sql.Time(stTime.getTime());
			java.sql.Time eTime = new java.sql.Time(enTime.getTime());
			
			//passing integer and double parameters to variables 
			Double budget = Double.parseDouble(request.getParameter("budget"));
			int noOfTickets = Integer.parseInt(request.getParameter("ticketIS"));
			Double ticketPrice =  Double.parseDouble(request.getParameter("ticketP"));
	
			//passing the user name of current user(retrieved by session management above) to getUID method.
			//getUID method returns current users user ID.
			int id = EventDB.getUID(un);
			
			//adding new event including the current users user ID as a foreign key.
			success = EventDB.addEvent(name, type, sDate, eDate,sTime,eTime,budget,noOfTickets,ticketPrice,id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(success == true) {
			
			//print success message if event created successfully
			out.println("<script type = 'text/javascript'>");
			out.println("alert('New event created successfully!')");
			out.println("loaction = 'EventManagerUI.jsp'");
			out.println("</script>");
			
			//redirect to event???????????????????????
			RequestDispatcher rd = request.getRequestDispatcher("mEvents");
			rd.forward(request, response);
		
		}else {
			
			//print unsuccessful message if event name already exists
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Event Name already exists! Please enter another event name')");
			out.println("loaction = 'CreateNewEventUI.jsp'");
			out.println("</script>");
			
		}
		

	}

}
