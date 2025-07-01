<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
</body>
</html>