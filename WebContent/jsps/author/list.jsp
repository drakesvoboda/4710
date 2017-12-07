<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <a href="/Demo/jsps/main.jsp">MAIN PAGE</a>
<hr>
  
  <h1>Select an author</h1>


<p style="color: red; font-weight: 900"> Select an Author</p>


    <c:forEach items="${Authors}" var="author">
	  <a href="/Demo/Author/Edit?id=${author.id }">${author.getAuthorName() }</a> <br>
	</c:forEach>
	

  </body>
</html>
