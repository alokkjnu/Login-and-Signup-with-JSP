<%@ page language="java" import ="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registration</h1>

<form action="reg.jsp" method="post">
<label for="name"><b>Name</b></label>
<input name="name" type="text" placeholder="name" value=""/><br>
<label for="email"><b>Email</b></label>
<input name="email" type="text" placeholder="Email" value=""/><br>
<label for="password"><b>Password</b></label>
<input name="password" type="text" placeholder="password" vlaue=""/><br>

<button type="submit">Register</button>
<button onclick="window.location.href='login.jsp'">Login</button><br>
</form>

</body>
</html>