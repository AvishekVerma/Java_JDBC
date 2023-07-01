package com.avishek.main;

import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.avishek.util.JdbcUtil;

public class ClobInsertionApp {

	public static void main(String[] args) {
		
		// Resources used 
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner scanner = null;
		
		// Variables used
		String name = null;
		String pdfLoc = null;
				
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			String sqlInsetQuery = "insert into cities(`name`,`history`)values(?,?)";
			if(connection != null) {
				pstmt = connection.prepareStatement(sqlInsetQuery);
			}
			
			if(pstmt != null) {
				scanner = new Scanner(System.in);
				
				// Collecting the inputs
				if(scanner != null) {
					System.out.println("Enter the cityname ::");
					name = scanner.next();
					
					System.out.println("Enter the pdf location :: ");
					pdfLoc = scanner.next();
				}
				
				// Set the input values to Query
				pstmt.setString(1, name);
				pstmt.setCharacterStream(2, new FileReader(new File(pdfLoc)));
				
				// Execute the query
				int rowAffected = pstmt.executeUpdate();
				System.out.println("No of row inserted is ::"+rowAffected);
			}
		}catch(SQLException | IOException e) {
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

