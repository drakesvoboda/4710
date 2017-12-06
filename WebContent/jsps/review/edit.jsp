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

	<h1>Complete Review : ${Review.id }</h1>

	

	<form action="<c:url value='/Review/Edit'/>" onsubmit="return validateForm(this)" method="post">
		
	<input type="hidden" name="reviewid" value="${Review.id }" />
	<input type="hidden" name="paperid" value="${Review.getPaperID() }" />
	<input type="hidden" name="pcmemberid" value="${Review.getPCMemberId() }" />
	

	<label>Submitted: </label>${Review.getSubDate() }<br><br>	
	
	<label>Recommend? </label>
		<c:choose>
            <c:when test="${Review.isRecommend()==true}">
            	<input type="checkbox" name="recommend" checked/>
            </c:when>
            <c:otherwise>
            	<input type="checkbox" name="recommend"/>
            </c:otherwise>
        </c:choose>
		<br><br>
		
		<label>Review Comments: </label> <br>
		<textarea name="comments">${Review.getComment() }</textarea><br><br>
		
		<input onclick="this.form.submited=this.value;" type="submit" name="submit" value="update" />
		<input onclick="this.form.submited=this.value;" type="submit" name="submit" value="delete" />
		<br>
		<label>Each paper must have 3 reviews. If you intend to delete this review, select a PC Member to write a replacement review</label>
		<select id="review_select" name="replacementPCMember">
						<c:forEach items="${ReplacementsForDelete}" var="member">
							<option value="${member.id }">${member.memberName }</option>
						</c:forEach>
					</select>
		
		<select id="replacementPCMember" name="replacementPCMember" size="12">
			<c:forEach items="${PCMembers}" var="member">
				<option value="${member.id }">${member.memberName }</option>
			</c:forEach>
		</select>
		

	</form>

</body>
</html>
