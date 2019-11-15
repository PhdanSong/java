<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.teacher" %>
<%@ page import="services.teacher.TeacherServices" %>
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
   <% String teacherId = (String) request.getSession().getAttribute("id");
		TeacherServices teacherServices = new TeacherServices();
		teacher teacher = teacherServices.selectAll(teacherId);
		request.getSession().setAttribute("teacher",teacher); 
		teacher tea = (teacher)request.getSession().getAttribute("teacher");%>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">个人信息管理</a></li>
    <li><a href="#">个人信息管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
     
    <div class="formtext">
    <ul class="placeul">
    <li><a href="#">欢迎进入</a></li>
    <li><a href="#">毕业设计选题管理系统</a></li>
    </ul></div>
   <!--  <form action="TeacherxinxiServlet" method="post"> -->
    
    <table class="tablelist">
    	<thead>
    	<tr>
        
        <th>工号</th>
        <th>姓名<i class="sort"><img src="images/px.gif" /></i></th>
        <th>性别</th>
        <th>电话</th>
        <th>主教课程</th>
        <th>备注</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
        <%-- <%=request.getSession().getAttribute("teacher")%> --%>
        <td><%=tea.getTeacher_ID()%></td>
        <td><%=tea.getXingming()%></td>
        <td><%=tea.getXingbie() %></td>
        <td><%=tea.getDianhua() %></td>
        <td><%=tea.getZhujiaokecheng() %></td>
        <td><%=tea.getBeizhu() %></td>
        <td><a href="tab_te.jsp" class="tablelink">修改</a></td>
        
        </tr> 
        
        
        
        </tbody>
    </table>
    <!-- </form> -->
    
   
    <div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
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
