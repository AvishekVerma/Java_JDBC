package com.avishek.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	
	private JdbcUtil() {}
	
	static {
		//Step 1: loading and register the Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	public static Connection getJdbcConnection() throws SQLException, IOException  {
		
		// Take the data from properties file
		FileInputStream fis = new FileInputStream("D:\\Coding\\Java\\JDBC\\JDBC-4\\JDBCDateInsertionApp\\src\\com\\avishek\\properties\\application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
			// Step 2. Establish the connection with Database
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			Connection connection = DriverManager.getConnection(url, user, password);
//			System.out.println("Connection Object created......");
			return connection;
	}
		
	public static void cleanUp(Connection con, Statement statement, ResultSet resultSet) throws SQLException{
			//Step 6. Close the resources
			if(con != null) {
				con.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(resultSet != null) {
				resultSet.close();
			}
	}


}
