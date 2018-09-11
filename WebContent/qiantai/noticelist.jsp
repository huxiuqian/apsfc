<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="UTF-8"%>
<%@page import="com.hpe.aposfc.dao.NoticeDao,com.hpe.aposfc.dao.impl.NoticeDaoImpl,
				com.hpe.aposfc.po.Notice"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>配送说明</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="css/common.css" rel="stylesheet" type="text/css" />

</head>


<script type="text/javascript" src="js/common.js"></script>

 
<body >
<%
        NoticeDao noticeDao = new NoticeDaoImpl();
        List<Notice> notice = noticeDao.selectNotice();
        
        
	%>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top">
  
    
  <jsp:include flush="fasle" page="top.jsp"/>
    
    </td>
  </tr>
  <tr >
  <td height="50"></td>
  
</tr>
  
  <tr>
    <td align="center" valign="top" height="250">
    
    <table border="0" cellspacing="0"  width="100%">
    
		<tr>
		  <td  align="center" vlign="top"  >
			 <strong><span style="font-family: Helvetica, sans-serif;font-size: 20px;">
			       餐厅公告
			 </span></strong>
			 <br>
		  </td>
		</tr>
		<tr>
		  <td  align="left" vlign="top" >
           <div style="margin: 0px 3px; padding: 10px;" align="left">
				<link href="css/newslist_time2.css" rel="stylesheet" type="text/css" />
					<ul class="newslist_time2">
															
					<% for( int i = notice.size()-1; i >= 0; i--){%>
						<li class="newslist_time2"><div class="time"><% out.print(notice.get(i).getTimes()); %></div>
							<a href="notice.jsp?h=<%= i%>" class="newslist_time2"><% out.print(notice.get(i).getName()); %></a>
						</li>
					<% } %>
															
					</ul>
			</div>
		  </td>
		</tr>
		<tr>
		  <td  align="center"  >
		  
			 <a href="index.jsp" target="_self">
			 <span style="font-family: Helvetica, sans-serif;font-size: 16px;">
			     返回
			 </span></a>
		  </td>
		</tr>	
   </table>
     </td>
  </tr>
  <tr>
    <td height="10">&nbsp;</td>
  </tr>
  <tr>
    <td height="50" align="center" valign="middle">&nbsp; 
   
        <jsp:include flush="fasle" page="copyright.jsp"/>
    </td>
  </tr>
  
</table>


 
</body>
</html>
