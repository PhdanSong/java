<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>功能菜单</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>个人信息管理
    </div>
    	<ul class="menuson">
    	<li class="active"><cite></cite><a href="chakangeren_te.jsp" target="rightFrame">个人信息管理</a><i></i></li> 	
        <!--  <li><cite></cite><a href="index.html" target="rightFrame">首页模版</a><i></i></li>
        <li class="active"><cite></cite><a href="right.html" target="rightFrame">数据列表</a><i></i></li>
        <li><cite></cite><a href="imgtable.html" target="rightFrame">图片数据表</a><i></i></li>
        <li><cite></cite><a href="form.html" target="rightFrame">添加编辑</a><i></i></li>
        <li><cite></cite><a href="imglist.html" target="rightFrame">图片列表</a><i></i></li>
        <li><cite></cite><a href="imglist1.html" target="rightFrame">自定义</a><i></i></li>
        <li><cite></cite><a href="tools.html" target="rightFrame">常用工具</a><i></i></li>
        <li><cite></cite><a href="filelist.html" target="rightFrame">信息管理</a><i></i></li>
        <li><cite></cite><a href="tab.html" target="rightFrame">Tab页</a><i></i></li>
        <li><cite></cite><a href="error.html" target="rightFrame">404页面</a><i></i></li>  -->
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>课题管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="keti_add.jsp" target="rightFrame">课题添加</a><i></i></li>
        <li><cite></cite><a href="keti_select.jsp" target="rightFrame">课题查询</a><i></i></li>
        </ul>     
    </dd> 
    
    
    <dd><div class="title"><span><img src="images/leftico03.png" /></span>选题管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="xuanti_te.jsp" target="rightFrame">选题管理</a><i></i></li>
    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span><img src="images/leftico04.png" /></span>论文管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="lunwen_te.jsp" target="rightFrame">论文管理</a><i></i></li>
    </ul>
    
    </dd> 
    <dd><div class="title"><span><img src="images/leftico01.png" /></span>成绩管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="chengji_te.jsp" target="rightFrame">成绩管理</a><i></i></li>
    </ul>
    
    </dd> 
    <dd><div class="title"><span><img src="images/leftico02.png" /></span>通知管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="tongzhi_add.jsp" target="rightFrame">新建通知</a><i></i></li>
        <li><cite></cite><a href="tongzhi_select.jsp" target="rightFrame">查看通知</a><i></i></li>
    </ul>
    
    </dd>         
    
    </dl>
    
</body>
</html>
