package com.avishek.main;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.avishek.util.JdbcUtil;

/*
 * CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GET_PRODUCT_DETAILS_BY_ID`(IN id INT,OUT NAME VARCHAR(20),OUT rate INT, OUT qnt INT)
BEGIN
	select pname, price, qty into name,rate,qnt from products where pid = id;
END
 */

public class CcStoredProcedureMySQL {

	public static void main(String[] args) {
		
		// Resources used 
		Connection connection = null;
		CallableStatement cstmt = null;
		Scanner scanner = null;	
		
		Integer id = null;
		
		String storedProcedureCall = "{CALL P_GET_PRODUCT_DETAILS_BY_ID(?,?,?,?)}";
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null) {
				cstmt = connection.prepareCall(storedProcedureCall);
			}
			
			scanner = new Scanner(System.in);
			if(scanner != null) {
				System.out.println("Enter the product id :: ");
				id = scanner.nextInt();
			}
			
			// setting the input values
			if(cstmt != null) {
				cstmt.setInt(1, id);
			}
			
			//Setting the Data types of output values
			if(cstmt != null) {
				cstmt.registerOutParameter(2, Types.VARCHAR);
				cstmt.registerOutParameter(3, Types.INTEGER);
				cstmt.registerOutParameter(4, Types.INTEGER);
			}
			
			// run the stored procedure
			if(cstmt != null) {
				cstmt.execute();
			}
			
			// Retrieve the value
			if(cstmt != null) {
				System.out.println("Product Name is :: "+cstmt.getString(2));
				System.out.println("Product Cost is :: "+cstmt.getInt(3));
				System.out.println("Product QTY is :: "+cstmt.getInt(4));
			}
			
			
			
		}catch(SQLException | IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				JdbcUtil.cleanUp(connection, cstmt, null);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			scanner.close();
		}
				

	}

}

