<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html> -->

<div class="navbar navbar-default">
	<ul class="nav navbar-right">
		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown" style="color: #FFF"> Login<b class="caret"></b></a>
			<div class="dropdown-menu pd10 right" style="min-width: 260px">
				<form role="form" id="loginForm" action="/member/memberLogin" method="POST"
					style="padding: 5px;">
					<div class="form-group" style="padding: 5px;">
						<label for="inputId">아이디</label> <input type="text"
							class="form-control" id="id" name="ID" placeholder="Enter ID">
					</div>
					<div class="form-group" style="padding: 5px;">
						<label for="inputPassword">비밀번호</label> <input type="password"
							class="form-control" id="pw" name="PW" placeholder="Password">
					</div>
					<button type="submit" id="login" class="btn btn-primary btn-sm">로그인</button>
					<!-- <button type="button" id="searchIDPW"
									class="btn btn-default btn-sm" onclick="searchIDPW()">ID/PW찾기</button> -->
				</form>
			</div></li>
		<li>&nbsp;&nbsp;
			<form role="form" id="regForm" action="/member/regMember" method="POST"
				style="padding: 5px; display: inline-block;">
				<button type="submit" id="regMember" class="btn btn-primary btn-sm">회원
					가입</button>
			</form>
		</li>
	</ul>
</div>