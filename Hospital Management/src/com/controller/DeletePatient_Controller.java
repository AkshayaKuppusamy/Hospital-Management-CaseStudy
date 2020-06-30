package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Patients;
import com.service.Patients_Service;

/**
 * Servlet implementation class DeletePatient_Controller
 */
@WebServlet("/DeletePatient_Controller")
public class DeletePatient_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePatient_Controller() {
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
			request.getRequestDispatcher("Delete_Patient.jsp").forward(request, response);
		} else {
		    boolean status = Patients_Service.deletePatientById(request.getParameter("patientId"));
		    if(status)
		    {
		    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/Delete_Patient.jsp");
	           	out.println("<script type=\"text/javascript\">\r\n" + 
		    			"	alert(\"Patient deleted is successful\");\r\n" + 
		    			"	</script>");	        
	           	rd.include(request,response);
		    }else
		    {
		    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/Delete_Patient.jsp");
		    	out.println("<script type=\"text/javascript\">\r\n" + 
		    			"	alert(\"Sorry Patient cannot be deleted \");\r\n" + 
		    			"	</script>");		       
		        rd.include(request,response);			    
		    }	
		}
		
	}

}
