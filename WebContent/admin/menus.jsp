<%@page import="com.hpe.aposfc.po.Menu"%>
<%@page import="com.hpe.aposfc.dao.impl.MenuDaoImpl"%>
<%@page import="com.hpe.aposfc.dao.MenuDao"%>
<%@page import="java.util.*"%>
<%@ page language="java"  pageEncoding="utf-8"%>
<html>
<head>
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
-->
</style>
</head>
<body>
<%
		MenuDao menuDao = new MenuDaoImpl();
		List<Menu> menu = menuDao.selectMenu();

	%>
	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top" bgcolor="#F7F8F9">
				<div align="center">
					<table id="table2" class="line_table"
						style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
						cellPadding="0">
						<tbody style="margin: 0; padding: 0">
							<tr>
								<td class="line_table" align="center" colspan="11" height="20"><span
									class="left_bt2">菜单信息列表</span></td>
							</tr>
							<tr>
								<td class="line_table" align="center"><span
									class="left_bt2">菜单名称</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">展示图片</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">原料</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">类型</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">说明</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">市场价格</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">市场价销售数量</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">会员单价</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">会员价销售数量</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">&nbsp;</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">&nbsp;</span></td>
							</tr>
					<% 	
						for(Menu m: menu){
																
					%>	
							<tr>
								<td class="line_table" align="center"><a
									href="menus_update.jsp?id=<%=m.getId()%>"><%	out.print(m.getName()); %></a></td>
								<td class="line_table" align="center"><a
									href="<%=m.getImgpath()%>"><img src="<%out.print(m.getImgpath()); %>"
										width="30" heigth="30"></a></td>
								<td class="line_table" align="center"><span
									class="left_txt"><%	out.print(m.getBurden()); %></span></td>
								<td class="line_table" align="center"><span
									class="left_txt"><%	out.print(m.getTypeid()); %></span></td>
								<td class="line_table" align="center"><span
									class="left_txt"><%	out.print(m.getBrief()); %></span></td>
								<td class="line_table" align="center"><span
									class="left_txt"><%	out.print(m.getPrice()); %></span></td>
								<td class="line_table" align="center"><span
									class="left_txt"><%	out.print(m.getSums()); %></span></td>
								<td class="line_table" align="center"><span
									class="left_txt"><%	out.print(m.getPrice1()); %></span></td>
								<td class="line_table" align="center"><span
									class="left_txt"><%	out.print(m.getSums1()); %></span></td>
								<td class="line_table" align="center"><a
									href="menus_update.jsp?id=<%=m.getId()%>">修改</a></td>
								<td class="line_table" align="center"><a
									href="MenuDelServlet?id=<%=m.getId()%>">删除</a></td>
							</tr>
					<%
						}
					%>
							
							<tr>
								<td class="line_table" align="center" colspan="11" height="20">
								<span class="left_bt2">第1页
										&nbsp;&nbsp;共1页
								</span>&nbsp;&nbsp; 
								    <a href="#">[首页]</a>
								    <a href="#">[尾页]</a>&nbsp;&nbsp; 
								    <a href="#%>">[上一页]</a>
									<a href="#">[下一页]</a>
								</td>
							</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
