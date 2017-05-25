import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import login.LoginCheck;

import db.DatabaseManager;




public class Home implements Servlet 
{
	private ServletConfig config=null;
	
	
	public ServletConfig getConfig() {
		return config;
	}

	public void setConfig(ServletConfig config) {
		this.config = config;
	}

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

	public void init(ServletConfig arg0) throws ServletException
	{
		this.config=arg0;
		ServletContext context = arg0.getServletContext();// get the reference of ServletContext type object
		//created by Tomcat.
		
		/*String dbDriver = arg0.getInitParameter("dbdriver");
		DatabaseManager.loadDriver(dbDriver);
		
		String dburl = arg0.getInitParameter("dburl");
		Enumeration e = arg0.getInitParameterNames();
		while (e.hasMoreElements())
		{
			String name  = (String)e.nextElement();
			String value = arg0.getInitParameter(name);
			System.out.println("Name is:" + name);
			System.out.println("Value is:" + value);
			
			 context.setAttribute(name, value);
			 //Set the attributes on ServletContext object so it will be available to all jsp and servlets.
			 //IO is memory extensive so setting the attributes on ServletContext or saving in ServletContext object
			 //for better performance. Avoid reading from web.xml for rest of the jsp and servlet.
			 
			
		}*/
			
		
	}

	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		arg1.setContentType("text/html");
		
		PrintWriter out = arg1.getWriter();//PrintWriter is a character based stream object connected between the server and
		                                   //and the user browser
		System.out.println("Inside Service...........");
		//typecast from ServletRequest to HttpServletRequest
		HttpServletRequest sr = (HttpServletRequest)arg0;//arg0 is ServletRequest; we did for cookie management
		Cookie arr[] = sr.getCookies();
		String uname=null;
		String password=null;
		if(arr!=null)
		{
			for (int i = 0; i<arr.length;i++)
			{
				Cookie c = arr[i];
				String cname = c.getName();
				String cvalue = c.getValue();
				if(cname.equals("uname"))
				{
					uname=cvalue;
				}
				if(cname.equals("password"))
				{
					password=cvalue;
				}
			}
		}
		
		
		
		//ServletResponse interface has a method called getwriter which returns a printwriter type of object
		//that is a stream object connected with the browser from which the request has come.
		if(uname==null&&password==null)
		{
			System.out.println("uname and password is null..........");
		RequestDispatcher rd = arg0.getRequestDispatcher("Home.jsp");
		rd.include(arg0, arg1);
		}
		else
		{
			System.out.println("Inside else block..........");
			//we got cookies.........
			//we should put the cookie values in session
			HttpSession hs = sr.getSession(true);
			hs.setAttribute("uname", uname);
			hs.setAttribute("password", password);
			LoginCheck lc = new LoginCheck();
			lc.setContext(config.getServletContext());
			 String mlevel=lc.checkLogin(uname, password);
			hs.setAttribute("mlevel",mlevel);
			hs.setAttribute("cart",null);
			out.println("<meta http-equiv=\"refresh\" content=\"0; url=member/member.jsp\">");
		}
		//PrintWriter pw = arg1.getWriter();
		//pw.println("Hello from the Service method");
		//pw.close();
		
	}
	

}
