<%@page import="com.hpe.aposfc.po.OrderList"%>
<%@page import="com.hpe.aposfc.dao.OrderDao"%>
<%@page import="com.hpe.aposfc.dao.impl.OrderDaoImpl"%>
<%@ page language="java" import="java.util.*,java.text.*"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>我的订单</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/skin.css" rel="stylesheet" type="text/css" />
<script src="js/date.js" type="text/javascript"></script>
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
    var tempStr = "共"+num1+"条记录 分"+totalPage+"页 当前第"+currentPage+"页";
    if(currentPage>1){
        tempStr += "<a href=\"#\" onClick=\"goPage("+(1)+","+psize+")\">首页</a>";
        tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage-1)+","+psize+")\"><上一页</a>"
    }else{
        tempStr += "首页";
        tempStr += "<上一页";    
    }

    if(currentPage<totalPage){
        tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage+1)+","+psize+")\">下一页></a>";
        tempStr += "<a href=\"#\" onClick=\"goPage("+(totalPage)+","+psize+")\">尾页</a>";
    }else{
        tempStr += "下一页>";
        tempStr += "尾页";    
    }

    document.getElementById("barcon").innerHTML = tempStr;
    
}</script>
<body style='background: transparent' onLoad="goPage(1,10);">
<%
	OrderDao orderDao = new OrderDaoImpl();
	List<OrderList> orderList = (List)session.getAttribute("list");
	if(orderList == null){
		orderList = new ArrayList(); 
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

							<div align="center" width="120">
								<form action="UsersOrderSearchServlet" name="form1" method="get">
									<table id="table1" class="line_table"
										style="width: 500px; margin: 0; padding: 0" cellSpacing="0"
										cellPadding="0">
										<tbody style="margin: 0; padding: 0">
											<tr>
												<td class="line_table" align="right" width="40%"><span
													class="left_bt2">按菜品名称查询</span></td>
												<td class="line_table" align="left" width="60%"><input
													type="text" name="menuname" size="20"> <input
													type="submit" name="name" value="查询菜名" ></td>
											<tr>
												<td class="line_table" align="right" width="40%"><span
													class="left_bt2">按销售日期查询</span></td>
												<td class="line_table" align="left" width="60%"><input
													type="text" name="date" size="20" readOnly
													onClick="setDay(this);">
													 <input type="submit" name="time" value="查询日期" ></td>
											</tr>
											<tr>
												<td class="line_table" align="center" colspan="3">
													<a href="UsersOrderSearchServlet?method=all">我的所有订单</a>&nbsp;&nbsp;&nbsp;&nbsp; 
													<a href="UsersOrderSearchServlet?method=no">未派送订单</a>&nbsp;&nbsp;&nbsp;&nbsp;
													<a href="UsersOrderSearchServlet?method=yes">已派送订单</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
											</tr>
									</table>
								</form>
							</div>
						</td>
					</tr>
					<tr>
						<td align="left" valign="top" height="20px"></td>
					</tr>
					<tr>
						<td align="left" valign="top">


							<div align="center" >
								<table id="table2" class="line_table"
									style="width: 900px; margin: 0; padding: 0" cellSpacing="0"
									cellPadding="0" >
									<tbody style="margin: 0; padding: 0" >
										<tr>
											<td class="line_table" align="center" colspan="9"  width="900px"><span
												class="left_bt2">订单查询结果信息列表</span></td>
										</tr>
										<tr>
											<td class="line_table" align="center" width="90px"><span
												class="left_bt2">菜品名称</span></td>
											<td class="line_table" align="center" width="90px"><span
												class="left_bt2">真实姓名</span></td>
											<td class="line_table" align="center" width="90px"><span
												class="left_bt2">订购电话</span></td>
											<td class="line_table" align="center" width="90px"><span
												class="left_bt2">派送地址</span></td>
											<td class="line_table" align="center" width="90px"><span
												class="left_bt2">订购数量</span></td>
											<td class="line_table" align="center" width="90px"><span
												class="left_bt2">单价(元)</span></td>
											<td class="line_table" align="center" width="90px"><span
												class="left_bt2">合计(元)</span></td>
											<td class="line_table" align="center" width="180px"><span
												class="left_bt2">订购时间</span></td>
											<td class="line_table" align="center" width="90px"><span
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
										<tr >
											<td class="line_table" align="center" width="90px"><span
												class="left_txt"><%	out.print(ol.getName()); %></span></td>
											<td class="line_table" align="center" width="90px"><span
												class="left_txt"><%	out.print(ol.getRealname()); %></span></td>
											<td class="line_table" align="center" width="90px"><span
												class="left_txt"><%	out.print(ol.getPhone()); %></span></td>
											<td class="line_table" align="center" width="90px"><span
												class="left_txt"><%	out.print(ol.getAddress()); %></span></td>
											<td class="line_table" align="center" width="90px"><span
												class="left_txt"><%	out.print(ol.getMenunum()); %></span></td>
											<td class="line_table" align="center" width="90px"><span
												class="left_txt"><%	out.print(ol.getPrice1()); %></span></td>
											<td class="line_table" align="center" width="90px"><span
												class="left_txt"><%	out.print(total); %></span></td>
											<td class="line_table" align="center" width="180px"><span
												class="left_txt"><%	out.print(ol.getTimes()); %></span></td>
											<td class="line_table" align="center" width="90px"><span
												class="left_txt"><%	out.print(ol.getDelivery()); %></span></td>
										</tr>
								<% 
									}
								%>
								
<!--  
								<tr>
									<td colspan="5">
									<input type="button" value="首页" onclick="first()"/>
									<input type="button" value="上一页" onclick="back()"/>
									<input type="button" value="下一页" onclick="next()"/>
									<input type="button" value="尾页" onclick="last()"/>
									<input type="hidden" value="0" id="pageId"/>
									第<span id="pageSpan">1</span>页|共<span id="simSpan"></span>	页	
									
									</td>
								</tr>	-->						
								</table>
								<table width="60%" align="right">
        <tr><td><div id="barcon" name="barcon"></div></td></tr>
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
<!--  <script type="text/javascript">
var jl = ;
var pageSize = 5;
var pages = 0;
if (jl%5==0){
	pages = jl/5;
}else{
	pages = Math.floor(jl/5+1);
}
document.getElementById("sumSpan").innerHTML = pages;
for(var i =0; i<5; i++){
	if(i<jl){
		document.getElementById("tr_"+(i+1)).style.display="";
	}
}
function first(){
	showPage(0);
}
function back(){
	var page = document.getElementById("pageId");
	var currentPage = parseInt(page)-1;
	if(page==0){
		alert("已经是第一页了！");
	}
	else{
		showPage(currentPage);
	}
}
function next(){
	var page = doucment.getElementById("pageId").value;
	var currentPage = parseInt(page)+1;
	if(page==parseInt(pages)-1){
		alert("已经是最后一页了！");
	}
	else{
		showPage(currentPage);
	}
}
function last(){
	showPage(parseInt(page)-1);
}
function hide(){
	for(var i =0; i<jl; i++){
		document.getElementById("tr_"+(i+1)).style.display="none";
	}
}
function showPage(currentPage){
	hide();
	var start = currentPage * pageSize;
	var end = (currentPage+1) * pageSize;
	for(var i = start; i< end; i++){
		if(i<jl){
			document.getElementById("tr_"+(i+1)).style.display="";
		}
	}
	document.getElementById("pageId").value = currentPage;
	document.getElementById("pageSpan").innerHTML = currentPage +1;
}
</script>
-->
</html>
