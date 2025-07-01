<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="services.UserServiceImpl"%>
<%@page import="services.UserService"%>
<%@page import="model.User"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
 UserService userService=new UserServiceImpl();
List<User> listAllUser=new ArrayList<>();
listAllUser=userService.retrieveAllUserData();
request.setAttribute("listAllUser",listAllUser);
%>

 <table width="100%" border="2px solid green">

<tr>
<th>S.N</th>
<th>USERNAME</th>
<th>EMAIL</th>
<th>ADDRESS</th>
<th>PHONE</th>
</tr>

<tr>
<c:forEach items="${listAllUser}" var="user" varStatus="status">
<tr>
   <td>${status.count}</td>
	<td>${user.username}</td>
	<td>${user.email}</td>
		<td>${user.address}</td>
			<td>${user.phone}</td>
	
</tr>
</c:forEach>
</tr>
</table>











</body>
</html>