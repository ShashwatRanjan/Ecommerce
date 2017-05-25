import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//To run this program first do http://localhost:8080/ecommerce/Home and then 
//http://localhost:8080/ecommerce/ContextRetriever


public class ContextRetriever implements Servlet 
{
	ServletConfig config = null;

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(ServletConfig config) throws ServletException {
		
		this.config = config;
	}

	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		ServletContext context = config.getServletContext();
		Object ob = context.getAttribute("dburl");
		String v =(String)ob;
		
		PrintWriter pw = arg1.getWriter();//we will get a stream object connected between the server and the browser
		pw.println("DB url:" +v);
		pw.close();
		
		
		
	}

	

}
