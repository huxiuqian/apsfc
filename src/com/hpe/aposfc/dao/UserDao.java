package com.hpe.aposfc.dao;

import java.util.List;

import com.hpe.aposfc.po.User;

public interface UserDao {
	User selectUserByName(String name);
	void addUser(User user);
	void updateUser(User user);
	public User login(String name ,String pwd);
	List<User> selectUser();
}
