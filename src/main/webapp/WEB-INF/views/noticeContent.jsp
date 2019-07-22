<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<!-- Bootstrap core CSS -->
<link href="/Resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
.padding1020 {
	padding-left: 50%;
	margin-top: 4rem; 
	padding-bottom: 5rem;
}

</style>

</head>
<body>
	<!-- Navigation -->
	<jsp:include page="navigation.jsp"></jsp:include>
	
	<div class="container padding1020">
		<div class="">
			<h1>공지사항</h1>
			<table class="table">
				<tbody>
					<tr class="row">
						<td class="col-1">글번호</td>
						<td class="col-1">${content.seq }</td>
						<td class="col-1">작성자</td>
						<td class="col-9">${content.mid }</td>
					</tr>
					<tr class="row">
						<td class="col-2">작성시간</td>
						<td class="col-10">${content.time }</td>
					</tr>
					<tr class="row">
						<td class="col-1">제목</td>
						<td class="col-11">${content.title }</td>
					</tr>
					<tr class="row">
						<td class="col-12">${content.contents }</td>
					</tr>
					<tr class="row">
						<td class="col-12"></tr>
					<tr class="row">
						<td class="col-3"><input type="button" value="수정" onclick="location.href='/notice/goNoticeUpdate?seq=${content.seq}'"></td>
						<td class="col-9"><input type="button" value="삭제" onclick="location.href='/notice/noticeDelete?seq=${content.seq}'"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	
	
	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	
	<!-- Bootstrap core JavaScript -->
	<script src="/Resources/vendor/jquery/jquery.min.js"></script>
	<script src="/Resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>