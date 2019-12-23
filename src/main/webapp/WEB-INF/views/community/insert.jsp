<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>우리 애를 부탁해</title>
<link rel="stylesheet" href="${rootPath}/css/home.css?ver=20191222003" type="text/css" >
<link rel="stylesheet" href="${rootPath}/css/community.css?ver=20191222002"  type="text/css" >
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf"%>
<%@ include file="/WEB-INF/views/include/include-nav.jspf"%>

<div id="community-insert">
	<h5>후기 글쓰기</h5>
	<fieldset>
		<legend>후기 작성</legend>
		<form:form modelAttribute="reDTO" autocomplete="on" class="memo-form">
			<input name="re_seq" type="hidden" value='<c:out value="${reDTO.re_seq}" default="1"/>'>
			<form:input path="re_auth" class="in-box" placeholder="작성자 ID" /><br />
			<form:input path="re_date" class="in-box" placeholder="작성일자" /><br />
			<form:input path="re_subject" class="in-box" placeholder="제목을 입력하세요" /><br />
			<form:textarea path="re_text" rows="5" placeholder="내용을 입력하세요" /><br />
			<button id="btn-insert">저장</button>
		</form:form>
	</fieldset>
</div>

<%@ include file="/WEB-INF/views/include/include-footer.jspf"%>
</body>
</html>