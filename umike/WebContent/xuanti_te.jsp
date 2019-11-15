<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="entity.ketixinxi" %>
<%@ page import="entity.xuantixinxi" %>
<%@ page import="entity.ketilunwen" %>
<%@ page import="services.xuantixinxi.XuantixinxiServices" %>
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

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">选题管理</a></li>
    <li><a href="#">选题管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
     
    <div class="formtext">我的学生选题列表：</div>
    
    <ul class="seachform">
    
    <li><label>&nbsp;&nbsp;搜索：</label></li>
    <li><label>选题编号：</label>  
    <input name="" type="text" class="scinput" />
    </li>
    
    <li><label>选题名称：</label>  
    <input name="" type="text" class="scinput" />
    </li>
    
    <li><label>选题人：</label>  
    <input name="" type="text" class="scinput" />
    </li>

    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="查找"/></li>
    
    </ul>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        
        <th>序号</th>
        <th>课题编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>课题名称</th>
        <th>课题类型</th>
        <th>发布教师</th>
        <th>课题名额</th>
        <th>已选名额</th>
        <th>选题人</th>
        <th>发布时间</th>
        <th>选题时间</th>
        <th>备注</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%String teacherId = (String) request.getSession().getAttribute("id");
		XuantixinxiServices xuantixinxiServices =new XuantixinxiServices();
		List<ketilunwen> xuanti = new ArrayList<ketilunwen>();
		xuanti = xuantixinxiServices.teacIDselectxuantixinxi(teacherId);
		if(xuanti.size()==0){%>		
        
        <tr align="center">
             <td colspan="9" style="height:150px;">暂无选题数据</td>
       </tr>
       
	   <% }else{
		for(int i=0;i<xuanti.size();i++){
		%>
        <tr>
        
        <td><%=i +1%></td>
        <td><%=xuanti.get(i).getKe().getKetibianhao() %></td>
        <td><%=xuanti.get(i).getKe().getKetimingcheng() %></td>
        <td><%=xuanti.get(i).getKe().getLeixing() %></td>
        <td><%=xuanti.get(i).getXuan().getTeacher_ID() %></td>
        <td><%=xuanti.get(i).getKe().getKetishuliang() %></td>
        <td><%=xuanti.get(i).getYiyuan() %></td>
        <td><%=xuanti.get(i).getXuan().getStudent_ID() %></td>
        <td><%=xuanti.get(i).getKe().getFabushijian() %></td>
        <td><%=xuanti.get(i).getXuan().getXuantishijian() %></td>
        <td><%=xuanti.get(i).getXuan().getBeizhu() %></td>
        <td><a href="#" class="click">修改备注</a> </td>
        </tr> 
        <%}}%>
        </tbody>
    </table>
    
   
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
