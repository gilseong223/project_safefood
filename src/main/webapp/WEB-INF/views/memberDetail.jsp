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

<title>Member Nutrient Detail</title>

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
		            data: [
		            	${nutriSum[0] },
		            	${nutriSum[1] },
		            	${nutriSum[2] },
		            	${nutriSum[3] },
		            	${nutriSum[4] },
		            	${nutriSum[5] },
		            	${nutriSum[6] },
		            	${nutriSum[7] },
		            	${nutriSum[8] }],
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
	<jsp:include page="navigation.jsp"></jsp:include>
	
	<div class="container">

		<!-- Portfolio Item Heading -->
		<h3 id="name" class="my-4">
			${sessionScope.ID} <small>의 섭취정보</small>
		</h3>
		<!-- Portfolio Item Row -->
		<div class="row">
				<table border="1">
	<tr><th>음식 코드 </th><th>음식명</th><th>섭취 일시</th><th>섭취 시간</th><th>수량</th><th>삭제하기</th></tr>
	<c:forEach items="${ detailList }" var="li" begin="0">
	<tr>
		<td>${li.fcode }</td>
		<td>${li.fname }</td>
		<td>${li.date }</td>
		<td><c:choose>
				<c:when test="${li.time == 1 }">
					아침
				</c:when>
				<c:otherwise>
					<c:choose>
					<c:when test="${li.time == 2 }">
						점심
					</c:when>
					<c:otherwise>
						저녁
					</c:otherwise>
					</c:choose>
				</c:otherwise>
		</c:choose>
		</td>
		<td>${li.cnt }</td>
		<td><form id="${status.index }" action="/member/detailDelete" method="POST">
					<!-- 	<input type="hidden" name="action" value="member/detailDelete.do"> -->
						<input type="hidden" name="deleted" value="${li.fcode }.${li.date}.${li.time}">
						<input type="submit" value="삭제하기">
					</form></td>
	</tr>
	</c:forEach>
	</table>
		</div>
		<h3 class="row my-5">영양 정보 합계</h3>
		<div class="row">
                 <div class="col-sm-6"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                  <canvas id="doughnut-graph" height="363" style="display: block; width: 474px; height: 363px;" width="474" class="chartjs-render-monitor"></canvas>
                </div>
                <div class="col-sm-6">
                  <table class="table">
	                <tbody>
	                
	                  <tr><td width="200">칼로리</td><td id="SERVING_WT">${nutriSum[0] }</td></tr>
	                  <tr><td width="200">탄수화물</td><td id="NUTR_CONT1">${nutriSum[1] }</td></tr>
	                  <tr><td width="200">단백질</td><td id="NUTR_CONT2">${nutriSum[2] }</td></tr>
	                  <tr><td width="200">지방</td><td id="NUTR_CONT3">${nutriSum[3] }</td></tr>
	                  <tr><td width="200">당류</td><td id="NUTR_CONT4">${nutriSum[4] }</td></tr>
	                  <tr><td width="200">나트륨</td><td id="NUTR_CONT5">${nutriSum[5] }</td></tr>
	                  <tr><td width="200">콜레스테롤</td><td id="NUTR_CONT6">${nutriSum[6] }</td></tr>
	                  <tr><td width="200">포화 지방산</td><td id="NUTR_CONT7">${nutriSum[7] }</td></tr>
	                  <tr><td width="200">트렌스지방</td><td id="NUTR_CONT8">${nutriSum[8] }</td></tr>
	                  
	                 
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