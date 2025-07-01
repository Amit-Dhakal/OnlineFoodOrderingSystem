<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.Items"%>
<%@page import="controller.AddItemController"%>
<%@page import="connection.DbConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<p>WELCOME VEG WORLD </p>
<a href="login.jsp">BACK</a>
<br>
<br>

</head>

<body>

<%
Connection conn=DbConnection.getDbConnection();
PreparedStatement ps;
ResultSet rs;
Items items=null;
String sql="select * from restaurant where hotelname=?";
ps=conn.prepareStatement(sql);

ps.setString(1,"vegworld");

rs=ps.executeQuery();

List<Items> listItems=new ArrayList<Items>();

while(rs.next()){	
	 items=new Items();
	items.setId(rs.getInt("ID"));
	items.setItemnames(rs.getString("ITEMNAME"));
	items.setPrice(rs.getDouble("PRICE"));
	items.setHotelname(rs.getString("HOTELNAME"));
	listItems.add(items);
}
request.setAttribute("listItems",listItems);
%>
<table width="80%" border="2px solid black">
<tr>
<th>s.n</th>
<th>ITEMNAME</th>
<th>PRICE</th>
<th>HOTELNAME</th>
</tr>

<c:forEach items="${listItems}" var="listItems" varStatus="status">
<tr>
<td>${status.count}</td>
<td>${listItems.itemnames}</td>
<td>${listItems.price}</td>
<td>${listItems.hotelname}</td>

<td> 
<a href="<%=request.getContextPath()%>/orderitemUrl?action=vorder&vid=${listItems.id}">Order</a>
</td>


</tr>
</c:forEach>
</table>



</body>

</html>