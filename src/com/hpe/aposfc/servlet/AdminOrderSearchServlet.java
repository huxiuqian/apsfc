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
 * Servlet implementation class AdminOrderSearchServlet
 */
public class AdminOrderSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminOrderSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void time(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession();
    	String date = (String)request.getParameter("date");
		OrderDao orderDao = new OrderDaoImpl();
		List<OrderList> list = orderDao.selectOrderByTime(date);
		session.setAttribute("adminlist",list);
    }
    protected void name(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession();
		String menuname = request.getParameter("menuname");
		OrderDao orderDao = new OrderDaoImpl();
		List<OrderList> list = orderDao.selectOrderByName(menuname);
		session.setAttribute("adminlist",list);
    }
    protected void id(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession();
		String sid = request.getParameter("userid");
		int id = Integer.parseInt(sid);
		OrderDao orderDao = new OrderDaoImpl();
		List<OrderList> list = orderDao.selectOrderByID(id);
		session.setAttribute("adminlist",list);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("查询日期".equals((String)request.getParameter("time"))){
			time(request,response);
		}else if("查询菜名".equals((String)request.getParameter("name"))){
			name(request,response);
		}else if("查询ID".equals((String)request.getParameter("id"))){
			id(request,response);
		}
		 request.getRequestDispatcher("order_search.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
