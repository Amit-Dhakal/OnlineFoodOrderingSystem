<%@page import="connection.DbConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Items"%>

<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
String selecteditemtwo =(String) session.getAttribute("selecteditem");
//out.println("WELCOME TO "+selecteditemtwo.toUpperCase());

%> 
</head>




<body>
<%

List<Items> listItems=new ArrayList<Items>();
Items items;
Connection conn=null;
PreparedStatement ps;
ResultSet rs=null;
conn=DbConnection.getDbConnection();
String sql="select * from restaurant where hotelname=?";
ps=(PreparedStatement) conn.prepareStatement(sql);	
ps.setString(1,session.getAttribute("selecteditem").toString());

rs=ps.executeQuery();

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



<table width="80%" border="2 px solid black">
<tr>
<th>S.N</th>
<th>itemname</th>
<th>price</th>
<th>hotelname</th>
</tr> 

<c:forEach items="${listItems}" var="listItems" varStatus="status">
<tr>
<td>${status.count}</td>
<td>${listItems.itemnames}</td>
<td>${listItems.price}</td>
 <td>${listItems.hotelname}</td>
 <td><a href="<%=request.getContextPath()%>/additemUrl?action=deletekfc&kid=${listItems.id}">Delete</a></td>  

</tr>


</c:forEach>


</table> 




</body>
</html>