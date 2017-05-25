package member;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DatabaseManager;

public class MemberDAO 
{
	String result="Data entered successfully";
	public String insertMember(java.sql.Connection con, MemberDTO mdto)
	{
		String sql = "Insert into registration values (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = DatabaseManager.getPreparedStatement(con, sql);
		try {
			ps.setString(1, mdto.getUname());
			ps.setString(2, mdto.getPwd());
			ps.setString(3, mdto.getFname());
			ps.setString(4, mdto.getLname());
			ps.setString(5, mdto.getCity());
			ps.setString(6, mdto.getCountry());
			ps.setString(7, mdto.getZip());
			ps.setString(8, mdto.getPhone());
			ps.setString(9, mdto.getEmail());
			ps.setDate(10, mdto.getDob());
			ps.setDate(11, mdto.getDor());
			ps.setString(12, "m1");
			ps.executeUpdate();
		} catch (SQLException e) 
		{
			result="Data not entered successfully";
			e.printStackTrace();
		}
		return result;
		
	}
}
