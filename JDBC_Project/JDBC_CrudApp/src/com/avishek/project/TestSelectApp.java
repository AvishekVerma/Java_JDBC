package com.avishek.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class TestSelectApp {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		// Step-1 Load & register the driver
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		System.out.println("Driver loaded successfully...");
		// Step-2 Establish the connection with DataBase.
//		String url = "jdbc:mysql://localhost:3306/avishekdb";
		String url = "jdbc:mysql:///avishekdb";
		String user = "root";
		String pass = "root123";
		Connection conn = DriverManager.getConnection(url,user,pass);
		System.out.println("Connection object created...");
		
		// Step-3 Create statement object & execute the query.
		Statement stat = conn.createStatement();
		System.out.println("Statement object created...");
		
		String sqlSelectQuery = "select sid,sname,sage,saddress from student";
		ResultSet resultSet = stat.executeQuery(sqlSelectQuery);
		
		System.out.println("ID\tNAME\tAGE\tADDRESS");
		while(resultSet.next()) {
			Integer sid=resultSet.getInt(1);
			String sname=resultSet.getString(2);
			Integer sage=resultSet.getInt(3);
			String saddr=resultSet.getString(4);
			System.out.println(sid+"\t"+sname+"\t"+sage+"\t"+saddr);
		}
		
		resultSet.close();
		stat.close();
		conn.close();
	}

}
