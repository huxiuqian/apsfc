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
 * Servlet implementation class MenuDelServlet
 */
public class MenuDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		MenuDao menuDao = new MenuDaoImpl();
		Menu menu = menuDao.selectMenuById(id);
		menuDao.deleteMenu(menu);
		String cue="É¾³ý³É¹¦£¡";  
	    request.setAttribute("cue", cue);  
	    request.getRequestDispatcher("menus.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
