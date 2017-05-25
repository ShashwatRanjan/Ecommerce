package listener;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import db.DatabaseManager;

public class InitializationListener implements ServletContextListener
{
//Tomcat will call this method when a ServletContext is destroyed.....(eg when we shut down tomcat)
	public void contextDestroyed(ServletContextEvent sce) 
	{
		System.out.println("eCommerce destroyed...");
		// TODO Auto-generated method stub
		
	}
//Tomcat will call this method when a ServletContext object is created...  (eg when tomcat starts or a servletcontext object is created)
	public void contextInitialized(ServletContextEvent sce) 
	{
		System.out.println("eCommerce initialized...");
		// TODO Auto-generated method stub
		/*ServletContext context = sce.getServletContext();
		String dbDriver = context.getInitParameter("dbdriver");
		
		DatabaseManager.loadDriver(dbDriver);
		
		String dburl = context.getInitParameter("dburl");
		Enumeration e = context.getInitParameterNames();
		while (e.hasMoreElements())
		{
			String name  = (String)e.nextElement();
			String value = context.getInitParameter(name);
			System.out.println("Name is:" + name);
			System.out.println("Value is:" + value);
			
			 context.setAttribute(name, value);
			 //Set the attributes on ServletContext object so it will be available to all jsp and servlets.
			 //IO is memory extensive so setting the attributes on ServletContext or saving in ServletContext object
			 //for better performance. Avoid reading from web.xml for rest of the jsp and servlet.
			 
			
		}*/
		
	}

}
