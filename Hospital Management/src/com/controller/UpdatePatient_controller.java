package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Patients_DAO;
import com.model.Patients;
import com.service.Patients_Service;

/**
 * Servlet implementation class SearchPatient_controller
 */
@WebServlet("/SearchPatient_controller")
public class UpdatePatient_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePatient_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String btnType = request.getParameter("fetchdata");
		if(btnType != null && btnType.equalsIgnoreCase("Get")) {
			Patients patients = Patients_Service.searchPatient(request.getParameter("patientId"));
			request.setAttribute("patientsRecord", patients); 
			request.getRequestDispatcher("Update_Patient.jsp").forward(request, response);
		} else {
			int patientId = Integer.parseInt(request.getParameter("patientId"));
			String patientname = request.getParameter("name");
		    int age = Integer.parseInt(request.getParameter("age"));
		    String joiningDate = request.getParameter("date_of_admission");
		    //String bed =request.getParameter("type_of_bed");
		    String bedDrop =request.getParameter("type_of_bedDrop");
		    String address =request.getParameter("address");
		    //String state =request.getParameter("state");
		    String stateDrop =request.getParameter("stateDrop");
		    //String city =request.getParameter("city");
		    String cityDrop =request.getParameter("cityDrop");
		    Patients patients = new Patients();
		    patients.setPatient_id(patientId);
		    patients.setPatient_name(patientname);
		    patients.setPatient_age(age);
		    patients.setPatient_address(address);
		    patients.setDate_of_admission(joiningDate);
		    patients.setType_of_bed(bedDrop);
		    patients.setPatient_city(cityDrop);
		    patients.setPatient_state(stateDrop);
		    boolean status = Patients_Service.updatePatient(patients);
		    if(status)
		    {
		    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/Update_Patient.jsp");
	        
		    	out.println("<script type=\"text/javascript\">\r\n" + 
		    			"	alert(\"Patient updated is successful\");\r\n" + 
		    			"	</script>");
	        
	        rd.include(request,response);
		    }else
		    {
		    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/Update_Patient.jsp");
		        

		    	out.println("<script type=\"text/javascript\">\r\n" + 
		    			"	alert(\"Sorry Patient cannot be updated \");\r\n" + 
		    			"	</script>");
		       
		        rd.include(request,response);
			    
		    }		    
		}
		
	}

}
