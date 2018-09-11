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
			String cue = "菜品已存在，请重新输入！";
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
			String cue = name+"添加成功！";  
	        request.setAttribute("cue", cue);  
	        request.getRequestDispatcher("menus.jsp").forward(request, response);
		}*/
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		MenuDao menuDao = new MenuDaoImpl();

		// response.setContentType("text/html;charset=utf-8");
		// 当前项目在服务器中的实际路径：D:\apache-tomcat-7.0.64\webapps\EAS2.0
		String realDir = request.getSession().getServletContext().getRealPath("");
		// System.out.println("项目路径：" + realDir);
		// 上下文路径
		String contextpath = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ contextpath + "/";

		try {
			String filePath = "img";
			// 当前项目实际路径的上传文件目录
			String realPath = realDir + "\\" + filePath;
			// 判断路径是否存在，不存在则创建
			File dir = new File(realPath);
			if (!dir.isDirectory())
				dir.mkdir();
			// 判断是否是上传表单操作
			if (ServletFileUpload.isMultipartContent(request)) {
				// 创建工厂
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// 设置上传文件的保存目录
				factory.setRepository(dir);
				// 设置缓冲区大小1000K
				factory.setSizeThreshold(1024000);
				// 创建文件上传解析器
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setHeaderEncoding("UTF-8");
				// 文件上传解析器解析请求，获得表单请求集合
				List items = upload.parseRequest(request);
				Iterator itr = items.iterator();
				String url = ""; // 图片地址
				String fileName = "";
				String state = "SUCCESS";
				String realFileName = "";
				String name = "";				
				String burden = "";
				String price = "";
				String price1 = "";
				String brief = "";
				String typeid = "";				
				// 迭代文件项
				while (itr.hasNext()) {
					// 获取表单项
					FileItem item = (FileItem) itr.next();
					try {
						// 如果表单项不是普通表单项，说明是文件域
						if (!item.isFormField()) {
							fileName = item.getName();// 获得不带路径的纯文件名
							// System.out.println(fileName);
							Pattern reg = Pattern.compile("[.]jpg|png|jpeg|gif$");
							Matcher matcher = reg.matcher(fileName);
							if (!matcher.find()) {
								state = "文件类型不允许！";
								break;
							}
							// 为了防止文件重名，对上传文件进行改名，扩展名不变
							realFileName = new Date().getTime()
									+ fileName.substring(fileName.lastIndexOf("."), fileName.length());
							// url为上传到服务器的文件完整路径名
							url = realPath + "\\" + realFileName;
							File file = new File(url);
							item.write(file);// 上传到服务器（写文件到服务器）
						} else {
							// 如果是普通表单项
							// System.out.println(
							// "menuname:" + item.getFieldName() + "，menuname:"
							// + item.getString("UTF-8"));
							String menuname = item.getFieldName();

							if (menuname.equals("name")) {
								name = item.getString("UTF-8");
								// System.out.println("菜单名：" + name);
							}
							
							if (menuname.equals("burden")) {
								burden = item.getString("UTF-8");
								// System.out.println("材料：" + burden);
							}
						
							if (menuname.equals("price")) {
								price = item.getString("UTF-8");
								// System.out.println("市场价格：" + price);
							}
							if (menuname.equals("price1")) {
								price1 = item.getString("UTF-8");
								// System.out.println("会员价格：" + price1);
							}
							if (menuname.equals("brief")) {
								brief = item.getString("UTF-8");
								// System.out.println("简介：" + brief);
							}
							if (menuname.equals("typeid")) {
								typeid = item.getString("UTF-8");
								// System.out.println("类型：" + typeid);
							}

						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				response.setStatus(200);
				String retxt = "{src:'" + basePath + filePath + "/" + realFileName + "',status:success}";
				response.getWriter().print(retxt + "<br>");

				// 保存filePath/realFileName到数据库
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
