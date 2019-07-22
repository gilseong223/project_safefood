<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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
<script src="/Resources/plugin/chart/Chart.js"></script>

<!-- Custom styles for this template -->
<link href="/Resources/css/landing-page.min.css" rel="stylesheet">
<link href="/Resources/css/example.css" rel="stylesheet">

<style>
.navbar-brand:hover{
	text-shadow: 2px 2px 2px #555;
	font-weight: bold;
	/*box-shadow: 0 0 5px #fff*/
}
</style>

<script src="http://code.jquery.com/jquery-1.4.4.min.js"></script>
   
	<div class="navbar navbar-primary navbar-fixed-top">

		<div class="container">
			<div class="navbar-header">
				<form action="/" method="get" id="goHome">
				<!-- 	 <input type="hidden" name="action" value="main/main.do">  -->
					 <a	class="navbar-brand" href="#" style="color: #FFF"
						onclick="document.getElementById('goHome').submit()">SafeFood
						Project</a>
				</form>
			</div>

			<c:choose>
				<c:when test="${sessionScope.ID.equals('null') }">
					<jsp:include page="befoLogin.jsp"></jsp:include>
				</c:when>
				<c:otherwise>
					<jsp:include page="successLogin.jsp"></jsp:include>
				</c:otherwise>
			</c:choose>

		</div>
	</div>
	<div class="navbar navbar-fixed-top">
		<div class="container" style="position: relative; height: 50px;">
			<ul class="nav centered"
				style="position: absolute; left: 50%; top: 0; transform: translate(-50%, 0);">

				<li>
					<form id="goNotice" action="/notice/noticeList" method="POST">
						<!-- <input type="hidden" name="action" value="member/memberEat.do"> --><a
							class="navbar-brand" style="color: #FFF"
							href="#" onclick="document.getElementById('goNotice').submit()">공지사항</a>
					</form></li>
				<li>
					<form id="goListForm" action="/food/search" method="post">
						<!-- <input type="hidden" name="action" value="food/list.do"> -->
						<a
							class="navbar-brand" id="goListButton" style="color: #FFF"
							href="#" onclick="document.getElementById('goListForm').submit()">식품
							목록</a>
					</form>
				</li>
				<c:choose>
				<c:when test="${not sessionScope.ID.equals('null') }">
					<li>
						<form id="goEatInfo" action="/member/memberEat" method="POST">
							<!-- <input type="hidden" name="action" value="member/memberEat.do"> --><a
								class="navbar-brand" style="color: #FFF"
								href="#" onclick="document.getElementById('goEatInfo').submit()">섭취정보</a>
						</form>
					</li>
				</c:when>
				</c:choose>
				<li>
					<form id="goQNAList" action="/qna/goQNAList" method="POST">
						<!-- <input type="hidden" name="action" value="member/memberEat.do"> --><a
							class="navbar-brand" style="color: #FFF"
							href="#" onclick="document.getElementById('goQNAList').submit()">QNA</a>
					</form>
				</li>
				
				<c:choose>
				<c:when test="${sessionScope.ID.equals('ssafy') }">
					<li><form id="goMemberAdmin" action="/member/memberAdmin" method="POST">
						<!-- <input type="hidden" name="action" value="member/admin.do"> --><a
							class="navbar-brand" id="goMemberAdminBtn" style="color: #FFF"
							href="#" onclick="document.getElementById('goMemberAdmin').submit()">회원관리</a>
					</form></li>
				</c:when>
			</c:choose>
			</ul>
		</div>
	</div>