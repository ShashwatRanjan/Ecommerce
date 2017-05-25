package product;

import java.sql.Date;

public class ProductDTO 
{
	private long productid;
	private String uname, catid,subcatid,title, description, picture1, picture2, status;
	private double price;
	private java.sql.Date dou;
	
	public ProductDTO() {
		super();
	}

	public ProductDTO(long productid, String uname, String catid, String subcatid,
			String title, String description, String picture1, String picture2,
			String status, double price, Date dou) {
		super();
		this.productid = productid;
		this.uname = uname;
		this.catid = catid;
		this.subcatid = subcatid;
		this.title = title;
		this.description = description;
		this.picture1 = picture1;
		this.picture2 = picture2;
		this.status = status;
		this.price = price;
		this.dou = dou;
	}

	public long getProductid() {
		return productid;
	}

	public void setProductid(long productid) {
		this.productid = productid;
	}

	
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getCatid() {
		return catid;
	}

	public void setCatid(String catid) {
		this.catid = catid;
	}

	public String getSubcatid() {
		return subcatid;
	}

	public void setSubcatid(String subcatid) {
		this.subcatid = subcatid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture1() {
		return picture1;
	}

	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}

	public String getPicture2() {
		return picture2;
	}

	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public java.sql.Date getDou() {
		return dou;
	}

	public void setDou(java.sql.Date dou) {
		this.dou = dou;
	}
	
	
	
}
