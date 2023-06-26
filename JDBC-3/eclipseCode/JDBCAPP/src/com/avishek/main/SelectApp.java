package com.avishek.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Step 1. Load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Loading the driver...");
		
		//Step 2. Establish the connection
		String url = "jdbc:mysql://localhost:3306/avishekdb";
		String user = "root";
		String password = "root123";
		Connection connection = DriverManager.getConnection(url,user,password);
		
		//Step 3. Create statement object and send the query.
		Statement statement = connection.createStatement();
		
		//Step 4. Execute the query and process the resultSet
		String sqlSelectQuery = "select sid,sname,sage,saddress from student";
		ResultSet resultSet =  statement.executeQuery(sqlSelectQuery);
		
		System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
		while(resultSet.next()) {
			int sid = resultSet.getInt(1);
			String sname = resultSet.getString(2);
			int sage = resultSet.getInt(3);
			String saddress = resultSet.getString(4);
			
			System.out.println(sid +"\t"+sname+"\t"+sage+"\t"+saddress);
		}
		//Step 5. Handle SQLException if generated
		
		//Step 6. Close the resources
		resultSet.close();
		statement.close();
		connection.close();

	}

}
