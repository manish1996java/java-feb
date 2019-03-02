
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
	<form action="status.jsp" method="GET">
	  <div class="form-group">
	    <label for="vname">Name</label>
	    <input type="text" class="form-control" id="vname" aria-describedby="emailHelp" placeholder="Enter Name" name="name" required>
	  </div>
	  <button type="submit" class="btn btn-danger">Submit</button>
	</form>
	</div>
</div>
<%@ include file="footer.jsp"%>

</body>
</html>

</body>
</html>