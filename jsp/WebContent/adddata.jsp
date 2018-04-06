<%@ page import="java.sql.*"%>

<%

String v1=request.getParameter("name");
String v2=request.getParameter("descriptions");
String v3=request.getParameter("price");

try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trimeals","root","");
	Statement smt=con.createStatement();
	smt.executeUpdate("insert into menus(name,descriptions,price) values('"+v1+"','"+v2+"','"+v3+"')");
	
	
	
}catch(Exception e){System.out.println(e);}

out.println("Registered successfully");

%>

