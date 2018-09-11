package com.hpe.aposfc.dao.impl;

import java.util.List;

import com.hpe.aposfc.dao.OrderDao;
import com.hpe.aposfc.po.Order;
import com.hpe.aposfc.po.OrderList;
import com.hpe.aposfc.util.DBUtil;

public class OrderDaoImpl implements OrderDao{
	private DBUtil dbUtil = new DBUtil();
	@Override
	public List<OrderList> selectOrder() {
		String sql = "select orders.orderid,orders.userid,menus.name, users.realname, users.phone, users.address, orders.menunum, menus.price1, orders.times, orders.delivery from orders inner join menus on menus.id=orders.menuid inner join users on users.id=orders.userid ";
		List list = null;
		Object[] params = { };
		try {
			list = dbUtil.getQueryList(OrderList.class, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OrderList> selectOrderList(int id) {
		String sql = "select menus.name, users.realname, users.phone, users.address, orders.menunum, menus.price1, orders.times, orders.delivery from orders inner join menus on menus.id=orders.menuid inner join users on users.id=orders.userid where users.id=? ";
		List list = null;
		Object[] params = { id };
		try {
			list = dbUtil.getQueryList(OrderList.class, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public void addOrder(Order order) {
		// TODO 自动生成的方法存根
		String sql = "insert into orders(menuid,userid,menunum,times,delivery) values(?,?,?,?,?)";
		Object[] params = { order.getMenuid(), order.getUserid(), order.getMenunum(), order.getTimes(), order.getDelivery() };
		try {
			dbUtil.execute(sql, params,true);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public Order selectOrderById(int id) {
		String sql = "select * from orders where orderid=?";
		Object[] params = { id };
		Order order = null;
		try {
			order = (Order) dbUtil.getObject(Order.class,sql, params);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}		
		return order;
	}

	@Override
	public Order selectOrdereByName(String name) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<OrderList> selectOrderListNo(int id) {
		String sql = "select menus.name, users.realname, users.phone, users.address, orders.menunum, menus.price1, orders.times, orders.delivery from orders inner join menus on menus.id=orders.menuid inner join users on users.id=orders.userid where users.id=? and delivery='否' ";
		List list = null;
		Object[] params = { id };
		try {
			list = dbUtil.getQueryList(OrderList.class, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OrderList> selectOrderListYes(int id) {
		String sql = "select menus.name, users.realname, users.phone, users.address, orders.menunum, menus.price1, orders.times, orders.delivery from orders inner join menus on menus.id=orders.menuid inner join users on users.id=orders.userid where users.id=? and delivery='是' ";
		List list = null;
		Object[] params = { id };
		try {
			list = dbUtil.getQueryList(OrderList.class, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OrderList> selectOrderListByName(int id,String name) {
		String sql = "select menus.name, users.realname, users.phone, users.address, orders.menunum, menus.price1, orders.times, orders.delivery from orders inner join menus on menus.id=orders.menuid inner join users on users.id=orders.userid where users.id=? and menus.name=? ";
		List list = null;
		Object[] params = { id , name};
		try {
			list = dbUtil.getQueryList(OrderList.class, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OrderList> selectOrderListByTime(int id,String time) {
		String sql = "select menus.name, users.realname, users.phone, users.address, orders.menunum, menus.price1, orders.times, orders.delivery from orders inner join menus on menus.id=orders.menuid inner join users on users.id=orders.userid where users.id=? and orders.times like ? ";
		List list = null;
		String times = time+"%";
		Object[] params = { id, times};
		try {
			list = dbUtil.getQueryList(OrderList.class, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateOrder(Order order) {
		String sql = "update orders set delivery=? where orderid=?";
		Object[] params = { order.getDelivery(), order.getOrderid() };
		try {
			dbUtil.execute(sql, params);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderList> selectOrderByTime(String time) {
		String sql = "select orders.userid,menus.name, users.realname, users.phone, users.address, orders.menunum, menus.price1, orders.times, orders.delivery from orders inner join menus on menus.id=orders.menuid inner join users on users.id=orders.userid where orders.times like ? ";
		List list = null;
		String times = time+"%";
		Object[] params = { times };
		try {
			list = dbUtil.getQueryList(OrderList.class, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OrderList> selectOrderByName(String name) {
		String sql = "select orders.userid,menus.name, users.realname, users.phone, users.address, orders.menunum, menus.price1, orders.times, orders.delivery from orders inner join menus on menus.id=orders.menuid inner join users on users.id=orders.userid where menus.name=? ";
		List list = null;
		Object[] params = { name };
		try {
			list = dbUtil.getQueryList(OrderList.class, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OrderList> selectOrderByID(int id) {
		String sql = "select orders.userid,menus.name, users.realname, users.phone, users.address, orders.menunum, menus.price1, orders.times, orders.delivery from orders inner join menus on menus.id=orders.menuid inner join users on users.id=orders.userid where users.id=? ";
		List list = null;
		Object[] params = { id };
		try {
			list = dbUtil.getQueryList(OrderList.class, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}



}
