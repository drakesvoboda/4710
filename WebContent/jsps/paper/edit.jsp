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
	<h1>Edit Paper : ${Paper.title }</h1>


<script>

function validateForm(){
	var reviewSelect = document.getElementById("review_select");
	
	var options = reviewSelect.options;
	
	var count = 0;
	
	for(var i = 0, len = options.length; i < len; ++i){
		if(options[i].selected) {
			++count;
		}
	}
	
	if (count != 3) {
        alert("Must select exactly 3 reviewers");
        return false;
    }else{
    	return true;
    }
}

</script>

	<c:choose>
		<c:when test="${ Reviewers.size() > 0 }">
			<h4>Assigned Reviewers</h4>
			<ul>
				<c:forEach items="${Reviewers}" var="member">
					<li>${member.memberName }</li>
				</c:forEach>
			</ul>

		</c:when>
		<c:otherwise>
			<form action="<c:url value='/Paper/Update'/>" onsubmit="return validateForm()"  method="post">
				<input type="hidden" name="PaperId" value="${Paper.id }" /> <br>
				<label>Select Reviewers </label> <br> 
				
				<select id="review_select" name="reviewers"
					size="12" multiple="multiple">
					<c:forEach items="${PCMembers}" var="member">
						<option value="${member.email }">${member.memberName }</option>
					</c:forEach>
				</select><br>

				<button type="submit">Submit</button>
			</form>
			
			<button onclick="validateForm()">test</button>
		</c:otherwise>
	</c:choose>



</body>
</html>
