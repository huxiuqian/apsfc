package com.hpe.aposfc.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpe.aposfc.dao.MenuDao;
import com.hpe.aposfc.dao.OrderDao;
import com.hpe.aposfc.dao.UserDao;
import com.hpe.aposfc.dao.impl.MenuDaoImpl;
import com.hpe.aposfc.dao.impl.OrderDaoImpl;
import com.hpe.aposfc.dao.impl.UserDaoImpl;
import com.hpe.aposfc.po.Menu;
import com.hpe.aposfc.po.Order;
import com.hpe.aposfc.po.User;
/**
 * Servlet implementation class UserOrderingServlet
 */
public class UserOrderingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserOrderingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Date date = new Date(System.currentTimeMillis()); 
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String times = format.format(date);
		String delivery = "·ñ";
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("name");
		UserDao userDao = new UserDaoImpl();
		User user = userDao.selectUserByName(name);
		Map<String, Menu> cart = (Map<String, Menu>)session.getAttribute("cart");
		OrderDao orderDao = new OrderDaoImpl();
		
		for(Map.Entry<String, Menu> entry : cart.entrySet()){
		MenuDao menuDao = new MenuDaoImpl();
		Menu menu = menuDao.selectMenuById(entry.getValue().getId()); 
		String sums1 = menu.getSums1();
		int sums = Integer.parseInt(sums1);
		Order order = new Order();
		order.setMenuid(entry.getValue().getId());
		order.setUserid(user.getId());
		order.setMenunum(String.valueOf(entry.getValue().getNumber()));
		order.setTimes(times);
		order.setDelivery(delivery);
		orderDao.addOrder(order);
		sums = entry.getValue().getNumber()+sums;
		String s = String.valueOf(sums);
		menu.setSums1(s);
		menuDao.updateSumMenu(menu);
		}
		String cue = "Ìí¼Ó³É¹¦£¡";  
        request.setAttribute("cue", cue);  
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
