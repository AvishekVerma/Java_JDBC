package com.avishek.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;

import com.avishek.util.JdbcUtil;

public class DeleteApp {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		Scanner sc = null;
		int sid = 0;
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			String sqlDeleteQuery = "delete from student where sid=?";
			if(connection != null) {
			pstmt =	connection.prepareStatement(sqlDeleteQuery);
			}
			
			if(pstmt != null) {
				
				sc = new Scanner(System.in);
				
				System.out.println("Enter the Id no. of the student :: ");
				sid = sc.nextInt();
				
				//use pre-compiled query to set the values
				pstmt.setInt(1, sid);
				
				// execute the query
				rowCount = pstmt.executeUpdate();
			}
			
			
				System.out.println("Row affected :: "+rowCount);
				
		}catch(IOException ie) {
			ie.printStackTrace();
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, null);
				sc.close();
				System.out.println("Closing the resource...");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
				

	}

}
