package com.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class Patient_Util {

		private static final String url="jdbc:mysql://localhost:3306/hospitalmanagementsystem";
		private static final String username = "root";
		private static final String password ="Bingi@143";
		public static Connection getConnection() {
			Connection con = null;
			try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			//System.out.print("Connection Sucessful");
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return con;
		 }
		public static void closeConnection(Connection con)
		 {
			 if(con!=null)
			 {
				 try {
					 con.close();
				 }catch (SQLException e)
				 {
					 e.printStackTrace();
				 }
			 }
		 }
		 
		 public static void closeStatement(PreparedStatement ps) {
			 if(ps!=null)
			 {
				 try {
					 ps.close();
				 }catch (SQLException e)
				 {
					 e.printStackTrace();
				 }
			 }
		 }
		 public static void closeStatement(Statement statement) {
			 if(statement!=null)
			 {
				 try {
					 statement.close();
				 }catch (SQLException e)
				 {
					 e.printStackTrace();
				 }
			 }
		 }

}
