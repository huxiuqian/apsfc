package com.hpe.aposfc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpe.aposfc.dao.TypeDao;
import com.hpe.aposfc.dao.impl.TypeDaoImpl;
import com.hpe.aposfc.po.Type;

/**
 * Servlet implementation class TypeUpdateServlet
 */
public class TypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeUpdateServlet() {
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
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		TypeDao typeDao = new TypeDaoImpl();
		Type type = typeDao.selectTypeById(id);
		type.setName(name);
		typeDao.updateType(type);
		String cue="ÐÞ¸Ä³É¹¦£¡";  
	    request.setAttribute("cue", cue);  
	    request.getRequestDispatcher("type.jsp").forward(request, response);
	}

}
