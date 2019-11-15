<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<style type="text/css">
.file-box{ position:relative;width:600px}
.upload_txt{ height:32px; border:1px solid #cdcdcd; width:540px;}
.upload_btn{ background-color:#FFF; border:1px solid #CDCDCD;height:34px; width:130px;margin-left:10px}
.upload_file{ position:absolute; top:0; right:80px; height:24px; filter:alpha(opacity:0);opacity: 0;width:260px }
</style>
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
	    <li><a href="#">论文管理</a></li>
	    <li><a href="#">论文提交</a></li>
    </ul>
    </div>    
    <div class="formbody">       
    <div id="usual1" class="usual">    
  	<div id="tab1" class="tabson">   
    <div class="formtext">添加论文信息：</div>   
    <form action="/UploadHandleServlet" name="fm" id="fm" enctype="multipart/form-data" method="post">
    <ul class="forminfo">
    <li><label>论文名称<b>*</b></label><input name="lunwen_addst_mingcheng" type="text" class="dfinput" value=""  style="width:300px;"/></li>   
    <li><label>论文内容<b>*</b></label>	
    <input type='text' name='lunwen_addst_neirong' id='puf' class='upload_txt' style="width:300px;" value="  附件"/>  &nbsp;&nbsp;&nbsp;&nbsp;
    <!-- <input type="text" name="predent" id="puf" /> --><input type="button" value="浏览..." onclick="mc()" style="width:50px;height:30px;" />
    <input name="file1" type="file" value="" id="uploadfile" style="display:none" onchange="if(this.value)mm(this.value);" />&nbsp;&nbsp;
    <input type="button" id="submitfile" onclick="document.fm.action='UploadHandlelunwenServlet';document.fm.enctype='multipart/form-data';document.fm.submit();" style="width:50px;height:30px;display:none"  value="上传">
    </li>  
    <li><label>备注<b>*</b></label>
    <textarea id="content7" name="lunwen_addst_beizhu" style="width:700px;height:200px;visibility:hidden;"></textarea>
    </li>
    <li>
    	<label>&nbsp;</label><input type="submit" name="submit"  id="submitbtn" onclick="tijiao()" class="btn" value="提交" />
        <label>&nbsp;</label><input name="" type="reset" class="btn" value="重置"/>
   
    </ul> 
     </form>  
    </div>       
	</div>    
    </div>
</body>
</html>
