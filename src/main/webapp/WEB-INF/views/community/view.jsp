<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>우리 애를 부탁해</title>
<link rel="stylesheet" href="${rootPath}/css/home.css?ver=20191222003" type="text/css" >
<link rel="stylesheet" href="${rootPath}/css/community.css?ver=20191222002"  type="text/css" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(function(){
	
	$("#btn-update").on("click", function(){
		document.location.href = "${rootPath}/community/update?id=${reDTO.re_seq}" 
	})
	
	$("#btn-delete").click(function(){
		if(confirm("메모를 삭제합니다!!!")) {
			let query = "${rootPath}/community/delete?re_seq=${reDTO.re_seq}"
			document.location.replace(query)
		}
	})
		
})
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>

<div id="community-update">
	<h5>후기</h5>
	<table>
		<tr>
			<td colspan="6" id="re-sub">${reDTO.re_subject}</td>
		</tr>
		<tr>
			<td colspan="6" id="re-text">${reDTO.re_text}</td>
		</tr>
		<tr id="re-hide">
			<td>${reDTO.re_seq}</td>
			<td colspan="1">${reDTO.re_auth}</td>
			<td colspan="2">${reDTO.re_date}</td>
		</tr>
	</table>
	
	<div class="btn-box">
		<a href="javascript:void(0)" class="btn" id="btn-update">수정</a>
		<a href="javascript:void(0)" class="btn" id="btn-delete">삭제</a>
	</div>
</div>

<%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>