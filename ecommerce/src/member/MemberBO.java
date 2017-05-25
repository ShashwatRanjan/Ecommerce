package member;

import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;

import db.DatabaseManager;

public class MemberBO //Buisness class
{
	private ServletContext context=null;
	
	
	public ServletContext getContext() 
	{
		return context;
	}
	public void setContext(ServletContext context) {
		this.context = context;
	}
	public String insertMember(MemberForm mform)
	{
		String dburl=(String)context.getAttribute("dburl");
		String dbuname=(String)context.getAttribute("dbuname");
		String dbpwd=(String)context.getAttribute("dbpassword");
		
		Connection con= DatabaseManager.getConnection(dburl, dbuname, dbpwd);
		System.out.println("Testing connection   " +con);
		MemberDTO mdto =formToDto(mform);
		MemberDAO mdao=new MemberDAO();
		String result = mdao.insertMember(con, mdto);
		
		return result;
	}
	public MemberDTO formToDto(MemberForm mform)
	{
		java.sql.Date dob, dor;
		String dd = mform.getDd();
		String mm = mform.getMm();
		String yy = mform.getYy();
		// Convert from ddmmyy string to java.sql.Date type
		String pattern="dd/MM/yyyy";
		String d1=dd+"/"+mm+"/"+yy;
		
		SimpleDateFormat sd=new SimpleDateFormat(pattern);
		java.util.Date d2=null;
		try {
			d2 = sd.parse(d1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dob = new java.sql.Date(d2.getTime());
		//converting the system's date into java.sql.Date
		java.util.Date d3 = new java.util.Date();
		dor = new Date(d3.getTime());
		MemberDTO mdto = new MemberDTO(mform.getUname(), mform.getPwd(), mform.getFname(), mform.getLname(), mform.getCity(), mform.getCountry(), mform.getZip(), mform.getPhone(), mform.getEmail(), "m1",dob, dor);
	 
		
		return mdto;
	}
}
