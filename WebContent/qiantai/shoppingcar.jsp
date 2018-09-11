<%@page import="com.hpe.aposfc.po.Menu"%>
<%@ page language="java" import="java.util.*,java.text.*"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>-我的订餐车</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/skin.css" rel="stylesheet" type="text/css" />
</head>
<body style='background: transparent'>
<%
//	Map<Menu, Integer> map = (Map<Menu, Integer>)session.getAttribute("cart");
	Map<String, Menu> map = (Map<String, Menu>)session.getAttribute("cart");
	if (map == null) {
		map = new HashMap<String, Menu>();
	}
%>
	<table width="900" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td align="left" valign="top"><jsp:include flush="fasle"
					page="top.jsp" /></td>
		</tr>
		<tr>
			<td height="50px"></td>

		</tr>

		<tr>
			<td align="center" valign="top" height="420px">

				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td align="left" valign="top">


							<div align="center">
								<table id="table2" class="line_table"
									style="width: 700px; margin: 0; padding: 0" cellSpacing="0"
									cellPadding="0">
									<tbody style="margin: 0; padding: 0">
										<tr>
											<td class="line_table" align="center" colspan="4"><span
												class="left_bt2">我的订餐信息列表</span></td>
										</tr>
										<tr>
											<td class="line_table" align="center" width="40%"><span
												class="left_bt2">菜品名称</span></td>
											<td class="line_table" align="center" width="20%"><span
												class="left_bt2">单价</span></td>
											<td class="line_table" align="center" width="20%"><span
												class="left_bt2">数量</span></td>
											<td class="line_table" align="center" width="20%"><span
												class="left_bt2">&nbsp;&nbsp;</span></td>
										</tr>
									<%
									//for (Map.Entry<Menu, Integer> entry : map.entrySet()) {  
										int money = 0;
										int num = 0;
										  for (Map.Entry<String, Menu> entry : map.entrySet()) { 
									   
									%>
										<tr>
											<td class="line_table" align="center" width="40%"><span
												class="left_txt"><% out.print(entry.getValue().getName()); %></span></td>
											<td class="line_table" align="center" width="20%"><span
												class="left_txt"><% out.print(entry.getValue().getPrice1());%></span></td>
											<td class="line_table" align="center" width="20%"><span
												class="left_txt"><% out.print(entry.getValue().getNumber());%></span></td>
											<td class="line_table" align="center" width="20%"><a
												href="ShoppingDelServlet?deleteid=<%=entry.getKey()%>">取消</a></td>
										</tr>
									<%
										int p = Integer.parseInt(entry.getValue().getPrice1());
										int n = entry.getValue().getNumber();
										money = money + p * n;
										num = num + n;
									}
									%>

										<tr>
											<td class="line_table" align="center" colspan="4"><span
												class="left_bt2">小&nbsp;&nbsp;计：</span>&nbsp; <span
												style="color: #ff0000;"><%=money %></span>&nbsp;&nbsp; <span
												class="left_bt2">元</span>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span class="left_bt2">共：</span>&nbsp; <span
												style="color: #ff0000;"><%=num %></span>&nbsp; <span
												class="left_bt2">份</span></td>

										</tr>

										<tr>
											<td class="line_table" align="center" colspan="4"
												valign="center"><a href="UserOrderingServlet"><img
													src="images/canche_submit.gif" border="0" /></a>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

												<a href="ShoppingClearServlet"><img
													src="images/quxiao2.gif" border="0" /></a></td>

										</tr>
								</table>
							</div>




						</td>
					</tr>
				</table>



			</td>
		</tr>
		<tr>
			<td height="10px">&nbsp;</td>
		</tr>
		<tr>
			<td height="50px" align="center" valign="middle"><jsp:include
					flush="fasle" page="copyright.jsp" /></td>
		</tr>

	</table>



</body>
</html>
