<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="connection.DbConnection"%>
<%@page import="model.Items"%>
<%@page import="controller.AddItemController"%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<a href="login.jsp">BACK</a>
<br>
<br>

</head>
<body>
<%
Connection conn=null;
PreparedStatement ps;
ResultSet rs;
//session.getAttribute("selecteditem").toString();
Items items=null;
conn=DbConnection.getDbConnection();
String sql="select * from restaurant where hotelname=?";
ps=(PreparedStatement) conn.prepareStatement(sql);
ps.setString(1,"nonvegdelights");

rs=ps.executeQuery();
List<Items> listItems=new ArrayList<Items>();

while(rs.next())
{
	 items=new Items();
	items.setId(rs.getInt("ID"));
	items.setItemnames(rs.getString("itemname"));
	items.setPrice(rs.getDouble("price"));
	items.setHotelname(rs.getString("HOTELNAME"));
	listItems.add(items);	
	request.setAttribute("listItems",listItems);
}


%>

<form action="additemUrl" method="post">

<table width="80%" border="2px black">
<tr>

<th>S.N </th>
<th>ITEMNAME</th>
<th>PRICE</th>
<th>HOTELNAME</th>
</tr>
<c:forEach items="${listItems}" var="listItems" varStatus="status">
<tr></tr>

<td>${status.count}</td>
<td>${listItems.itemnames}</td>
<td>${listItems.price}</td>
<td>${listItems.hotelname}</td>

<td><a href="<%=request.getContextPath()%>/orderitemUrl?action=order&eid=${listItems.id}">Order</a></td>  
</c:forEach>
</tr>

</form>



</table>










</body>



</html>