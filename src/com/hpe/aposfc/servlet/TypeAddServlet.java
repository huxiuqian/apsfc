package com.hpe.aposfc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.aposfc.dao.TypeDao;
import com.hpe.aposfc.dao.impl.TypeDaoImpl;
import com.hpe.aposfc.po.Type;


/**
 * Servlet implementation class TypeAddServlet
 */
public class TypeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeAddServlet() {
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
		System.out.println(name);
		TypeDao typeDao = new TypeDaoImpl();
		Type type = null;
		type= typeDao.selectTypeByName(name);
		if(type != null){
			String cue = "菜品类别已存在，请重新输入！";
			request.setAttribute("cue",cue);
			request.getRequestDispatcher("type_add.jsp").forward(request, response);			
		}else{
			Type type1 = new Type();
			type1.setName(name);	
			typeDao.addType(type1);
			String cue=name+"添加成功！";  
	        request.setAttribute("cue", cue);  
	        request.getRequestDispatcher("type.jsp").forward(request, response);
		}
	}

}
