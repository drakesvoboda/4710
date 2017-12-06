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
	<c:choose>
		<c:when test="${ !isNew }">
			<h1>Edit Paper : ${Paper.title }</h1>
		</c:when>
		<c:otherwise>
			<h1>New Paper</h1>
		</c:otherwise>
	</c:choose>
	
	<script>
		function validateForm(form) {
			if (form.submited == "delete") {
				return true;
			}

			var reviewSelect = document.getElementById("review_select");

			var options = reviewSelect.options;

			var count = 0;

			for (var i = 0, len = options.length; i < len; ++i) {
				if (options[i].selected) {
					++count;
				}
			}

			if (count != 3) {
				alert("Must select exactly 3 reviewers");
				return false;
			} else {
				return true;
			}
		}
	</script>
	<form action="<c:url value='/Paper/Edit'/>"
		onsubmit="return validateForm(this)" method="post">

		<c:if test="${ !isNew }">
			<input type="hidden" name="PaperId" value="${Paper.id }" />
		</c:if>

		<label>Paper Title</label> <br> <input type="text" name="title"
			value="${Paper.title}" /><br>
		<br> <label>Abstract</label><br>
		<textarea name="abstract">${Paper.paperAbstract}</textarea>
		<br>
		<br> <label>PDF</label><br>
		<textarea name="pdf">${Paper.pdf}</textarea>
		<br>
		<br>
<c:if test="${ !isNew }">
		<c:if test="${ Authors.size() > 0 }">
			<h4>
				Authors <small>In Order</small>
			</h4>
			<ul>
				<c:forEach items="${Authors}" var="author">
					<li>${author.getAuthorName() }</li>
				</c:forEach>
			</ul>

		</c:if>

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

				<label>Select Reviewers </label>
				<br>

				<select id="review_select" name="PCMemberIds" size="12"
					multiple="multiple">
					<c:forEach items="${PCMembers}" var="member">
						<option value="${member.id }">${member.memberName }</option>
					</c:forEach>
				</select>
				<br>


			</c:otherwise>
		</c:choose>

</c:if>
		<input onclick="this.form.submited=this.value;" type="submit"
			name="submit" value="update" />
		<c:if test="${ !isNew }">
			<input onclick="this.form.submited=this.value;" type="submit"
				name="submit" value="delete" />
		</c:if>
	</form>


</body>
</html>
