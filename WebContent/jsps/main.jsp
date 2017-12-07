<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>main</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
* {
	font-size: 10pt;
}

body {
	text-align: center;
}

.table {
	width: 1024px;
	height: 100%;
	border: 1px solid gray;
	border-collapse: collapse;
}

.table td {
	border: 1px solid gray;
}

iframe {
	width: 100%;
	height: 100%;
}
</style>
</head>

<body>

	<script>
		function InitDatabase() {

			var loader = [ "Initializing", " Initializing.", "  Initializing..",
					"   Initializing...", "   Initializing...", "   Initializing...", "   Initializing..." ];
			
			var i = 0;
			
			document.getElementById("msg").innerHTML = loader[i];
			
			var timeout = setInterval(function() {

				document.getElementById("msg").innerHTML = loader[i];
				i = (i < 6) ? i + 1 : 0
						console.log(i);
			}, 200);

			var xhttp = new XMLHttpRequest();

			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					clearInterval(timeout);
					document.getElementById("msg").innerHTML = this.responseText;
				}
			};
			
			xhttp.open("POST", "/Demo/InitDatabase", true);
			
			xhttp.send();
		}
	</script>

	<h4 id="msg"></h4>
	<div style="font-size: 24pt;">
		<button onclick="javascript:InitDatabase()" target="_blank">Initialize
			Database</button>
		&nbsp; <a href="<c:url value='/Paper/List'/>" target="_parent">View
			Papers</a>
		|&nbsp; <a href="<c:url value='/PCMember/List'/>" target="_parent">View
			PC Members</a>
		|&nbsp; <a href="<c:url value='/Review/List'/>" target="_parent">View
			Reviews</a>
		|&nbsp; <a href="<c:url value='/Author/List'/>" target="_parent">View
			Authors</a>
	</div>
</body>
</html>
