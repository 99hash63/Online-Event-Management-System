package register;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import em.user.UserDB;
import em.user.UserDetails;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean tf;
		
		//import statement for js code
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		//Retrieving data from login form 
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		
		
		try {
		//Creating EventManager object and passing user data to it's attributes
		UserDetails newUser = new UserDetails(0, name, email, address, phone, username, password);
		
		//passing EventManager object with relevant data to addUser method in EventManagerDB class
		tf= UserDB.addUser(newUser);
		
		//redirecting to login page if user registration is successful
		if(tf==true) {
			RequestDispatcher rd = request.getRequestDispatcher("loginUI.jsp");
			rd.forward(request, response);
		}
		//alert message using javaScript if registration is unsuccessful
		else {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('UserName already exists!');");
			out.println("location = 'RegisterUI.jsp'");
			out.println("</script>");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
