package com.hpe.aposfc.po;

public class Admin {
	private int id;
	private String name;
	private String pwd;
	private String authority;
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPwd() {
		return pwd;
	}
	public String getAuthority() {
		return authority;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", pwd=" + pwd + ", authority=" + authority + "]";
	}
	
}
