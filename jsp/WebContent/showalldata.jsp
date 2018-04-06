<%@page language="java"%>
<%@page import="java.sql.*"%>
<h1>Show all data</h1>
<form >
<input name="id" type="text" placeholder="id"/><br>
<button>Show Data</button>
</form>
<table border="1">
<%
try {
	String v1=request.getParameter("id");
	
	System.out.println(v1);
	String id=null;
	String name=null;
	String descriptions=null;
	String price= null;
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trimeals","root","");
	Statement smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
	ResultSet rs=smt.executeQuery("select * from menus where id='"+v1+"'");

if(rs.next())
{
%>
<tr>
<tr><td>Id</td><td><input type="text" name="name" value="<%=rs.getString("id")%>"></td></tr>
<tr><td>Name</td><td><input type="text" name="address" value="<%=rs.getString("name")%>"></td></tr>
<tr><td>Descriptions</td><td><input type="text" name="contact" value="<%=rs.getString("descriptions")%>"></td></tr>
<tr><td>Price</td><td><input type="text" name="email" value="<%=rs.getString("price")%>"></td></tr>
<%



id=rs.getString("id");
name=rs.getString("name");
descriptions=rs.getString("descriptions");
price=rs.getString("price");


}
}
catch(Exception e){System.out.println(e);}
%>
</table>