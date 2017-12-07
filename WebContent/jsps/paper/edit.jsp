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

	<style>
#author-view .selected-author {
	width: calc(100% - 60px);
	float: left;
	padding: 5px 0;
	border-bottom: 1px solid #f4f4f4;
}

#author-view button {
	width: 30px;
	float: left;
	height: 30px;
}
</style>
</head>

<body>
	<a href="/Demo/jsps/main.jsp">MAIN PAGE</a>
	<hr>

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
			value="${Paper.title}" /><br> <br> <label>Abstract</label><br>
		<textarea name="abstract">${Paper.paperAbstract}</textarea>
		<br> <br> <label>PDF</label><br>
		<textarea name="pdf">${Paper.pdf}</textarea>
		<br> <br>
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
			<c:if test="${ Authors.size() == 0 }">
				<p>Assign Authors</p>
				<div id="fancy-select" style="overflow: hidden">
					<div style="max-width: 150px; float: left">
						<c:forEach items="${AuthorsToSelect}" var="author">
							<div class="author"
								style="overflow: hidden; padding-bottom: 3px;">
								<span class="id" style="display: none">${author.getId() }</span>
								<span class="name">${author.getAuthorName() }</span>
								<button type="button" style="float: right; margin-left: 5px;"
									onclick="return fancySelect.addElement(this.parentNode)">-></button>
							</div>

						</c:forEach>
					</div>

					<div id="author-inputs"></div>
					<div id="author-view" style="margin-left: 150px;"></div>
				</div>
			</c:if>
			<br>
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

	<script>
		var fancySelect = (function() {
			var elements = [];
			var allElements = document.getElementsByClassName('author');
			var inputs = document.getElementById('author-inputs');
			var view = document.getElementById('author-view');

			var render = function() {
				inputs.innerHTML = "";
				view.innerHTML = "";
				for (var i = 0, len = elements.length; i < len; ++i) {
					var hiddeninput = document.createElement('input');

					hiddeninput.setAttribute("name", "author[" + i + "]");
					hiddeninput.setAttribute("type", "hidden");
					hiddeninput.setAttribute("value", elements[i]
							.getElementsByClassName("id")[0].innerHTML);

					inputs.appendChild(hiddeninput);

					var elementToView = elements[i];

					elementToView.setAttribute("class", "selected-author");

					var sinkButton = document.createElement('button');
					sinkButton.setAttribute("type", "button");
					sinkButton.setAttribute("onclick",
							"fancySelect.sinkElement(" + i + ")");
					sinkButton.innerHTML = "▼";

					var floatButton = document.createElement('button');
					floatButton.setAttribute("type", "button");
					floatButton.setAttribute("onclick",
							"fancySelect.floatElement(" + i + ")");
					floatButton.innerHTML = "▲";

					view.appendChild(elementToView);
					view.appendChild(sinkButton);
					view.appendChild(floatButton);
				}

			}

			return {
				addElement : function(element) {
					var elementToAdd = document.createElement("div");

					var innerSpan = document.createElement("span");

					element.setAttribute("style", "display: none");

					innerSpan.innerHTML = element.getElementsByClassName("id")[0].innerHTML
					innerSpan.setAttribute("class", "id");
					innerSpan.setAttribute("style", "display:none");

					elementToAdd.innerHTML = element
							.getElementsByClassName("name")[0].innerHTML

					elementToAdd.appendChild(innerSpan);

					elements.push(elementToAdd);

					render();
				},
				removeElement : function(i) {

					render();
				},
				floatElement : function(i) {

					if (i > 0) {
						var temp = elements[i - 1]
						elements[i - 1] = elements[i];
						elements[i] = temp;
						render();
					}
				},
				sinkElement : function(i) {
					if (i < elements.length - 1) {
						var temp = elements[i + 1]
						elements[i + 1] = elements[i];
						elements[i] = temp;
						render();
					}
				}
			}

		}());
	</script>


</body>
</html>
