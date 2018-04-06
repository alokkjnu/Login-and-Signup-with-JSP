<%@ page import="java.sql.*"%>

<%

String v1=request.getParameter("name");
String v2=request.getParameter("descriptions");
String v3=request.getParameter("price");
String v4=request.getParameter("id");

try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trimeals","root","");
	Statement smt=con.createStatement();
	smt.executeUpdate("UPDATE menus set name='"+v1+"', descriptions='"+v2+"', price='"+v3+"' where id='"+v4+"'");
	
	
	
}catch(Exception e){System.out.println(e);}

out.println("update successfully");
response.sendRedirect("welcome.jsp");

%>
