package em.createEvent;

import java.io.IOException;
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
import em.user.UserDB;
import em.user.UserDetails;

/**
 * Servlet implementation class UpdateEventController
 */
@WebServlet("/UpdateEventController")
public class UpdateEventController extends HttpServlet {
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
			int id = Integer.parseInt(request.getParameter("eid"));
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
			
			//calling update method in EventDB class
			success = EventDB.updateEvent(name, type, sDate, eDate,sTime,eTime,budget,noOfTickets,ticketPrice,id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//If event update is successful
		if(success == true) {
			
			//display successful message
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Event updated successfully!')");
			out.println("loaction = 'EventManagerUI.jsp'");
			out.println("</script>");
			
			//redirecting to my events UI page with new event list
			RequestDispatcher rd = request.getRequestDispatcher("mEvents");
			rd.forward(request, response);
		}
		
		//If event name already exist
		else {
			
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Event Name already exists! Please enter another event name')");
			out.println("loaction = 'CreateNewEventUI.jsp'");
			out.println("</script>");
			
		}
		
	}
}
