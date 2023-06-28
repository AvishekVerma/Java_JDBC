package com.avishek.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.avishek.util.JdbcUtil;

public class DateInsertionApp {

	public static void main(String[] args) {
		
		// Resources used 
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner scanner = null;
		
		// Variables used
		java.sql.Date sqlDob = null;
		java.sql.Date sqlDom = null;
		
		String name = null;
		String dob = null;
		String dom = null;
				
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			String sqlInsetQuery = "insert into users(`name`,`dob`,`dom`)values(?,?,?)";
			if(connection != null) {
				pstmt = connection.prepareStatement(sqlInsetQuery);
			}
			
			if(pstmt != null) {
				scanner = new Scanner(System.in);
				
				// Collecting the inputs
				if(scanner != null) {
					System.out.println("Enter the username ::");
					name = scanner.next();
					System.out.println("Enter the dob(MM-dd-yyyy) ::");
					dob = scanner.next();
					System.out.println("Enter the dom(yyyy-MM-dd) ::");
					dom = scanner.next();
				}
				
				if(dob != null) {
					// Conversion of String to sqlDate
					SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyy");
					java.util.Date uDate = sdf.parse(dob);
					
					long value = uDate.getTime();
					sqlDob = new java.sql.Date(value);
				}
				
				if(dom != null) {
					sqlDom = java.sql.Date.valueOf(dom);
				}
				
				// Set the input values to Query
				pstmt.setString(1, name);
				pstmt.setDate(2, sqlDob);
				pstmt.setDate(3, sqlDom);
				
				// Execute the query
				int rowAffected = pstmt.executeUpdate();
				System.out.println("No of row inserted is ::"+rowAffected);
			}
		}catch(SQLException | IOException e) {
			e.printStackTrace();
		}catch(ParseException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				JdbcUtil.cleanUp(connection, pstmt, null);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			scanner.close();
		}
				

	}

}
