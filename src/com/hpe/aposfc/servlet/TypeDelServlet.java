package com.hpe.aposfc.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpe.aposfc.dao.TypeDao;
import com.hpe.aposfc.dao.impl.TypeDaoImpl;
import com.hpe.aposfc.po.Type;

/**
 * Servlet implementation class TypeDelServlet
 */
public class TypeDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		TypeDao typeDao = new TypeDaoImpl();
		Type type = typeDao.selectTypeById(id);
		typeDao.deleteType(type);
		String cue="É¾³ý³É¹¦£¡";  
	    request.setAttribute("cue", cue);  
	    request.getRequestDispatcher("type.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
