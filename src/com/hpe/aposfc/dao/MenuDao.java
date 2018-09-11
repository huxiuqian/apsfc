package com.hpe.aposfc.dao;

import java.util.List;

import com.hpe.aposfc.po.Menu;


public interface MenuDao {
	List<Menu> selectMenu();

	void addMenu(Menu menu);
	void updateMenu(Menu menu);
	void updateSumMenu(Menu menu);
	void deleteMenu(Menu menu);
	Menu selectMenuById(int id);
	Menu selectMenuByName(String name);
}
