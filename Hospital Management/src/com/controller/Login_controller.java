package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.Login_Service;

/**
 * Servlet implementation class Login_controller
 */
@WebServlet("/Login_controller")
public class Login_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String role = null;
    		String user = request.getParameter("user");
    		String password = request.getParameter("password");
    		PrintWriter out = response.getWriter();
    		role = Login_Service.validate(user,password);

    			if(role.equalsIgnoreCase("Admin")) {
    				HttpSession session = request.getSession(true);  
    		    	session.setAttribute("user",user);
    				RequestDispatcher rd = request.getRequestDispatcher("homepage_executive.jsp");
        			rd.forward(request, response);
    			}
    			else if(role.equalsIgnoreCase("Diagnostics") ) {
    				HttpSession session = request.getSession(true);  
    		    	session.setAttribute("user",user);
    				RequestDispatcher rd = request.getRequestDispatcher("homepage_diagnostics.jsp");
        			rd.forward(request, response);
    			}
    			else if(role.equalsIgnoreCase("Pharmasiat")) {
    				HttpSession session = request.getSession(true);  
    		    	session.setAttribute("user",user);
    				RequestDispatcher rd = request.getRequestDispatcher("homepage_pharmacist.jsp");
        			rd.forward(request, response);
    			}
    		else {
    			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
    			out.println("<script type=\"text/javascript\">\r\n" + 
    	    			"	alert(\"Invalid Credentials\");\r\n" + 
    	    			"	</script>");
    			rd.include(request, response);
    		}
	}

}
