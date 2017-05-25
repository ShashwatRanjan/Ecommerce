package member;

import java.sql.Date;

public class MemberDTO 
{
	private String uname, pwd,fname, lname, city, country, zip, phone, email, mlevel;
	private java.sql.Date dob, dor;
	public MemberDTO() {
		super();
	}
	public MemberDTO(String uname, String pwd, String fname, String lname,
			String city, String country, String zip, String phone,
			String email, String mlevel, Date dob, Date dor) {
		super();
		this.uname = uname;
		this.pwd = pwd;
		this.fname = fname;
		this.lname = lname;
		this.city = city;
		this.country = country;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
		this.mlevel = mlevel;
		this.dob = dob;
		this.dor = dor;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMlevel() {
		return mlevel;
	}
	public void setMlevel(String mlevel) {
		this.mlevel = mlevel;
	}
	public java.sql.Date getDob() {
		return dob;
	}
	public void setDob(java.sql.Date dob) {
		this.dob = dob;
	}
	public java.sql.Date getDor() {
		return dor;
	}
	public void setDor(java.sql.Date dor) {
		this.dor = dor;
	}
	
	
}
