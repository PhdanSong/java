<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="services.tongzhi.TongzhiServices"%>
<%@ page  import="entity.student"%>    
<%@ page  import="entity.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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


<body>

	<%String student_ID=(String)request.getSession().getAttribute("id");
	TongzhiServices tonservice=new TongzhiServices();
	List<ketilunwen> keti=new ArrayList<ketilunwen>();
    keti=(List<ketilunwen>)tonservice.StuselectAll(student_ID);
    int countRow =tonservice.countTongzhiDao(student_ID);
    int pageCount=0;
    System.out.println("学号是"+student_ID+"条数是"+countRow);
    if (countRow % 8 > 0)
		pageCount = countRow / 8 + 1;
	else
		pageCount = countRow / 8;
    System.out.println("tongzhi_selectst"+keti);
	request.getSession().setAttribute("keti",keti);
	List<ketilunwen> ketilunwen=(List<ketilunwen>)request.getSession().getAttribute("keti");
	List<tongzhi> ton=(List<tongzhi>)request.getSession().getAttribute("list");
	System.out.println("ton"+ton);
	%>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">通知查看</a></li>
    <li><a href="#">通知查看</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    <div class="formtext">已有通知信息列表：</div>
    <table class="tablelist">   
    	<thead>
    	<tr>
    	<th>通知编号</th>
        <th>通知标题</th>
        <th>发布教师</th>
        <th>通知内容</th>
        <th>发布时间</th>
        <th>提醒时间</th>
        <th>备注</th>
        </tr>
        </thead>
        <tbody>        
        <%-- <% if(ketilunwen.size()!=0){
        for(int i = 0 ; i< ketilunwen.size();i++){   %>
	        <tr>
	        <td><%=ketilunwen.get(i).getTon().getTongzhi_ID()%></td>
	        <td><%=ketilunwen.get(i).getTon().getTongzhibiaoti()%></td>
	        <td><%=ketilunwen.get(i).getTon().getTeacher_ID()%></td>
	        <td><a href="tongzhi_yulanst.jsp?bianhao=<%=ketilunwen.get(i).getTon().getTongzhi_ID()%>" class="tablelink">预览</a></td>
	        <td><%=ketilunwen.get(i).getTon().getFabushijian()%></td>
	        <td><%=ketilunwen.get(i).getTon().getTixingshijian()%></td>
	        <td><%=ketilunwen.get(i).getTon().getBeizhu()%></td>
        </tr>
       <%  }
       }%>
       <% if(ketilunwen.size()==0){%>
	        <tr>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
        </tr>
       <%  
       }%> --%>
       	<tr>
    <c:if test="${not empty List}">
    <c:forEach items="${List}" var="ton" >
		<td>${ton.tongzhi_ID}</td>
		<td>${ton.tongzhibiaoti}</td>
		<td>${ton.teacher_ID}</td>
		<td><a href="tongzhi_yulanst.jsp?bianhao=${ton.tongzhi_ID}" class="tablelink">预览</a></td>
		<td>${ton.fabushijian}</td>
		<td>${ton.tixingshijian}</td>
		<td>${ton.beizhu}</td>
	</c:forEach>
	</c:if>
	<c:if test="${empty List}">
		<td>0</td>
		<td>0</td>
		<td>0</td>
		<td>0</td>
		<td>0</td>
		<td>0</td>
		<td>0</td>
	</c:if>
	</tr>
        </tbody>
    </table>
    
   
    <div class="pagin">
    	<div class="message">共<i class="blue"><%=countRow %></i>条记录，当前显示第&nbsp;<i class="blue"><%=pageCount %>&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="Tongzhifenye?pageNo=1">1</a></li>
        <li class="paginItem"><a href="Tongzhifenye?pageNo=2">2</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
