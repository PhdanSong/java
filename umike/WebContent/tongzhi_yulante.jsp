<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.tongzhi" %>
<%@ page import="services.tongzhi.TongzhiServices" %>
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

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">通知管理</a></li>
     <li><a href="#">查看通知</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    
    
  	<div id="tab1" class="tabson">
    
    <div class="formtext">预览通知信息：</div>
    <% String teacherId = (String) request.getSession().getAttribute("id");
	   TongzhiServices tongzhiServices = new TongzhiServices();
	   String tongzhiID=request.getParameter("tongzhiID");
	   request.getSession().setAttribute("tongzhiID",tongzhiID);
	   tongzhi tong = tongzhiServices.teacIDselectTongzhi(teacherId,tongzhiID);
	   request.getSession().setAttribute("tong",tong); 
	   tongzhi tongz = (tongzhi)request.getSession().getAttribute("tong");%>
	   
   <%--  <ul class="forminfo">
    <li><label>通知标题<b>*</b></label><input name="tongzhibiaoti" type="text" class="dfinput" value="<%=tongz.getTongzhibiaoti() %>" readonly="readonly" style="width:300px;"/><b>&nbsp;&nbsp;此项不能为空</b></li>
    <li><label>发布时间<b>*</b></label>
    <input name="fabushijian" type="text" class="dfinput" value="<%=tongz.getFabushijian() %>" readonly="readonly" style="width:300px;"/>
    </li>
    <li><label>提醒时间<b>*</b></label><input name="tixingshijian" type="text" class="dfinput" value="<%=tongz.getTixingshijian() %>" readonly="readonly" style="width:300px;"/></li>
    <li><label>通知内容<b>*</b></label>
    <textarea id="content7" name="tongzhineirong" style="width:700px;height:200px;" disabled="disabled"><%=tongz.getTongzhineirong() %></textarea>
    
    </li>
    <li><label>备注<b>*</b></label><input name="beizhu" type="text" class="dfinput" value="<%=tongz.getBeizhu() %>"  readonly="readonly" style="width:300px;"/></li>
    <li><label>&nbsp;</label><a href="tongzhi_gaite.jsp?tongzhiID=<%=tongz.getTongzhi_ID() %>" ><input name="" type="submit" class="btn" value="修改"/></a>
        <label>&nbsp;</label><a href="tongzhi_select.jsp" ><input name="" type="button" class="btn" value="返回"/></a></li>
    </ul> --%>
     <div style="font:25px bolder '微软雅黑'; text-align:center;">   
       	<%=tongz.getTongzhibiaoti() %>
	    <div style="font:20px bolder '宋体';text-align:left;margin:30px">
	       &nbsp;&nbsp;&nbsp;&nbsp;<%=tongz.getTongzhineirong() %>
	    </div>
	    <div style="position:absolute;right:70px;top:350px;font:20px bolder '宋体'">
	    	发布人：     <%=tongz.getTeacher_ID() %>
	    </div>  
	    <div style="position:absolute;right:70px;top:400px;font:20px bolder '宋体'">
	    	发布时间：  <%=tongz.getFabushijian() %>
	    </div> 
	    <div style="position:absolute;right:70px;top:450px;font:20px bolder '宋体'">
	    <a href="tongzhi_select.jsp" ><input name="" type="button" class="btn" value="返回"/></a>
	    </div> 
    </div>   
    </div> 
  
       
	</div> 
 
	
    
    
    
    
    
    </div>


</body>

</html>
