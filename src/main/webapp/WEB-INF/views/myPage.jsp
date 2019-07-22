<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,edu.ssafy.root.member.Member,edu.ssafy.root.service.MemberServiceImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% Member mem = ((Member)request.getAttribute("member")); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>마이페이지</title>
<link href="/Resources/css/bootstrap.min.css" rel="stylesheet">

<link href="/Resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/Resources/css/example.css" rel="stylesheet">

<!-- Bootstrap core CSS -->
<link href="/Resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="/Resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet">
<link
	href="/Resources/vendor/simple-line-icons/css/simple-line-icons.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link href="/Resources/css/landing-page.min.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.4.4.min.js"></script>

<script type="text/javascript">
$(function() {
	$("#btnLeave").on("click", function(e) {
		console.log("is this possible?");
		$("#regForm").attr("action", "/member/memberLeave");
		$("#regForm").submit();
	});
});
</script>

<style>
.navbar {
	background: #81469a;
	padding: 0rem;
}

.navbar-nav .dropdown-menu {
	position: absolute !important;
}

#msgPart {
	color: red;
}
</style>

</head>
<body>
	<!-- Navigation -->
	<jsp:include page="navigation.jsp"></jsp:include>

	<div class="container" style="margin-top: 5rem; padding-bottom: 5rem;">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-6">
				<h1>마이페이지</h1>
				<form id="regForm" action="/member/memberUpdate" method="POST">
					<div class="form-group">
						<label for="id">아이디</label> <input type="text"
							class="form-control" id="id" name="ID" readonly="readonly" value="${sessionScope.ID }">
					</div>
					<div class="form-group">
						<label for="pw">비밀번호 </label> <input type="password"
							class="form-control" id="pw" name="PW" placeholder="비밀번호를 입력하세요">
					</div>
					<div class="form-group">
						<label for="name">이름</label> <input type="text"
							class="form-control" id="name" name="name" readonly="readonly" value="${sessionScope.name }">
					</div>
					<div class="form-group">
						<label for="address">주소</label> <input type="text"
							class="form-control" id="address" name="address" value="${member.getAddress() }">
					</div>
					<div class="form-group">
						<label for="phone">전화번호</label> <input type="text"
							class="form-control" id="phone" name="phone" value="${member.getPhone() }">
					</div>
					<div class="form-group">
						<label for="alergy">알레르기</label>
						
						<jsp:include page="allergyList.jsp"></jsp:include>
						
					</div>
					<button type="submit" class="btn btn-primary" id="btnSave">수정</button>
					<button type="button" class="btn btn-primary" id="btnLeave">회원탈퇴</button>
					<p id="msgPart">${msg}</p>
				</form>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>

	<script src="/Resources/vendor/jquery/jquery.min.js"></script>
	<script src="/Resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>
