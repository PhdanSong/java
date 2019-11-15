<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="services.tongzhi.TongzhiServices"%>
<%@ page  import="entity.student"%>    
<%@ page  import="entity.tongzhi"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>

<%
response.setContentType("text/html;charset=UTF-8");
String bianhao = request.getParameter("bianhao"); 
int realbianhao=Integer.parseInt(bianhao);
tongzhi ton=new tongzhi();
TongzhiServices tonServices=new TongzhiServices();
ton=tonServices.StuselectById(realbianhao);
System.out.println("tongzhi_yulan"+ton);
%>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">通知查看</a></li>
    <li><a href="#">通知查看</a></li>
    </ul>
    </div>
    
    <div class="formtext">已有通知内容：</div>
    <div style="font:25px bolder '微软雅黑'; text-align:center;">   
       	<%=ton.getTongzhibiaoti() %>
	    <div style="font:20px bolder '宋体';text-align:left;margin:30px">
	       &nbsp;&nbsp;&nbsp;&nbsp;<%=ton.getTongzhineirong() %>
	    </div>
	    <div style="position:absolute;right:70px;top:400px;font:20px bolder '宋体'">
	    	发布人 ：    <%=ton.getTeacher_ID() %>
	    </div>  
	    <div style="position:absolute;right:70px;top:450px;font:20px bolder '宋体'">
	    	发布时间：  <%=ton.getFabushijian() %>  
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
