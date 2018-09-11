package com.hpe.aposfc.dao;

import com.hpe.aposfc.po.Admin;

public interface AdminDao {
	Admin selectAdminByName(String name);
	void updateAdmin(Admin admin);
	public Admin login(String name ,String pwd);
}
