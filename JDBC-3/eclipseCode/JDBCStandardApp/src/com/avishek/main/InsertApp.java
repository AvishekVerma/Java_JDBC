package com.avishek.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import com.avishek.util.JdbcUtil;

public class InsertApp {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null) {
				statement = connection.createStatement();
			}
			if(statement != null) {
				resultSet = statement.executeQuery("select sid, sname, sage, saddress from student");
			}
			
			if(resultSet != null) {
				System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3) + "\t" + resultSet.getString(4));
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
				JdbcUtil.cleanUp(connection, statement, resultSet);
				System.out.println("closing the resources...");
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
				

	}

}
