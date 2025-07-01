package model;

import java.sql.Date;

public class Items {
	
	private int id;	
	private String username;
	private Date datetime;
	private String hotelname;
	private String itemnames;
	private Double price;
	
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getItemnames() {
		return itemnames;
	}
	public void setItemnames(String itemnames) {
		this.itemnames = itemnames; 
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Items [id=" + id + ", itemnames=" + itemnames + ", price=" + price + "]";
	}
	
	

}
