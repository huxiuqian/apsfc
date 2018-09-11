package com.hpe.aposfc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.aposfc.dao.UserDao;
import com.hpe.aposfc.dao.impl.UserDaoImpl;
import com.hpe.aposfc.po.User;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String realname = request.getParameter("realname");		
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String card = request.getParameter("card");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		UserDao userDao = new UserDaoImpl();
		User user = null;
		user= userDao.selectUserByName(name);
		if(user != null){
			String cue = "该用户已注册，请重新输入！";
			request.setAttribute("cue",cue);
			request.getRequestDispatcher("reg.jsp").forward(request, response);			
		}else{
			User user1 = new User();
			user1.setName(name);
			user1.setPwd(pwd);
			user1.setRealname(realname);
			user1.setSex(sex);
			user1.setAge(age);
			user1.setCard(card);
			user1.setAddress(address);
			user1.setPhone(phone);
			user1.setEmail(email);
			user1.setCode(code);
			userDao.addUser(user1);
			String cue=name+"注册成功，请重新登陆！";  
	        request.setAttribute("cue", cue);  
	        request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
