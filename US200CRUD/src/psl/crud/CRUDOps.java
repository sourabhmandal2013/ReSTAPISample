package psl.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import psl.base.US500;

public class CRUDOps 
{
	public List<US500> readFromDb() 									//Read All
	{
		Connection conn = MySqlConnection.startConnection();
		String readQuery = "Select * from us_500";
		Statement stmnt = null;
		ResultSet rs = null;
		List<US500> userList = new ArrayList<US500>();
		US500 obj = null;

		try
		{
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(readQuery);
			while(rs.next())
			{
				obj = new US500(rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("company_name"), rs.getString("address"),
						rs.getString("city"), rs.getString("county"), 
						rs.getString("state"), rs.getInt("zip"), rs.getString("phone1"),
						rs.getString("phone2"), rs.getString("email"), rs.getString("web"));
				userList.add(obj);
				
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			MySqlConnection.disconnectConnection();
		}
		
		System.out.println(userList.toString());
		
		return userList;
		
	}

	public List<US500> searchDB(String emailtosearch)							//Read One
	{
		Connection conn = MySqlConnection.startConnection();
		String readQuery = "Select * from us_500 where email = '"+emailtosearch+"'";
		Statement stmnt = null;
		ResultSet rs = null;
		List<US500> userList = new ArrayList<US500>();
		US500 obj = null;

		try
		{
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(readQuery);
			while(rs.next())
			{
				obj = new US500(rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("company_name"), rs.getString("address"),
						rs.getString("city"), rs.getString("county"), 
						rs.getString("state"), rs.getInt("zip"), rs.getString("phone1"),
						rs.getString("phone2"), rs.getString("email"), rs.getString("web"));
				userList.add(obj);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return userList;
	}
	
	public boolean writeToDb(US500 writeObj) 								//Write One
	{
		boolean flag = true; 
		Connection conn = MySqlConnection.startConnection();
		String writeQuery = "INSERT INTO us_500 (first_name,last_name,company_name,address,city,county,state,zip,phone1,phone2,email,web) values ('"+writeObj.getFirst_name()+"','"+writeObj.getLast_name()+"','"
				+writeObj.getCompany_name()+"','"+writeObj.getAddress()
				+ "','" +writeObj.getCity()+"','"+writeObj.getCounty()+"','"+writeObj.getState()
				+ "'," + writeObj.getZip()+",'"+writeObj.getPhone1()+"','"+writeObj.getPhone2()+"','"+ writeObj.getEmail()+"','"+writeObj.getWeb()+"')";
		Statement stmnt;
		try 
		{
			stmnt = conn.createStatement();
			flag = stmnt.execute(writeQuery);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			MySqlConnection.disconnectConnection();
		}
		return flag;
	}
	
	public boolean updateToDb(String email , US500 writeObj) 				//Update
	{
//		Connection conn = MySqlConnection.startConnection();
		deleteFromDb(email);
		boolean flag = writeToDb(writeObj);
		return flag;
//		Statement stmnt;
//		
//		
//		ResultSet rs;
//		try 
//		{
//			stmnt = conn.createStatement();
//			rs = stmnt.executeQuery(readQuery);
//			while(rs.next())
//			{
//				
//			}
//			
//		} 
//		catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}
//		finally 
//		{
//			MySqlConnection.disconnectConnection();
//		}
	}
	
	public boolean deleteFromDb(String email) 								//Delete
	{
		boolean flag = true;
		Connection conn = MySqlConnection.startConnection();
		String deleteQuery = "DELETE FROM us_500 WHERE email = '"+email+"'";
		Statement stmnt;
		try 
		{
			stmnt = conn.createStatement();
			flag = stmnt.execute(deleteQuery);
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			MySqlConnection.disconnectConnection();
		}
		return flag;
	}
	public boolean deleteFromDbByCityState(String city ,String state) 								//Delete
	{
		boolean flag = true;
		Connection conn = MySqlConnection.startConnection();
		String deleteQuery = "DELETE FROM us_500 WHERE city = '"+city+"' And state = '" +state+"'";
		Statement stmnt;
		try 
		{
			stmnt = conn.createStatement();
			flag = stmnt.execute(deleteQuery);
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			MySqlConnection.disconnectConnection();
		}
		return flag;
	}
		
//		PreparedStatement stmnt = null;
//		try
//		{
//			stmnt = conn.prepareStatement(query);
//			stmnt.setString(1,writeObj.getFirst_name());
//			stmnt.setString(2,writeObj.getLast_name());
//			stmnt.setString(3,writeObj.getCompany_name());
//			stmnt.setString(4,writeObj.getAddress());
//			stmnt.setString(5,writeObj.getCity());
//			stmnt.setString(6,writeObj.getCounty());
//			stmnt.setString(7,writeObj.getState());
//			stmnt.setInt(8,writeObj.getZip());
//			stmnt.setString(9,writeObj.getPhone1());
//			stmnt.setString(10,writeObj.getPhone2());
//			stmnt.setString(11,writeObj.getEmail());
//			stmnt.setString(12,writeObj.getWeb());
//			
//		catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}
//		finally 
//		{
//			MySqlConnection.disconnectConnection();
//		}
		
	public List<US500> searchMultiple(String countySearch , String zipSearch)							//Read One
	{
		Connection conn = MySqlConnection.startConnection();
		String readQuery = "Select * from us_500 where county = '"+countySearch+"' and zip = " + Integer.parseInt(zipSearch) ;
		Statement stmnt = null;
		ResultSet rs = null;
		List<US500> userList = new ArrayList<US500>();
		US500 obj = null;

		try
		{
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(readQuery);
			while(rs.next())
			{
				obj = new US500(rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("company_name"), rs.getString("address"),
						rs.getString("city"), rs.getString("county"), 
						rs.getString("state"), rs.getInt("zip"), rs.getString("phone1"),
						rs.getString("phone2"), rs.getString("email"), rs.getString("web"));
				userList.add(obj);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return userList;
	}
	
	
}
