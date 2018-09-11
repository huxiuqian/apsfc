
<%@page import="com.hpe.aposfc.po.Type"%>
<%@page import="com.hpe.aposfc.dao.TypeDao"%>
<%@page import="com.hpe.aposfc.dao.impl.TypeDaoImpl"%>
<%@page language="java" pageEncoding="utf-8"%>
<%@page import="com.hpe.aposfc.dao.MenuDao,com.hpe.aposfc.dao.impl.MenuDaoImpl,
				com.hpe.aposfc.po.Menu,java.util.*"%>
<%@page import="com.hpe.aposfc.dao.NoticeDao,com.hpe.aposfc.dao.impl.NoticeDaoImpl,
				com.hpe.aposfc.po.Notice"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>阿婆私房菜</title>
<meta content="" name=keywords />
<meta content="" name=description />
<!-- <link href="css/common.css" rel="stylesheet" type="text/css" /> -->
<script type="text/javascript" src="../jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/form.js"></script>
<script type="text/javascript" src="js/blockui.js"></script>

</head>



<body style='background: transparent' >
	<%
		MenuDao menuDao = new MenuDaoImpl();
		List<Menu> menu = menuDao.selectMenu();
        NoticeDao noticeDao = new NoticeDaoImpl();
        List<Notice> notice = noticeDao.selectNotice();
        TypeDao typeDao = new TypeDaoImpl();
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
			<td height="30"></td>

		</tr>

		<tr>
			<td align="left" valign="top"><table width="100%" border="0"
					cellspacing="0" cellpadding="0">
					<tr>
						<td width="59%" align="left" valign="top">
						<div id='pdv_3606'
								class='pdv_class' title=''
								style='width: 648px; top: 0px; left: 0px; z-index: 12'>
								<div id='spdv_3606' class='pdv_content'
									style='overflow: visible; width: 100%;'>
									<div class="pdv_border"
										style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
										<!-- <div style="height:25px;margin:1px;display:none;background:;">
                <div style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:"></div>
                <div style="float:right;margin-right:10px;display:none"> <a href="-1" style="line-height:25px;color:">更多</a> </div>
              </div>-->
             
               							<div style="padding: 0px">
											<link href="css/dingcanall.css" rel="stylesheet"
												type="text/css" />
											<script src="js/dingcanall.js" type="text/javascript"></script>

											<div id="dingcanall2">

												<div style="margin-top: 0px; padding: px;">

													<div id="mm_01" class="dingcanall_connow">
														<table>
