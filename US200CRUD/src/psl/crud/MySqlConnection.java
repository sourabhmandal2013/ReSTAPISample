package psl.crud;

import java.sql.*;

public class MySqlConnection 
{
	private static Connection conn = null; 
	
	public static Connection startConnection()
	{
		conn = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rest_data_schema","root", "root");
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void disconnectConnection()
	{
		try 
		{
			conn.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
