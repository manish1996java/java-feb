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
</head>
<body>
<%

Connection con = null;
PreparedStatement ps = null;

String name = request.getParameter("name");
String staff = request.getParameter("staff");
String type = request.getParameter("type");

Class.forName("com.mysql.cj.jdbc.Driver");
System.out.println("Driver loaded");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","manish@123");
System.out.println("connection established");
ps = con.prepareStatement("insert into vehicles_mst(vname,staff_no,vehicle_type) values(?,?,?); ");
ps.setString(1, name);
ps.setString(2, staff);
ps.setString(3, type);
ps.executeUpdate();
System.out.println("execute query");

%>



</body>
</html>