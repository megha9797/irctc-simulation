<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h3>Enter your details:</h3>

<form action="registerservlet" method="post">
First Name:
<input type="text"name="firstname"value="firstname"><br><br>
Last Name:
<input type="text"name="lastname"value="lastname"><br><br>
User Id:
<input type="text"name="name"value="name"><br><br>
Password:
<input type="password"name="password"value="password"><br><br><br>

<input type="submit"value="submit"><br><br>
</form></center>
</body>
</html>