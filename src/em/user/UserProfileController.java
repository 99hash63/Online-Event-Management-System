package em.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserProfileController
 */
@WebServlet("/UserProfileController")
public class UserProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<UserDetails> details;
	
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
			
		//Retrieving user profile details of currently logged in Event Manager using session attributes.
		details = UserDB.getUser(un);
		request.setAttribute("user", details);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Redirecting to user profile page with the relevant data
		if(details != null) {
			RequestDispatcher dis = request.getRequestDispatcher("UserProfileUI.jsp");
			dis.forward(request, response);
			}
		
	}

}
