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

<c:if test="${authors != null}">
<form onsubmit="return app.validateForm(this)" action="<c:url value='/Paper/List'/>" method="post">
		<label>Search for papers by:</label> 
		<select name="lastname" id="lastname">
			<c:forEach items="${authors}" var="author">
				<option value="${author.getAuthorName()}">${author.getAuthorName()}</option>
			</c:forEach>
		</select>
		<span id="second-author">
		and 
		<select name="lastname2" id="lastname2">
			<c:forEach items="${authors}" var="author">
				<option value="${author.getAuthorName()}">${author.getAuthorName()}</option>
			</c:forEach>
		</select>
		</span>
		<br>
		 
		
		<label>
			<input type="radio" name="type" value="singleauthor" checked onchange="app.toggleSecondAuthor()"> Single Author
		</label> 
		<br> 
		
		<label> 
			<input type="radio" name="type" value="firstauthor" onchange="app.toggleSecondAuthor()"> First Author
		</label> 
		<br> 
		
		<label> 
			<input type="radio" name="type" value="twoauthors" id="multiple-authors" onchange="app.toggleSecondAuthor()"> Multiple Authors
		</label> 
		<br>
		<button type="submit">GO</button>
	</form>
</c:if>
	
	
	<p style="color: red; font-weight: 900">${msg}</p>
	
	<c:forEach items="${Papers}" var="paper">
		<a href="/Demo/Paper/Edit?id=${paper.id }">${paper.title }</a>
		<br>
	</c:forEach>
	<br>
	<a href="/Demo/Paper/Edit">+ Create a paper</a>
	<br>

<c:if test="${recommended_papers != null}">
	<h3>Recommended Papers</h3>
	<c:forEach items="${recommended_papers}" var="paper">
		<a href="/Demo/Paper/Edit?id=${paper.id }">${paper.title }</a>
		<br>
	</c:forEach>
</c:if>
	<script>
	var app = (function() {
		var multiple = document.getElementById("multiple-authors");	
		var second_author = document.getElementById("second-author");
		
		return{
			validateForm: function(form) {		
				
				var lastname = document.getElementById("lastname");
				var lastname2 = document.getElementById("lastname2");
				
				if(multiple.checked && lastname.value == lastname2.value ){
					alert("The two authors must be different")
					return false;			
				}
			},
			
			toggleSecondAuthor: function(){		
				if(multiple.checked){
					second_author.style = "";
				}else{
					second_author.style = "display: none";
				}		
			}
		}
		
		})();
	
	(function(){
		app.toggleSecondAuthor();	
	})();
	
	</script>

</body>
</html>
