<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	text-align: left;
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
</style>
</head>
<body>
	<div class="header">
		<h1>ABC Hospital Management System</h1>
	</div>
	<div class="navbar">
		<div class="dropdown">
			<button class="dropbtn">Patient</button>
			<div class="dropdown-content">
				<a href="create_patient.jsp">Create Patient</a> 
				<a href="update_patient.jsp">Update Patient</a> 
				<a href="#">Delete Patient</a>
				<a href="view_patients.jsp">View Patients</a> 
				<a href="#">search Patient</a>
				<a href="#">Billing</a> 
			</div>
		</div>
		<a href="#" class="disable">Pharmacy</a> 
		<a href="#" class="disable">Diagnostics</a> 
		<a href="#">Log out</a>
	</div>
	<div class="main">
		<h1 align="center">View Patients</h1>
		<table border="1" cellpadding="15px" align="center">
			<tr>
				<th>Patient ID</th>
				<th>SSN ID</th>
				<th>Name</th>
				<th>Age</th>
				<th>Date of admission</th>
				<th>Type of bed</th>
				<th>Address</th>
				<th>State</th>
				<th>City</th>
				<th>Status</th>
			</tr>
			<c:forEach var="items" items="${patient}">
				<tr>
					<td>${items.patient_id}</td>
					<td>${items.patient_ssn_id}</td>
					<td>${items.patient_name}</td>
					<td>${items.patient_age}</td>
					<td>${items.date_of_admission}</td>
					<td>${items.type_of_bed}</td>
					<td>${items.patient_address}</td>
					<td>${items.patient_state}</td>
					<td>${items.patient_city}</td>
					<td>${items.patient_status}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>