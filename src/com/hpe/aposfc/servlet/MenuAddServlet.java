package com.hpe.aposfc.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hpe.aposfc.dao.MenuDao;
import com.hpe.aposfc.dao.impl.MenuDaoImpl;
import com.hpe.aposfc.po.Menu;


/**
 * Servlet implementation class MenuAddServlet
 */
public class MenuAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuAddServlet() {
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
	/*	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String burden = request.getParameter("burden");
		String price = request.getParameter("price");
		String price1 = request.getParameter("price1");
		String brief = request.getParameter("brief");
		String typeid = request.getParameter("typeid");
		int tid = Integer.parseInt(typeid); 
		System.out.println(tid);
		
		MenuDao menuDao = new MenuDaoImpl();
		Menu menu = null;
		menu = menuDao.selectMenuByName(name);
		if(menu != null){
			String cue = "��Ʒ�Ѵ��ڣ����������룡";
			request.setAttribute("cue",cue);
			request.getRequestDispatcher("menus_add.jsp").forward(request, response);			
		}else{
			Menu menu1 = new Menu();
			menu1.setName(name);
			menu1.setBurden(burden);
			menu1.setPrice(price);
			menu1.setPrice1(price1);
			menu1.setBrief(brief);
			menu1.setTypeid(tid);
			menu1.setImgpath(img);
			menuDao.addMenu(menu1);
			String cue = name+"��ӳɹ���";  
	        request.setAttribute("cue", cue);  
	        request.getRequestDispatcher("menus.jsp").forward(request, response);
		}*/
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		MenuDao menuDao = new MenuDaoImpl();

		// response.setContentType("text/html;charset=utf-8");
		// ��ǰ��Ŀ�ڷ������е�ʵ��·����D:\apache-tomcat-7.0.64\webapps\EAS2.0
		String realDir = request.getSession().getServletContext().getRealPath("");
		// System.out.println("��Ŀ·����" + realDir);
		// ������·��
		String contextpath = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ contextpath + "/";

		try {
			String filePath = "img";
			// ��ǰ��Ŀʵ��·�����ϴ��ļ�Ŀ¼
			String realPath = realDir + "\\" + filePath;
			// �ж�·���Ƿ���ڣ��������򴴽�
			File dir = new File(realPath);
			if (!dir.isDirectory())
				dir.mkdir();
			// �ж��Ƿ����ϴ�������
			if (ServletFileUpload.isMultipartContent(request)) {
				// ��������
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// �����ϴ��ļ��ı���Ŀ¼
				factory.setRepository(dir);
				// ���û�������С1000K
				factory.setSizeThreshold(1024000);
				// �����ļ��ϴ�������
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setHeaderEncoding("UTF-8");
				// �ļ��ϴ��������������󣬻�ñ����󼯺�
				List items = upload.parseRequest(request);
				Iterator itr = items.iterator();
				String url = ""; // ͼƬ��ַ
				String fileName = "";
				String state = "SUCCESS";
				String realFileName = "";
				String name = "";				
				String burden = "";
				String price = "";
				String price1 = "";
				String brief = "";
				String typeid = "";				
				// �����ļ���
				while (itr.hasNext()) {
					// ��ȡ����
					FileItem item = (FileItem) itr.next();
					try {
						// ����������ͨ���˵�����ļ���
						if (!item.isFormField()) {
							fileName = item.getName();// ��ò���·���Ĵ��ļ���
							// System.out.println(fileName);
							Pattern reg = Pattern.compile("[.]jpg|png|jpeg|gif$");
							Matcher matcher = reg.matcher(fileName);
							if (!matcher.find()) {
								state = "�ļ����Ͳ�����";
								break;
							}
							// Ϊ�˷�ֹ�ļ����������ϴ��ļ����и�������չ������
							realFileName = new Date().getTime()
									+ fileName.substring(fileName.lastIndexOf("."), fileName.length());
							// urlΪ�ϴ������������ļ�����·����
							url = realPath + "\\" + realFileName;
							File file = new File(url);
							item.write(file);// �ϴ�����������д�ļ�����������
						} else {
							// �������ͨ����
							// System.out.println(
							// "menuname:" + item.getFieldName() + "��menuname:"
							// + item.getString("UTF-8"));
							String menuname = item.getFieldName();

							if (menuname.equals("name")) {
								name = item.getString("UTF-8");
								// System.out.println("�˵�����" + name);
							}
							
							if (menuname.equals("burden")) {
								burden = item.getString("UTF-8");
								// System.out.println("���ϣ�" + burden);
							}
						
							if (menuname.equals("price")) {
								price = item.getString("UTF-8");
								// System.out.println("�г��۸�" + price);
							}
							if (menuname.equals("price1")) {
								price1 = item.getString("UTF-8");
								// System.out.println("��Ա�۸�" + price1);
							}
							if (menuname.equals("brief")) {
								brief = item.getString("UTF-8");
								// System.out.println("��飺" + brief);
							}
							if (menuname.equals("typeid")) {
								typeid = item.getString("UTF-8");
								// System.out.println("���ͣ�" + typeid);
							}

						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				response.setStatus(200);
				String retxt = "{src:'" + basePath + filePath + "/" + realFileName + "',status:success}";
				response.getWriter().print(retxt + "<br>");

				// ����filePath/realFileName�����ݿ�
				// User user = ubiz.getById(uid);

				String realimg = (filePath + "/" + realFileName);
				String img = "../" + realimg;
				int tid = Integer.parseInt(typeid);
				Menu menu1 = new Menu();
				menu1.setName(name);
				menu1.setBurden(burden);
				menu1.setPrice(price);
				menu1.setPrice1(price1);
				menu1.setBrief(brief);
				menu1.setTypeid(tid);
				menu1.setImgpath(img);
				menuDao.addMenu(menu1);
				response.sendRedirect("menus.jsp");

			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

}
