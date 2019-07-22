<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
#regist {
	padding : 5% 20%;
}

</style>

</head>

<body>
	
	<!-- Navigation -->
	<jsp:include page="navigation.jsp"></jsp:include>

	<div id='regist'>
		<h2>공지 수정하기</h2>
		<form action="/notice/noticeUpdate" method="post">
			<input type="hidden" value="${content.seq }" name="seq">
			<p>제목 : <input type='text' name='title' value="${content.title }"></p>
			<p>작성자 : <input type='text' readonly="readonly" value='${sessionScope.ID }' name='mid'></p>
			<p>내용 : <textarea rows="10" cols="100" name='contents'>${content.contents }</textarea></p>
			<input type='submit'>
		</form>
	</div>
	
	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>

	<script src="/Resources/vendor/jquery/jquery.min.js"></script>
	<script src="/Resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>