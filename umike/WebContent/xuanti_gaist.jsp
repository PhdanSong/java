<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page  import="entity.ketilunwen"%>
<%@ page  import="services.xuantixinxi.XuantixinxiServices"%>
    
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
<%String student_ID=(String)request.getSession().getAttribute("id");
XuantixinxiServices xuanservice=new XuantixinxiServices();
ketilunwen keti=new ketilunwen();
keti=xuanservice.stuIDselectxuantixinxi(student_ID);
request.getSession().setAttribute("keti",keti);
keti=(ketilunwen)request.getSession().getAttribute("keti");
%>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">选题管理</a></li>
     <li><a href="#">已选查询</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    
    
  	<div id="tab1" class="tabson">
    
    <div class="formtext">修改学生选题：</div>
   
    <ul class="forminfo">
    <li><label>课题编号<b>*</b></label><input name="xuanti_gaist_ketibianhao" type="text" class="dfinput" value=<%=keti.getKe().getKetibianhao()%>   style="width:300px;"/></li>
   
    <li><label>课题名称<b>*</b></label><input name="xuanti_gaist_ketimingcheng" type="text" class="dfinput" value=<%=keti.getXuan().getKetimingcheng() %>  style="width:300px;"/></li>
    
    <li><label>类型<b>*</b></label>
    
    <%String leixing=String.valueOf(keti.getKe().getLeixing()); %>
    <div class="vocation">
    <select class="select1" style="width:250px;" name="xuanti_gaist_leixing"  value=<%=keti.getKe().getLeixing()%>>
    <option selected="selected"  value="系统" <%="系统".equals(leixing)?"selected":"" %>>系统</option>
    <option  value="论文" <%="论文".equals(leixing)?"selected":"" %>>论文</option>
    <option  value="动漫" <%="动漫".equals(leixing)?"selected":"" %>>动漫</option>
    </select>
    </div>    
    
    </li>
    <li><label>发布教师<b>*</b></label>
    <input name="xuanti_gaist_fabujiaoshi" type="text" class="dfinput" value=<%=keti.getKe().getTeacID() %>  style="width:300px;"/>
    </li>
    
     <li><label>选题人<b>*</b></label>
    <input name="xuanti_gaist_xuantiren" type="text" class="dfinput" value=<%=keti.getXuan().getStudent_ID() %> style="width:300px;"/>
    </li>
    
    <li><label>发布时间<b>*</b></label><input name="xuanti_gaist_fabushijian" type="text" class="dfinput" value=<%=keti.getKe().getFabushijian() %>  style="width:300px;"/></li>
    <li><label>备注<b>*</b></label>
    <textarea id="content7" name="xuanti_gaist_beizhu" style="width:700px;height:200px;visibility:hidden;" ><%=keti.getXuan().getBeizhu() %></textarea>
    
    </li>
    <li><label>&nbsp;</label><input name="" type="button" class="btn" value="提交"/>
        <label>&nbsp;</label><input name="" type="button" class="btn" value="重置"/></li>
    </ul>
    </div> 
  
       
	</div> 
 
	
    
    
    
    
    
    </div>


</body>

</html>
