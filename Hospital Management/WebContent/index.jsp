<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABC Hospital Management System</title>
<style>
	body{
		font-family: Arial, Helvetica, sans-serif;
		margin: 0;
		background-color: #97FFFF;	
	}
	.header{
		padding: 10px;
		text-align: center;
		background-color: #66CCCC;
		color: white;
	}
	.main {
	padding: 200px;	
	}
	form { 
	margin: 0 auto; 
	width:400px;
	border-style: solid;
	padding: 20px;
	}
	.login_bt{
		text-align:center;
	}
</style>
</head>
<body>
	<div class="header">
		<h1>ABC Hospital Management System</h1>
	</div>
	<div class="main">
		
		<form action="Login_controller" method="post">
			<h3 align="center">Login</h3>
			<table>
				<tr>
					<td>
						<label>User name</label>
					</td>
					<td>
						<input type="text" id="user" name="user" size="30">
					</td>
				</tr>
				<tr>
					<td>
						<label>Password</label>
					</td>
					<td>
						<input type="password" id="password" name="password" size="30">
					</td>
				</tr>
			</table>
			<br>
			<div class="login_bt">
				<input type="submit" value="login">
			</div>
		</form>
	</div>
</body>
</html>