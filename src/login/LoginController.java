package login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import em.user.UserDB;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static boolean success;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//import statement for js code
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		//Retrieving data from login form 
		String username = request.getParameter("uid");
		String pwd = request.getParameter("pass");
		
		//session management
		HttpSession session = request.getSession();
		session.setAttribute("userSession", username);
		
		
		try {
		//validating user name and password
		 success = UserDB.validate(username, pwd);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//For valid user login credentials 
		if(success==true) {
			
			RequestDispatcher rd = request.getRequestDispatcher("EventManagerUI.jsp");
			rd.forward(request, response);
		}
		
		//For invalid user login credentials 
		else {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Please enter valid username and password');");
			out.println("location = 'loginUI.jsp'");
			out.println("</script>");
			
		}
	}

}
