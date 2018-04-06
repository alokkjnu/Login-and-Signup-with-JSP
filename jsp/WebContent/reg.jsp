<%@ page import="java.sql.*"%>

<%

String v1=request.getParameter("email");
String v2=request.getParameter("password");
String v3=request.getParameter("name");

try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trimeals","root","");
	Statement smt=con.createStatement();
	smt.executeUpdate("insert into user(name,email,password) values('"+v3+"','"+v1+"','"+v2+"')");
	
	
	
}catch(Exception e){System.out.println(e);}

out.println("Registered successfully");
response.sendRedirect("Login.jsp");

%>

