<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="entity.ketixinxi" %>
<%@ page import="entity.lunwenxinxi" %>
<%@ page import="entity.ketilunwen" %>
<%@ page import="services.lunwenxinxi.LunwenxinxiServices" %>
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
    <li><a href="#">论文管理</a></li>
    <li><a href="#">论文管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
     
    <div class="formtext">已有论文信息列表：</div>
    
    <ul class="seachform">
    
    <li><label>&nbsp;&nbsp;搜索：</label></li>
    <li><label>论文名称：</label>  
    <input name="" type="text" class="scinput" />
    </li>
    
    <li><label>选题编号：</label>  
    <input name="" type="text" class="scinput" />
    </li>
    
    <li><label>提交人：</label>  
    <input name="" type="text" class="scinput" />
    </li>

    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="查找"/></li>
    
    </ul>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
       
        <th>序号</th>
        <th>课题编号</th>
        <th>课题名称</th>
        <th>课题类型</th>
        <th>发布教师</th>
        <th>论文名称<i class="sort"><img src="images/px.gif" /></i></th> 
        <th>选题人</th>       
        <th>附件</th>
        <th>提交时间</th>
        <th>备注</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
         <%String teacherId = (String) request.getSession().getAttribute("id");
		LunwenxinxiServices lunwenxinxiServices =new LunwenxinxiServices();
		List<ketilunwen> lunwen = new ArrayList<ketilunwen>();
		lunwen = lunwenxinxiServices.teacIDselectlunwenxinxi(teacherId);
		if(lunwen.size()==0){%>		
        
        <tr align="center">
             <td colspan="9" style="height:150px;">暂无论文数据</td>
       </tr>
       
    	<% }else{
		for(int i=0;i<lunwen.size();i++){
		%>
        <tr>
        
        <td><%=i +1%></td>
        <td><%=lunwen.get(i).getKe().getKetibianhao() %></td>
        <td><%=lunwen.get(i).getKe().getKetimingcheng() %></td>
        <td><%=lunwen.get(i).getKe().getLeixing() %></td>
        <td><%=lunwen.get(i).getLun().getTeacher_ID() %></td>
        <td><%=lunwen.get(i).getLun().getLunwenmingcheng() %></td>
        <td><%=lunwen.get(i).getLun().getStudent_ID() %></td>
        <td><a href="downLoadlunwenServlet?filename=<%=lunwen.get(i).getLun().getLunbaocunming() %>" class="tablelink">下载</a></td>        
        <td><%=lunwen.get(i).getLun().getTijiaoshijian() %></td>
        <td><%=lunwen.get(i).getLun().getBeizhu() %></td>
        <td><a href="#" class="click">修改备注</a> </td>
        </tr> 
        <%}} %>
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
