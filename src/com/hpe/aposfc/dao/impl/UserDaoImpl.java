package com.hpe.aposfc.dao.impl;


import java.util.List;

import com.hpe.aposfc.dao.UserDao;
import com.hpe.aposfc.po.Menu;
import com.hpe.aposfc.po.User;
import com.hpe.aposfc.util.DBUtil;

public class UserDaoImpl implements UserDao{
	private DBUtil dbUtil = new DBUtil();
	@Override
	public User selectUserByName(String name) {
		String sql = "select * from users where name=?";
		Object[] params = { name };
		User user = null;
		try {
			user = (User) dbUtil.getObject(User.class,sql, params);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}		
		return user;
	}
	@Override
	public void addUser(User user) {
		String sql = "insert into users(name,pwd,realname,sex,age,card"
				+ ",address,phone,email,code) values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { user.getName(), user.getPwd(), user.getRealname(), user.getSex(), 
				user.getAge(), user.getCard(), user.getAddress(), user.getPhone(), 
				user.getEmail(), user.getCode() };
		try {
			dbUtil.execute(sql, params,true);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	@Override
	public User login(String name ,String pwd) {
		String sql = "select * from users where name=? and pwd=?";
		User userResult = null;
		Object[] params = { name , pwd};
		try {
			userResult = (User) dbUtil.getObject(User.class,sql, params);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return userResult;
	}
	@Override
	public void updateUser(User user) {
		// TODO 自动生成的方法存根
		String sql = "update users set pwd=?, realname=?, age=?, card=?, "
				+ "address=?, phone=?, email=?, code=? where id=?";
		Object[] params = { user.getPwd(), user.getRealname(),user.getAge(),user.getCard(),
				user.getAddress(), user.getPhone(), user.getEmail(), user.getCode(), user.getId()};
		try {
			dbUtil.execute(sql, params);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	@Override
	public List<User> selectUser() {
		String sql = "select * from users";
		List list = null;
		Object[] params = {};
		try {
			list = dbUtil.getQueryList(User.class, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
