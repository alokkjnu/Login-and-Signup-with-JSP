<%@ page import="java.sql.*"%>

<%
String user1=request.getParameter("email");
String pass1=request.getParameter("password");

try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trimeals","root","");
	PreparedStatement ps=con.prepareStatement("select * from user where email='"+user1+"' and password='"+pass1+"'");
	ResultSet rs=ps.executeQuery();
			
	while(rs.next()){
		user1=rs.getString("email");
		pass1=rs.getString("password");
	}
	
	
	if(user1.equals(user1) && pass1.equals(pass1)){
		
	}
	
}

	catch(Exception re){System.out.println(re);}

out.println("Login successfully");
response.sendRedirect("welcome.jsp");
%>

