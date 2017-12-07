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

<form onsubmit="return app.validateForm(this)" action="<c:url value='/PCMember/List'/>" method="post">
		<label>Search for papers rejected by:</label> 
		<select name="lastname" id="lastname">
			<c:forEach items="${PCMembers}" var="PCMember">
				<option value="${PCMember.memberName}">${PCMember.memberName}</option>
			</c:forEach>
		</select>
	
		and 
		<select name="lastname2" id="lastname2">
			<c:forEach items="${PCMembers}" var="PCMember">
				<option value="${PCMember.memberName}">${PCMember.memberName}</option>
			</c:forEach>
		</select>
	
		<br>
		 
		
		<button type="submit">GO</button>
	</form>



  

  <h1>Select a PC Member</h1>



<p style="color: red; font-weight: 900"> Members with the most reviews</p>
    <c:forEach items="${PCMembersMostReview}" var="PCMember">
	  <a href="/Demo/PCMember/Edit?id=${PCMember.id}">${PCMember.memberName}</a> <br>
	</c:forEach>

<p style="color: red; font-weight: 900"> All PC Members</p>

    <c:forEach items="${PCMembers}" var="PCMember">
	  <a href="/Demo/PCMember/Edit?id=${PCMember.id}">${PCMember.memberName}</a> <br>
	</c:forEach>
	<br>
	<a href="/Demo/PCMember/Edit">+ New PC Member</a> <br>
	
	<p style="color: red; font-weight: 900"> Members with no reviews</p>
    <c:forEach items="${PCMembersNoReview}" var="PCMember">
	  <a href="/Demo/PCMember/Edit?id=${PCMember.id}">${PCMember.memberName}</a> <br>
	</c:forEach>


<script>
	var app = (function() {
		
		return{
			validateForm: function(form) {		
				
				var lastname = document.getElementById("lastname");
				var lastname2 = document.getElementById("lastname2");
				
				if(lastname.value == lastname2.value ){
					alert("The two PC Members must be different")
					return false;			
				}
			}
		}
		
		})();
</script>
  </body>
</html>
