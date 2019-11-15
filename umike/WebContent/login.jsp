<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录后台管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })
});  
/* var bhao = "wu";	
	function check1(){
		document.getElementById("username").value="";
	   if(document.getElementById("password").value==""){
		location.href="login.jsp?bhao="+bhao;
		} 
	}
	function check2(){
	    document.getElementById("password").value="";
	     if(document.getElementById("username").value==""){
			location.href="login.jsp?&bhao="+bhao;
	      } 
	} */
	window.onload=function(){
		//document.fm.puf.value="";
		//document.getElementById("bb").style.display = 'none';;
	}
	
</script> 

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
    <form action="LoginServlet" method="post">
    <ul><!-- onclick="JavaScript:this.value=''"  -->
    <li><input name="username" id="username" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/></li>
    <li><input name="password" id="password" type="text" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/></li>
    <li>&nbsp;<input name="radiobutton" type="radio" value="student" checked="checked"/>&nbsp;&nbsp;学生&nbsp;&nbsp;<input name="radiobutton" type="radio" value="teacher"/>&nbsp;&nbsp;教师 
    <%  String bb = (String)request.getSession().getAttribute("aaa");
    String id= request.getParameter("username");
	String name=request.getParameter("password");
     if(bb==null||bb.equals("")){
    	 
     }else{
    	 if(bb.equals("2")){
    		 %>
    		  &nbsp;&nbsp;<b id="bb" style="color:red;style:block;">请填写用户名或密码</b>
    	  <% } 
    	  if(bb.equals("0")){             
        %>
              &nbsp;&nbsp;<b id="bb" style="color:red;style:block;">用户名或密码不正确，请重新输入</b>
        <%} 
        }%>
    </li>
    <li><input name="button" type="submit" class="loginbtn" value="登陆" /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
    <!--onclick="javascript:window.location='main_te.jsp'"  -->
    </ul>
    </form>
    
    </div>
    
    </div>
    
    
    
    <div class="loginbm">版权所有  2013  <a href="http://www.mycodes.net">源码之家</a> </div>
	
    
</body>

</html>
