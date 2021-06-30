package em.createEvent;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteEventController
 */
@WebServlet("/DeleteEventController")
public class DeleteEventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static boolean success;
	private static int eventID;

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
		
		//getting event ID of the event to be deleted
		eventID = Integer.parseInt(request.getParameter("eid"));
		
		try {
			//calling deleteEvent method by passing relevant ID
			success = EventDB.deleteEvent(eventID);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		if(success==true) {
			//Displaying delete successful message
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Event deleted successfully!')");
			out.println("loaction = 'EventDashboard.jsp'");
			out.println("</script>");
			
			//redirecting to my events UI page with new event list
			RequestDispatcher rd = request.getRequestDispatcher("mEvents");
			rd.forward(request, response);
		
		}
	}
}
