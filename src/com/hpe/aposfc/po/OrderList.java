package com.hpe.aposfc.po;

public class OrderList {
	private int orderid;
	private int userid;
	private String name;
	private String realname;
	private String phone;
	private String address;
	private String menunum;
	private String price1;
	private String times;
	private String delivery;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMenunum() {
		return menunum;
	}
	public void setMenunum(String menunum) {
		this.menunum = menunum;
	}
	public String getPrice1() {
		return price1;
	}
	public void setPrice1(String price1) {
		this.price1 = price1;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	@Override
	public String toString() {
		return "OrderList [orderid=" + orderid + ", userid=" + userid + ", name=" + name + ", realname=" + realname
				+ ", phone=" + phone + ", address=" + address + ", menunum=" + menunum + ", price1=" + price1
				+ ", times=" + times + ", delivery=" + delivery + "]";
	}


}
