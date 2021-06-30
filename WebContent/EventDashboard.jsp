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
		<p>This is event dashboard </p>
		<!--Session Management-->
		<%
			String name =  (String)session.getAttribute("userSession");
			if(name == null){
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
		
	
	<!--Displaying all details of relevant event-->
	<c:forEach var="us" items="${event}">
	
		${us.name}<br>
		${us.type}<br>
		${us.sd}<br>
		${us.st}<br>
		${us.ed}<br>
		${us.et}<br>
		${us.budget}<br>
		${us.tp}<br>
		${us.ti}<br>
		
		<!--Setting current details to passable parameters for variable updateE-->
		<c:url value="UpdateEventUI.jsp" var="updateE">
			<c:set var="eventID" value="${us.eID}"/>
			<c:param name="eid" value="${us.eID}"/>
			<c:param name="name" value="${us.name}"/>
			<c:param name="type" value="${us.type}"/>
			<c:param name="sd" value="${us.sd}"/>
			<c:param name="st" value="${us.st}"/>
			<c:param name="ed" value="${us.ed}"/>
			<c:param name="et" value="${us.et}"/>
			<c:param name="budget" value="${us.budget}"/>
			<c:param name="tp" value="${us.tp}"/>
			<c:param name="ti" value="${us.ti}"/>
		</c:url>
	</c:forEach>
	
	<!--Button redirects to update event UI and passes all parameters of variable updateE-->
	<a href="${updateE}">
	<input type="button" name="update" value="Update Event Details">
	</a>
	
	<!--Button redirects to delete event controller-->
	<form action="eDel" method="post">
	<button name="eid" value="${eventID}">delete event</button>
	</form>
	
	
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