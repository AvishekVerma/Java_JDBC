package com.avishek.main;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// JDBC 4.X auto loading feature is enable. 
public class InsertApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		
		
		// Step 1. Load and register the driver
		//Class.forName("com.mysql.cj.jdbc.Driver");
		//System.out.println("Driver Loaded Successfully....");
		
		// Step 2. Establish the connection with Database
		String url = "jdbc:mysql:///avishekdb"; // it will work bcz java and SQL is in same system.
		String user = "root";
		String password = "root123";
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println("Connection Object created......");
		
		// Step 3. Create statement Object & execute the query
		Statement statement = connection.createStatement();
		System.out.println("Statement Object created......");
		
		String sqlUpdateQuery = "update student set saddress = 'MT' where sid = 5";
		int rowAffected = statement.executeUpdate(sqlUpdateQuery);
		System.out.println("No of rows affected is :: "+ rowAffected);
		
		
		
		// Step 5. Handle the SQLException if it get generated
		
		// Step 6. Close the Connection
		statement.close();
		connection.close();
		System.out.println("Closing the resources......");
	}

}
