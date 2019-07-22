<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html> --%>

<div class="navbar navbar-default">
	<ul class="nav navbar-right">
		<li>${sessionScope.name}님 환영합니다. &nbsp;</li>
		
		<li>
			<form action="/member/memberMyPage" method="POST" id="mypageForm">
				<button name="mypage" id="mypage" value="myPage" class="btn btn-info btn-sm">마이페이지</button>
			</form>
		</li>
		
		<li style="margin-left:5px;">
			<form action="/member/memberLogout" method="POST" id="logoutForm">
				<button name="logout" id="logout" value="로그아웃" class="btn btn-danger  btn-sm">로그아웃</button>
			</form>
		</li>
	</ul>
</div>