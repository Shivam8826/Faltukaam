package com.cg.jpainitialsetup.Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {

		// 1: Gather the DB information
			private String driverClassName = "org.postgresql.Driver";
			private String url = "jdbc:postgresql://localhost/postgres";
			private String username = "postgres";
			private String password = "8882330";	
			private Connection con=null;
			private PreparedStatement psmt=null;
			
			private Connection connect() {
				try {
					Class c = Class.forName(driverClassName);
					con = DriverManager.getConnection(url,username,password);
				}catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
				return con;
			}
			
			public PreparedStatement prepareStatement(String sql) {
				try { 
					psmt = connect().prepareStatement(sql);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return psmt;
			}
			
			public void closeConnection(){
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			
			public void closePrepareStatement(){
				try {
					psmt.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}

}
