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

	<c:choose>
		<c:when test="${ !isNew }">
			<h1>Edit PC Member : ${PCMember.memberName }</h1>
		</c:when>
		<c:otherwise>
			<h1>New PC Member</h1>
		</c:otherwise>
	</c:choose>
	
	
	<form action="<c:url value='/PCMember/Edit'/>"	onsubmit="return validateForm(this)" method="post">
		
		<c:if test="${ !isNew }">
			<input type="hidden" name="PCmemberID" value="${PCMember.id }" />
		</c:if>
		
		<label>PC Member Name</label> <br>
		<input type="text" name="membername" value="${PCMember.memberName}" /><br><br>

		<label>PC Member Email</label> <br>
		<input type="text" name="email" value="${PCMember.email}" /><br><br>
		
		<input onclick="this.form.submited=this.value;" type="submit" name="submit" value="update" />
		
		<c:if test="${ !isNew }">
			<input onclick="this.form.submited=this.value;" type="submit" name="submit" value="delete" />
		</c:if>
		
	</form>


</body>
</html>