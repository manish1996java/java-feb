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
<link href="CSS/bootstrap.min.css" rel="stylesheet">
<link href="CSS/showtable.css" rel="stylesheet">
</head>
<body>


<%@ include file="header.jsp"%>
<div id="container">
	<div class="mngmargin">
	<form action="status.jsp" method="GET">
	  <div class="form-group">
	    <label for="vname">Name</label>
	    <input type="text" class="form-control" id="vname" aria-describedby="emailHelp" placeholder="Enter Name" name="name">
	  </div>
	  <div class="form-group">
	    <label for="vstaffno">Staff No</label>
	    <input type="text" class="form-control" id="vstaffno" aria-describedby="emailHelp" placeholder="Enter Name" name="staff">
	  </div>
	  <div class="form-group">
	    <label for="vtype">Vehicle</label>
	    <input type="text" class="form-control" id="vtype" aria-describedby="emailHelp" placeholder="Enter Name" name="type">
	  </div>
	  <div class="form-group">
	    <label for="vehicleno">Vehicle No</label>
	    <input type="text" class="form-control" id="vehicleno" aria-describedby="emailHelp" placeholder="Enter Name" name="vnumber">
	  </div>
	  <div class="form-group">
	    <label for="vstickerno">Sticker No</label>
	    <input type="text" class="form-control" id="vstickerno" aria-describedby="emailHelp" placeholder="Enter Name" name="sticker">
	  </div>
	  <div class="form-group">
	    <label for="vsupportingdoc">Supporting Doc</label>
	    <input type="text" class="form-control" id="vsupportingdoc" aria-describedby="emailHelp" placeholder="Enter Name" name="doc">
	  </div>
	  <div class="form-group">
	    <label for="vcontact">Contact No</label>
	    <input type="text" class="form-control" id="vcontact" aria-describedby="emailHelp" placeholder="Enter Name" name="cnt">
	  </div>
	  <div class="form-group">
	    <label for="vsign">Signature</label>
	    <input type="text" class="form-control" id="vsign" aria-describedby="emailHelp" placeholder="Enter Name" name="sig">
	  </div>
	  <button type="submit" class="btn btn-danger">Submit</button>
	</form>
	</div>
</div>
<%@ include file="footer.jsp"%>

</body>
</html>