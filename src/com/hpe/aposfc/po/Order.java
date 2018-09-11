package com.hpe.aposfc.po;

public class Order {
	private int orderid;
	private int menuid;
	private int userid;
	private String menunum;
	private String times;
	private String delivery;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getMenunum() {
		return menunum;
	}
	public void setMenunum(String menunum) {
		this.menunum = menunum;
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
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", menuid=" + menuid + ", userid=" + userid + ", menunum=" + menunum
				+ ", times=" + times + ", delivery=" + delivery + "]";
	}
	
	
}
