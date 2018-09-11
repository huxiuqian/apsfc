package com.hpe.aposfc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.aposfc.dao.OrderDao;
import com.hpe.aposfc.dao.impl.OrderDaoImpl;
import com.hpe.aposfc.po.Order;


/**
 * Servlet implementation class AdminOrderUpdateServlet
 */
public class AdminOrderUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminOrderUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void no(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String sid = request.getParameter("id");
    	int id = Integer.parseInt(sid);
		OrderDao orderDao = new OrderDaoImpl();
		Order order = orderDao.selectOrderById(id);
		String de = "已取消";
		order.setDelivery(de);
		orderDao.updateOrder(order);
		String cue="修改成功！";  
	    request.setAttribute("cue", cue);  
    }
    protected void yes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String sid = request.getParameter("id");
    	int id = Integer.parseInt(sid);
		OrderDao orderDao = new OrderDaoImpl();
		Order order = orderDao.selectOrderById(id);
		String de = "是";
		order.setDelivery(de);
		orderDao.updateOrder(order);
		String cue="修改成功！";  
	    request.setAttribute("cue", cue);  
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
