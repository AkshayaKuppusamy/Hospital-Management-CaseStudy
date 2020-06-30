<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABC Hospital Management System</title>

<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	margin: 0;
	background-color: #97FFFF;
}

.header {
	padding: 10px;
	text-align: center;
	background: #66CCCC;
	color: white;
}

.header h1 {
	text-align: center;
}

.navbar {
	overflow: hidden;
	background-color: #66CCCC;
	font-family: Arial;
}

.navbar a {
	float: left;
	font-size: 16px;
	color: black;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: black;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.navbar a:hover, .dropbtn:hover {
	background-color: #37FDFC;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #66CCCC;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #37FDFC;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.disable {
	pointer-events: none;
	cursor: default;
}

.main {
	padding: 80px;
	
}
.main h2{
	text-align:center;
	
}
form { 
	margin: 0 auto; 
	width:400px;
}
p{
	font-size: small; 
}


</style>
</head>
<body>
	<%
	  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		if(session.getAttribute("user")==null){
			response.sendRedirect("index.jsp");
		}
	%>
	<div class="header">
		<h1>ABC Hospital Management System</h1>
	</div>
	
	
	<div class="navbar">
		<div class="dropdown">
			<button class="dropbtn">Patient</button>
			<div class="dropdown-content">
				<a href="create_patient.jsp">Create Patient</a> 
				<a href="Update_Patient.jsp">Update Patient</a> 
				<a href="Delete_Patient.jsp">Delete Patient</a>
				<a href="ViewPatients_controller">View Patients</a> 
				<a href="SearchPatientById.jsp">Search Patient</a>
				<a href="#">Billing</a> 
			</div>
		</div>
		<a href="#" class="disable">Pharmacy</a> 
		<a href="#" class="disable">Diagnostics</a> 
		<a href="logout.jsp">Log out</a>
	</div>
	
	<div class="main">
		<h2>Delete Patient</h2>
 	<div class="register">

 	 <form action="DeletePatient_Controller" method="post">
 		<table>
 		 
 		 	<tr>
 				<td>
 					<label class="required">Patient ID</label>
 				</td>
 				<td>
 					<input type="number" id="patientId" name="patientId" required value="${patientsRecord.getPatient_id()}" >
 				</td>
 				<td>
 				   <input type="submit" name="fetchdata" value="Get" >
 				</td>
 			</tr>
<!-- 
	 	  <tr>
	 	  	<td><label class="required">Patient SSN ID</label></td>
	 	  	<td colspan=2>
	 	  	<input readonly type="number" id="patientId" name="patientSSnId" value="${patientsRecord.getPatient_ssn_id()}"></td>
	 	  </tr>
	 --> 	  
	 	  <tr>
	 	  	<td><label class="required">Patient Name</label></td>
	 	  	<td colspan=2>
	 	  	<input readonly type="text" id="name" name="name" value="${patientsRecord.getPatient_name()}"></td>
	 	  </tr>
	 	  
	 	  <tr>
	 	  	<td><label class="required">Patient Age</label></td>
	 	  	<td colspan=2>
	 	  	<input readonly type="number" id="age" name="age" value="${patientsRecord.getPatient_age()}"></td>
	 	  </tr>
	 	  <tr>
	 	  	<td><label class="required">Patient Admitted Date</label></td>
	 	  	<td colspan=2>
	 	  	<input readonly type="text" id="date_of_admission" name="date_of_admission" value="${patientsRecord.getDate_of_admission()}"></td>
	 	  </tr>
	 	  <tr>
	 	  	<td><label class="required">Type of Bed</label></td>
	 	  	<td colspan=2>
	 	  		<input readonly name="type_of_bed" class="type_of_bed" id="type_of_bed" value="${patientsRecord.getType_of_bed()}">
	 	  	 	
			</td>
	 	  </tr>
	 	  <tr>
	 	  	<td><label class="required">Patient Address</label></td>
	 	  	<td colspan=2><input readonly type="text" id="address" name="address" value="${patientsRecord.getPatient_address()}"></td>
	 	  </tr>
	 	  <tr>
	 	  	<td><label class="required">Patient State</label></td>
	 	  	<td colspan=2>
				<input readonly  name="state" class="states" id="stateId"  value="${patientsRecord.getPatient_state()}">
	 	  	 	
	 	  	</td>
	 	  </tr>
	 	  <tr>
	 	  	<td><label class="required">Patient City</label></td>
	 	  	<td colspan=2>
	 	  	<input readonly name="city" class="cities" id="cityId"  value="${patientsRecord.getPatient_city()}">
	 	  	
	 	  	</td>
	 	  </tr>
	 	  <tr>
	 	  	<td align=center colspan=3> <input type="submit" value="Delete Patient" name="submitBtn" ></td>
	 	  </tr>
 	
 		</table>
 	  </form>
 	  

 	</div>
		
	</div>
</body>
</html>