package com.hpe.aposfc.dao.impl;

import com.hpe.aposfc.dao.AdminDao;

import com.hpe.aposfc.po.Admin;
import com.hpe.aposfc.util.DBUtil;

public class AdminDaoImpl implements AdminDao{
	private DBUtil dbUtil = new DBUtil();
	@Override
	public Admin login(String name, String pwd) {
		String sql = "select * from admin where name=? and pwd=?";
		Admin adminResult = null;
		Object[] params = { name, pwd};
		try {
			adminResult = (Admin) dbUtil.getObject(Admin.class, sql, params);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return adminResult;
	}
	@Override
	public Admin selectAdminByName(String name) {
		String sql = "select * from admin where name=?";
		Object[] params = { name };
		Admin admin = null;
		try {
			admin = (Admin) dbUtil.getObject(Admin.class,sql, params);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}		
		return admin;
	}
	@Override
	public void updateAdmin(Admin admin) {
		String sql = "update admin set name=?, pwd=? where id=?";
		Object[] params = { admin.getName(), admin.getPwd(), admin.getId() };
		try {
			dbUtil.execute(sql, params);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}










