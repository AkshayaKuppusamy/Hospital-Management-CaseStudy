package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.Patients;
import com.util.Patient_Util;

public class Patients_DAO {
	
	public static ArrayList<Patients> viewPatients(){
		ArrayList<Patients> patient = new ArrayList<Patients>();
		try {
			Connection conn=Patient_Util.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs=statement.executeQuery("SELECT *  FROM `patient_records` WHERE `patient_status` = 'Active'");
			while(rs.next()) {
				Patients list = new Patients();
				list.setPatient_id(rs.getInt(rs.findColumn("id")));
				list.setPatient_ssn_id(rs.getInt(rs.findColumn("patient_ssn_id")));
				list.setPatient_name(rs.getString(rs.findColumn("patient_name")));
				list.setPatient_age(rs.getInt(rs.findColumn("patient_age")));
				list.setDate_of_admission(rs.getString(rs.findColumn("date_of_admission")));
				list.setType_of_bed(rs.getString(rs.findColumn("type_of_bed")));
				list.setPatient_address(rs.getString(rs.findColumn("patient_address")));
				list.setPatient_state(rs.getString(rs.findColumn("patient_state")));
				list.setPatient_city(rs.getString(rs.findColumn("patient_city")));
				list.setPatient_status(rs.getString(rs.findColumn("patient_status")));
				patient.add(list);
			}
			conn.close();
			rs.close();
		}catch(Exception  e)
		{
			e.printStackTrace();
		}
		return patient;
	}
	
	public static int createPatient(Patients patient) {
		int status = 0;
		if(checkSSNID(patient)) {
			return status;
		}
		try {
			PreparedStatement ps = null;
			Connection conn=Patient_Util.getConnection();
			ps = conn.prepareStatement("insert into patient_records(patient_ssn_id,patient_name,patient_age,date_of_admission,type_of_bed,patient_address,patient_state,patient_city) values(?,?,?,?,?,?,?,?)");
			
			
			ps.setInt(1,patient.getPatient_ssn_id());
		    ps.setString(2,patient.getPatient_name());
		    ps.setInt(3,patient.getPatient_age());
		    ps.setString(4,patient.getDate_of_admission());
		    ps.setString(5,patient.getType_of_bed());
		    ps.setString(6,patient.getPatient_address());
		    ps.setString(7,patient.getPatient_state());
		    ps.setString(8,patient.getPatient_city());
			status = ps.executeUpdate();
			conn.close();
			ps.close();
		}catch(Exception  e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public static boolean checkSSNID(Patients patient) {
		boolean status = false;
		
		try {
			PreparedStatement ps = null;
			Connection conn=Patient_Util.getConnection();
			ps = conn.prepareStatement("Select *  from patient_records where patient_ssn_id = ?;");

			ps.setInt(1,patient.getPatient_ssn_id());
			ResultSet rs  = ps.executeQuery();
			status= rs.next();
			conn.close();
			ps.close();
		}catch(Exception  e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	
	//Search Patient by Id
	public static Patients searchPatient(String recordId){
		Patients patient = new Patients();
		try {
			Connection conn=Patient_Util.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs=statement.executeQuery("SELECT *  FROM `patient_records` WHERE id=" +recordId+"  and `patient_status` = 'Active'");
			while(rs.next()) {				
				patient.setPatient_id(rs.getInt(rs.findColumn("id")));
				patient.setPatient_ssn_id(rs.getInt(rs.findColumn("patient_ssn_id")));
				patient.setPatient_name(rs.getString(rs.findColumn("patient_name")));
				patient.setPatient_age(rs.getInt(rs.findColumn("patient_age")));
				patient.setDate_of_admission(rs.getString(rs.findColumn("date_of_admission")));
				patient.setType_of_bed(rs.getString(rs.findColumn("type_of_bed")));
				patient.setPatient_address(rs.getString(rs.findColumn("patient_address")));
				patient.setPatient_state(rs.getString(rs.findColumn("patient_state")));
				patient.setPatient_city(rs.getString(rs.findColumn("patient_city")));
				patient.setPatient_status(rs.getString(rs.findColumn("patient_status")));
			}
			conn.close();
			rs.close();
		}catch(Exception  e)
		{
			e.printStackTrace();
		}
		return patient;
	}
//Update Patient Record
	public static boolean updatePatient(Patients patient) {
		//UPDATE `patient_records` SET `patient_name`=?,`patient_age`=?,`date_of_admission`=?,`type_of_bed`=?,`patient_address`=?,`patient_state`=?,`patient_city`=? WHERE id= ?
		boolean status = false;
		int var = 0;

		try {
			PreparedStatement ps = null;
			Connection conn=Patient_Util.getConnection();
			ps = conn.prepareStatement("UPDATE `patient_records` SET `patient_name`=?,`patient_age`=?,`date_of_admission`=?,`type_of_bed`=?,`patient_address`=?,`patient_state`=?,`patient_city`=? WHERE id= ?");
		    ps.setString(1,patient.getPatient_name());
		    ps.setInt(2,patient.getPatient_age());
		    ps.setString(3,patient.getDate_of_admission());
		    ps.setString(4,patient.getType_of_bed());
		    ps.setString(5,patient.getPatient_address());
		    ps.setString(6,patient.getPatient_state());
		    ps.setString(7,patient.getPatient_city());
		    ps.setInt(8,patient.getPatient_id());
			var = ps.executeUpdate();
			conn.close();
			ps.close();
		}catch(Exception  e)
		{
			e.printStackTrace();
		}
		if(var != 0 ) {
			status = true;
		}
		return status;
	}
//Delete Patient Record
	public static boolean deletePatientById(String recordId){
		boolean status = false;
		int var = 0;
		try {
			Connection conn=Patient_Util.getConnection();
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM `patient_records` WHERE id=" +recordId);
			//ResultSet rs=statement.executeQuery(
			var = ps.executeUpdate();
			conn.close();
			ps.close();
		}catch(Exception  e)
		{
			e.printStackTrace();
		}
		if(var != 0 ) {
			status = true;
		}
		return status;
	}

}
