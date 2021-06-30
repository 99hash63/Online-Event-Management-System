package em.createEvent;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EventDashboardController
 */
@WebServlet("/EventDashboardController")
public class EventDashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<EventDetails> details;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//session management
		HttpSession session = request.getSession();
		String un = session.getAttribute("userSession").toString();
		
		//getting event name of the button user clicked on my events page.
		String eName=  request.getParameter("eName");
		
		try {
			
			//Retrieving details of event by passing event name to the getEventDetails method
			details = EventDB.getEventDetails(eName);
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		//redirecting to Event Dashboard with relevant details.
		if(details != null) {
			request.setAttribute("event", details);
			RequestDispatcher dis = request.getRequestDispatcher("EventDashboard.jsp");
			dis.forward(request, response);
		}
			
	}

}
