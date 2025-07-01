<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="connection.DbConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="model.User"%>
<%@page import="model.Order"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<p>My Orders</p>
<body>

<%
Connection conn=null;
PreparedStatement ps;
ResultSet rs;

	conn=DbConnection.getDbConnection();
	String sql="select * from orderitem where username=?";
    ps=(PreparedStatement) conn.prepareStatement(sql);         
    ps.setString(1,session.getAttribute("userid").toString());     
	rs=ps.executeQuery();
	List<Order> itemsList=new ArrayList();
	
	while(rs.next()) 
	{
		Order order=new Order();
		
		order.setUsername(rs.getString("USERNAME"));			
		order.setItemname(rs.getString("ITEMNAME"));
		order.setPrice(rs.getDouble("PRICE"));
		order.setDatetime(rs.getString("DATETIME"));
		itemsList.add(order);
	}
	
	request.setAttribute("itemsList",itemsList);

%>


<c:forEach items="${itemsList}" var="itemsList" varStatus="status">

<ul>
 ${status.count} :) USERNAME:- ${itemsList.username}, ITEMNAME:- ${itemsList.itemname}, PRICE:- ${itemsList.price}, ORDER DATE:- ${itemsList.datetime}<br>

</ul>

</c:forEach>
 
 




<%-- <table width="80%" border="2 px solid black">

<tr>
<th>S.N</th>
<th>username</th>
<th>itemname</th>
<th>price</th>
<th>datetime</th>
</tr> 

<c:forEach items="${itemsList}" var="itemsList" varStatus="status">
<tr>
<td>${status.count}</td>
<td>${itemsList.username}</td>
<td>${itemsList.itemname}</td>
<td>${itemsList.price}</td>
<td>${itemsList.datetime}</td>
</tr>

</c:forEach>

</table>
 --%>

 
 
 

</body>
</html>