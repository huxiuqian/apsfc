<%@page import="com.hpe.aposfc.po.Notice"%>
<%@page import="com.hpe.aposfc.dao.impl.NoticeDaoImpl"%>
<%@page import="com.hpe.aposfc.dao.NoticeDao"%>
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
	NoticeDao noticeDao = new NoticeDaoImpl();
	List<Notice> notice = noticeDao.selectNotice();

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
									<span class="left_bt2">公告信息列表</span>
								</td>
							</tr>
							<tr>
								<td class="line_table" align="center" width="25%"><span
									class="left_bt2">标题</span></td>
								<td class="line_table" align="center" width="40%"><span
									class="left_bt2">内容</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_bt2">发布时间</span></td>
								<td class="line_table" align="center" width="10%"></td>
							</tr>
					<% 	
						for(Notice n: notice){
												
					%>		
							<tr>
								<td class="line_table" align="center" width="20%"><span
									class="left_txt"><%	out.print(n.getName()); %></span></td>
								<td class="line_table" align="center" width="40%"><span
									class="left_txt"><%	out.print(n.getContent()); %></span></td>
								<td class="line_table" align="center" width="20%"><span
									class="left_txt"><%	out.print(n.getTimes()); %></span></td>
								<td class="line_table" align="center" width="20%"><a
									href="NoticeDelServlet?nid=<%=n.getId()%>">删除</a></td>
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
