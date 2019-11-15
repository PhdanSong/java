<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="entity.tongzhi" %>

<%@ page import="services.tongzhi.TongzhiServices" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
function Tongdelete(tongzhiID) {
    if(confirm('确认删除吗？')){
    	location.href="TongzhideleteServlet?&tongzhiID="+tongzhiID;
    } 
}
var ids="";
function doDelete() {  
    location.href = "TongzhideleteServlet?deleteIds=" + ids;  
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
    <li><a href="#">通知管理</a></li>
    <li><a href="#">查看通知</a></li>
    </ul>
    </div>
    <%String ids = "";   %>
    <div class="rightinfo">
     <div class="tools">
    	<ul class="toolbar">
        <li class="tianjia"><span><img src="images/t01.png" /></span><a href="tongzhi_add.jsp?" class="tablelink">添加通知</a></li>
        <li class="shanchu"><span><img src="images/t03.png" /></span><a href="#" class="tablelink" onClick="doDelete()">批量删除</a></li>
        </ul>
      </div>
    <div class="formtext">已有通知信息列表：</div>
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value=""  id="checkall" name="checkall" onclick="checkAll()" /></th>
        <th>序号</th>
        <th>通知标题</th>
        <th>发布教师</th>
        <th>发布时间</th>
        <th>提醒时间</th>
        <th>通知内容</th>
        <th>备注</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%String teacherId = (String) request.getSession().getAttribute("id");
	    TongzhiServices tongzhiServices =new TongzhiServices();
		List<tongzhi> tongzhi = new ArrayList<tongzhi>();
		tongzhi = tongzhiServices.selectAll(teacherId);
		/*size:总记录条数     */
		int size=tongzhi.size();
		/*curPage:当前页    */
		int curPage = 1;
		/*pageCount:总页数   */
		int pageCount = (size%5==0)?(size/5):(size/5+1);
        String tmp = request.getParameter("curPage");  
		if(tmp==null){  
		       tmp="1";  
		}  
	    curPage = Integer.parseInt(tmp);  

		if(tongzhi.size()==0){%>		
            
              <tr align="center">
                   <td colspan="9" style="height:150px;">暂无通知数据</td>
             </tr>
             
		<% }else{ 
			
			for(int i=0;i<tongzhi.size();i++){
			ids += "," + tongzhi.get(i).getTongzhi_ID();  
		%>
        <tr>
        <td><input type="checkbox" value="" id='<%=tongzhi.get(i).getTongzhi_ID()  %>' name='checkbox_<%=tongzhi.get(i).getTongzhi_ID()  %>' onclick="doCheck(<%=tongzhi.get(i).getTongzhi_ID() %>)" /></td>
        <td><%=i +1%></td>
        <td><%=tongzhi.get(i).getTongzhibiaoti() %></td>
        <td><%=tongzhi.get(i).getTeacher_ID() %></td>
        <td><%=tongzhi.get(i).getFabushijian() %></td>
        <td><%=tongzhi.get(i).getTixingshijian() %></td>
        <td><a href="tongzhi_yulante.jsp?tongzhiID=<%=tongzhi.get(i).getTongzhi_ID() %>" class="tablelink">预览</a></td>
        <td><%=tongzhi.get(i).getBeizhu() %></td>
        <td><a href="tongzhi_gaite.jsp?tongzhiID=<%=tongzhi.get(i).getTongzhi_ID() %>" class="tablelink">修改</a> <a href="#" class="click" onclick="Tongdelete(<%=tongzhi.get(i).getTongzhi_ID() %>);">删除</a></td>
       
        </tr> 
        <%} 
		if(!"".equals(ids)) {  
		    ids = ids.substring(1);  
		}  
	
		}%>
        </tbody>
    </table>
    
   
        <div class="pagin">
    	<div class="message">共<i class="blue"><%=size %></i>条记录，当前显示第&nbsp;<i class="blue"><%=curPage %>&nbsp;</i>页</div>
        <ul class="paginList">
       <%--  <c:if test="${param.pageNo + 1  gt 1}"><!-- 大于1,还可以往第1页跳 --> --%>
        <li class="paginItem"><a href="tongzhi_select.jsp?curPage=<%=curPage -1%>"><span class="pagepre"></span></a></li>
      <%--   </c:if>
        <c:if test="${param.pageNo + 1  le 1}"><!-- 小于等于1，就不能往前跳了 -->
        <li class="paginItem"><a href="#"><span class="pagepre"></span></a></li>
        </c:if> --%>
        <li class="paginItem"><a href="tongzhi_select.jsp?curPage=1;">1</a></li>
        <!--  <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li> -->
      <%--   <c:if test="${param.pageNo +1 lt pageCount}"> --%>
        <li class="paginItem"><a href="tongzhi_select.jsp?pageNo=<%=curPage+1%>"><span class="pagenxt"></span></a></li>
       <%--  </c:if>
        <c:if test="${param.pageNo +1 ge pageCount}">
        <li class="paginItem"><a href="#"><span class="pagenxt"></span></a></li>
        </c:if> --%>
        <li class="paginItem"><a href="tongzhi_select.jsp?curPage=<%=pageCount%>"><%=pageCount %> }</a></li>
        </ul>
    </div>
    
    
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
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
