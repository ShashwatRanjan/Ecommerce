 package cart;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import db.DatabaseManager;

import product.ProductDAO;
import product.ProductDTO;

public class Cart 
{
	ServletContext context=null;
	HttpServletRequest request = null;
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public ServletContext getContext() {
		return context;
	}


	public void setContext(ServletContext context) {
		this.context = context;
	}


	public void addtoCart(String pid)
	{
		String dburl = (String)context.getAttribute("dburl");
		String dbuname = (String)context.getAttribute("dbuname");
		String dbpassword = (String)context.getAttribute("dbpassword");
		Connection con = DatabaseManager.getConnection(dburl, dbuname, dbpassword);
		ProductDAO pdao=new ProductDAO();
		
		ProductDTO pdto = pdao.searchProductById(con, pid);
		HttpSession hs = request.getSession(false);
		Object obj = hs.getAttribute("cart");
		if (obj == null)
		{
			ArrayList<ProductDTO> arr = new ArrayList<ProductDTO>();
			arr.add(pdto);
			hs.setAttribute("cart", arr);
			
		}
		else
		{
			ArrayList<ProductDTO> arr = (ArrayList<ProductDTO>)obj;
			arr.add(pdto);
			hs.setAttribute("cart", arr);
		}
		
	}
}
