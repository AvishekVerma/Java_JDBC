package com.avishek.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	private JdbcUtil() {};
	static 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	public static Connection getJdbcConn() throws SQLException,IOException{
		// Take the data from properties file
		FileInputStream fis = new FileInputStream("D:\\Coding\\Java\\JDBC\\JDBC_Project\\Student_manager\\src\\application.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		//Step-2
		String url = prop.getProperty("url");
		String user= prop.getProperty("user");
		String pass= prop.getProperty("password");
		Connection conn = DriverManager.getConnection(url,user,pass);
//		System.out.println("Connection object create"+ url + user+pass);
		return conn;
	}
	
	public static void cleanUp(Connection conn, Statement stat, ResultSet res) throws SQLException 
	{
		// Step 6
		if(conn != null) {
			conn.close();
		}
		if(stat != null) {
			stat.close();
		}
		if(res != null) {
			res.close();
		}
	}
	
	
	
}
