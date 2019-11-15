<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="entity.student"%>
<%@ page  import="services.student.StudentServices"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    
  	<div id="tab1" class="tabson">
    
    <div class="formtext">修改学生信息：</div>
    <form action="StudentUpdateServlet" method="post">
    <ul class="forminfo">
    <li><label>学号<b>*</b></label><input name="tab_st_student_ID" type="text" class="dfinput" value=<%=stu.getXuehao()%>  style="width:300px;"/><b>&nbsp;&nbsp;此项不得修改</b></li>
   
    <li><label>姓名<b>*</b></label><input name="tab_st_xingming" type="text" class="dfinput" value=<%=stu.getXingming()%>  style="width:300px;"/></li>
    
    <li><label>性别<b>*</b></label>
    
    <%String m=String.valueOf(stu.getXingbie()); %>
    <div class="vocation"> 
    <select class="select1" name="tab_st_xingbie" style="width:250px;">
    <option selected="selected"  value="男" <%="男".equals(m)?"selected":"" %>>男</option>
    <option value="女" <%="女".equals(m)?"selected":"" %>>女</option>
    </select>
    </div>   
 
    
    </li>
    <li><label>电话<b>*</b></label><input name="tab_st_dianhua" type="text" class="dfinput" value=<%=stu.getDianhua()%>  style="width:300px;"/></li>
    <li><label>籍贯<b>*</b></label>
    <%String jiguan=String.valueOf(stu.getJiguan()); %>
    <div class="vocation">
    <select class="select1" style="width:250px;" name="tab_st_jiguan">
    <option selected="selected"  value="北京" <%="北京市".equals(jiguan)?"selected":"" %>>北京市</option>
    <option  value="石家庄市" <%="石家庄市".equals(jiguan)?"selected":"" %>>石家庄市</option>
    <option  value="保定市" <%="保定市".equals(jiguan)?"selected":"" %>>保定市</option>
    <option  value="衡水市" <%="衡水市".equals(jiguan)?"selected":"" %>>衡水市</option>
    <option  value="秦皇岛市" <%="秦皇岛市".equals(jiguan)?"selected":"" %>>秦皇岛市</option>
    <option  value="辛集市" <%="辛集市".equals(jiguan)?"selected":"" %>>辛集市</option>
    </select>
    </div>   
    </li>
    
    <li><label>学院<b>*</b></label>
    <%String xueyuan=String.valueOf(stu.getXueyuan()); %>
    <div class="vocation">
    <select class="select1" style="width:250px;" name="tab_st_xueyuan">
    <option selected="selected"  value="软件学院" <%="软件学院".equals(jiguan)?"selected":"" %>>软件学院</option>
    <option  value="数信学院" <%="数信学院".equals(xueyuan)?"selected":"" %>>数信学院</option>
    <option  value="生科学院" <%="生科学院".equals(xueyuan)?"selected":"" %>>生科学院</option>
    <option  value="资环学院" <%="资环学院".equals(xueyuan)?"selected":"" %>>资环学院</option>
    </select>
    </div>   
    </li>
    
    <li><label>专业<b>*</b></label>
    <%String zhuanye=String.valueOf(stu.getZhuanye()); %>
    <div class="vocation">
    <select class="select1" style="width:250px;" name="tab_st_zhuanye"  value=<%=stu.getZhuanye()%>>
    <option selected="selected"  value="软件工程" <%="软件工程".equals(zhuanye)?"selected":"" %>>软件工程</option>
    <option  value="动漫设计" <%="动漫设计".equals(zhuanye)?"selected":"" %>>动漫设计</option>
    <option  value="国画研究" <%="国画研究".equals(zhuanye)?"selected":"" %>>国画研究</option>
    </select>
    </div>   
    </li>
    
    <li><label>班级<b>*</b></label>
    <%String banji=String.valueOf(stu.getBanji()); %>
    <div class="vocation">
    <select class="select1" style="width:250px;" name="tab_st_banji" value=<%=stu.getBanji()%>>
    <option selected="selected"  value="1" <%="1".equals(banji)?"selected":"" %>>1</option>
    <option  value="2" <%="2".equals(banji)?"selected":"" %>>2</option>
    <option  value="3" <%="3".equals(banji)?"selected":"" %>>3</option>
    <option  value="4" <%="4".equals(banji)?"selected":"" %>>4</option>
    <option  value="5" <%="5".equals(banji)?"selected":"" %>>5</option>
    <option  value="6" <%="6".equals(banji)?"selected":"" %>>6</option>
    <option  value="7" <%="7".equals(banji)?"selected":"" %>>7</option>
    <option  value="8" <%="8".equals(banji)?"selected":"" %>>8</option>
    </select>
    </div>   
    </li>
    
    <li><label>备注<b>*</b></label>
    <textarea id="content7" name="tab_st_beizhu" style="width:700px;height:200px;visibility:hidden;"><%=stu.getBeizhu()%></textarea>
    
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
