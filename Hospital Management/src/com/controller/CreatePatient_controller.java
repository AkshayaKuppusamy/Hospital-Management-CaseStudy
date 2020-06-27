package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model_class.Patients;
import com.service.Patients_Service;

/**
 * Servlet implementation class CreatePatient_controller
 */
@WebServlet("/CreatePatient_controller")
public class CreatePatient_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		int patientssnid = Integer.parseInt(request.getParameter("SSN ID"));
		String patientname = request.getParameter("name");
	    int age = Integer.parseInt(request.getParameter("age"));
	    String joiningDate = request.getParameter("date_of_admission");
	    String bed =request.getParameter("type_of_bed");
	    String address =request.getParameter("address");
	    String state =request.getParameter("state");
	    String city =request.getParameter("city");
		
	   
	    
	    Patients patient= new Patients();
	    patient.setPatient_ssn_id(patientssnid);
	    patient.setPatient_name(patientname);
	    patient.setPatient_age(age);
	    patient.setDate_of_admission(joiningDate);
	    patient.setPatient_address(address);
	    patient.setType_of_bed(bed);
	    patient.setPatient_state(state);
	    patient.setPatient_city(city);
	    int status=Patients_Service.create(patient);
	    if(status>0)
	    {
	    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/create_patient.jsp");
        
	    	response.getWriter().println("<script type=\"text/javascript\">\r\n" + 
	    			"	alert(\"Patient is registered successfully\");\r\n" + 
	    			"	</script>");
        //out.println("Patient is registered successfully");
        rd.include(request,response);
	    }else
	    {
	    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/create_patient.jsp");

	    	response.getWriter().println("<script type=\"text/javascript\">\r\n" + 
	    			"	alert(\"Sorry patient cannot be registered\");\r\n" + 
	    			"	</script>");
	        
	       // out.println("Sorry patient cannot be registered");
	        rd.include(request,response);
		    
	    }

	}

}
