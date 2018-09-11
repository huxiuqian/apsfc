package com.hpe.aposfc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpe.aposfc.dao.UserDao;
import com.hpe.aposfc.dao.impl.UserDaoImpl;
import com.hpe.aposfc.po.User;

/**
 * Servlet implementation class UserModifyServlet
 */
public class UserModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserModifyServlet() {
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

		String pwd = request.getParameter("pwd");
		String realname = request.getParameter("realname");		
		String age = request.getParameter("age");
		String card = request.getParameter("card");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		UserDao userDao = new UserDaoImpl();
		HttpSession session=request.getSession();
		String name = (String)session.getAttribute("name");
		User user = userDao.selectUserByName(name);
		user.setPwd(pwd);
		user.setRealname(realname);
		user.setAge(age);
		user.setCard(card);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		user.setCode(code);
		userDao.updateUser(user);
		String cue="修改成功，请重新登陆！";  
	    request.setAttribute("cue", cue);  
	    request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}
}
