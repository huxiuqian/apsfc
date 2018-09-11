package com.hpe.aposfc.dao.impl;

import java.util.List;

import com.hpe.aposfc.dao.MenuDao;
import com.hpe.aposfc.po.Menu;
import com.hpe.aposfc.po.OrderList;
import com.hpe.aposfc.util.DBUtil;

public class MenuDaoImpl implements MenuDao{
	private DBUtil dbUtil = new DBUtil();

	@Override
	public List<Menu> selectMenu() {
		String sql = "select * from menus";
		List list = null;
		Object[] params = {};
		try {
			list = dbUtil.getQueryList(Menu.class, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Menu selectMenuById(int id) {
		String sql = "select * from menus where id=?";
		Object[] params = { id };
		Menu menu = null;
		try {
			menu = (Menu) dbUtil.getObject(Menu.class,sql, params);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}		
		return menu;
	}

	@Override
	public void deleteMenu(Menu menu) {
		String sql = "delete from menus where id = ?";
		Object[] params = { menu.getId() };
		try {
			dbUtil.execute(dbUtil.getConnection(),sql, params);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

	@Override
	public void addMenu(Menu menu) {
		String sql = "insert into menus(name,burden,price,price1,brief,typeid,imgpath,sums,sums1) values(?,?,?,?,?,?,?,?,?)";
		String sums="0";
		String sums1="0";
		Object[] params = { menu.getName(),menu.getBurden(),menu.getPrice(),menu.getPrice1(),
				menu.getBrief(),menu.getTypeid(),menu.getImgpath(),sums,sums1};
		try {
			dbUtil.execute(sql, params,true);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public void updateMenu(Menu menu) {
		String sql = "update menus set name=?, burden=?, price=?, price1=?, brief=?, typeid=? where id=?";
		Object[] params = { menu.getName(), menu.getBurden(), menu.getPrice(), menu.getPrice1(),
				menu.getBrief(), menu.getTypeid(), menu.getId() };
		try {
			dbUtil.execute(sql, params);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public Menu selectMenuByName(String name) {
		String sql = "select * from menus where name=?";
		Object[] params = { name };
		Menu menu= null;
		try {
			menu = (Menu) dbUtil.getObject(Menu.class,sql, params);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}		
		return menu;
	}

	@Override
	public void updateSumMenu(Menu menu) {
		String sql = "update menus set sums1=? where id=?";
		Object[] params = { menu.getSums1(), menu.getId() };
		try {
			dbUtil.execute(sql, params);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
