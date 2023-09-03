package com.avishek.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.avishek.utils.JdbcUtil;

public class SelectApp {

	public static void select() {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement  stat = null;
		ResultSet resSet=null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sid : ");
		Integer inputSid = sc.nextInt();
		
		try {
			conn = JdbcUtil.getJdbcConn();
			if(conn != null) {
				stat = conn.createStatement();
			}
			if(stat != null) {
				String sqlSelectStat = "select sid,sname,sage,saddress from student where sid='"+inputSid+"' ";
				resSet = stat.executeQuery(sqlSelectStat);
			}
			if(resSet==null) {
				System.out.println("Record doesn't exist for given Id "+inputSid);
			}
			if(resSet != null) {
				System.out.println("ID\tNAME\tAGE\tADDRESS");
				System.out.println("---------------------------------");
				
				while(resSet.next()) {
					Integer sid=resSet.getInt(1);
					String sname=resSet.getString(2);
					Integer sage=resSet.getInt(3);
					String saddr=resSet.getString(4);
					System.out.println(sid+"\t"+sname+"\t"+sage+"\t"+saddr);
				}
//				if(!resSet.next()) {
//					System.out.println("Record doesn't exist for given Id "+inputSid);
//				}
			}
		}catch(IOException io) {
			io.printStackTrace();
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.cleanUp(conn, stat, resSet);
				sc.close();
				System.out.println("---------------------------------");
				System.out.println("Resources closed successfully...");
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
	}

}
