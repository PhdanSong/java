<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entity.teacher" %>
<%@ page import="services.teacher.TeacherServices" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
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
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    
    
  	<div id="tab1" class="tabson">
    
    <div class="formtext">修改教师信息：</div>
    <form action="TeacherxinxiServlet" method="post">
    <ul class="forminfo">
    <li><label>工号<b>*</b></label><input name="gonghao" type="text" class="dfinput" value="<%=tea.getTeacher_ID()%>"  style="width:300px;"/><!-- <b>&nbsp;&nbsp;此项不得修改</b> --></li>
   
    <li><label>姓名<b>*</b></label><input name="xingming" type="text" class="dfinput" value="<%=tea.getXingming()%>"  style="width:300px;"/></li>
    
    <li><label>性别<b>*</b></label>
    <%String m=String.valueOf(tea.getXingbie()); %>
    <div class="vocation">
    <select class="select1" name="xingbie" style="width:250px;">
    <option value="男" <%="男".equals(m)?"selected":"" %>>男</option>
    <option value="女" <%="女".equals(m)?"selected":"" %>>女</option>
    </select>
    </div>  
    
    
   <%--  <div class="vocation">
    <% if(tea.getXingbie().equals("男")) {%>
    <select class="select1" name="xingbie" style="width:250px;">
    <option selected="selected">男</option>
    <option>女</option>
    </select>
    <%}else{%>
    <select class="select1" name="xingbie" style="width:250px;">
    <option>男</option>
    <option selected="selected">女</option>
    </select>
    <%} %>
    </div>    --%>
    
    </li>
    <li><label>电话<b>*</b></label><input name="dianhua" type="text" class="dfinput" value="<%=tea.getDianhua() %>"  style="width:300px;"/></li>
    <li><label>主教课程<b>*</b></label><input name="zhujiaokecheng" type="text" class="dfinput" value="<%=tea.getZhujiaokecheng() %>"  style="width:300px;"/></li>
    <li><label>备注<b>*</b></label>
    <textarea id="content7" name="beizhu" style="width:700px;height:200px;visibility:hidden;"><%=tea.getBeizhu() %></textarea>
    
    </li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="提交"/>
        <label>&nbsp;</label><input name="" type="reset" class="btn" value="重置"/></li>
    </ul>
    </form>
    </div> 
  
       
	</div> 

    </div>


</body>

</html>
