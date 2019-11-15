<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ page  import="services.lunwenxinxi.LunwenxinxiServices"%>
<%@ page  import="entity.lunwenxinxi"%>
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
function tijiao(){
	 var _ii=$("submitfile");_ii.click();
	 //alert("aaaaaaaaaaa");
}
</script>
</head>

<body>

	<%String student_ID=(String)request.getSession().getAttribute("id");
	LunwenxinxiServices lunServices=new LunwenxinxiServices();
	lunwenxinxi lun=new lunwenxinxi();
	lun=(lunwenxinxi)lunServices.selectlunwenxinxi(student_ID);
	request.getSession().setAttribute("lun",lun);
	lun=(lunwenxinxi)request.getSession().getAttribute("lun");
	%>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">论文管理</a></li>
     <li><a href="#">论文查看</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    
    
  	<div id="tab1" class="tabson">
    
    <div class="formtext">修改论文信息：</div>
    <form action="StulunUpdateServlet" name="fm" id="fm" method="post">
    <ul class="forminfo">
    <li><label>论文名称<b>*</b></label><input name="lunwen_gaist_mingcheng" type="text" class="dfinput" value="<%=lun.getLunwenmingcheng() %>"  style="width:300px;"/></li> 
    <li><label>论文内容<b>*</b></label><input name="lunwen_gaist_neirong" type="text" id="puf" class="dfinput" value="<%=lun.getFujian() %>"  style="width:300px;"/>
    <input name="baocunming" type="text" class="dfinput" value="<%=lun.getLunbaocunming() %>"  style="display:none"/>&nbsp;&nbsp;
    <input type="button" value="浏览..." onclick="mc()" style="width:50px;height:30px;" />
    <input name="file1" type="file" value="" id="uploadfile" style="display:none" onchange="if(this.value)mm(this.value);" />&nbsp;&nbsp;
    <input type="button" id="submitfile" onclick="document.fm.action='UploadHandlelunwengaiServlet';document.fm.enctype='multipart/form-data';document.fm.submit();" style="width:50px;height:30px;display:none"  value="上传"></li>  
     <li><label>备注<b>*</b></label>
     <textarea id="content7" name="lunwen_gaist_beizhu" style="width:700px;height:200px;visibility:hidden;"><%=lun.getBeizhu() %></textarea>
    </li>
    
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" onclick="tijiao()" value="提交"/>
        <label>&nbsp;</label><input name="" type="button" class="btn" value="重置"/></li>
    </ul>
    </form>
    </div> 
  
       
	</div> 
 
	
    
    
    
    
    
    </div>


</body>

</html>
