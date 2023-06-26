package com.avishek.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;

import com.avishek.util.JdbcUtil;

public class SelectApp {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Scanner sc = null;
		int sid = 0;
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			String sqlSelectQuery = "select sid,sname,sage,saddress from student where sid=?";
			if(connection != null) {
			pstmt =	connection.prepareStatement(sqlSelectQuery);
			}
			
			if(pstmt != null) {
				
				sc = new Scanner(System.in);
				
				System.out.println("Enter the Id no. of the student :: ");
				sid = sc.nextInt();
				
				//use pre-compiled query to set the values
				pstmt.setInt(1, sid);
				
				// execute the query
				resultSet = pstmt.executeQuery();
				}
			
			if(resultSet != null) {
				System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
				if(resultSet.next()) {
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
				}else {
					System.out.println("Entered id dones not exist :: "+sid);
				}
			}
		}catch(IOException ie) {
			ie.printStackTrace();
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
				sc.close();
				System.out.println("Closing the resource...");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
				

	}

}
