<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="edu.ssafy.root.food.Food"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	Food food = (Food) request.getAttribute("food");
%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>예상 섭취정보</title>

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
<script src="http://code.jquery.com/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	drawChart();
	
	
	function drawChart() {
		var ctx = document.getElementById("doughnut-graph").getContext("2d");
		console.log(ctx)
		myChart = new Chart(ctx,{
		    type: 'doughnut',
		    data: {
		        labels: ["칼로리","탄수화물","단백질","지방","당류","나트륨","콜레스테롤","포화 지방산","트렌스지방"],
		        datasets: [{
		            label: '# of Votes',
		            data: [<%=food.getNutrient()[0] %>,
		            	<%=food.getNutrient()[2] %>,
		            	<%=food.getNutrient()[3] %>,
		            	<%=food.getNutrient()[4] %>,
		            	<%=food.getNutrient()[5] %>,
		            	<%=food.getNutrient()[6] %>,
		            	<%=food.getNutrient()[7] %>,
		            	<%=food.getNutrient()[8] %>,
		            	<%=food.getNutrient()[9] %>],
		            backgroundColor: [
		                'rgba(255, 99, 132, 0.2)',
		                'rgba(54, 162, 235, 0.2)',
		                'rgba(255, 206, 86, 0.2)',
		                'rgba(75, 192, 192, 0.2)',
		                'rgba(153, 102, 255, 0.2)',
		                'rgba(255, 159, 64, 0.2)',
		                'rgba(255, 153, 255, 0.2)',
		                'rgba(102, 0, 153, 0.2)',
		                'rgba(51, 0, 0, 0.2)'
		            ],
		            borderColor: [
		                'rgba(255, 99, 132, 1)',
		                'rgba(54, 162, 235, 1)',
		                'rgba(255, 206, 86, 1)',
		                'rgba(75, 192, 192, 1)',
		                'rgba(153, 102, 255, 1)',
		                'rgba(255, 159, 64, 1)',
		                'rgba(255, 153, 255, 1)',
		                'rgba(102, 0, 153, 1)',
		                'rgba(51, 0, 0, 1)'
		            ],
		            borderWidth: 1
		        }]
		    },
		    options: {
		        scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
		    }
		});
		
	}
});

</script>
<style type="text/css">


.form-control-borderless:hover, .form-control-borderless:active, .form-control-borderless:focus {
    border: none;
    outline: none;
    box-shadow: none;
}


</style>

<script type="text/javascript">
$(document).ready(function() {
	drawChart();
	drawGraph();
	set();
	$("#submit").on("click", function() {
		search();
		console.log(searchname);
	});
});
</script>

</head>
<body>

<!-- Navigation -->
	<div class="navbar navbar-primary navbar-fixed-top">

		<div class="container">
			<div class="navbar-header">
				<form action=".do" method="POST" id="goHome">
					<input type="hidden" name="action" value="main/main.do">
					<a class="navbar-brand" href="#" style="color: #FFF" onclick="document.getElementById('goHome').submit()">SafeFood Project</a>
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

				<li><a class="navbar-brand" style="color: #FFF" href="#">공지 사항</a></li>
				<li><form id="goListForm" action=".do" method="POST"><input type="hidden" name="action" value="food/list.do"><a class="navbar-brand" id="goListButton" style="color: #FFF" href="#" onclick="document.getElementById('goListForm').submit()">식품 목록</a></form></li>
				<li><a class="navbar-brand" style="color: #FFF" href="#">섭취정보</a></li>
			</ul>
		</div>
	</div>
	
	<div style="text-align: center"><h3>식품목록</h3></div>
	<div class="container">

		<!-- Portfolio Item Heading -->
		<h4 id="name" class="my-4">
			${sessionScope.ID } <small>님의 예상 섭취정보</small>
		</h4>

		<!-- Portfolio Item Row -->
		<div class="row">

			<div class="col-md-3">
				<img id="imagee" class="img-fluid" src="Resources/<%=food.getFimage() %>" alt="">
			</div>

			<div class="col-md-8">
				<P>이름!_!#!(!#%</P>)
				<P>수량1@!ㅑ#ㅓ@!ㅓ</P>
				<button class="btn btn-info">추가</button>
			</div>
		</div>
		<h3 class="row my-5">영양 정보</h3>
		<div class="row">
                 <div class="col-sm-6"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                  <canvas id="doughnut-graph" height="363" style="display: block; width: 474px; height: 363px;" width="474" class="chartjs-render-monitor"></canvas>
                </div>
                <div class="col-sm-6">
                  <table class="table">
	                <tbody>
	                
	                  <tr><td width="200">일일 제공량</td><td id="SERVING_WT"><%=food.getNutrient()[0] %></td></tr>
	                  <tr><td width="200">칼로리</td><td id="NUTR_CONT1"><%=food.getNutrient()[1] %></td></tr>
	                  <tr><td width="200">탄수화물</td><td id="NUTR_CONT2"><%=food.getNutrient()[2] %></td></tr>
	                  <tr><td width="200">단백질</td><td id="NUTR_CONT3"><%=food.getNutrient()[3] %></td></tr>
	                  <tr><td width="200">지방</td><td id="NUTR_CONT4"><%=food.getNutrient()[4] %></td></tr>
	                  <tr><td width="200">당류</td><td id="NUTR_CONT5"><%=food.getNutrient()[5] %></td></tr>
	                  <tr><td width="200">나트륨</td><td id="NUTR_CONT6"><%=food.getNutrient()[6] %></td></tr>
	                  <tr><td width="200">콜레스테롤</td><td id="NUTR_CONT7"><%=food.getNutrient()[7] %></td></tr>
	                  <tr><td width="200">포화 지방산</td><td id="NUTR_CONT8"><%=food.getNutrient()[8] %></td></tr>
	                  <tr><td width="200">트렌스지방</td><td id="NUTR_CONT9"><%=food.getNutrient()[9] %></td></tr>
	                  
	                 
	                </tbody>
	              </table>
                </div>
              </div>
	</div>
	
	
	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	
	<!-- Bootstrap core JavaScript -->
	<script src="/Resources/vendor/jquery/jquery.min.js"></script>
	<script src="/Resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>