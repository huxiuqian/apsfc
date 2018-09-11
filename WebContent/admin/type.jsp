<%@page import="com.hpe.aposfc.po.Type"%>
<%@page import="com.hpe.aposfc.dao.impl.TypeDaoImpl"%>
<%@page import="com.hpe.aposfc.dao.TypeDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
TypeDao typeDao = new TypeDaoImpl();
List<Type> type = typeDao.selectType();
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
								<td class="line_table" align="center" colspan="8" height="20">
									<span class="left_bt2">类别信息列表</span>
								</td>
							</tr>
							<tr>
								<td class="line_table" align="center" width="30%"><span
									class="left_bt2">类别ID</span></td>
								<td class="line_table" align="center" width="30%"><span
									class="left_bt2">类别名称</span></td>
								<td class="line_table" align="center" width="20%"></td>
								<td class="line_table" align="center" width="20%"></td>
							</tr>
					<% 	
						for(Type t: type){
												
					%>
							<tr>
								<td class="line_table" align="center" width="30%"><span
									class="left_txt"><%	out.print(t.getId()); %></span></td>
								<td class="line_table" align="center" width="30%"><span
									class="left_txt"><%	out.print(t.getName()); %></span></td>
								<td class="line_table" align="center" width="20%"><a
									href="type_update.jsp?id=<%=t.getId() %>" target="main">修改</a></td>
								<td class="line_table" align="center" width="20%"><a
									href="TypeDelServlet?id=<%=t.getId() %>" target="main">删除</a></td>
							</tr>
					<%
						}
					%>
						
					</table>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
