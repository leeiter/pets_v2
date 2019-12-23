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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	
})
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>

<c:choose>
	<c:when test="${BODY == 'HOSPITAL-LIST'}">
		<p>여기는 병원 찾기 페이지</p>
	</c:when>
	<c:when test="${BODY == 'INGREDIENT-LIST'}">
		<p>여기는 피검사 정보 페이지</p>
	</c:when>
	<c:when test="${BODY == 'CONDITION-LIST'}">
		<p>여기는 상태 정보 페이지</p>
	</c:when>
	<c:when test="${BODY == 'LOGIN'}">
		<p>여기는 로그인 페이지</p>
	</c:when>
	<c:when test="${BODY == 'JOIN'}">
		<p>여기는 회원가입 페이지</p>
	</c:when>
	<c:otherwise>
		<%@ include file="/WEB-INF/views/include/include-main.jspf" %>
	</c:otherwise>
</c:choose>

<%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>