<!-- 需要优化，菜品类型为名字 -->															
														<% 	
															for(Menu m: menu){
																if(m.getId()%2==1){
														%>
															<tr>
															<% }%>
																<td style="margin-top: 10px;">
																	<div>
																		<table>
																			<tr>
																				<td rowspan="5" class="bookPic"><img
																					src="<%	out.print(m.getImgpath()); %>" width="160px" height="140px"  
																					style="border: 1px solid #300;" /></td>
																				<td><span>菜名:</span></td>
																				<td><span><strong><%	out.print(m.getName()); %></strong></span></td>
																			</tr>
																			<tr>
																				<td><span>市场价格:</span></td>
																				<td><span><%	out.print(m.getPrice()); %></span></td>
																			</tr>
																			<tr>
																				<td><span>会员价格:</span></td>
																				<td><span><strong style="color: red;"><%	out.print(m.getPrice1()); %></strong></span></td>
																			</tr>
																			<tr>
																				<td><span>配料:</span></td>
																				<td><span><%	out.print(m.getBurden()); %></span></td>
																			</tr>
																			<tr>
																				<td><span>菜品类型:</span></td>
																				<td><span><%	    Type type = typeDao.selectTypeById(m.getTypeid());
																									out.print(type.getName()); %></span></td>
																			</tr>
																			<tr>
																				<td colspan="2" style="height: 40px;"><a
																					href="ShoppingServlet?id=<%=m.getId()%>">加入餐车</a></td>
																				<td></td>
																			</tr>
																		</table>
																	</div>
																</td>
															<% 
																}
															%>																
															</tr>														
														</table>
													</div>
												</div>
											</div>
										</div>

										<div id="dingcanall_bottom_left">&nbsp;</div>
										<div id="dingcanall_bottom_right">&nbsp;</div>
										<input type="hidden" name="picw" id="picw" value="150" /> 
										<input type="hidden" name="pich" id="pich" value="140" /> 
										<input type="hidden" name="fittype" id="fittype" value="auto" />
									</div>
								</div>
							</div>
						</td>
						<td width="41%" align="right" valign="top"><table width="243"
								border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td></td>
								</tr>
								<tr>
									<td valign="top"><div id='pdv_' class='pdv_class'
											title='网站公告'
											style='width: 243px; top: 0px; left: 0px; z-index: 3'>
											<div id='spdv_3603' class='pdv_content'
												style='overflow: hidden; width: 100%; height: 100%'>
												<div class="pdv_border"
													style="border: 0px; height: 100%; padding: 0; margin: 0; background: url(base/border/640/images/left.jpg) repeat-y">
													<div
														style="height: 100%; background: url(images/right.jpg) right repeat-y">
														<div
															style="height: 43px; background: url(images/bg.jpg) 0px 0px no-repeat">
															<div
																style="float: left; font: bold 16px/43px 'Microsoft YaHei', 'SimSun', Arial, Sans-Serif; text-align: left; padding-left: 50px; color: #feab43;">
																餐厅公告</div>
															<div
																style="float: right; width: 60px; height: 43px; text-align: right; background: url(images/bg.jpg) -840px 0px no-repeat">
																<a href="noticelist.jsp"
																	style="font: 12px/43px simsun; color: #505050; margin-right: 12px; display: inline">更多&gt;&gt;</a>
															</div>
														</div>
														<div style="margin: 0px 3px; padding: 10px;" align="left">
															<link href="css/newslist_time2.css" rel="stylesheet" type="text/css" />
															<ul class="newslist_time2">
															
												<% for( int i = notice.size()-1; i > notice.size()-3; i--){%>
															<li class="newslist_time2"><div class="time"><% out.print(notice.get(i).getTimes()); %></div>
																	<a href="notice.jsp?h=<%= i%>" class="newslist_time2"><% out.print(notice.get(i).getName()); %></a>
															</li>
												<% } %>
															
															</ul>
														</div>
													</div>
												</div>
												<div
													style="margin-top: -10px; height: 10px; line-height: 10px; background: url(images/bg.jpg) 0px -220px no-repeat">&nbsp;</div>
												<div
													style="float: right; margin-top: -10px; width: 10px; height: 10px; line-height: 10px; background: url(images/bg.jpg) -890px -220px no-repeat">&nbsp;</div>
											</div>
										</div></td>
								</tr>
								<tr>
									<td height="10">&nbsp;</td>
								</tr>
								<tr>
									<td valign="top">
										<div id='pdv_3614' class='pdv_class' title='我的餐车'
											style='width: 243px; top: 0px; left: 0px; z-index: 2'>
											<div id='spdv_3614' class='pdv_content'
												style='overflow: visible; width: 100%;'>
												<div class="pdv_border"
													style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
													<div
														style="height: 25px; margin: 1px; display: none; background:;">
														<div
															style="float: left; margin-left: 12px; line-height: 25px; font-weight: bold; color:">
															我的餐车</div>
														<div
															style="float: right; margin-right: 10px; display: none">
															<a href="-1" style="line-height: 25px; color:">更多</a>
														</div>
													</div>
													<div style="padding: 0px">
														<link href="css/dingcanche.css" rel="stylesheet"
															type="text/css" />
														<script src="js/dingcanall.js" type="text/javascript"></script>
														<script src="js/dingcansubmit.js" type="text/javascript"></script>
														<div id="dingcanche">
															<div id="dingcanche2">
																<div id="dingcanche_top">
																	<div id="dingcanche_top_left">我的餐车</div>
																	<div id="dingcanche_top_right">&nbsp;</div>
																</div>


																<div id="dcinfo" style="margin: 0px 3px 1px 3px;"></div>
																<table width="100%" border="0" cellspacing="0"
																	style="background: #fef0d3;">
																	<tr>
																		<td align="center">菜单名称</td>
																		<td align="center">单价</td>
																		<td align="center">数量</td>
																		<td align="center"></td>
																	</tr>
 									<%
									    int money = 0;
									    int num = 0;
									    for (Map.Entry<String, Menu> entry : map.entrySet()) { 
									   
									%>
																	<tr>
																		<td align="center"><% out.print(entry.getValue().getName()); %></td>
																		<td align="center"><% out.print(entry.getValue().getPrice1()); %></td>
																		<td align="center"><% out.print(entry.getValue().getNumber()); %></td>
																		<td align="center"><a
																			href="ShoppingDelServlet?deleteid=<%=entry.getKey()%>">取消</a></td>
																	</tr>
									<%
											int p = Integer.parseInt(entry.getValue().getPrice1());
											int n = entry.getValue().getNumber();
											money = money + p * n;
											num = num + n;
										 }
									%>
																	
																</table>

																<div style="height: 24px; margin: 5px 3px 1px 3px;">
																	<div
																		style="float: left; line-height: 24px; padding-left: 25px;">小&nbsp;&nbsp;计：</div>
																	<div
																		style="float: right; line-height: 24px; padding-right: 15px;">
																		<font id="allnums" style="color: #ff0000;"><%=num%></font>份
																	</div>
																	<div
																		style="float: right; line-height: 24px; padding-right: 30px;">
																		<font id="cpprice" style="color: #ff0000;"><%=money%></font>元
																	</div>
																</div>
																<div style="height: 30px; margin: 5px 3px 1px 3px;">
																	<table width="100%" border="0" cellspacing="0">
																		<tr>
																			<td align="center" width="40%"></td>
																			<td align="center" width="40%"><a
																				href="UserOrderingServlet"><img
																					src="images/canche_submit.gif" border="0" /></a></td>
																			<td align="center" width="40%"><a
																				href="ShoppingClearServlet"><img
																					src="images/quxiao2.gif" border="0" /></a></td>
																		</tr>
																	</table>

																</div>
															</div>
														</div>
													</div>
													<div id="dingcanche_bottom_left">&nbsp;</div>
													<div id="dingcanche_bottom_right">&nbsp;</div>
													<input type="hidden" name="modnums_b" id="modnums_b"
														value="" />
													<script>
														$("div.cpline_d:even")
																.addClass(
																		"cpline_s");
													</script>
												</div>
											</div>
										</div>
										</div>

									</td>
								</tr>
								<tr>
									<td height="10">&nbsp;</td>
								</tr>
								<tr>
									<td valign="top">
									<div id='pdv_3613' class='pdv_class' title='本周菜单'
											style='width: 243px; top: 0px; left: 0px; z-index: 5'>
											<div id='spdv_3613' class='pdv_content'
												style='overflow: hidden; width: 100%; height: 100%'>
												<div class="pdv_border"
													style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
													<div
														style="height: 25px; margin: 1px; display: none; background:;">
														<div
															style="float: left; margin-left: 12px; line-height: 25px; font-weight: bold; color:">
															本周菜单</div>
														<div
															style="float: right; margin-right: 10px; display: none">
															<a href="-1" style="line-height: 25px; color:">更多</a>
														</div>
													</div>
													<div style="padding: 0px">
														<link href="css/dingcanweekmenu.css" rel="stylesheet"
															type="text/css" />
														<div id="dingcanweekmenu">
															<div id="dingcanweekmenu2">
																<div id="dingcanweekmenu_top">
																	<div id="dingcanweekmenu_top_left">销售排行榜</div>
																	<div id="dingcanweekmenu_top_right">&nbsp;</div>
																</div>
																<div style="padding: px;">
																	<div class="dingcanweekmenuinfo" align="left">
																		<link href="css/newslist_time2.css" rel="stylesheet"
																			type="text/css" />
														<% 	
                                                        Menu m1 = new Menu();
														m1.setSums1("0");
														Menu m2 = new Menu();
														m2.setSums1("0");
														Menu m3 = new Menu();
														m3.setSums1("0");
														for(int j = 0; j<menu.size() ; j++){
                                                             if(Integer.parseInt(menu.get(j).getSums1())>Integer.parseInt(m1.getSums1())){
                                                            	 m1 = menu.get(j);
                                                             }else if(Integer.parseInt(menu.get(j).getSums1())>Integer.parseInt(m2.getSums1())){
                                                            	 m2 = menu.get(j);
                                                             }else if(Integer.parseInt(menu.get(j).getSums1())>Integer.parseInt(m3.getSums1())){
                                                            	 m3 = menu.get(j);
                                                             }
														}
														%>
																		<li class="newslist_time2"><div class="time">共销售<%	out.print(m1.getSums1()); %>次</div>
																			<a href="#" class="newslist_time2"><%	out.print(m1.getName()); %></a></li>
																			<li class="newslist_time2"><div class="time">共销售<%	out.print(m2.getSums1()); %>次</div>
																			<a href="#" class="newslist_time2"><%	out.print(m2.getName()); %></a></li>
																			<li class="newslist_time2"><div class="time">共销售<%	out.print(m3.getSums1()); %>次</div>
																			<a href="#" class="newslist_time2"><%	out.print(m3.getName()); %></a></li>

																			</div>
																</div>
															</div>
														</div>
														<!--<div id="dingcanweekmenu_bottom_left"></div>
                    <div id="dingcanweekmenu_bottom_right">&nbsp;</div>-->
													</div>
												</div>
											</div>
										</div></td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td height="10">&nbsp;</td>
		</tr>
		<tr>
			<td height="50" align="center" valign="middle"><jsp:include
					flush="fasle" page="copyright.jsp" /></td>
		</tr>

	</table>



</body>
</html>
