<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>


<!--header-->
	<header>
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
	
	</header> 
	<hr class = "hr">
<!-- header-->



	<!--registration form-->
	<form action="reg" method="post">
		Name<input type="text" name="name"><br>
		Email<input type="text" name="email"><br>
		Address<input type="text" name="address"><br>
		Phone<input type="text" name="phone"><br>
		User Name<input type="text" name="userName"><br>
		Password<input type="text" name="password"><br>
		<input type="submit" name="submit" value="register">
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