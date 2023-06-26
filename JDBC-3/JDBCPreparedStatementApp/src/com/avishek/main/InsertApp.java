package com.avishek.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import com.avishek.util.JdbcUtil;

public class InsertApp {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			String sqlInsertQuery = "insert into student(`sid`,`sname`,`sage`,`saddress`)values(?,?,?,?)";
			if(connection != null) {
			pstmt =	connection.prepareStatement(sqlInsertQuery);
			}
			
			if(pstmt != null) {
				
				//use pre-compiled query to set the values
				pstmt.setInt(1,8);
				pstmt.setString(2, "lalitha");
				pstmt.setInt(3, 23);
				pstmt.setString(4, "USA");
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
				System.out.println("Closing the resource...");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
				

	}

}
