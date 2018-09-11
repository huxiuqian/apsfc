package com.hpe.aposfc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpe.aposfc.dao.AdminDao;
import com.hpe.aposfc.dao.impl.AdminDaoImpl;
import com.hpe.aposfc.po.Admin;


/**
 * Servlet implementation class AdminUpdateServlet
 */
public class AdminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateServlet() {
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
		String pwd = request.getParameter("pwd");
		AdminDao adminDao = new AdminDaoImpl();
		HttpSession session=request.getSession();
		String sname = (String)session.getAttribute("name");
		Admin admin = adminDao.selectAdminByName(sname);
		admin.setName(name);
		admin.setPwd(pwd);	
		adminDao.updateAdmin(admin);
		String cue="修改成功，请重新登陆！";  
	    request.setAttribute("cue", cue);  
	    request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
