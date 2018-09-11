package com.hpe.aposfc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.aposfc.dao.MenuDao;
import com.hpe.aposfc.dao.impl.MenuDaoImpl;
import com.hpe.aposfc.po.Menu;


/**
 * Servlet implementation class MenuUpdateServlet
 */
public class MenuUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String burden = request.getParameter("burden");
		String price = request.getParameter("price");
		String price1 = request.getParameter("price1");
		String brief = request.getParameter("brief");
		String typeid = request.getParameter("typeid");
		int tid = Integer.parseInt(typeid); 
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		MenuDao menuDao = new MenuDaoImpl();
		Menu menu = menuDao.selectMenuById(id);
		menu.setName(name);
		menu.setBurden(burden);
		menu.setPrice(price);
		menu.setPrice1(price1);
		menu.setBrief(brief);
		menu.setTypeid(tid);
		menuDao.updateMenu(menu);
		String cue="ÐÞ¸Ä³É¹¦£¡";  
	    request.setAttribute("cue", cue);  
	    request.getRequestDispatcher("menus.jsp").forward(request, response);
	}

}
