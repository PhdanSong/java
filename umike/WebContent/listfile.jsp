<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下载文件显示页面</title>
</head>
<body>
    <!-- 遍历Map集合 -->
     <c:forEach var="me" items="${fileNameMap}">
         <c:url value="/downLoadServlet" var="downurl">
         <!--  me.key 和downLoadServlet中 filename相同  me.key是ListFileServlet中fileNameMap中map的key值  
               downloadurl就是filename-->
             <c:param name="filename" value="${me.key}"></c:param>
         </c:url>
         ${me.value}<a href="${downurl}">下载</a>
         <br/>
     </c:forEach>
    
</body>
</html>