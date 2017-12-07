<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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

	<h1>Edit Author : ${Author.getAuthorName() }</h1>

			<form action="<c:url value='/Author/Edit'/>" method="post">
		
		<c:if test="${ !isNew }">
			<input type="hidden" name="authorid" value="${Author.getId() }" />
		</c:if>
		
		<label>Author Name</label> <br>
		<input type="text" name="authorname" value="${Author.getAuthorName()}" /><br><br>

		<label>Author Affiliation</label> <br>
		<input type="text" name="affiliation" value="${Author.getAffiliation()}" /><br><br>

		<label>Author Email</label> <br>
		<input type="text" name="email" value="${Author.getEmail()}" /><br><br>
		
		<input onclick="this.form.submited=this.value;" type="submit" name="submit" value="update" />
		
		<c:if test="${ !isNew }">
			<input onclick="this.form.submited=this.value;" type="submit" name="submit" value="delete" />
		</c:if>
		
	</form>
		

</body>
</html>
