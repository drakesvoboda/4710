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
  <h1>Select a PC Member</h1>



<p style="color: red; font-weight: 900"> Members with the most reviews</p>
    <c:forEach items="${PCMembersMostReview}" var="PCMember">
	  <a href="/Demo/PCMember/Edit?email=${PCMember.email}">${PCMember.memberName}</a> <br>
	</c:forEach>

<p style="color: red; font-weight: 900"> All PC Members</p>

    <c:forEach items="${PCMembers}" var="PCMember">
	  <a href="/Demo/PCMember/Edit?email=${PCMember.email}">${PCMember.memberName}</a> <br>
	</c:forEach>
	<br>
	<a href="/Demo/PCMember/Edit">+ New PC Member</a> <br>
	
	<p style="color: red; font-weight: 900"> Members with no reviews</p>
    <c:forEach items="${PCMembersNoReview}" var="PCMember">
	  <a href="/Demo/PCMember/Edit?email=${PCMember.email}">${PCMember.memberName}</a> <br>
	</c:forEach>

  </body>
</html>
