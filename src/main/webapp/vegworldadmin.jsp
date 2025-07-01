<%@page import="java.io.Writer"%>
<%@page import="java.awt.print.Printable"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Items"%>

   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.sql.Connection"%>
<%@page import="model.Items"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="connection.DbConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%
// session.getAttribute("selecteditem").toString().toUpperCase();
String selecteditem =(String) session.getAttribute("selecteditem");
out.println("WELCOME TO "+selecteditem.toUpperCase());
%>
</head>




<body>
<%
Connection conn=DbConnection.getDbConnection();
PreparedStatement ps;
ResultSet rs=null;
Items items=null;

String sql="select * from restaurant where hotelname=?";
ps=conn.prepareStatement(sql);
ps.setString(1,session.getAttribute("selecteditem").toString());

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


<table width="80%" border="1px solid black">

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
 <td>${listItems.hotelname}</td>.
<td>

<a href="<%=request.getContextPath()%>/additemUrl?action=deleteveg&vid=${listItems.id}">Delete</a>  

</td>


</tr>





</c:forEach>







</table>







</body>



</html>