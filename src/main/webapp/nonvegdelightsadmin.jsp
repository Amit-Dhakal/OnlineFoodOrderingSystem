<%@page import="java.sql.SQLException"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.Items"%>

<%@page import="connection.DbConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
String selecteditemone =(String) session.getAttribute("selecteditem");
//out.println("WELCOME TO "+selecteditemone.toUpperCase());
%>
                       
</head>
<body>
<p>ADD ITEMS</p>
<br>
<br>

<!-- 
<form action="additemUrl" method="POST">

<select name="hotelname" id="hotelname">
  <option value="nonvegdelights">NON-VEG DELIGHTS</option>
  <option value="kfc">KFC</option>
  <option value="vegworld">VEG WORLD</option>
</select><br>

<input type="text" name="itemname" value="itemname"><br>
<input type="text" name="price" value="price"><br>
<input type="submit" name="submit" value="ADD"><br>
</form>
 -->
<%
List<Items> listItems=new ArrayList<Items>();

Connection conn=null;
PreparedStatement ps;
ResultSet rs=null;
Items items=null;
try{
	conn=DbConnection.getDbConnection();
	String sql="select * from restaurant where hotelname=?";

	ps=(PreparedStatement) conn.prepareStatement(sql);		
	ps.setString(1,session.getAttribute("selecteditem").toString());
	rs = ps.executeQuery();
	 
	while(rs.next()){
		 items=new Items();
		items.setId(rs.getInt("ID"));
		items.setItemnames(rs.getString("ITEMNAME"));
		items.setPrice(rs.getDouble("PRICE"));
		items.setHotelname(rs.getString("HOTELNAME"));
		listItems.add(items);
	}	
}catch(SQLException e){
	
	e.printStackTrace();
}



request.setAttribute("listItems",listItems);



%>
<table width="80%" border="2 px solid black">

<tr>
<th>S.N</th>
<th>itemname</th>
<th>price</th>
<th>hotelname</th>
</tr> 

<c:forEach items="${listItems}" var="itemslist" varStatus="status">
<tr>
<td>${status.count}</td>
<td>${itemslist.itemnames}</td>
<td>${itemslist.price}</td>
<td>${itemslist.hotelname}</td>

<td><a href="<%=request.getContextPath()%>/additemUrl?action=delete&eid=${itemslist.id}">Delete</a></td>  
 
</tr>

</c:forEach>
</table>

</body>
</html>