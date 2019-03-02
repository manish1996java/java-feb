<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<link href="CSS/bootstrap.min.css" rel="stylesheet"/>
		<link href="CSS/showtable.css" rel="stylesheet"/>
	<head>
	<body>
	
	<%@ include file="header.jsp" %>

	<div id="container">
	<div id="maintable" class="mngmargin">
		<h2>Upload Document</h2>	
		<hr>
		<form action="ServletDemo" method="GET">
	<!--  	ID <input type="text" name="id"/>
			Pass <input type="text" name="pass"/>  -->
			
			<div class="custom-file">
  			<input type="file" class="custom-file-input" id="customFile" name="path" accept=".docx,.doc">
  			<label class="custom-file-label" for="customFile">Choose file</label>
			</div>
			<button type="submit" class="btn btn-primary">submit</button>
		</form>
		
	</div>
	</div>
	<%@ include file="footer.jsp" %>
	</body>
</html>
</html>