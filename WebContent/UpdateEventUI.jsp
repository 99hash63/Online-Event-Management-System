<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>


	<!-- header-->
	<header>
		<p>This is update event page</p>
		<!--Session Management-->
		<%
			String Uname =  (String)session.getAttribute("userSession");
			if(Uname == null){
				response.sendRedirect("loginUI.jsp");
			}
			else{
			}
		%>
		
	<img class="logo"  src="images/log.png" alt="Image cannot be loaded"  border ="0" height="80px"  width ="90px">

	<nav>
		<a href="home.html"> HOME</a>
		<a href="register.html"> REGISTER</a>
		<a href="login.html">LOGIN</a>
		<a href="contact us.html"> CONTACT US</a>
		<a href="about us.html"> ABOUT US</a>
		<a href="account.html">  ACCOUNT</a>
	</nav>
	
	<i>
		<h2 class = "title1"> Quick Plans</h2> <br>
		<h2 class = "title2"> 24x7 </h2> <br>
		<h2></h2>
	</i>
	
	
	<hr class = "hr">
	</header>
	<!-- header-->
		
		
	</header>

		<!--getting all parameters passed from event dashboard-->
		<%
			String id = request.getParameter("eid"); 
			String name = request.getParameter("name");
			String type = request.getParameter("type");
			String sd = request.getParameter("sd");
			String st = request.getParameter("st");
			String ed = request.getParameter("ed");
			String et = request.getParameter("et");
			String budget = request.getParameter("budget");
			String tp = request.getParameter("tp");
			String ti = request.getParameter("ti");
		%>

	<!--Update event form-->
	<form action="ue" method="post">
	
		Event Name<input type="text" name="name" value="<%= name %>"><br>
		
		<label for="eventT">Event Type</label>
			<select name="eventT" id="et" value="cb">
			  <option value="" disabled selected hidden ><%= type %></option>
			  <option value="Halloween Party">Halloween Party</option>
			  <option value="Musical Show">Musical Show</option>
			  <option value="Holi Festival">Holi Festival</option>
			  <option value="Beach Party">Beach Party</option>
			  <option value="Carnival">Carnival</option>
			  <option value="Stage Drama">Stage Drama</option>
			  <option value="Avurudu  Festival">Avurudu  Festival</option>
			   <option value="Event">other</option>
			</select><br>
			
		Start Date<input type="date" name="sd" value="<%= sd %>"><br>
		Start Time<input type="time" name="st" value="<%= st %>"><br>
		End Date<input type="date" name="ed" value="<%= ed %>"><br>
		End Time<input type="time" name="et" value="<%= et %>"><br>
		Target Budget<input type="text" name="budget" value="<%= budget %>"><br>
		Number of tickets to issue<input type="number" name="ticketIS" value="<%= ti %>"><br>
		Price of one ticket<input type="text" name="ticketP" value="<%= tp %>"><br>
		
		<button name="eid" value="<%= id %>">submit</button>
		</form> 
	<!--end of Update event form-->
	
	
	<!-- footer -->

<div class="footer">
	<div class= "follow">Follow us on </div>
	<div class="getthe">Get the app </div>
	<div class="copy">Copyright &copy; Quick Plans PLC <br> 165/9, <br>Pelenwatta,<br> Pannipitiya. </div>

	<div class="socialbuttons">
		<a href="https://www.facebook.com"><img src="images/footer/fb.png" alt="facebook" class="fb"></a>
		<a href="https://www.instagram.com"><img src="images/footer/insta.webp" alt="instagram" class="insta"></a>
		<a href="https://www.twitter.com"><img src="images/footer/twitter.png" alt="twitter" class="twitter"></a>
		<a href="https://www.play.google.com"><img src="images/footer/android.png" alt="play store" class="android"></a>
		<a href="https://www.apple.com/ios/app-store/"><img src="images/footer/ios.png" alt="app store" class="ios" ></a>
	</div>

</div>

</body>
</html>