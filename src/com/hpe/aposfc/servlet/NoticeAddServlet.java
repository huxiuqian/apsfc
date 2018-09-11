package com.hpe.aposfc.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.aposfc.dao.NoticeDao;
import com.hpe.aposfc.dao.TypeDao;
import com.hpe.aposfc.dao.impl.NoticeDaoImpl;
import com.hpe.aposfc.dao.impl.TypeDaoImpl;
import com.hpe.aposfc.po.Notice;
import com.hpe.aposfc.po.Type;

/**
 * Servlet implementation class NoticeAddServlet
 */
public class NoticeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeAddServlet() {
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
		Date date=new Date(System.currentTimeMillis()); 
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd"); 
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String times = format.format(date);
		NoticeDao noticeDao = new NoticeDaoImpl();
		Notice notice = null;
		notice = noticeDao.selectNoticeByName(name);
		if(notice != null){
			String cue = "公告已存在，请重新输入！";
			request.setAttribute("cue",cue);
			request.getRequestDispatcher("notice_add.jsp").forward(request, response);			
		}else{
			Notice notice1 = new Notice();
			notice1.setName(name);
			notice1.setContent(content);
			notice1.setTimes(times);
			noticeDao.addNotice(notice1);
			String cue=name+"添加成功！";  
	        request.setAttribute("cue", cue);  
	        request.getRequestDispatcher("notice.jsp").forward(request, response);
		}
	}

}
