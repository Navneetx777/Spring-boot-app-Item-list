<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Items</title>
</head>
<body>
	<form action = "/api/v1/items" method="post">
		<label>Id : </label>
		<br>
		<input type = "text" name = "id">
		<br>
		<label>Name : </label>
		<br>
		<input type = "text" name = "name">
		<br>
		<label>Quantity : </label>
		<br>
		<input type = "text" name = "quantity">
		<br>
		<input type = "submit" name = "submit">
	</form>
	<br>
	<form action = "/api/v1/items" method="get">
		<input type = button name = "Show list">
	</form>
</body>
</html>