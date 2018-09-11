package com.hpe.aposfc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpe.aposfc.dao.OrderDao;
import com.hpe.aposfc.dao.UserDao;
import com.hpe.aposfc.dao.impl.OrderDaoImpl;
import com.hpe.aposfc.dao.impl.UserDaoImpl;
import com.hpe.aposfc.po.OrderList;
import com.hpe.aposfc.po.User;

/**
 * Servlet implementation class UsersOrderSearchServlet
 */
public class UsersOrderSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersOrderSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void allList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession();
    	UserDao userDao = new UserDaoImpl();
		String name = (String)session.getAttribute("name");
		User user = userDao.selectUserByName(name);
    	OrderDao orderDao = new OrderDaoImpl();
		List<OrderList> list = orderDao.selectOrderList(user.getId());
		session.setAttribute("list",list);
    }
    protected void no(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession();
    	UserDao userDao = new UserDaoImpl();
		String name = (String)session.getAttribute("name");
		User user = userDao.selectUserByName(name);
		OrderDao orderDao = new OrderDaoImpl();
		List<OrderList> list = orderDao.selectOrderListNo(user.getId());
		session.setAttribute("list",list);
    }
    protected void yes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession();
    	UserDao userDao = new UserDaoImpl();
		String name = (String)session.getAttribute("name");
		User user = userDao.selectUserByName(name);
		OrderDao orderDao = new OrderDaoImpl();
		List<OrderList> list = orderDao.selectOrderListYes(user.getId());
		session.setAttribute("list",list);
    }
    protected void time(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession();
    	UserDao userDao = new UserDaoImpl();
		String name = (String)session.getAttribute("name");
		String date = (String)request.getParameter("date");
		System.out.println(date);
		User user = userDao.selectUserByName(name);
		OrderDao orderDao = new OrderDaoImpl();
		List<OrderList> list = orderDao.selectOrderListByTime(user.getId(),date);
		for(OrderList o : list){
			System.out.println(o);
		}
		session.setAttribute("list",list);
    }
    protected void name(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession();
    	UserDao userDao = new UserDaoImpl();
		String name = (String)session.getAttribute("name");
		String menuname = request.getParameter("menuname");
		System.out.println(menuname);
		User user = userDao.selectUserByName(name);
		OrderDao orderDao = new OrderDaoImpl();
		List<OrderList> list = orderDao.selectOrderListByName(user.getId(),menuname);
		session.setAttribute("list",list);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("no".equals(method)){
			no(request,response);
		}else if("yes".equals(method)){
			yes(request,response);
		}else if("all".equals(method)){
			allList(request,response);
		}else if("查询日期".equals((String)request.getParameter("time"))){
			time(request,response);
		}else if("查询菜名".equals((String)request.getParameter("name"))){
			name(request,response);
		}
		 request.getRequestDispatcher("order.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
