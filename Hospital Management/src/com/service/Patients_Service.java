package com.service;

import java.util.ArrayList;

import com.dao.Patients_DAO;
import com.model_class.Patients;

public class Patients_Service {
	public static ArrayList<Patients> view() {
		ArrayList<Patients> pat = Patients_DAO.viewPatients();
		return pat;
	}
	public static int create(Patients patient) {
		int status = 0;
		status = Patients_DAO.createPatient(patient);
		return status;
	}
	
}
