package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model_class.Patients;
import com.service.Patients_Service;

/**
 * Servlet implementation class ViewPatients_controller
 */
@WebServlet("/ViewPatients_controller")
public class ViewPatients_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the data from dataBase
		ArrayList<Patients> patient = Patients_Service.view();
		request.setAttribute("patient", patient);
		// redirect to a different page
		RequestDispatcher rd = request.getRequestDispatcher("/view_patient_list.jsp");
		rd.forward(request, response);
	}

}
 