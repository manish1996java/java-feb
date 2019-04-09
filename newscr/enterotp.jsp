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

	String username = (String) request.getAttribute("username");
	String email = (String) request.getAttribute("emailadd");
	String otp = (String) request.getAttribute("otp");
	%>

<div id="container">
	<h2>OTP page</h2>
	<form action="ConfirmOtp" method="POST" onsubmit="">
	
	<div class="search">
	
		<h3><%=username %></h3>
		<input type="text" placeholder="enter otp" name="otp">
		<input type="hidden" name="email" value="<%=email%>" />
		<input type="hidden" name="username" value="<%=username%>" />
		<input type="hidden" name="dbotp" value="<%=otp%>" />
		<button type="submit">submit</button>
	</div>
	</form>
</div>
</body>
</html>