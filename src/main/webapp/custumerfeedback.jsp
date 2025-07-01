<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="services.UserServiceImpl"%>
<%@page import="services.UserService"%>
<%@page import="model.Feedback"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
Customer Feedback
<br>
<br>
</head>

<body>
<%
 UserService userService=new UserServiceImpl();
 List<Feedback> listUserFeedback=userService.retrieveAllUserFeedbackData();
 request.setAttribute("listUserFeedback",listUserFeedback);
 %>
<table width="100%" border="2px solid blue" >
	<tr>
		<th>s.n</th>
		<th>username</th>
		<th>email</th>
		<th>feedback</th>
	</tr>


	<c:forEach items="${listUserFeedback}" var="user" varStatus="status">
		<tr>
			<td>${status.count}</td>
			<td>${user.username}</td>
			<td>${user.email}</td>
			<td>${user.feedback}</td>			
	</c:forEach>
	<tr>	
	</tr> 

</table>
<%-- <a href="<%=request.getContextPath() %>/empUrl?action=edit&eId=${emp.id}">All Orders list</a></td>
 --%>
<%-- <a href="<%=request.getContextPath()%>/newUser?action=displayuser">All Users list</a></td><br>
<a href="allorder.jsp">All Orders list</a></td><br>
 --%>

<!-- <form action="alluser.jsp" method="get">

<input type="submit" name="submit" value="All Users list"><br>
<input type="submit" name="submit" value="All Orders list"><br>
<input type="submit" name="submit" value="All Order Users">

</form>
 -->

<a href="alluser.jsp">All Users List</a><br>
<a href="allorders.jsp">All Orders List</a><br>
<a href="alluser.jsp">All Orders Users</a>
<br>
<br>

 <p>To delete list</p>
<!-- <a href="restaurantlist.jsp">All Resturants</a>
 -->
 
 <a href="restaurantlist.jsp">All Resturants</a>

 
 <br>




</body>


</html>