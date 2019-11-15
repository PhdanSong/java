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
    	<li class="active"><cite></cite><a href="chakangeren_st.jsp" target="rightFrame">个人信息管理</a><i></i></li>
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>选题管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="xuanti_st.jsp" target="rightFrame">选题登记</a><i></i></li>
        <li><cite></cite><a href="xuanti_selectst.jsp" target="rightFrame">已选查询</a><i></i></li>
        </ul>     
    </dd> 
    
    
    <dd><div class="title"><span><img src="images/leftico03.png" /></span>论文管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="lunwen_addst.jsp" target="rightFrame">论文提交</a><i></i></li>
        <li><cite></cite><a href="lunwen_selectst.jsp" target="rightFrame">论文查看</a><i></i></li>
    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span><img src="images/leftico04.png" /></span>成绩查看</div>
    <ul class="menuson">
        <li><cite></cite><a href="chengji_st.jsp" target="rightFrame">成绩查看</a><i></i></li>
    </ul>
    
    </dd> 
    <dd><div class="title"><span><img src="images/leftico01.png" /></span>通知查看</div>
    <ul class="menuson">
        <li><cite></cite><a href="Tongzhifenye" target="rightFrame">通知查看</a><i></i></li>
    </ul>
    
    </dd>       
    
    </dl>
    
</body>
</html>
