<%@page import="services.UserService"%>
<%@page import="services.UserServiceImpl"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

Welcome ${userid},

<style type="text/css">

.topnav{
 background-color: #333;
  overflow: hidden;
}
.topnav a{

  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;

}
.topnav a:hover{
 background-color: #ddd;
  color: black;
}
.topnav a:active{
background-color: #04AA6D;
  color: white;
}

.link{

     text-align: center;
}

</style>
</head>

<body>


<div class="topnav">
<a class="active" href="#home" id="home">Home</a>
<a href="userorders.jsp" id="order">Your Orders</a>
<a href="feedback.jsp" id="feedback">Feedback</a>
<a href="index.jsp" id="logout">Log Out</a>
</div>


<div class="link">

<a href="vegworlduser.jsp"><img src="images/images.jpg"></a><br>
<p>VEG-WORLD</p><br><br>

<a href="kfcuser.jsp"><img src="images/chickenroast.jpg"></a><br>
<p>KFC</p1><br><br>

<a href="nonvegdelightsuser.jsp"><img src="images/nonveg.jpg"></a><br>
<p>NON-VEG DELIGHTS</p1><br>

</div>




<!-- <input type="submit" name="submit" src="images/images.jpg" Specfiy Image Border" alt="non veg delights"> <br> 
   <input type="submit" name="submit" src="images/images.jpg" Specfiy Image Border" alt="kfc">  <br><br>
   <input type="submit" name="submit" src="images/images.jpg" Specfiy Image Border" alt="veg world"> <br> 
 -->
 
 
</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

 $('#feedback').click(function()
{
	 
)}
 </script>
 
 

 
 
</html>






