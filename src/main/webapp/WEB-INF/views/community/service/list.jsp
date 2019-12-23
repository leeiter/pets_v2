<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>우리 애를 부탁해</title>
<link rel="stylesheet" href="${rootPath}/css/home.css?ver=20191222003" type="text/css" >
<link rel="stylesheet" href="${rootPath}/css/community.css?ver=20191222003"  type="text/css" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	
	$("#btn-write").click(function(){
		document.location.href = "${rootPath}/community/service/insert"
	})
	
	$(".content-body").click(function(){
		let id = $(this).attr("data-id")
		let auth = $(this).attr("data-auth")
		document.location.href = "${rootPath}/community/service/view?id=" + id
	})
	


})
</script>
<style type="text/css">
#community-nav ul li:first-child a {
	background-color: #fff;
	color: black;
}


#community-nav ul li:last-child a {
	background-color: #e67e22;
	color: white;
}

#community-nav ul li:last-child {
	margin-right: 10px;
}

#community-nav ul li a:hover {
	background-color: #e67e22;
	color: white;
}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>
<div id= "community">
	<section id="community-nav">
		<ul>
			<li><a href="${rootPath}/community/list">후기</a></li>
			<li><a href="${rootPath}/community/service/list">고객센터</a></li>
		</ul>
	</section>
	
	<table>
	<tr>
		<th id="rt1">번호</th>
		<th id="rt2">제목</th>
		<th id="rt3">작성자</th>
		<th id="rt4">작성일</th>
	<tr>
	<c:choose>
		<c:when test="${empty SELIST}">
			<tr>
				<td>고객 문의가 없습니다</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${SELIST}" var="seDTO" varStatus="index">
				<tr class="content-body" data-id="${seDTO.se_seq}">
					<td>${seDTO.se_seq}</td>
					<td id="re-subject">${seDTO.se_subject}</td>
					<td>${seDTO.se_auth}</td>
					<td>${seDTO.se_date}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
	
	<button id="btn-write">글쓰기</button>
</div>
<%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>