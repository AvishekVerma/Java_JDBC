package com.avishek.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.avishek.utils.JdbcUtil;

public class DeleteApp {

	public static void delete() {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stat =null;
		int rowsAffacted =0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sid : ");
		Integer inputSid = sc.nextInt();
		
		try {
			conn = JdbcUtil.getJdbcConn();
			if(conn!=null) {
				stat=conn.createStatement();
			}
			if(stat!=null) {
				String sqlDeleteQuery = "delete from student where sid='"+inputSid+"' ";
				rowsAffacted =stat.executeUpdate(sqlDeleteQuery);
				System.out.println("No of rows deleted : "+rowsAffacted);
			}
		}catch(IOException ie) {
			ie.printStackTrace();
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.cleanUp(conn, stat, null);
				sc.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}

}
