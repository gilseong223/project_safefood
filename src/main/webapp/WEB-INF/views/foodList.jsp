<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,edu.ssafy.root.food.Food"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	ArrayList<Food> list = (ArrayList<Food>) request.getAttribute("list");
	String keyword = (String) request.getAttribute("keyword");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>food list</title>

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
<script type="text/javascript">
$(function() {
	
	$(".info").on("click", function(e) {
		var code = $($(e.target)[0]).data("code");
		$("#code").attr("value", code);
		$("#detail-form").attr("action", "/food/detail");
		$("#detail-form").submit();
	});
	
	$(".zzim").on("click", function(e) {
		var code = $($(e.target)[0]).data("code");
		$("#code").attr("value", code);
		$("#detail-form").submit();
	});
	
	$(".eating").on("click", function(e){
		var code = $(this).closest("div").attr("id");
		$("#code").attr("value", code);
		
		var btnType = $(this).attr("id");
		console.log($(this));
		
		var btnId = 0;
		if(btnType == "eat1") btnId = 1;
		else if(btnType == "eat2") btnId = 2;
		else if(btnType == "eat3") btnId = 3;
		
		var fCnt = $(this).parent().children().first().val();

		var keyword = '${keyword }';
		if(keyword != null){
			$("#searchbox").attr("value", keyword);
			$("#btnId").attr("value", btnId);
			$("#fCnt").attr("value", fCnt);
		}
		
		alert("추가되었습니다.");
		$("#detail-form").attr("action", "/member/addProduct?keyword="+keyword);
		$("#detail-form").submit();
	});
});
</script>

<style type="text/css">
.foodImg {
	height: 333px;
	width: 243px;
	left: 30px;
}
</style>
</head>
<body>

	<!-- Navigation -->
	<jsp:include page="navigation.jsp"></jsp:include>

	<!-- /.row -->

	<div class="row justify-content-center" style="padding-top: 20px;">
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
							<input name="searchbox" id="searchbox"
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

	<div class="container">
		<section class="my-4">
			<h3>식품 목록</h3>

			<div class="row">

				<form id="detail-form" action="/member/detail" method="post">
					<input type="hidden" name="code" id="code" value="">
					<input type="hidden" name="btnId" id="btnId" value="">
					<!-- <input type="hidden" name="action" id="address" value="/food/detail.do"> -->
					<div class="row" id="foodlist">

						<%
							for (int i = 0, len = list.size(); i < len; i++) {
						%>
						<div id='<%=i%>' class='col-md-auto col-sm-6'>
								<div class='hover ehover3' style="margin-right:40px; margin-bottom:20px;">
									<img class='foodImg'
										src='/Resources/<%=list.get(i).getFimage()%>' alt='foodImage'>
									<div class='overlay'>
										<h2><%=list.get(i).getFname()%></h2>
										<button type="button" class='info'
											data-code="<%=list.get(i).getFcode()%>" data-toggle='modal'
											data-target='#modal3'>상세보기</button>
									
								
											<c:choose>
											<c:when test="${sessionScope.ID.equals('null') }"></c:when>
											<c:otherwise>
												<div class="btn-group" role="group" aria-label="btn group">
													<ul class="list-unstyled additionalBtn" style="display: inline-block;">
														<li class="dropdown">
															<button type="button"
																class="info2 dropdown-toggle btn btn-rounded"
																data-toggle="dropdown" style="color: #fff"><i class="fas fa-heart fa-sm pr-2" aria-hidden="true"></i>추가<b class="caret"></b>
															</button>
															<div class="dropdown-menu toomyeong" style="min-width: 260px" id="<%=list.get(i).getFcode()%>">
																<input type="number" id="fCnt" name="fCnt" style="display: block; margin-left:15px; width:60px" value="1">
																<button id="eat1" type="button" class="btn btn-info eating" style="margin-left: 5%; margin-top: 5%; background-color:#00f9cc; font-weight:bold;">아침</button>
																<button id="eat2" type="button" class="btn btn-info eating" style="margin-left: 5%; margin-top: 5%; background-color:#00f9cc;; font-weight:bold;">점심</button>
																<button id="eat3" type="button" class="btn btn-info eating" style="margin-left: 5%; margin-top: 5%; background-color:#00f9cc;; font-weight:bold;">저녁</button>
															</div>
														</li>
													</ul>
			
													<button type="button" class="info2 btn btn-rounded zzim additionalBtn" style="margin-left: 10px">
														<i class="fas fa-star fa-sm pr-2" aria-hidden="true"></i>찜
													</button>
												</div>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
						</div>
						<%
							}
						%>
					</div>
				</form>

			</div>
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
			<script src="/Resources/js/bootstrap.min.js"></script>
		</section>
	</div>

	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>

	<!-- Bootstrap core JavaScript -->
	<script src="/Resources/vendor/jquery/jquery.min.js"></script>
	<script src="/Resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>