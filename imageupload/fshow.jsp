<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script
  src="https://code.jquery.com/jquery-3.4.0.min.js"
  integrity="sha256-BJeo0qm959uMBGb65z40ejJYGSgR7REI4+CW1fNKwOg="
  crossorigin="anonymous">
</script>
<%
	String jsonname = (String) request.getAttribute("jsonname");
/*	out.println("jsonname :"+jsonname); */
	String imagepath = (String) request.getAttribute("image");
	String fullPath = "http://localhost:8080/DemoProject/upload/"+imagepath;
	out.println("imagepath :"+fullPath);
%>
<script>
	$(document).ready(function(){
		$("#moving").hide();
		console.log("ready is working");
		$("#file").change(function(){
			console.log("on change funtion");
			
			$("#moving").show();
		
		})
		
		var formData = new FormData(this);
			jQuery.each($('#file'))[0].files,function(i,file){
			
			formData.append('file-i,file');
			
		}
		
		xmlHttp.upload.addEventLitener('progress',function(event){
			console.log(event.loaded);
			
		})
		
		
	});
	
	
</script>

</head>
<body>
<form action="FileUploadServlet" method="post" enctype='multipart/form-data'>
		<img src="<%=fullPath%>" id="picture">
		Enter you Name:<input type="text" name="username">
		Choose file<input type="file" id="file" name="file">
		<input type="button" onClick="ajaxCall()" value="Get Picture">
		<input type="submit" id="button" value="submit">
		<img alt="" src="./movingline.gif" id="moving">
	</form>
	<script
  src="https://code.jquery.com/jquery-3.4.0.min.js"
  integrity="sha256-BJeo0qm959uMBGb65z40ejJYGSgR7REI4+CW1fNKwOg="
  crossorigin="anonymous"></script>
	<script>

</body>
</html>