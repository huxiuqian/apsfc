<%@page import="com.hpe.aposfc.po.Type"%>
<%@page import="com.hpe.aposfc.dao.impl.TypeDaoImpl"%>
<%@page import="com.hpe.aposfc.dao.TypeDao"%>
<%@page import="com.hpe.aposfc.po.Menu"%>
<%@page import="com.hpe.aposfc.dao.impl.MenuDaoImpl"%>
<%@page import="com.hpe.aposfc.dao.MenuDao"%>
<%@page import="java.util.*"%>
<%@ page language="java" pageEncoding="utf-8"%>
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
	String sid = request.getParameter("id");
	int id = Integer.parseInt(sid);
	Menu menu = menuDao.selectMenuById(id);
	TypeDao typeDao = new TypeDaoImpl();
	List<Type> type = typeDao.selectType();

%>
	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top" bgcolor="#F7F8F9">
				<p>修改菜单</p>
				<div align="center">
					<form action="MenuUpdateServlet" method="post"
						name="form1" onSubmit="return check11()">
						<table id="table2" class="line_table"
							style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
							cellPadding="0">

							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">菜单名称：</span></td>
								<td class="line_table" height="25" width="70%"><input
									type="text" name="name" size="45" value="<% out.print(menu.getName()); %>"></td>
							</tr>

							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">原&nbsp;&nbsp;&nbsp; 料：</span></td>
								<td class="line_table" height="25" width="80%"><input
									type="text" name="burden" size="45"
									value="<% out.print(menu.getBurden()); %>"></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">市场价格：</span></td>
								<td height="25" width="80%"><input type="text" name="price"
									size="45" value="<% out.print(menu.getPrice()); %>"></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">会员价格：</span></td>
								<td height="25" width="80%"><input type="text"
									name="price1" size="45" value="<% out.print(menu.getPrice1()); %>"></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">说&nbsp;&nbsp;&nbsp; 明：</span></td>
								<td class="line_table" height="25" width="80%"><textarea
										rows="12" name="brief" cols="100"><% out.print(menu.getBrief()); %></textarea></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">菜品类别：</span></td>
								<td class="line_table" height="25" width="80%"><select
									name="typeid">
					<% 	
						for(Type t: type){
												
					%>
								<option value="<%	out.print(t.getId()); %>"><%	out.print(t.getName()); %></option>
					<%
						}
					%>
								</select></td>
							</tr>
							<tr>
								<td class="line_table" align="right" width="20%"><span
									class="left_bt2">展示图片</span>：</td>
								<td class="line_table" width="80%" align="left"><img
									src="<% out.print(menu.getImgpath()); %>"></td>
								<input type="hidden" name="id" value="<% out.print(menu.getId()); %>"/>
							</tr>

							<tr>
								
								<td class="line_table" height="25" align="center" colspan="2">
									<input type="submit" value="修改"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" value="返回" onclick="javascript:window.location.href='menus.jsp'"/>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</td>

		</tr>
	</table>


</body>
</html>
