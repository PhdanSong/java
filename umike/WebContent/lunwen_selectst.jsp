<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="services.lunwenxinxi.LunwenxinxiServices" %>
<%@ page  import="entity.*"%>
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
	LunwenxinxiServices lunservice=new LunwenxinxiServices();
	ketilunwen lun=new ketilunwen();
	lun=(ketilunwen)lunservice.IDselectlunwenxinxi(student_ID);
	request.getSession().setAttribute("lun",lun);
	lun=(ketilunwen)request.getSession().getAttribute("lun");
	%>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">论文管理</a></li>
    <li><a href="#">论文查看</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
     
    <div class="formtext">已有论文信息列表：</div>

    <table class="tablelist">
    	<thead>
    	<tr>
        <th>序号</th>
        <th>课题编号</th>
        <th>课题名称</th>
        <th>发布教师</th>
        <th>选题人</th>
        <th>论文名称<i class="sort"><img src="images/px.gif" /></i></th>
        <th>论文内容</th>
        <th>提交时间</th>
        <th>备注</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
        <td>1</td>
       <%if(lun.getKe()==null){ %>
        <td>0</td>
        <td>0</td>
        <td>0</td>
        <td>0</td>
        <td>0</td>
        <td><a href="#" class="tablelink">下载</a></td>
        <td>0</td>
        <td>0</td>      
        
     <%} %>
        
      	 <%if(lun.getKe()!=null){ %>
        <td><%=lun.getKe().getKetibianhao() %></td>
        <td><%=lun.getLun().getKetimingcheng() %></td>
        <td><%=lun.getLun().getTeacher_ID() %></td>
        <td><%=lun.getLun().getStudent_ID() %></td>
        <td><%=lun.getLun().getLunwenmingcheng() %></td>
        <td><a href="downLoadlunwenServlet?filename=<%=lun.getLun().getLunbaocunming() %>" class="tablelink">下载</a></td>
        <td><%=lun.getLun().getTijiaoshijian() %></td>
        <td><%=lun.getLun().getBeizhu() %></td>
        <%} %>
        <td><a href="lunwen_gaist.jsp" class="tablelink"> 修改</a>     <a href="#" class="click"> 删除</a></td>
        
        
        </tr> 
    
        </tbody>
    </table>
    
   
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
        <form action="StudentDeletelunwenServlet" method="post">
        <input name="" type="submit"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </form>
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
