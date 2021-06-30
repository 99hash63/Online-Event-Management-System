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
 * Servlet implementation class MyEventsController
 */
@WebServlet("/MyEventsController")
public class MyEventsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int id;
	private static List<EventDetails> myEvents;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//session management
		HttpSession session = request.getSession();
		String un = session.getAttribute("userSession").toString();
		
		
		try {
			
		//passing the user name of current user(retrieved by session management above) to getUID method.
		//getUID method returns current users user ID.
		id = EventDB.getUID(un);
			
		//retrieving users event list by passing user Id to viewMyEvents method.
		myEvents = EventDB.viewMyEvents(id);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//redirecting to MyEventsUI with relevant details.
		if(myEvents != null) {
			request.setAttribute("myEvents", myEvents);
			RequestDispatcher dis = request.getRequestDispatcher("MyEventsUI.jsp");
			dis.forward(request, response);
		}
	}

}
