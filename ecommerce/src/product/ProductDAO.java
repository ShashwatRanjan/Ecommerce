package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;



import db.DatabaseManager;

public class ProductDAO 
{
	

	public String insert(Connection con,ProductDTO dto)
	{
		String result="Data entered successfully";
		String sql="insert into product(uname,catid, subcatid, title, description, price, dou, picture1,picture2,status) values (?,?,?,?,?,?,?,?,?,?)";
		
		//?,? are called placeholders...they act like variable...  by using prepared statement we need to compile the sql query only once...
		//and on the compiled sql we are populating the placeholders..
		//Performance checks: Buffering to increase performance; garbage collection - less hanging objects; close preparedstatments and connection when work is performed;
		//Use of preparedstatments inplace of ordinary statements
		PreparedStatement ps = DatabaseManager.getPreparedStatement(con, sql);
		try {
			ps.setString(1,dto.getUname());
			ps.setString(2,dto.getCatid());
			ps.setString(3,dto.getSubcatid());
			ps.setString(4,dto.getTitle());
			ps.setString(5,dto.getDescription());
			ps.setDouble(6,dto.getPrice());
			ps.setDate(7,dto.getDou());
			ps.setString(8,dto.getPicture1());
			ps.setString(9,dto.getPicture2());
			ps.setString(10,dto.getStatus());
			
			ps.executeUpdate();
			System.out.println("Data");
			
			} catch (SQLException e) {
				result="Data not entered successfully";
				e.printStackTrace();
		}
		
		
		return result;
	}
	
	public ArrayList searchProductByKey(Connection con, String key)
	{
		ArrayList ar = new ArrayList();
		String sql="select * from product where description like '%"+key+"%'";
		PreparedStatement ps = DatabaseManager.getPreparedStatement(con, sql);
		try {
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				ProductDTO pdto = new ProductDTO(rs.getLong("productid"), rs.getString("uname"), rs.getString("catid"), rs.getString("subcatid"), rs.getString("title"), rs.getString("description"), rs.getString("picture1"), rs.getString("picture2"), rs.getString("status"), rs.getDouble("price"), rs.getDate("dou"));
				ar.add(pdto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
		
	}
	public ProductDTO searchProductById(Connection con, String pid)
	{
		//ArrayList ar = new ArrayList();
		String sql="select * from product where productid=?";
		PreparedStatement ps = DatabaseManager.getPreparedStatement(con, sql);
		ProductDTO pdto=null;
		try {
			ps.setLong(1, Long.parseLong(pid));
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				 pdto= new ProductDTO(rs.getLong("productid"), rs.getString("uname"), rs.getString("catid"), rs.getString("subcatid"), rs.getString("title"), rs.getString("description"), rs.getString("picture1"), rs.getString("picture2"), rs.getString("status"), rs.getDouble("price"), rs.getDate("dou"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pdto;
		
	}
}

