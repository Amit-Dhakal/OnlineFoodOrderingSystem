<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

#feedback
{
    height:200px;
    font-size:14pt;
}


</style>
welcome to feedback page ${userid},


</head>
<body>
<%
HttpSession httpSession=request.getSession();
         httpSession.getAttribute("userid");
         
         HttpSession httpSession1=request.getSession();   
         httpSession1.getAttribute("email");

   %>
   
   
<form action="userFeedback" method="post">
<p>Username</p>
<input type="text" name="username" value="${userid}"><br>

<p>Email</p>
<input type="text" name="email" value="${email}"><br>

<p>Feedback</p>
<input type="text" name="feedback" id="feedback"><br>

<p>Submit Your Feedback</p>
<input type="submit" name="submit" value="send"><br>
 
</form>








</body>
</html>