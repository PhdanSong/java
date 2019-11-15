<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="entity.student"%>
<%@ page  import="services.student.StudentServices"%>
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
StudentServices stuservice=new StudentServices(); 
student student=stuservice.selectAll(student_ID);
request.getSession().setAttribute("student",student);
student stu=(student)request.getSession().getAttribute("student");
%>
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
  
  	<form action="StudentServlet" method="post">
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>学号</th>
        <th>姓名<i class="sort"><img src="images/px.gif" /></i></th>
        <th>性别</th>
        <th>电话</th>
        <th>籍贯</th>
        <th>学院</th>
        <th>专业</th>
        <th>班级</th>
        <th>备注</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
        <td><%=stu.getXuehao()%></td>
        <td><%=stu.getXingming()%></td>
        <td><%=stu.getXingbie()%></td>
        <td><%=stu.getDianhua()%></td>
        <td><%=stu.getJiguan()%></td>
        <td><%=stu.getXueyuan()%></td>
        <td><%=stu.getZhuanye()%></td>
        <td><%=stu.getBanji()%></td>
        <td><%=stu.getBeizhu()%></td>
        <td><a href="tab_st.jsp" class="tablelink">修改</a></td>
        </tr> 
        
        </tbody>
    </table>
    </form>
    
   
    <!-- <div class="pagin">
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
    </div> -->
    
    
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
