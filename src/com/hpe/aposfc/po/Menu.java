package com.hpe.aposfc.po;

public class Menu {
	private int id;
	private String name;
	private int typeid;
	private String burden;
	private String brief;
	private String price;
	private String sums;
	private String price1;
	private String sums1;
	private String imgpath;
	private int number;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Menu() {

	}

	public Menu(int id, String name, String price1, int number) {
		this.id = id;
		this.name = name;
		this.price1 = price1;
		this.number = number;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getBurden() {
		return burden;
	}
	public void setBurden(String burden) {
		this.burden = burden;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSums() {
		return sums;
	}
	public void setSums(String sums) {
		this.sums = sums;
	}
	public String getPrice1() {
		return price1;
	}
	public void setPrice1(String price1) {
		this.price1 = price1;
	}
	public String getSums1() {
		return sums1;
	}
	public void setSums1(String sums1) {
		this.sums1 = sums1;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", typeid=" + typeid + ", burden=" + burden + ", brief=" + brief
				+ ", price=" + price + ", sums=" + sums + ", price1=" + price1 + ", sums1=" + sums1 + ", imgpath="
				+ imgpath + "]";
	}

}
