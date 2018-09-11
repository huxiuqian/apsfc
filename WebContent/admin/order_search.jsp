<%@page import="com.hpe.aposfc.po.OrderList"%>
<%@page import="com.hpe.aposfc.dao.impl.OrderDaoImpl"%>
<%@page import="com.hpe.aposfc.dao.OrderDao"%>
<%@page import="java.util.*"%>
<%@ page language="java" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<script src="js/date.js" type="text/javascript"></script>
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
	OrderDao orderDao = new OrderDaoImpl();
	List<OrderList> orderList = (List)session.getAttribute("adminlist");
	if(orderList == null){
		orderList = new ArrayList(); 
	}
	
%>

	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top" bgcolor="#F7F8F9">

				<div align="center" width="120">
					<form action="AdminOrderSearchServlet" name="form1"
						method="get">
						<table id="table1" class="line_table"
							style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
							cellPadding="0">
							<tbody style="margin: 0; padding: 0">

								<tr>
									<td class="line_table" align="right" width="40%"><span
										class="left_bt2">按用户ID查询</span></td>
									<td class="line_table" align="left" width="60%"><input
										type="text" name="userid" size="20"> <input
										type="submit" name="id" value="查询ID"></td>
								</tr>
								<tr>
									<td class="line_table" align="right" width="40%"><span
										class="left_bt2">按菜品名称查询</span></td>
									<td class="line_table" align="left" width="60%"><input
										type="text" name="menuname" size="20"> <input
										type="submit" name="name" value="查询菜名"></td>
								<tr>
									<td class="line_table" align="right" width="40%"><span
										class="left_bt2">按销售日期查询</span></td>
									<td class="line_table" align="left" width="60%"><input
										type="text" name="date" size="20" readOnly
										onClick="setDay(this);"> <input type="submit" name="time" 
										value="查询日期"></td>
						</table>
					</form>
				</div>



				<div align="center">
					<table id="table2" class="line_table"
						style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
						cellPadding="0">
						<tbody style="margin: 0; padding: 0">
							<tr>
								<td class="line_table" align="center" colspan="12"><span
									class="left_bt2">销售订单查询结果信息列表</span></td>
							</tr>
							<tr>
								<td class="line_table" align="center"><span
									class="left_bt2">用户ID</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">真实姓名</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">联系方式</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">家庭住址</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">菜品名称</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">订购数量</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">单价(元)</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">合计(元)</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">订购时间</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">是否派送</span></td>
								
							</tr>
	<%
									int total=0;
									int p =0;
									int n =0;
									for( OrderList ol : orderList){
										p = Integer.parseInt(ol.getPrice1());
										n = Integer.parseInt(ol.getMenunum());
										total = p * n;
						%>
                             <tr>
								<td class="line_table" align="center"><span
									class="left_txt"><%	out.print(ol.getUserid()); %></span></td>
								<td class="line_table" align="center"><span
									class="left_txt"><%	out.print(ol.getRealname()); %></span></td>
								<td class="line_table" align="center"><span
									class="left_txt"><%	out.print(ol.getPhone()); %></span></td>
								<td class="line_table" align="center"><span
									class="left_txt"><%	out.print(ol.getAddress()); %></span></td>
								<td class="line_table" align="center"><span
									class="left_txt"><%	out.print(ol.getName()); %></span></td>
								<td class="line_table" align="center"><span
									class="left_txt"><%	out.print(ol.getMenunum()); %></span></td>
								<td class="line_table" align="center"><span
									class="left_txt"><%	out.print(ol.getPrice1()); %></span></td>
								<td class="line_table" align="center"><span
									class="left_txt"><%	out.print(total); %></span></td>
								<td class="line_table" align="center"><span
									class="left_txt"><%	out.print(ol.getTimes()); %></span></td>
								<td class="line_table" align="center"><span
									class="left_txt"><%	out.print(ol.getDelivery()); %></span></td>

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
