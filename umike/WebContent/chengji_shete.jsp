<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.ketixinxi" %>
<%@ page import="entity.lunwenxinxi" %>
<%@ page import="entity.chengji" %>
<%@ page import="entity.ketilunwen" %>
<%@ page import="services.chengji.ChengjiServices" %>
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
    <li><a href="#">成绩管理</a></li>
     <li><a href="#">成绩管理</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    
    
  	<div id="tab1" class="tabson">
    
    <div class="formtext">设置学生成绩：</div>
    <form action="ChengjigaiServlet" method="post">
      <%String teacherId = (String) request.getSession().getAttribute("id");
		ChengjiServices chengjiServices =new ChengjiServices();
		String chengji_ID=request.getParameter("chengjiID");
		request.getSession().setAttribute("chengjiId",chengji_ID); 
		ketilunwen cheng = chengjiServices.selectChengjiById(teacherId,chengji_ID); %>
    <ul class="forminfo">
    <li><label>课题编号<b>*</b></label><input name="ketibianhao" type="text" class="dfinput" value="<%=cheng.getKe().getKetibianhao() %>" readonly="readonly" style="width:300px;"/><b>&nbsp;&nbsp;此项不修改</b></li>
   
    <li><label>课题名称<b>*</b></label><input name="ketimingcheng" type="text" class="dfinput" value="<%=cheng.getKe().getKetimingcheng() %>"  readonly="readonly" style="width:300px;"/><b>&nbsp;&nbsp;此项不修改</b></li>
    
    <li><label>课题类型<b>*</b></label>
    <%--  <%String m=String.valueOf(cheng.getKe().getLeixing()); %>
    <div class="vocation">
    <select class="select1" name="leixing" style="width:250px;">
    <option value="软件" <%="软件".equals(m)?"selected":"" %>>软件</option>
    <option value="计算机" <%="计算机".equals(m)?"selected":"" %>>计算机</option>
    </select>
    </div>   --%>
    
    <input name="leixing" type="text" class="dfinput" value="<%=cheng.getKe().getLeixing() %>" readonly="readonly" style="width:300px;"/><b>&nbsp;&nbsp;此项不修改</b></li>
    <li><label>选题人<b>*</b></label><input name="student_ID" type="text" class="dfinput" value="<%=cheng.getLun().getStudent_ID() %>" readonly="readonly" style="width:300px;"/><b>&nbsp;&nbsp;此项不修改</b></li>
     <li><label>论文名称<b>*</b></label>
    <input name="lunwenmingcheng" type="text" class="dfinput" value="<%=cheng.getLun().getLunwenmingcheng() %>" readonly="readonly" style="width:300px;"/><b>&nbsp;&nbsp;此项不修改</b></li>
    <li><label>论文成绩<b>*</b></label><input name="fenshu" type="text" class="dfinput" value="<%=cheng.getChe().getFenshu() %>"  style="width:300px;"/></li>
    <li><label>教师评语<b>*</b></label>
    <textarea id="content7" name="pingyu" style="width:700px;height:200px;visibility:hidden;"><%=cheng.getChe().getPingyu() %></textarea>
    
    </li>
    <li><label>备注<b>*</b></label>
    <input name="beizhu" type="text" class="dfinput" value="<%=cheng.getChe().getBeizhu() %>"  style="width:300px;"/>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="提交"/>
        <label>&nbsp;</label><input name="" type="button" class="btn" value="重置"/></li>
    </ul>
    </form>
    </div> 
  
       
	</div> 
 
	
    
    
    
    
    
    </div>


</body>

</html>
