package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.util.Patient_Util;

public class Login_DAO {
	public static String validate(String user,String pw) {
		String role=null;
		try {
			Connection con = Patient_Util.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM userstore where login=? and password=?");  
			ps.setString(1,user);  
			ps.setString(2,pw);  
			      
			ResultSet rs=ps.executeQuery(); 
			if(rs.next()) {
				role=rs.getString(rs.findColumn("role"));
				//System.out.println(rs.getString(rs.findColumn("role")));
			}       
			}catch(Exception e){
				System.out.println(e);
			}  
			return role;
	}	
}
