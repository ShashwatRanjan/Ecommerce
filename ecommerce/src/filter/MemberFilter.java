package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberFilter implements Filter
{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException 
	{
		
		System.out.println("Member filter executed!");
		//authencation and authorization
		//to call the getSession method we cannot do on ServletRequest...  we have to do it on HttpServletRequest
		//for that we have to type cast from ServletRequest to HttpServletRequest
		HttpServletRequest sr = (HttpServletRequest)request;
		HttpSession hs=sr.getSession(false);//by putting false we want that a new session obj will not get created if the session is not there
		//it will only retrieve the session obj reference
		
		HttpServletResponse rp	= (HttpServletResponse)response;
		if(hs==null)
		{
			//the user is not logged in...  he must be redirected to login page
			System.out.println("Test1...");
			rp.sendRedirect("../Login.jsp");
		}
		else
		{
			System.out.println("Test2...");
			Object un=hs.getAttribute("uname");
			String mlevel=null;
			String uname=null;
			String password=null;
			boolean authorization=false;
			boolean authencate=false;
			if(un!=null)//he is authencated
			{
				System.out.println("Test3...");
				authencate = true;
				
				//here we are checking for authorization
				uname=(String)un;
				mlevel=(String)hs.getAttribute("mlevel");
				if(mlevel.equals("m1")||mlevel.equals("admin"))
						authorization=true;
			}
			
			if(authorization==true)
			
				chain.doFilter(request, response);
			else 
			{
				System.out.println("Test4...");
				if(authencate == false)
					rp.sendRedirect("../Login.jsp");
				if((authencate == true)&&(authorization == false))
					rp.sendRedirect("../Login.jsp?err=Not Authorized");
			}
				
				
		}
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
