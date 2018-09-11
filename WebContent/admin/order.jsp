<%@page import="com.hpe.aposfc.po.OrderList"%>
<%@page import="com.hpe.aposfc.dao.impl.OrderDaoImpl"%>
<%@page import="com.hpe.aposfc.dao.OrderDao"%>
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
<script type="text/javascript">
function goPage(pno,psize){
    var itable = document.getElementById("table2");
    var num = itable.rows.length;//表格所有行数(所有记录数)
    console.log(num);
    var totalPage = 0;//总页数
    var pageSize = psize;//每页显示行数
    //总共分几页 
    if(num/pageSize > parseInt(num/pageSize)){   
            totalPage=parseInt(num/pageSize)+1;   
       }else{   
           totalPage=parseInt(num/pageSize);   
       }   
    var currentPage = pno;//当前页数
    var startRow = (currentPage - 1) * pageSize+1;//开始显示的行  31 
       var endRow = currentPage * pageSize;//结束显示的行   40
       endRow = (endRow > num)? num : endRow;    40
       console.log(endRow);
       //遍历显示数据实现分页
    for(var i=1;i<(num+1);i++){    
        var irow = itable.rows[i-1];
        if(i>=startRow && i<=endRow){
            irow.style.display = "block";    
        }else{
            irow.style.display = "none";
        }
    }
    var pageEnd = document.getElementById("pageEnd");
    var num1 = num-2;
    var tempStr = "共"+num1+"条记录 共"+totalPage+"页 当前第"+currentPage+"页";
    if(currentPage>1){
        tempStr += "<a href=\"#\" onClick=\"goPage("+(1)+","+psize+")\"> 首页 </a>";
        tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage-1)+","+psize+")\"> <上一页 </a>"
    }else{
        tempStr += "首页";
        tempStr += "<上一页";    
    }

    if(currentPage<totalPage){
        tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage+1)+","+psize+")\"> 下一页> </a>";
        tempStr += "<a href=\"#\" onClick=\"goPage("+(totalPage)+","+psize+")\"> 尾页 </a>";
    }else{
        tempStr += "下一页>";
        tempStr += "尾页";    
    }

    document.getElementById("barcon").innerHTML = tempStr;
    
}</script>
<body onLoad="goPage(1,10);">
<%
	OrderDao orderDao = new OrderDaoImpl();
	List<OrderList> orderList = orderDao.selectOrder();
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
								<td class="line_table" align="center" colspan="12" width="1200px"><span
									class="left_bt2">销售订单查询结果信息列表</span></td>
							</tr>
							<tr>
								<td class="line_table" align="center" width="49px"><span
									class="left_bt2">用户ID</span></td>
								<td class="line_table" align="center" width="98px"><span
									class="left_bt2">真实姓名</span></td>
								<td class="line_table" align="center" width="100px"><span
									class="left_bt2">联系方式</span></td>
								<td class="line_table" align="center" width="99px"><span
									class="left_bt2">家庭住址</span></td>
								<td class="line_table" align="center" width="99px"><span
									class="left_bt2">菜品名称</span></td>
								<td class="line_table" align="center" width="99px"><span
									class="left_bt2">订购数量</span></td>
								<td class="line_table" align="center" width="99px"><span
									class="left_bt2">单价(元)</span></td>
								<td class="line_table" align="center" width="99px"><span
									class="left_bt2">合计(元)</span></td>
								<td class="line_table" align="center" width="199px"><span
									class="left_bt2">订购时间</span></td>
								<td class="line_table" align="center" width="99px"><span
									class="left_bt2">是否派送</span></td>
								<td class="line_table" align="center" colspan="2" width="102px"><span
									class="left_bt2">确认订单</span></td>
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
								<td class="line_table" align="center" width="50px"><span
									class="left_txt"><%	out.print(ol.getUserid()); %></span></td>
								<td class="line_table" align="center" width="100px"><span
									class="left_txt"><%	out.print(ol.getRealname()); %></span></td>
								<td class="line_table" align="center" width="100px"><span
									class="left_txt"><%	out.print(ol.getPhone()); %></span></td>
								<td class="line_table" align="center" width="100px"><span
									class="left_txt"><%	out.print(ol.getAddress()); %></span></td>
								<td class="line_table" align="center" width="100px"><span
									class="left_txt"><%	out.print(ol.getName()); %></span></td>
								<td class="line_table" align="center" width="100px"><span
									class="left_txt"><%	out.print(ol.getMenunum()); %></span></td>
								<td class="line_table" align="center" width="100px"><span
									class="left_txt"><%	out.print(ol.getPrice1()); %></span></td>
								<td class="line_table" align="center" width="100px"><span
									class="left_txt"><%	out.print(total); %></span></td>
								<td class="line_table" align="center" width="200px"><span
									class="left_txt"><%	out.print(ol.getTimes()); %></span></td>
								<td class="line_table" align="center" width="100px"><span
									class="left_txt"><%	out.print(ol.getDelivery()); %></span></td>

								<td class="line_table" align="center"  width="50px"><a
									href="AdminOrderUpdateServlet?method=yes&id=<%=ol.getOrderid()%>">确认</a></td>
								<td class="line_table" align="center" width="50px"><a
									href="AdminOrderUpdateServlet?method=no&id=<%=ol.getOrderid()%>">取消</a></td>
							</tr>
						<% 
							}
						%>	
							
							
					</table>
					<table width="800px" align="right">
        <tr><td><div id="barcon" name="barcon"></div></td></tr>
    </table>
				</div>
				
				
				
				
			</td>
		</tr>
	</table>
</body>
</html>