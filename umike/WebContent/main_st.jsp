<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息管理系统界面</title>
</head>
<frameset rows="88,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset cols="187,*" frameborder="no" border="0" framespacing="0">
    <frame src="left_st.jsp" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="chakangeren_st.jsp" name="rightFrame" id="rightFrame" title="rightFrame" />
  </frameset>
</frameset>
<noframes><body>
 <%-- <%=request.getParameter("username")  %> --%>
 <%= request.getSession().getAttribute("id")%> 
 <%
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html; charset=UTF-8");
    response.setCharacterEncoding("utf-8");
    //获得输入的查询姓名
    String username=request.getParameter("username");
    request.setAttribute("username", username);
    %>
   
</body></noframes>
</html>