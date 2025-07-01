<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

 <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"> 
 
 $('btn').click(function()
 {
 console.log('you clicked on ');
 )};
 </script>
 
  -->
</head>

<body>

<form action="userLogin" method="post"  >

<input type="text" name="uname" value="username" ><br>
<input type="text" name="pwd" value="password" ><br>
<input type="submit" name="submit" value="Login" id="btn" ><br>

</form>

<form action="newuser.jsp" method="post" >
<input type="submit" name="submit" value="Add new user"  >
</form>


</body>
</html>