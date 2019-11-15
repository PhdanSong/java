<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="services.ketixinxi.KetixinxiServices"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="entity.ketilunwen"%>
<%@ page import="entity.ketixinxi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
   $(".click").click(function(){
  $(".tip").fadeIn(200);
  }); 
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body>

	<%-- <%String student_ID=(String)request.getSession().getAttribute("id");
	KetixinxiServices ketiservice=new KetixinxiServices();
	List<ketilunwen> list=new ArrayList<ketilunwen>();
	list=ketiservice.mingeKetixinxi();
	request.getSession().setAttribute("list",list);
	list=(List<ketilunwen>)request.getSession().getAttribute("list");
	%> --%>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">选题管理</a></li>
    <li><a href="#">课题登记</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
     
    <div class="formtext">已有课题信息列表：</div>
    
    <form action="StuSelectKetiServlet" method="post">
    <ul class="seachform">
    
    <li><label>&nbsp;&nbsp;搜索：</label></li>
    <li><label>课题编号：</label>  
    <input name="xuanti_st_ketibianhao" type="text" class="scinput" />
    </li>
    
    <li><label>课题名称：</label>  
    <input name="xuanti_st_keti" type="text" class="scinput" />
    </li>
    
    <li><label>发布教师：</label>  
    <input name="xuanti_st_fabujiaoshi" type="text" class="scinput" />
    </li>

    <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查找"/></li>
    
    </ul>
    </form>
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>序号</th>
        <th>课题编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>课题名称</th>
        <th>课题类型</th>
        <th>发布教师</th>
        <th>附件</th>
        <th>课题名额</th>
        <th>剩余名额</th>
        <th>发布时间</th>
        <th>备注</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>   
        <% 
        String xuanti_st_ketibianhao=request.getParameter("xuanti_st_ketibianhao");
		String xuanti_st_keti=request.getParameter("xuanti_st_keti");
		String xuanti_st_fabujiaoshi=request.getParameter("xuanti_st_fabujiaoshi");
    	String student_ID=(String)request.getSession().getAttribute("id");
    	KetixinxiServices ketiservice=new KetixinxiServices();
    	List<ketilunwen> list=new ArrayList<ketilunwen>();  
    	%>
    	 <%
        	if((xuanti_st_ketibianhao==null||"".equals(xuanti_st_ketibianhao))&&(xuanti_st_keti==null||"".equals(xuanti_st_keti))&&(xuanti_st_fabujiaoshi==null||"".equals(xuanti_st_fabujiaoshi))){
        	list=ketiservice.count(); 
            request.getSession().setAttribute("list",list);
        	list=(List<ketilunwen>)request.getSession().getAttribute("list");
        	if(list.size()==0){%>
        		<tr>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
        	<%}
        	else{
	        for(int i = 0 ; i< list.size();i++){   %>
		        <tr>
		        <td><input name="" type="checkbox" value="" /></td>
		        <td><%=i+1%></td>
		        <td><%=list.get(i).getKe().getKetibianhao()%></td>
		        <td><%=list.get(i).getKe().getKetimingcheng() %></td>
		        <td><%=list.get(i).getKe().getLeixing() %></td>
		        <td><a href="#" class="tablelink"><%=list.get(i).getKe().getTeacID() %></a></td>
		        <td><a href="#" class="tablelink">下载</a></td>
		        <td>5</td>
		        <td><%=list.get(i).getMin().getCount() %></td>
		        <td><%=list.get(i).getKe().getFabushijian() %></td>
		        <td><%=list.get(i).getKe().getBeizhu() %></td>
		        <td>
		        <%if(list.get(i).getMin().getCount().toString().equals("0.0")) {%><a href="#"><font color="grey">我要选题</font></a>	<% }%>
   				<%if(!list.get(i).getMin().getCount().toString().equals("0.0")) {%>
		        <a class="click" href="StudentxuantinewServlet?ketibianhao=<%=list.get(i).getKe().getKetibianhao()%>">我要选题</a> <%} %>
		        </td></tr> 
		        <%  }
        	}
		        }
    	 //编号
    	 if(!(xuanti_st_ketibianhao==null||"".equals(xuanti_st_ketibianhao))&&(xuanti_st_keti==null||"".equals(xuanti_st_keti))&&(xuanti_st_fabujiaoshi==null||"".equals(xuanti_st_fabujiaoshi))){
    		 
         	int j=Integer.parseInt(request.getSession().getAttribute("list1").toString());
         	System.out.println("传过来的个数是"+j);
         	ketilunwen keti=new ketilunwen();
         	List<ketilunwen> list1=new ArrayList<ketilunwen>();
         	for(int n=0;n<j;n++){
         		keti=(ketilunwen)request.getSession().getAttribute("listcontent"+n);
         		System.out.println("获取到了"+n);
         		list1.add(keti);
         	}
         	System.out.println("传过来的个数是"+list1);
         	if(list1.size()==0){%>
    		<tr>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
    	<%}else{
 	        for(int i = 0 ; i<list1.size();i++){   %>
 		        <tr>
 		        <td><input name="" type="checkbox" value="" /></td>
 		        <td><%=i+1%></td>
 		        <td><%=list1.get(i).getKe().getKetibianhao() %></td>
 		        <td><%=list1.get(i).getKe().getKetimingcheng() %></td>
 		        <td><%=list1.get(i).getKe().getLeixing() %></td>
 		        <td><a href="#" class="tablelink"><%=list1.get(i).getKe().getTeacID() %></a></td>
 		        <td><a href="#" class="tablelink">下载</a></td>
 		        <td>5</td>
 		        <td><%=list1.get(i).getMin().getCount() %></td>
 		        <td><%=list1.get(i).getKe().getFabushijian() %></td>
 		        <td><%=list1.get(i).getKe().getBeizhu() %></td>
 		        <td>
		        <%if(list1.get(i).getMin().getCount().toString().equals("0.0")) {%><a href="#"><font color="grey">我要选题</font></a>	<% }%>
   				<%if(!list1.get(i).getMin().getCount().toString().equals("0.0")) {%>
		        <a class="click" href="StudentxuantinewServlet?ketibianhao=<%=list1.get(i).getKe().getKetibianhao()%>">我要选题</a> <%} %>
		        </td></tr>  
 		        <%  }
    	}
 		        }  
    	 //名称
    	 if((xuanti_st_ketibianhao==null||"".equals(xuanti_st_ketibianhao))&&!(xuanti_st_keti==null||"".equals(xuanti_st_keti))&&(xuanti_st_fabujiaoshi==null||"".equals(xuanti_st_fabujiaoshi))){
    		 
          	int j=Integer.parseInt(request.getSession().getAttribute("list1").toString());
          	System.out.println("传过来的个数是"+j);
          	ketilunwen keti=new ketilunwen();
          	List<ketilunwen> list1=new ArrayList<ketilunwen>();
          	for(int n=0;n<j;n++){
          		keti=(ketilunwen)request.getSession().getAttribute("listketi"+n);
          		System.out.println("获取到了"+n);
          		list1.add(keti);
          	}
          	System.out.println("传过来的个数是"+list1);
          	if(list1.size()==0){%>
    		<tr>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
    	<%}else{
  	        for(int i = 0 ; i<list1.size();i++){   %>
  		        <tr>
  		        <td><input name="" type="checkbox" value="" /></td>
  		        <td><%=i+1%></td>
  		        <td><%=list1.get(i).getKe().getKetibianhao() %></td>
  		        <td><%=list1.get(i).getKe().getKetimingcheng() %></td>
  		        <td><%=list1.get(i).getKe().getLeixing() %></td>
  		        <td><a href="#" class="tablelink"><%=list1.get(i).getKe().getTeacID() %></a></td>
  		        <td><a href="#" class="tablelink">下载</a></td>
  		        <td>5</td>
  		        <td><%=list1.get(i).getMin().getCount() %></td>
  		        <td><%=list1.get(i).getKe().getFabushijian() %></td>
  		        <td><%=list1.get(i).getKe().getBeizhu() %></td>
  		        <td>
		        <%if(list1.get(i).getMin().getCount().toString().equals("0.0")) {%><a href="#"><font color="grey">我要选题</font></a>	<% }%>
   				<%if(!list1.get(i).getMin().getCount().toString().equals("0.0")) {%>
		        <a class="click" href="StudentxuantinewServlet?ketibianhao=<%=list1.get(i).getKe().getKetibianhao()%>">我要选题</a> <%} %>
		        </td></tr> 
  		        <%  }
    	}
  		        }  
    	 //教师
    	 if((xuanti_st_ketibianhao==null||"".equals(xuanti_st_ketibianhao))&&(xuanti_st_keti==null||"".equals(xuanti_st_keti))&&!(xuanti_st_fabujiaoshi==null||"".equals(xuanti_st_fabujiaoshi))){
    		 
    		 int j=Integer.parseInt(request.getSession().getAttribute("list1").toString());
           	System.out.println("传过来的个数是"+j);
           	ketilunwen keti=new ketilunwen();
           	List<ketilunwen> list1=new ArrayList<ketilunwen>();
           	for(int n=0;n<j;n++){
           		keti=(ketilunwen)request.getSession().getAttribute("listjiaoshi"+n);
           		System.out.println("获取到了"+n);
           		list1.add(keti);
           	}
           	System.out.println("传过来的个数是"+list1);
           	if(list1.size()==0){%>
    		<tr>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
	        <td>0</td>
    	<%}else{
   	        for(int i = 0 ; i<list1.size();i++){   %>
   		        <tr>
   		        <td><input name="" type="checkbox" value="" /></td>
   		        <td><%=i+1%></td>
   		        <td><%=list1.get(i).getKe().getKetibianhao() %></td>
   		        <td><%=list1.get(i).getKe().getKetimingcheng() %></td>
   		        <td><%=list1.get(i).getKe().getLeixing() %></td>
   		        <td><a href="#" class="tablelink"><%=list1.get(i).getKe().getTeacID() %></a></td>
   		        <td><a href="#" class="tablelink">下载</a></td>
   		        <td>5</td>
   		        <td><%=list1.get(i).getMin().getCount() %></td>
   		        <td><%=list1.get(i).getKe().getFabushijian() %></td>
   		        <td><%=list1.get(i).getKe().getBeizhu() %></td>
   		        <td>
		        <%if(list1.get(i).getMin().getCount().toString().equals("0.0")) {%><a href="#"><font color="grey">我要选题</font></a>	<% }%>
   				<%if(!list1.get(i).getMin().getCount().toString().equals("0.0")) {%>
		        <a class="click" href="StudentxuantinewServlet?ketibianhao=<%=list1.get(i).getKe().getKetibianhao()%>">我要选题</a> <%} %>
		        </td></tr> 
   		        <%  }
    	}
   		        }  
    	 //编号、名称、教师
    	 if(!(xuanti_st_ketibianhao==null||"".equals(xuanti_st_ketibianhao))&&!(xuanti_st_keti==null||"".equals(xuanti_st_keti))&&!(xuanti_st_fabujiaoshi==null||"".equals(xuanti_st_fabujiaoshi))){
    			int j=Integer.parseInt(request.getSession().getAttribute("list1").toString());
               	System.out.println("传过来的个数是"+j);
               	ketilunwen keti=new ketilunwen();
               	List<ketilunwen> list1=new ArrayList<ketilunwen>();
               	for(int n=0;n<j;n++){
               		keti=(ketilunwen)request.getSession().getAttribute("listthree"+n);
               		System.out.println("获取到了"+n);
               		list1.add(keti);
               	}
               	System.out.println("传过来的个数是"+list1);
               	if(list1.size()==0){%>
        		<tr>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
        	<%}else{
       	        for(int i = 0 ; i<list1.size();i++){   %>
       		        <tr>
       		        <td><input name="" type="checkbox" value="" /></td>
       		        <td><%=i+1%></td>
       		        <td><%=list1.get(i).getKe().getKetibianhao() %></td>
       		        <td><%=list1.get(i).getKe().getKetimingcheng() %></td>
       		        <td><%=list1.get(i).getKe().getLeixing() %></td>
       		        <td><a href="#" class="tablelink"><%=list1.get(i).getKe().getTeacID() %></a></td>
       		        <td><a href="#" class="tablelink">下载</a></td>
       		        <td>5</td>
       		        <td><%=list1.get(i).getMin().getCount() %></td>
       		        <td><%=list1.get(i).getKe().getFabushijian() %></td>
       		        <td><%=list1.get(i).getKe().getBeizhu() %></td>
       		        <td>
		        <%if(list1.get(i).getMin().getCount().toString().equals("0.0")) {%><a href="#"><font color="grey">我要选题</font></a>	<% }%>
   				<%if(!list1.get(i).getMin().getCount().toString().equals("0.0")) {%>
		        <a class="click" href="StudentxuantinewServlet?ketibianhao=<%=list1.get(i).getKe().getKetibianhao()%>">我要选题</a> <%} %>
       		        </td></tr> 
       		        <%  }
        	}
    	 }
    	 //编号、名称
    	 if(!(xuanti_st_ketibianhao==null||"".equals(xuanti_st_ketibianhao))&&!(xuanti_st_keti==null||"".equals(xuanti_st_keti))&&(xuanti_st_fabujiaoshi==null||"".equals(xuanti_st_fabujiaoshi))){
 			int j=Integer.parseInt(request.getSession().getAttribute("list1").toString());
            	System.out.println("传过来的个数是"+j);
            	ketilunwen keti=new ketilunwen();
            	List<ketilunwen> list1=new ArrayList<ketilunwen>();
            	for(int n=0;n<j;n++){
            		keti=(ketilunwen)request.getSession().getAttribute("listthree"+n);
            		System.out.println("获取到了"+n);
            		list1.add(keti);
            	}
            	System.out.println("传过来的个数是"+list1);
            	if(list1.size()==0){%>
     		<tr>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
		        <td>0</td>
     	<%}else{
    	        for(int i = 0 ; i<list1.size();i++){   %>
    		        <tr>
    		        <td><input name="" type="checkbox" value="" /></td>
    		        <td><%=i+1%></td>
    		        <td><%=list1.get(i).getKe().getKetibianhao() %></td>
    		        <td><%=list1.get(i).getKe().getKetimingcheng() %></td>
    		        <td><%=list1.get(i).getKe().getLeixing() %></td>
    		        <td><a href="#" class="tablelink"><%=list1.get(i).getKe().getTeacID() %></a></td>
    		        <td><a href="#" class="tablelink">下载</a></td>
    		        <td>5</td>
    		        <td><%=list1.get(i).getMin().getCount() %></td>
    		        <td><%=list1.get(i).getKe().getFabushijian() %></td>
    		        <td><%=list1.get(i).getKe().getBeizhu() %></td>
    		        <td>
    		        <td>
		        <%if(list1.get(i).getMin().getCount().toString().equals("0.0")) {%><a href="#"><font color="grey">我要选题</font></a>	<% }%>
   				<%if(!list1.get(i).getMin().getCount().toString().equals("0.0")) {%>
		        <a class="click" href="StudentxuantinewServlet?ketibianhao=<%=list1.get(i).getKe().getKetibianhao()%>">我要选题</a> <%} %>
		        </td></tr> 
    		        <%  }
     	}
 	 }
    	 //编号、教师
    	 if(!(xuanti_st_ketibianhao==null||"".equals(xuanti_st_ketibianhao))&&(xuanti_st_keti==null||"".equals(xuanti_st_keti))&&!(xuanti_st_fabujiaoshi==null||"".equals(xuanti_st_fabujiaoshi))){
  			int j=Integer.parseInt(request.getSession().getAttribute("list1").toString());
             	System.out.println("传过来的个数是"+j);
             	ketilunwen keti=new ketilunwen();
             	List<ketilunwen> list1=new ArrayList<ketilunwen>();
             	for(int n=0;n<j;n++){
             		keti=(ketilunwen)request.getSession().getAttribute("listthree"+n);
             		System.out.println("获取到了"+n);
             		list1.add(keti);
             	}
             	System.out.println("传过来的个数是"+list1);
             	if(list1.size()==0){%>
      		<tr>
 		        <td>0</td>
 		        <td>0</td>
 		        <td>0</td>
 		        <td>0</td>
 		        <td>0</td>
 		        <td>0</td>
 		        <td>0</td>
 		        <td>0</td>
 		        <td>0</td>
 		        <td>0</td>
 		        <td>0</td>
 		        <td>0</td>
      	<%}else{
     	        for(int i = 0 ; i<list1.size();i++){   %>
     		        <tr>
     		        <td><input name="" type="checkbox" value="" /></td>
     		        <td><%=i+1%></td>
     		        <td><%=list1.get(i).getKe().getKetibianhao() %></td>
     		        <td><%=list1.get(i).getKe().getKetimingcheng() %></td>
     		        <td><%=list1.get(i).getKe().getLeixing() %></td>
     		        <td><a href="#" class="tablelink"><%=list1.get(i).getKe().getTeacID() %></a></td>
     		        <td><a href="#" class="tablelink">下载</a></td>
     		        <td>5</td>
     		        <td><%=list1.get(i).getMin().getCount() %></td>
     		        <td><%=list1.get(i).getKe().getFabushijian() %></td>
     		        <td><%=list1.get(i).getKe().getBeizhu() %></td>
     		        <td>
     		        
		        <%if(list1.get(i).getMin().getCount().toString().equals("0.0")) {%><a href="#"><font color="grey">我要选题</font></a>	<% }%>
   				<%if(!list1.get(i).getMin().getCount().toString().equals("0.0")) {%>
		        <a class="click" href="StudentxuantinewServlet?ketibianhao=<%=list1.get(i).getKe().getKetibianhao()%>">我要选题</a> <%} %>
		        </td></tr> 
     		        <%  }
      	}
  	 }
    	 
    	 if((xuanti_st_ketibianhao==null||"".equals(xuanti_st_ketibianhao))&&!(xuanti_st_keti==null||"".equals(xuanti_st_keti))&&!(xuanti_st_fabujiaoshi==null||"".equals(xuanti_st_fabujiaoshi))){
   			int j=Integer.parseInt(request.getSession().getAttribute("list1").toString());
              	System.out.println("传过来的个数是"+j);
              	ketilunwen keti=new ketilunwen();
              	List<ketilunwen> list1=new ArrayList<ketilunwen>();
              	for(int n=0;n<j;n++){
              		keti=(ketilunwen)request.getSession().getAttribute("listthree"+n);
              		System.out.println("获取到了"+n);
              		list1.add(keti);
              	}
              	System.out.println("传过来的个数是"+list1);
              	if(list1.size()==0){%>
       		<tr>
  		        <td>0</td>
  		        <td>0</td>
  		        <td>0</td>
  		        <td>0</td>
  		        <td>0</td>
  		        <td>0</td>
  		        <td>0</td>
  		        <td>0</td>
  		        <td>0</td>
  		        <td>0</td>
  		        <td>0</td>
  		        <td>0</td>
       	<%}else{
      	        for(int i = 0 ; i<list1.size();i++){   %>
      		        <tr>
      		        <td><input name="" type="checkbox" value="" /></td>
      		        <td><%=i+1%></td>
      		        <td><%=list1.get(i).getKe().getKetibianhao() %></td>
      		        <td><%=list1.get(i).getKe().getKetimingcheng() %></td>
      		        <td><%=list1.get(i).getKe().getLeixing() %></td>
      		        <td><a href="#" class="tablelink"><%=list1.get(i).getKe().getTeacID() %></a></td>
      		        <td><a href="#" class="tablelink">下载</a></td>
      		        <td>5</td>
      		        <td><%=list1.get(i).getMin().getCount() %></td>
      		        <td><%=list1.get(i).getKe().getFabushijian() %></td>
      		        <td><%=list1.get(i).getKe().getBeizhu() %></td>
      		        <td>
      		        <a class="click" href="StudentxuantinewServlet?ketibianhao=<%=list1.get(i).getKe().getKetibianhao() %>">我要选题</a> 
      		        </td></tr> 
      		        <%  }
       	}
   	 } 
		        %>
        
        </tbody>
    </table>
    
   
    <!-- <div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div> -->
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>选题成功！</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">        
        <input name="" type="submit"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
        
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

 	<script type="text/javascript">
	 function woyaoxuanti(stu)
	{	
	request.getSession().setAttribute("list",stu);
	list=(List<ketilunwen>)request.getSession().getAttribute("list");
	alert("选题情况"+list.size());
     } 
</script> 
</body>

</html>
