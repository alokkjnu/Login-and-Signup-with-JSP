<%@ page import="java.sql.*"%>

<%

String v1=request.getParameter("id");


try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trimeals","root","");
	Statement smt=con.createStatement();
	smt.executeUpdate("DELETE from menus where id='"+v1+"'");
	
	
	
}catch(Exception e){System.out.println(e);}

out.println("Deleted successfully");
response.sendRedirect("welcome.jsp");

%>

