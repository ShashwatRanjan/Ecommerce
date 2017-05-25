package login;

import javax.servlet.ServletContext;

import db.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginCheck 
{
	private ServletContext context = null;
	
	
	
	public ServletContext getContext() {
		return context;
	}



	public void setContext(ServletContext context) {
		this.context = context;
	}



	public String checkLogin(String uname,String password)//this function will check in the database if a member with
	//this uname and password exists.. If yes return the mlevel of that person.. or else return a null......
	{
		
		String dburl=(String)context.getAttribute("dburl");
		String dbuname=(String)context.getAttribute("dbuname");
		String dbpwd=(String)context.getAttribute("dbpassword");
		
		Connection con= DatabaseManager.getConnection(dburl, dbuname, dbpwd);
		String query = "select * from registration where uname = ? and pwd = ?";
		PreparedStatement ps = DatabaseManager.getPreparedStatement(con, query);
		String mlevel=null;
		try {
			ps.setString(1, uname);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				mlevel=rs.getString("mlevel");
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Testing connection   " +con);
		return mlevel;
	}
	
}
