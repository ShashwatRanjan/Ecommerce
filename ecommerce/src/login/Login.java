package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	ServletConfig config=null;
	

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String uname  = request.getParameter("uname");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		                  
		LoginCheck lcheck = new LoginCheck();
		//we need the ServetContext obj reference here .. to send as argument in the next line..
		//we can call a method on the servletconfig to get the ServletContext
		ServletContext context=config.getServletContext();
		lcheck.setContext(context);
		String mlevel = lcheck.checkLogin(uname, password);
		//if mlevel is having some value other then null  then he is logged in...
		if(mlevel!=null)
		{
			HttpSession hs = request.getSession(true);
			hs.setAttribute("uname",uname);
			hs.setAttribute("password",password);
			hs.setAttribute("mlevel",mlevel);
			hs.setAttribute("cart",null);
			//he is logged in
			if(remember!=null)
			{
				//user has clicked on the checkbox so that he will be remembered.. for that we will create cookies
				Cookie c1 =new Cookie("uname", uname);
				c1.setMaxAge(10000);
				Cookie c2 =new Cookie("password", password);
				c2.setMaxAge(10000);
				response.addCookie(c1);
				response.addCookie(c2);
				
				//<meta http-equiv="refresh" content="5; url=http://example.com/">
			}
			//he should be sent to the member page.. because he is logged in
			//out.println("<meta http-equiv=/"refresh" content=/"0; url=member/member.jsp/">");
			//<meta http-equiv="refresh" content="5; url=http://example.com/">
			out.println("<meta http-equiv=\"refresh\" content=\"0; url=member/member.jsp\">");
			
		}
		else
		{
			//he is not logged in
			//he should be sent back to login page
			out.println("<meta http-equiv=\"refresh\" content=\"0; url=login.jsp\">");
		}
		
		
		}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=config;//making a class level variable and it will be available through out the class.
	}
	

}
