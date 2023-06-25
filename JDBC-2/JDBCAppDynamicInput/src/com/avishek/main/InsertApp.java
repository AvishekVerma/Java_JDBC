package com.avishek.main;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.*;
import java.util.*;

// JDBC 4.X auto loading feature is enable. 
public class InsertApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		
		
		// Step 1. Load and register the driver
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		System.out.println("Driver Loaded Successfully....");
		
		// Step 2. Establish the connection with Database
		String url = "jdbc:mysql:///avishekdb"; // it will work bcz java and SQL is in same system.
		String user = "root";
		String password = "root123";
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println("Connection Object created......");
		
		// Step 3. Create statement Object & execute the query
		Statement statement = connection.createStatement();
		System.out.println("Statement Object created......");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Id no. of the student :: ");
		int sid = sc.nextInt();
		
//		System.out.println("Enter the name of the student :: ");
//		String sname = sc.next();
		
//		System.out.println("Enter the age of the student :: ");
//		int sage = sc.nextInt();
		
		System.out.println("Enter the address of the student :: ");
		String saddress = sc.next();
		
		// Step 4. Execute the Query and Process the resultSet
		//Formatting 1st approach
		//String sqlInsetQuery = "insert into student(`sid`,`sname`,`sage`,`saddress`)values("+sid+",'"+sname+"',"+sage+",'"+saddress+"')";
		// 2nd approach
		//sname = '"+sname+"';
		// 3rd and Recommended approach
		String sqlInsetQuery = String.format("update student set saddress = '%s' where sid = %d", saddress,sid);
		System.out.println(sqlInsetQuery);
		int rowAffected = statement.executeUpdate(sqlInsetQuery);
		System.out.println("No of rows affected is :: "+ rowAffected);
		
		// Step 5. Handle the SQLException if it get generated
		
		// Step 6. Close the Connection
		statement.close();
		connection.close();
		sc.close();
		System.out.println("Closing the resources......");
	}

}
