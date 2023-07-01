package com.avishek.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.avishek.util.JdbcUtil;

public class ImageRetrivalApp {

	public static void main(String[] args) {
		
		// Resources used 
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		// Variables used
		int id = 1;
				
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			String sqlSelectQuery = "select id,name,image from persons where id=?";
			if(connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
			}
			
			if(pstmt != null) {
				// Set the input values to Query
				pstmt.setInt(1, id);
				
				// Execute the query
				resultSet = pstmt.executeQuery();
			}
			
			if(resultSet != null) {
				if(resultSet.next()) {
					System.out.println("ID\tNAME/tIMAGE");
					int sid = resultSet.getInt(1);
					String sname = resultSet.getString(2);
					InputStream is = resultSet.getBinaryStream(3);
					
					File file = new File("copied.jpg");
					FileOutputStream fos = new FileOutputStream(file);
					
					byte[] b = new byte[1024];
					// Reads some number of bytes from the input steam and stores then
					// into the buffer array b,
					// If the length of b is zero, then no bytes are read and 0 is returned;
					while(is.read(b)>0) {
						fos.write(b);
					}
					
//					int i = is.read();
//					while(i != -1) {
//						fos.write(i);
//						i = is.read();	
//					}
					fos.close();
					System.out.println(sid +"\t"+sname+"\t"+file.getAbsolutePath());
				}else {
					System.out.println("Record not availabel for the given Id :: "+id);
				}
			}
				
		}catch(SQLException | IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
				

	}

}

