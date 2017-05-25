
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager 

{
	public static void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} 
		
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(String dburl, String dbuname, String dbpwd)
	{
		Connection con=null;
		try 
		{
			con = DriverManager.getConnection(dburl,dbuname,dbpwd);
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		return con;
	}
	public static PreparedStatement getPreparedStatement(Connection con, String sql)
	{
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}
	public static void closeConnection(Connection con)
	{
		try {
			con.close();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void closePrepared(Connection ps)
	{
		try {
			ps.close();
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}
}
