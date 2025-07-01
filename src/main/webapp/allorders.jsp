<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="connection.DbConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="model.Order"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
Connection conn=DbConnection.getDbConnection();
PreparedStatement ps;
ResultSet rs;
List<Order> listOrders=new ArrayList<Order>();

String sql="select * from orderitem";
ps=conn.prepareStatement(sql);

rs=ps.executeQuery(sql);

while(rs.next()){
	
	Order order=new Order();
	order.setId(rs.getInt("ID"));
	order.setUsername(rs.getString("USERNAME"));
	order.setItemname(rs.getString("ITEMNAME"));
	order.setPrice(rs.getDouble("PRICE"));
	order.setDatetime(rs.getString("DATETIME"));
	listOrders.add(order);

}
request.setAttribute("listOrders", listOrders);

%>

<table width="100%" border="2px solid black">

<tr>
<th>id</th>
<th>USERID</th>
<th>ITEM</th>
<th>PRICE</th>
<th>ORDER DATE</th>
</tr>

<c:forEach items="${listOrders}" var="listOrders" varStatus="status">
<tr>
<td>${status.count}</td>
<td>${listOrders.username}</td>
<td>${listOrders.itemname}</td>
<td>${listOrders.price}</td>
<td>${listOrders.datetime}</td>

</c:forEach>

</tr>





</table>












</body>
</html>