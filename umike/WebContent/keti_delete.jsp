<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="entity.ketixinxi" %>
<%@ page import="services.ketixinxi.KetixinxiServices" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">

</script>

</head>


<body>
    <form action="KetishanServlet" method="post"> >
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">课题管理</a></li>
    <li><a href="#">课题查询</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
     
   
        <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="images/t01.png" /></span>添加</li>
        <li class="click"><span><img src="images/t03.png" /></span>删除</li>
        </ul>
        
        
    
    </div>
     <div class="formtext">已有课题信息列表：</div>
    <ul class="seachform">
    
    <li><label>&nbsp;&nbsp;搜索：</label></li>
    <li><label>课题编号：</label>  
    <input name="" type="text" class="scinput" />
    </li>
    
    <li><label>课题名称：</label>  
    <input name="" type="text" class="scinput" />
    </li>

    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="查找"/></li>
    
    </ul>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>序号</th>
        <th>课题编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>课题名称</th>
        <th>课题类型</th>
        <th>发布教师</th>
        <th>附件</th>
        <th>课题名额</th>
        <th>发布时间</th>
        <th>备注</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <% String teacherId = (String) request.getSession().getAttribute("id");
        String bianhao = request.getParameter("bianhao");
        request.getSession().setAttribute("bianhao", bianhao);
        KetixinxiServices ketixinxiServices = new KetixinxiServices();
		List<ketixinxi> keti = new ArrayList<ketixinxi>();
		keti = ketixinxiServices.getKetixinxi(teacherId);
		for(int i=0;i<keti.size();i++){
		%>
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>1</td>
        <td><%=keti.get(i).getKetibianhao() %></td>
        <td><%=keti.get(i).getKetimingcheng() %></td>
        <td><%=keti.get(i).getLeixing() %></td>
        <td><%=keti.get(i).getTeacID() %></td>
        <td><a href="#" class="tablelink">下载</a></td>
        <td><%=keti.get(i).getKetishuliang() %></td>
        <td><%=keti.get(i).getFabushijian() %></td>
        <td><%=keti.get(i).getBeizhu() %></td>
        <td><a href="keti_gaite.jsp?bianhao=<%=keti.get(i).getKetibianhao() %>" class="tablelink">修改</a>     <a href="#" class="click" onclick="Studelete(<%=keti.get(i).getKetibianhao() %>);"> 删除</a></td>
        </tr>
        <% } %>   
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
    
   
    

    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
    </form>
</body>

</html>
