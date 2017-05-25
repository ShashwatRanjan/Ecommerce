package product;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import db.DatabaseManager;

public class ProductBO 
{
	ServletContext context = null;
	
	
	
	public ServletContext getContext() {
		return context;
	}
	public void setContext(ServletContext context) {
		this.context = context;
	}
    public String insertProduct (HttpServletRequest request)//jsp is invoking this fun
	{
		ProductForm pf=uploadImage_returnProductForm(request);//image uploaded and Productform returned
		
		ProductDTO pdto=formToDto(pf);
		ProductDAO pdao=new ProductDAO();
		
		String dburl=(String)context.getAttribute("dburl");
		String dbuname=(String)context.getAttribute("dbuname");
		String dbpwd=(String)context.getAttribute("dbpassword");
		
		Connection con= DatabaseManager.getConnection(dburl, dbuname, dbpwd);
		System.out.println("Testing connection   " +con);
		
		String result=pdao.insert(con,pdto);
		return result;
	}
	//The below function will upload the pictures into tomcat , create a productform type of 
	//object and return it..
	ProductForm uploadImage_returnProductForm(HttpServletRequest request)
	{
		FileItemFactory factory = new DiskFileItemFactory();

		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		ProductForm pf = new ProductForm();

		// Parse the request
		try 
		{
			List items = upload.parseRequest(request);//this function parses the request object
			
			Iterator itr = items.iterator();
			
			
			while (itr.hasNext())
			{
				FileItem  fI = (FileItem) itr.next();
				if(fI.isFormField())
				{
					String fieldName = fI.getFieldName();
					String value = fI.getString();
					
					if (fieldName.equals("catid"))
					{
						pf.setCatid(value);
					}
					
					if (fieldName.equals("subcatid"))
					{
						pf.setSubcatid(value);
					}
					
					if (fieldName.equals("title"))
					{
						pf.setTitle(value);
					}
					
					if (fieldName.equals("description"))
					{
						pf.setDescription(value);
					}
					
					if (fieldName.equals("price"))
					{
						pf.setPrice(value);
					}
						
					
				}
				else //its an image
				{
					String fieldName = fI.getFieldName();//image field name
					String fileName=fI.getName();//name of the image
					
					if (fieldName.equals("picture1"))
					{
						pf.setPicture1(fileName);
					}
					
					if (fieldName.equals("picture2"))
					{
						pf.setPicture2(fileName);
					}
					String contextPath=context.getRealPath("/");//gives you the real path
					//eg c:\tomcat\webapps\ecommerce\
					//System.out.println("test.........................."+context.getRealPath("/"));
					
					String filePath=contextPath+"image/product/"+fileName;
					File f= new File(filePath);
					try {
						fI.write(f);//this line uploads the picture into the tomcat
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		} 
		catch (FileUploadException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pf;
	}
	
	ProductDTO formToDto(ProductForm pform)
	{
		//converting the system's date into java.sql.Date
				java.util.Date d1 = new java.util.Date();
				java.sql.Date dou = new Date(d1.getTime());
		
	    ProductDTO pdto = new ProductDTO(1, "vishakha", pform.getCatid(), pform.getSubcatid(), pform.getTitle(), pform.getDescription(), pform.getPicture1(), pform.getPicture2(), "yes", Double.parseDouble(pform.getPrice()), dou);
		return pdto;
	}
	
	public ArrayList searchProductByKey (String key)
	{
		String dburl=(String)context.getAttribute("dburl");
		String dbuname=(String)context.getAttribute("dbuname");
		String dbpwd=(String)context.getAttribute("dbpassword");
		
		Connection con= DatabaseManager.getConnection(dburl, dbuname, dbpwd);
		System.out.println("Testing connection   " +con);
		
		ProductDAO pdao = new ProductDAO();
		ArrayList alist = pdao.searchProductByKey(con, key);
		
		return alist;
		
		
		
	}
	public ProductDTO searchProductById (String pid)
	{
		String dburl=(String)context.getAttribute("dburl");
		String dbuname=(String)context.getAttribute("dbuname");
		String dbpwd=(String)context.getAttribute("dbpassword");
		
		Connection con= DatabaseManager.getConnection(dburl, dbuname, dbpwd);
		System.out.println("Testing connection   " +con);
		
		ProductDAO pdao = new ProductDAO();
		ProductDTO alist = pdao.searchProductById(con, pid);
		
		return alist;
		
		
		
	}
	
}
