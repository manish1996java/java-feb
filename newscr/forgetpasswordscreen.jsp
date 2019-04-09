<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

				<div>
					<label> <a href=""> Forgot
							Password?</a>
					</label>
				</div>
				<div>
					<form action="ForgetPasswordOperation" method="POST" style="background-color:#eee;border-radius:15px" target="_blank" onsubmit="try {return window.confirm(&quot;This form may not function properly due to certain security constraints.\nContinue?&quot;);} catch (e) {return false;}">
						<h6>Please Enter your Registered
							Email Address</h6>

						<label>(<a href="mailto:e.g.xdfmail@gmail.com" target="_blank">e.g.xdfmail@gmail.com</a>)</label>

						<input type="email" name="inputpassword">
						<div>
							<label> </label>
						</div>
						<button type="submit">Send Password Reset
							Link</button>

					</form>
				</div>
				</body></html>