package com.hpe.aposfc.dao;

import java.util.List;

import com.hpe.aposfc.po.Order;
import com.hpe.aposfc.po.OrderList;

public interface OrderDao {
	List<OrderList> selectOrder();
	List<OrderList> selectOrderList(int id);
	List<OrderList> selectOrderListNo(int id);
	List<OrderList> selectOrderListYes(int id);
	List<OrderList> selectOrderListByName(int id,String name);
	List<OrderList> selectOrderListByTime(int id,String time);
	List<OrderList> selectOrderByTime(String time);
	List<OrderList> selectOrderByName(String name);
	List<OrderList> selectOrderByID(int id);
	void addOrder(Order order);
	void updateOrder(Order order);
	Order selectOrderById(int id);
	Order selectOrdereByName(String name);
}
