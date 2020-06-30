package com.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.dao.Patients_DAO;
import com.model.Patients;
import com.util.Patient_Util;

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


	//Search Patient by id
	public static Patients searchPatient(String recordId) {
		return Patients_DAO.searchPatient(recordId);
	}
	
	//Update Patient Record
	public static boolean updatePatient(Patients patient) {
		//UPDATE `patient_records` SET `patient_name`=?,`patient_age`='?',`date_of_admission`=?,`type_of_bed`=?,`patient_address`=?,`patient_state`=?,`patient_city`=? WHERE id= ?
		boolean status = false;
		status = Patients_DAO.updatePatient(patient);
		return status;
	}
	
	//Delete Patient Record
	public static boolean deletePatientById(String recordId){
		boolean status = false;
		status = Patients_DAO.deletePatientById(recordId);
		return status;
	}
}