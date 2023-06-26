package com.avishek.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;

import com.avishek.util.JdbcUtil;

public class InsertAppDynamicInput {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner sc = null;
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			String sqlInsertQuery = "insert into student(`sid`,`sname`,`sage`,`saddress`)values(?,?,?,?)";
			if(connection != null) {
			pstmt =	connection.prepareStatement(sqlInsertQuery);
			}
			
			if(pstmt != null) {
				
				sc = new Scanner(System.in);

				System.out.println("Enter the Id no. of the student :: ");
				int sid = sc.nextInt();
				
				System.out.println("Enter the name of the student :: ");
				String sname = sc.next();
				
				System.out.println("Enter the age of the student :: ");
				int sage = sc.nextInt();
				
				System.out.println("Enter the address of the student :: ");
				String saddress = sc.next();
				
				
				//use pre-compiled query to set the values
				pstmt.setInt(1,sid);
				pstmt.setString(2, sname);
				pstmt.setInt(3, sage);
				pstmt.setString(4, saddress);
				// execute the query
				int rowCount = pstmt.executeUpdate();
				System.out.println("No of rows updated is :: " + rowCount);
			}
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
