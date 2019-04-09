<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="container">

<%
	String email = (String) request.getAttribute("email");
%>
<%=email%>
	<h2>Enter you new password</h2>
	<form action="UpdateNewPass" method="post">
	<div class="search">
		<input type="text" placeholder="enter you new password" name="pass">
		<input type="hidden" name="email" value="<%=email%>">
		<button>update password</button>
	</div>
	</form>
</div>
</body>	
</html>