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
				<a href="update_patient.jsp">Update Patient</a> 
				<a href="#">Delete Patient</a>
				<a href="ViewPatients_controller">View Patients</a> 
				<a href="#">search Patient</a>
				<a href="#">Billing</a> 
			</div>
		</div>
		<a href="#" class="disable">Pharmacy</a> 
		<a href="#" class="disable">Diagnostics</a> 
		<a href="logout.jsp">Log out</a>
	</div>
	<div class="main">
	<%		
    	HttpSession ses = request.getSession(false);// don't create if it doesn't exist
    	if(ses != null && !ses.isNew()) {
    		response.sendRedirect("ViewPatients_controller");
	   	} else {
    	    response.sendRedirect("/index.jsp");
    	}
	%>
	</div>
</body>
</html>