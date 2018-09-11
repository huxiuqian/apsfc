package com.hpe.aposfc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.aposfc.dao.NoticeDao;
import com.hpe.aposfc.dao.impl.NoticeDaoImpl;
import com.hpe.aposfc.po.Notice;


/**
 * Servlet implementation class NoticeDelServlet
 */
public class NoticeDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("nid");
		int id = Integer.parseInt(sid);
		NoticeDao noticeDao = new NoticeDaoImpl();
		Notice notice = noticeDao.selectNoticeById(id);
		noticeDao.deleteNotice(notice);
		String cue="É¾³ý³É¹¦£¡";  
	    request.setAttribute("cue", cue);  
	    request.getRequestDispatcher("notice.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
