package com.hpe.aposfc.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpe.aposfc.dao.MenuDao;
import com.hpe.aposfc.dao.impl.MenuDaoImpl;
import com.hpe.aposfc.po.Menu;

/**
 * Servlet implementation class ShoppingDelServlet
 */
public class ShoppingDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
/*
		String deleteid = request.getParameter("deleteid");
		int did = Integer.parseInt(deleteid);
		System.out.println("aaaa"+did);
		MenuDao menuDao = new MenuDaoImpl();
		Menu menu1 = menuDao.selectMenuById(did);
		HttpSession session = request.getSession();
		Map<Menu, Integer> cart1 = (Map<Menu, Integer>) session.getAttribute("cart");
		cart1.remove(menu1);
		session.setAttribute("cart", cart1);
		response.sendRedirect("shoppingcar.jsp");
*/
		String deleteid = request.getParameter("deleteid");
		//ø…“‘…æ3––£ø
		int did = Integer.parseInt(deleteid);
		MenuDao menuDao = new MenuDaoImpl();
		Menu menu1 = menuDao.selectMenuById(did);
		HttpSession session = request.getSession();
		Map<String, Menu> cart1 = (Map<String, Menu>) session.getAttribute("cart");
		cart1.remove(deleteid);
		session.setAttribute("cart", cart1);
		response.sendRedirect("shoppingcar.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
