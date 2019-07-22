<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>회원가입</title>
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
				<h1>회원가입</h1>
				<form id="regForm" action="/member/afterRegMember" method="POST">
					<div class="form-group">
						<label for="id">아이디</label> <input type="text"
							class="form-control" id="id" name="id" placeholder="아이디를 입력하세요">
					</div>
					<div class="form-group">
						<label for="pw">비밀번호 </label> <input type="password"
							class="form-control" id="pw" name="pw" placeholder="비밀번호를 입력하세요">
					</div>
					<div class="form-group">
						<label for="name">이름</label> <input type="text"
							class="form-control" id="name" name="name" placeholder="이름을 입력하세요">
					</div>
					<div class="form-group">
						<label for="address">주소</label> <input type="text"
							class="form-control" id="address" name="address" placeholder="주소를 입력하세요">
					</div>
					<div class="form-group">
						<label for="phone">전화번호</label> <input type="text"
							class="form-control" id="phone" name="phone" placeholder="전화번호를 입력하세요">
					</div>
					<div class="form-group">
						<label for="alergy">알레르기</label>
						<div class="custom-check">
							<label> 
								<input type="checkbox" value="bean 0" name="allergy"> 대두
							</label>
							<label class="mx-4">
								<input type="checkbox" value="penut 1" name="allergy"> 땅콩
							</label>
							<label class="mx-4">
								<input type="checkbox" value="milk 2" name="allergy">우유 
							</label>
							<label class="mx-4">
								<input type="checkbox" value="crab 3" name="allergy"> 게 
							</label>
						</div>
						<div class="custom-check">
							<label>
								<input type="checkbox" value="shrimp 4" name="allergy"> 새우
							</label>
							<label class="mx-4">
								<input type="checkbox" value="tuna 5"	name="allergy"> 참치 
							</label>
							<label class="mx-4">
								<input type="checkbox" value="salmon 6" name="allergy">연어 
							</label>
							<label class="mx-4">
								<input type="checkbox" value="mugwort 7" name="allergy"> 쑥 
							</label>
						</div>
						<div class="custom-check">
							<label> 
								<input type="checkbox" value="beaf 8"	name="allergy"> 소고기
							</label>
							<label class="mx-4">
								<input type="checkbox" value="chicken 9" name="allergy"> 닭고기 
							</label>
							<label class="mx-4">
								<input type="checkbox" value="pork 10" name="allergy">돼지고기 
							</label>
						</div>
						<div class="custom-check">
							<label>
								<input type="checkbox" value="peach 11" name="allergy"> 복숭아
							</label>
							<label class="mx-4">
								<input type="checkbox" value="dandelion 12" name="allergy"> 민들레 
							</label>
							<label class="mx-4">
								<input type="checkbox" value="egg 13" name="allergy">계란흰자 
							</label>
						</div>
					</div>
					<button type="submit" class="btn btn-primary" id="btnSave">등록</button>
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