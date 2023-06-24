import java.sql.*;
import javax.sql.*;

class  TestApp
{
	public static void main(String[] args) 
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try{
			// Step 1. Load and register the Driver

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully....");
			
			// set path=C:\Program Files\Java\jdk-17.0.5\bin
			// set classpath=D:\Coding\Java\jars\mysql-connector-j-8.0.33\mysql-connector-j-8.0.33.jar

			// Step 2. Estiblish the Connection with database

			String url = "jdbc:mysql://localhost:3306/avishekdb";
			String userName = "root";
			String passWord = "root123";
			connection = DriverManager.getConnection(url,userName, passWord);
			System.out.println("connection established successfully...");
			System.out.println("The implementation class name is :: " + connection.getClass().getName());

			// Step 3. Create statement object and send the query

			String sqlSelectQuery = "select sid, sname, sage, saddress from student";
			statement = connection.createStatement();
			System.out.println("The implementation class name is :: " + statement.getClass().getName());
			resultSet = statement.executeQuery(sqlSelectQuery);
			System.out.println("The implementation class name is :: " + resultSet.getClass().getName());

			// Step 4 Process the resultSet
			
			System.out.println();
			System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
			while(resultSet.next()){
				Integer sid = resultSet.getInt(1);
				String sname = resultSet.getString(2);
				Integer sage = resultSet.getInt(3);
				String saddr = resultSet.getString(4);

				System.out.println(sid+"\t"+sname+"\t"+sage+"\t"+saddr);
			}
		} 

		// Step 5 Handling the Exception

		catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{

			// Step 6 Closing the connection
			
			if(connection != null){
				try{
					connection.close();
				}catch(SQLException se){
					se.printStackTrace();
				}
			}
		}

	}
}



