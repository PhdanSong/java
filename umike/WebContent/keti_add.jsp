<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.ketixinxi" %>
<%@ page import="services.ketixinxi.KetixinxiServices" %>
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
	$(".btn").click(function(){
		//  $(".tip").fadeIn(200);
		alert("测试" );
		  });
});

$=function(id){return document.getElementById(id);}
function mc(){var _i=$("uploadfile");_i.click();}
function mm(tValue){
	//$("puf").value=(document.fm.uploadfile.value);
	//var _ii=$("submitfile");_ii.click();
	//alert("aaaaaaa");
	var t1 = tValue.lastIndexOf("\\");  
	var t2 = tValue.lastIndexOf(".");  
    if(t1 >= 0 && t1 < t2 && t1 < tValue.length){ 
    	/*不加文件类型   */
       //document.getElementById("puf").value = tValue.substring(t1 + 1, t2);  
    	/*加文件类型   */
       document.getElementById("puf").value = tValue.substring(t1 + 1);  
	  }  

	
	}
window.onload=function(){
	//document.fm.puf.value="";
}
function tijiao(){
	 var _ii=$("submitfile");_ii.click();
	 //alert("aaaaaaaaaaa");
 }

</script>
</head>

<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">课题管理</a></li>
     <li><a href="#">课题添加</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    
    
  	<div id="tab1" class="tabson">
    
    <div class="formtext">添加课题信息：</div>
    <!-- <form action="KitiServlet" method="post"> -->
    <form action="KitiServlet" name="fm" id="fm" method="post">
    <ul class="forminfo">
    <li><label>课题编号<b>*</b></label><input name="ketibianhao" type="text" class="dfinput" value=""  style="width:300px;"/><b>&nbsp;&nbsp;此项为必填项</b></li>
   
    <li><label>课题名称<b>*</b></label><input name="ketimingcheng" type="text" class="dfinput" value=""  style="width:300px;"/></li>
    
    <li><label>课题类型<b>*</b></label>   
   <!--  <div class="vocation">
    <select class="select1" name="leixing" style="width:250px;">
    <option>软件</option>
    <option>计算机</option>
    </select>
    </div>        -->
    <input name="leixing" type="text" class="dfinput" value=""  style="width:300px;"/>
    </li>
    <li><label>课题名额<b>*</b></label>
    <input name="ketishuliang" type="text" class="dfinput" value=""  style="width:300px;"/>
    </li>
    <% String filename = (String)request.getSession().getAttribute("filename");%>
    <li><label>附件<b>*</b></label>
    <input name="fujian" type="text" class="dfinput" value="" id="puf" style="width:300px;"/>   
    &nbsp;&nbsp;&nbsp;&nbsp;
    <!-- <input type="text" name="predent" id="puf" /> --><input type="button" value="浏览..." onclick="mc()" style="width:50px;height:30px;" />
    <input name="file1" type="file" value="" id="uploadfile" style="display:none" onchange="if(this.value)mm(this.value);" />&nbsp;&nbsp;
    <input type="button" id="submitfile" onclick="document.fm.action='UploadHandleServlet';document.fm.enctype='multipart/form-data';document.fm.submit();" style="width:50px;height:30px;display:none;"  value="上传"></li>
    <li><label>备注<b>*</b></label>
    <textarea id="content7" name="beizhu" style="width:700px;height:200px;visibility:hidden;"></textarea>   
    </li><!--document.fm.action='KitiServlet';document.fm.submit();"   -->
    <li><label>&nbsp;</label><input name="" type="submit" id="submitbtn" onclick="tijiao()" class="btn" value="提交"/>
        <label>&nbsp;</label><input name="" type="button" class="btn" value="重置"/></li>
    </ul>
    </form>
    </div> 
 
	</div> 

    </div>


</body>

</html>
