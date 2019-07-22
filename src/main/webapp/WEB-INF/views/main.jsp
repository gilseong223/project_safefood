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

<title>Safe food</title>

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
<link href="/Resources/css/landing-page.min.css" rel="stylesheet">
<link href="/Resources/css/example.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.4.4.min.js"></script>

</head>

<body>
	<!-- Navigation -->
	<jsp:include page="navigation.jsp"></jsp:include>
	
	<br>
	<br>
	
	<div class="row justify-content-center">
		<div class="col-12 col-md-10 col-lg-8">
			<div class="row no-gutters align-items-center">
				<div class="col-1">
					<i class="fas fa-search h4 text-body"></i>
				</div>
				<!--end of col-->
				<form class="col-11" action="/food/search" id="searchForm">
					<!-- <input type="hidden" name="action" value="food/search.do"> -->
					<div class="row">
						<div class="col-10">
							<input name="searchbox"
								class="form-control form-control-lg form-control-borderless"
								type="search" placeholder="검색할 키워드를 입력해주세요">
						</div>
						<!--end of col-->
						<div class="col-1">
							<button type="submit" id="search" class="btn btn-lg btn-success">Search</button>
						</div>
					</div>
				</form>
				<!--end of col-->
			</div>
		</div>
		<!--end of col-->
	</div>
	
	<br>
	

	<!-- Masthead -->
	<header class="forbottonpadding text-white text-center">
		<img class="img-fluid" alt="safe food" src="/Resources/img/Safefood3.jpg">
	</header>

	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>

	<!-- Bootstrap core JavaScript -->
	<script src="/Resources/vendor/jquery/jquery.min.js"></script>
	<script src="/Resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
