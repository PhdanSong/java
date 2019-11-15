<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="entity.ketixinxi" %>
<%@ page import="services.ketixinxi.KetixinxiServices" %>
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
   //$(".tip").fadeIn(200);
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
 function Studelete(bhao) {
    if(confirm('确认删除吗？')){
    	location.href="KetideleteServlet?&bianhao="+bhao;
    } 
}
function fujian(bianhao) {
	location.href = "downLoadServlet?filename=" + bianhao;  
	//alert(bianhao);
}

 
 var ids="";
 function doDelete() {  
     location.href = "KetideleteServlet?deleteIds=" + ids;  
 }

 function doCheck(id) {  
     ids += "," + id;
     alert(ids);
 }  
 function checkAll() {  
 	var a = document.getElementsByTagName("input");
     if(a[0].checked){
     	for(var i = 0;i<a.length;i++){
     		if(a[i].type == "checkbox") 
     			a[i].checked = true;
     		    ids += "," + a[i].id;
     		    
     		}
     }else{
     	for(var i = 0;i<a.length;i++){
     		if(a[i].type == "checkbox") 
     			a[i].checked = false;
     		    ids ="";
     	}
     }
     
 }  
</script>

</head>


<body>
     
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">课题管理</a></li>
    <li><a href="#">课题查询</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
        <div class="tools">  
    	<ul class="toolbar">
        <li class="tianjia"><span><img src="images/t01.png" /></span><a href="keti_add.jsp" class="tablelink">添加课题</a></li>
        <li class="shanchu"><span><img src="images/t03.png" /></span><a href="#" class="tablelink" onClick="doDelete()">批量删除</a></li>
        </ul>
      </div>
     <div class="formtext">已有课题信息列表：</div>
    <form action="KetixinxichaServlet" method="post">
    <ul class="seachform">
    <li><label>&nbsp;&nbsp;搜索：</label></li>
    <li><label>课题编号：</label>  
    <input name="ketibianhao" type="text" class="scinput" />
    </li> 
    <li><label>课题名称：</label>  
    <input name="ketimingcheng" type="text" class="scinput" />
    </li>
    <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查找"/></li>  
    </ul>
     </form>
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" id="checkall" name="checkall" onclick="checkAll()" /></th>
        <th>序号</th>
        <th>课题编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>课题名称</th>
        <th>课题类型</th>
        <th>发布教师</th>
        <th>附件</th>
        <th>附件操作</th>
        <th>课题名额</th>
        <th>发布时间</th>
        <th>备注</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <% String teacherId = (String) request.getSession().getAttribute("id");
        KetixinxiServices ketixinxiServices = new KetixinxiServices();
		List<ketixinxi> keti = new ArrayList<ketixinxi>();
		String ketimingcheng = (String)request.getSession().getAttribute("ketimingcheng");
		String ketibianhao = (String)request.getSession().getAttribute("ketibianhao");
	
		
		/*点击查找时没有课题编号有课题名称筛选出的课题信息    */
		List<ketixinxi> ketilist = (List<ketixinxi>)request.getSession().getAttribute("ketilist");	
		/*点击查找时有课题编号没有课题名称筛选出的课题信息    */
		ketixinxi ketione = (ketixinxi)request.getSession().getAttribute("ketione");
		/*点击查找时有课题编号和课题名称筛选出的课题信息    */
		ketixinxi ketitwo = (ketixinxi)request.getSession().getAttribute("ketitwo");
		/*如果查找框中没有输入课题名称和课题编号信息(1)    */
		if(ketimingcheng==null||ketimingcheng.equals("")){
			/*也没有课题编号   */
			if(ketibianhao==null||ketibianhao.equals("")){
		keti = ketixinxiServices.getKetixinxi(teacherId);
		if(keti.size()==0){%>		
        
        <tr align="center">
             <td colspan="12" style="height:150px;">暂无课题数据</td>
       </tr>       
	   <% }else{
		for(int i=0;i<keti.size();i++){
		%>
        <tr>
        <td><input name="" type="checkbox" value="" id='<%=keti.get(i).getKetibianhao()  %>' name='checkbox_<%=keti.get(i).getKetibianhao()  %>' onclick="doCheck(<%=keti.get(i).getKetibianhao() %>)" /></td>
        <td><%=i +1%></td>
        <td><%=keti.get(i).getKetibianhao() %></td>
        <td><%=keti.get(i).getKetimingcheng() %></td>
        <td><%=keti.get(i).getLeixing() %></td>
        <td><%=keti.get(i).getTeacID() %></td>
        <td><%=keti.get(i).getFujian() %></td>
        <td><a href="downLoadServlet?filename=<%=keti.get(i).getBaocunming() %>" class="tablelink">下载</a></td>
        <td><%=keti.get(i).getKetishuliang() %></td>
        <td><%=keti.get(i).getFabushijian() %></td>
        <td><%=keti.get(i).getBeizhu() %></td><!--  -->
        <td><a href="keti_gaite.jsp?bianhao=<%=keti.get(i).getKetibianhao() %>" class="tablelink">修改</a>     <a href="KetideleteServlet?&bianhao=<%=keti.get(i).getKetibianhao() %>" class="click" > 删除</a></td>
        </tr>
        <% }} 
		
		}else{
			/*没有课题名称有课题编号   */
			if(ketione.getKetibianhao()==null||ketione.getKetibianhao().equals("")){
	        	/*如果没有查找到输入课题的记录   */	
	        		%>		
	                
	                <tr align="center">
	                     <td colspan="12" style="height:150px;">暂无相关课题编号查询记录</td>
	               </tr>
	               
	        	   <% }else{
	        		 /*如果找到了   */
		%>
		<tr>
            <td><input name="" type="checkbox" value=""  id='<%=ketione.getKetibianhao()  %>' name='checkbox_<%=ketione.getKetibianhao()  %>' onclick="doCheck(<%=ketione.getKetibianhao() %>)"/></td>
            <td>1</td>
            <td><%=ketione.getKetibianhao() %></td>
            <td><%=ketione.getKetimingcheng() %></td>
            <td><%=ketione.getLeixing() %></td>
            <td><%=ketione.getTeacID() %></td>
            <td><%=ketione.getFujian() %></td>
            <td><a href="downLoadServlet?filename=<%=ketione.getBaocunming()%>" class="tablelink">下载</a></td>
            <td><%=ketione.getKetishuliang() %></td>
            <td><%=ketione.getFabushijian() %></td>
            <td><%=ketione.getBeizhu() %></td>   <!--   -->
            <td><a href="keti_gaite.jsp?bianhao=<%=ketione.getKetibianhao() %>" class="tablelink">修改</a>     <a href="KetideleteServlet?&bianhao=<%=ketione.getKetibianhao() %>" class="click"> 删除</a></td>
        </tr>	
		<% } }

        }else{
        	/*有课题名称没编号   */
        	if(ketibianhao==null||ketibianhao.equals("")){
        		if(ketilist.size()==0){
                	/*如果没有查找到输入课题的记录   */	
                		%>		
                        
                        <tr align="center">
                             <td colspan="12" style="height:150px;">暂无相关课题名称查询记录</td>
                       </tr>
                       
                	   <% }else{
                		 /*如果找到了   */
        		for(int i=0;i<ketilist.size();i++){
        	
        	%><tr>
        <td><input name="" type="checkbox" value=""  id='<%=ketilist.get(i).getKetibianhao()  %>' name='checkbox_<%=ketilist.get(i).getKetibianhao()  %>' onclick="doCheck(<%=ketilist.get(i).getKetibianhao() %>)"/></td>
        <td><%=i +1%></td>
        <td><%=ketilist.get(i).getKetibianhao() %></td>
        <td><%=ketilist.get(i).getKetimingcheng() %></td>
        <td><%=ketilist.get(i).getLeixing() %></td>
        <td><%=ketilist.get(i).getTeacID() %></td>
        <td><%=ketilist.get(i).getFujian() %></td>
        <td><a href="downLoadServlet?filename=<%=ketilist.get(i).getBaocunming()%>" class="tablelink" onclick="fujian(<%=ketilist.get(i).getKetibianhao() +","+  ketilist.get(i).getFujian()  %>);">下载</a></td>
        <td><%=ketilist.get(i).getKetishuliang() %></td>
        <td><%=ketilist.get(i).getFabushijian() %></td>
        <td><%=ketilist.get(i).getBeizhu() %></td>  <!--    -->
        <td><a href="keti_gaite.jsp?bianhao=<%=ketilist.get(i).getKetibianhao() %>" class="tablelink">修改</a>     <a href="KetideleteServlet?&bianhao=<%=ketilist.get(i).getKetibianhao() %>" class="click"> 删除</a></td>
        </tr>
     
         <% } } }else{
        	 /*有名称有编号   */
        	 	if(ketitwo.getKetibianhao()==null||ketitwo.getKetibianhao().equals("")){
	        	/*如果没有查找到输入课题的记录   */	
	        		%>		
	                
	                <tr align="center">
	                     <td colspan="12" style="height:150px;">暂无相关课题编号和课题名称查询记录</td>
	               </tr>
	               
	        	   <% }else{
	        	   %>
        	<tr>
            <td><input name="" type="checkbox" value="" id='<%=ketitwo.getBaocunming()  %>' name='checkbox_<%=ketitwo.getKetibianhao()  %>' onclick="doCheck(<%=ketitwo.getKetibianhao() %>)"/></td>
            <td>1</td>
            <td><%=ketitwo.getKetibianhao() %></td>
            <td><%=ketitwo.getKetimingcheng() %></td>
            <td><%=ketitwo.getLeixing() %></td>
            <td><%=ketitwo.getTeacID() %></td>
            <td><%=ketitwo.getFujian() %></td>
            <td><a href="downLoadServlet?filename=<%=ketitwo.getBaocunming() %>" class="tablelink">下载</a></td>
            <td><%=ketitwo.getKetishuliang() %></td>
            <td><%=ketitwo.getFabushijian() %></td>
            <td><%=ketitwo.getBeizhu() %></td><!--  -->
            <td><a href="keti_gaite.jsp?bianhao=<%=ketitwo.getKetibianhao() %>" class="tablelink">修改</a>     <a href="KetideleteServlet?&bianhao=<%=ketitwo.getKetibianhao() %>" class="click"> 删除</a></td>
            </tr> 
	 
        <%} }

        }
        
        
        %>   
        </tbody>
    </table>
    
   
    <div class="pagin">
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
    </div>
    
    <!-- <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" onClick="window.location='keti_add.jsp'"/>&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div> -->
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定"/>&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
   </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	
	<%-- function Studelete(bhao) {
		 $(".tip").fadeIn(200);
		 alert(document.getElementById("aaa").innerHTML);
		 <%int count = ketixinxiServices.deleteKetixinxi(teacherId,bhao);
		   String count= (String) request.getSession().setAttribute("count",count);%>
	     /* if(confirm('确认删除吗？')){
	            location.href='keti_delete.jsp?&bianhao='+bhao;
	     } */
	} --%>
	
	/* function queding(){
		

	} */
	</script>

</body>

</html>
