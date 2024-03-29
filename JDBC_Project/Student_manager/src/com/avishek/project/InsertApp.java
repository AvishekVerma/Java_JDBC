package com.avishek.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.avishek.utils.JdbcUtil;

public class InsertApp {

	public static void insert() {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement  stat = null;
		int rowsAffected=0;
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Id : ");
		Integer inputId= sc.nextInt();
		System.out.println("Enter Name : ");
		String inputName=sc.next();
		System.out.println("Enter Age : ");
		Integer inputAge=sc.nextInt();
		System.out.println("Enter Address : ");
		String inputAddress=sc.next();
		System.out.println("Provide details are as below....");
		
		System.out.println(inputId+"  "+inputName+" "+inputAge+"  "+inputAddress);
		
		try {
			conn = JdbcUtil.getJdbcConn();
			if(conn!=null) {
				stat = conn.createStatement();
			}
			if(stat!=null) {
				String sqlInsertQuery = String.format("insert into student(`sid`,`sname`,`sage`,`saddress`) values ('%d','%s',%d,'%s')",inputId,inputName,inputAge,inputAddress);
				rowsAffected = stat.executeUpdate(sqlInsertQuery);
				System.out.println("No. of record updated successfully : "+rowsAffected);
			}
		}catch(IOException io) {
			io.printStackTrace();
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.cleanUp(conn, stat, null);
				sc.close();
				System.out.println("---------------------------------");
				System.out.println("Resources closed successfully...");
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}

}
