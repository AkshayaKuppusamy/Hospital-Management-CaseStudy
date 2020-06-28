<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>

	<%		
    	HttpSession ses = request.getSession(false);// don't create if it doesn't exist
    	if(ses != null && !ses.isNew()) {
			ses.invalidate();
            response.sendRedirect("/Hospital_Management_System/index.jsp");
		   
	   
    	}
	%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>