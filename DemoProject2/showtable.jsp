
<%@page import="com.bmpl.DTO.VehicleDTO"%>
<%@page import="com.bmpl.DAO.VehicleDAO"%>
<%@ page language="java"  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="CSS/bootstrap.min.css" rel="stylesheet"/>
<link href="CSS/showtable.css" rel="stylesheet"/>
</head>
<body>

<%@ include file="header.jsp" %>

<div id="container">
	<div id="maintable" class="mngmargin">
	<form action="addpage.jsp" method="GET">
  		<div class="form-group">	
		<div class="btn-group" role="group" aria-label="Basic example">
				<button type="submit" class="btn btn-primary">Add</button>
		</div>
		</div>
	</form>
	<form action="remove.jsp" method="GET">
  		<div class="form-group">	
		<div class="btn-group" role="group" aria-label="Basic example">
				<button type="submit" class="btn btn-danger">Remove</button>
		</div>
		</div>
	</form>
	<%
	VehicleDAO vdao = new VehicleDAO();
	ArrayList<VehicleDTO> listFromDB = new ArrayList<>();

	listFromDB = vdao.showData();
	
	%>
	
	
	

		<table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">Sno.</th>
		      <th scope="col">Name</th>
		      <th scope="col">Staff No.</th>
		      <th scope="col">Vehicle</th>
		      <th scope="col">Vehicle no.</th>
		      <th scope="col">Sticker no.</th>
		      <th scope="col">Supporting documents</th>
		      <th scope="col">Contact no</th>
		      <th scope="col">Signature</th>
		    </tr>
		  </thead>
		  <tbody>

<%
int i = 1;
for(VehicleDTO vdto: listFromDB){
	
%>
		<tr>
	      <th scope="row"><% out.println(i); %></th>
	      <td><% out.println((vdto.getName())); %></td>
	      <td><% out.println((vdto.getStaffNo())); %></td>
	      <td><% out.println((vdto.getType())); %></td>
	      <td><% out.println((vdto.getVehicleNo())); %></td>
	      <td><% out.println((vdto.getStickerNo())); %></td>
	      <td><% out.println((vdto.getSupportingDoc())); %></td>
	      <td><% out.println((vdto.getContactNo())); %></td>
	      <td><% out.println((vdto.getSignature())); %></td>
	    </tr>
<%
i++;
}
%>		  
		  		  
		    
		  </tbody>
		</table>
		
	</div>
</div>		
		<%@ include file="footer.jsp" %>

</body>
</html>