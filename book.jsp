<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><center>
<h3>Enter passenger details:</h3>

<form action="bookservlet" method="post">
First Name:
<input type="text"name="name"value="name"><br><br>
Age:
<input type="text"name="age"value="age"><br><br><br>

<input type="submit"value="Confirm Booking"><br><br>
<a href = "index.jsp">Cancel</a>

</form></center>
</body>
</html>