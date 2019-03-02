<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="CSS/bootstrap.min.css" rel="stylesheet"/>
<link href="CSS/showtable.css" rel="stylesheet"/>
</head>
<body>
<%@ include file="header.jsp"%>
<div id="container">
	<div class="mngmargin">

<%

Connection con = null;
PreparedStatement ps = null;

String name = request.getParameter("name");
String staff = request.getParameter("staff");
String type = request.getParameter("type");
String vno = request.getParameter("vnumber");
String sticker = request.getParameter("sticker");
String suppDoc = request.getParameter("doc");
String contact = request.getParameter("cnt");
String signature = request.getParameter("sig");


Class.forName("com.mysql.cj.jdbc.Driver");
System.out.println("Driver loaded");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","manish@123");
System.out.println("connection established");

boolean flage = true;
int value = 0;

if(name != null && staff != null && type != null && vno != null && suppDoc != null && contact != null){
	flage = false;
	ps = con.prepareStatement("insert into vehicles_mst(vname,staff_no,vehicle_type,vehicle_no,supporting_doc,contact_no,signature) values(?,?,?,?,?,?,?); ");
	ps.setString(1, name);
	ps.setString(2, staff);
	ps.setString(3, type);
	ps.setString(4, vno);
	ps.setString(5, sticker);
	ps.setString(6, contact);
	ps.setString(7, signature);

	
	value = ps.executeUpdate();
	System.out.println("execute query");
}

if(flage){
if(name != null && staff == null && type == null){
	ps = con.prepareStatement("delete from vehicles_mst where vname=?");
	ps.setString(1, name);
	value = ps.executeUpdate();
	System.out.println("execute query");
}
}
if(value == 1){
	
%>	
	<h2>Successfull</h2>
<% 	
}else {
%>
	<h2>unsuccessfull</h2>
<% 
}

%>


 <form action="ServletDemo" method="GET">
	  <button type="submit" class="btn btn-primary">Show Table</button>
</form>
 

</div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>