package com.hpe.aposfc.dao.impl;

import java.util.List;

import com.hpe.aposfc.dao.TypeDao;
import com.hpe.aposfc.po.Type;
import com.hpe.aposfc.util.DBUtil;

public class TypeDaoImpl implements TypeDao{
	private DBUtil dbUtil = new DBUtil();
	@Override
	public List<Type> selectType() {
		String sql = "select * from types";
		List list = null;
		Object[] params = {};
		try {
			list = dbUtil.getQueryList(Type.class, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void addType(Type type) {
		String sql = "insert into types(name) values(?)";
		Object[] params = { type.getName() };
		try {
			dbUtil.execute(sql, params,true);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateType(Type type) {
		String sql = "update types set name=? where id=?";
		Object[] params = { type.getName(), type.getId() };
		try {
			dbUtil.execute(sql, params);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public void deleteType(Type type) {
		String sql = "delete from types where id = ?";
		Object[] params = { type.getId() };
		try {
			dbUtil.execute(dbUtil.getConnection(),sql, params);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public Type selectTypeById(int id) {
		String sql = "select * from types where id=?";
		Object[] params = { id };
		Type type = null;
		try {
			type = (Type) dbUtil.getObject(Type.class,sql, params);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}		
		return type;
	}

	@Override
	public Type selectTypeByName(String name) {
		String sql = "select * from types where name=?";
		Object[] params = { name };
		Type type = null;
		try {
			type = (Type) dbUtil.getObject(Type.class,sql, params);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}		
		return type;
	}

}
