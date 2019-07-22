<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="edu.ssafy.root.food.Food"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	Food food = (Food) request.getAttribute("food");
	String[] labelList = {"칼로리","탄수화물","단백질","지방","당류","나트륨","콜레스테롤","포화지방산","트렌스지방"};
	double[] dailyNutri = {2500,300,54.5,53.3,100,2, 0.3,15,2};
%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>food Detail</title>

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
<script src="https://unpkg.com/vue"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.18.0/axios.js"></script>
<style type="text/css">


.form-control-borderless:hover, .form-control-borderless:active, .form-control-borderless:focus {
    border: none;
    outline: none;
    box-shadow: none;
}

.nutriFrame {
	margin: auto;
}

.capsule {
	display: inline-block!important;
	width: 100px;
	height: 200px;
	border: 3px solid rgba(253, 148, 131, 1);
	-webkit-border-radius: 50px;
	-moz-border-radius: 50px;
	border-radius: 50px;
	color: white;
	margin-left: 7px;
	margin-right: 7px;
	margin-bottom: 20px;
}

.circle {
	position: relative;
	margin-top:5px;
	margin-left:5px;
	width: 85px;
	height: 85px;
	background: rgba(253, 148, 131, 1);
	-moz-border-radius: 50%;
	-webkit-border-radius: 50%;
	border-radis: 50%;
	font-weight:bold;
	font-size: 1.3rem;
	padding-top: 22px;
	text-align: center;
}

.nutri {
	color : rgba(253, 148, 131, 1);
	margin-top: 5px;
	text-align:center;
	font-weight: bold;
	font-size: 1.1rem;
}

.halfCircle {
	color : white;
	margin-top: 27px;
	margin-left: 5px;
	text-align:center;
	font-weight: bold;
	font-size: 1.3rem;
	height: 38px;
	width: 84px;
	border-radius: 0 0 84px 84px;
	-moz-border-radius: 0 0 84px 84px;
	-webkit-border-radius: 0 0 84px 84px;
	background: rgba(253, 148, 131, 1);
}


#fname {
	padding-top: 40px;
	font-size: 48px;
}

#maker {
	display:inline-block;
	padding-right: 15px;
}

#ingredient {
	border-top: 1px solid black;
	padding-top: 10px;
}

.drawTopLine {
	border-top: 1.7px solid black;
	padding-top: 10px;
}

.subTitle {
	font-size: 18px;
	margin-bottom: 0.2rem!important;
}

.contentsFont {
	letter-spacing: 0px;
	word-spacing: 1px;
}

#detailTitle {
	position: relative;
	left: -15px;
	margin-bottom: 1.2rem!important;
}

.decWidth {
	width: 971px;
	min-width: auto;
}

.warp-if {
	width: 1100px;
	margin: auto;
}

.Oriposition {
	margin-left: 0px!important;
}

.table td{
	margin-right: 15px!important;
}

#hiddenP{
	display: none;
}
.foodImg {
	height: 333px;
	width: 243px;
	left: 30px;
}
</style>

<script type="text/javascript">
$(document).ready(function() {
	$("#submit").on("click", function() {
		search();
		console.log(searchname);
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
		
		$("#detail-form").attr("action", "/member/addProduct");
		$("#detail-form").submit();
	});
});

</script>

</head>
<body>

<!-- Navigation -->
	<jsp:include page="navigation.jsp"></jsp:include>
	
	<div id="mainFrame" class="contentsFont warp-if">
		<div class="layer-cont">
		<!-- Portfolio Item Heading -->
		<h3 id="layer-tit" class="my-4">상세보기</h3>

		<!-- Portfolio Item Row -->
		<div class="row drawTopLine">

			<div class="col-md-6">
				<img id="imagee" class="img-fluid" src="/Resources/<%=food.getFimage() %>" alt="">
			</div>

			<div class="col-md-6">
				<input type="hidden" id="curFcode" value="<%=food.getFcode() %>">
				<p id="fname"><%= food.getFname() %></p> 
				<h3 id="maker" class="subTitle">제조사</h3>
				<span id="corporation"><%= food.getFmaker() %></span>
				<h3 class="my-3 subTitle">원재료</h3>
				<p id="ingredient"><%= food.getFmaterial() %></p>
				<hr>
				
				<h3 class="my-3 subTitle">알레르기 성분</h3>
				<%-- <p id="hiddenP" v-model="curfCode"><%=food.getFcode() %></p> --%>
				<p v-html="allergy"></p>
				
				<form id="detail-form" action="detail" method="post">
					<input type="hidden" name="code" id="code" value="">
					<input type="hidden" name="btnId" id="btnId" value="">
					<!-- <input type="hidden" name="action" id="address" value="/food/detail.do"> -->
					<div class="row" id="foodlist">

						<div id='<%=food.getFcode()%>' class='col-md-3 col-sm-6 mb-4'>
								<c:choose>
									<c:when test="${sessionScope.ID.equals('null') }">

									</c:when>
									<c:otherwise>
										<ul class="list-unstyled" style="display:inline-block;">
											<li class="dropdown"><button type="button" class="dropdown-toggle btn btn-primary"
												data-toggle="dropdown" style="color: #fff"> 추가<b class="caret"></b></button>
												<div class="dropdown-menu pd10 right" style="min-width: 260px" id="<%=food.getFcode()%>">
													<input type="number" id="fCnt" name="fCnt" style="display:block" value="1">
													<button id="eat1" type="button" class="btn btn-info eating" style="margin-left: 5%; margin-top:5%">아침</button>
													<button id="eat2" type="button" class="btn btn-info eating" style="margin-left: 5%; margin-top:5%">점심</button>
													<button id="eat3" type="button" class="btn btn-info eating" style="margin-left: 5%; margin-top:5%">저녁</button>
												</div>
											</li>
										</ul>

										<button type="button" class="btn btn-info zzim" style="margin-left: 10px">찜</button>
									</c:otherwise>
								</c:choose>
							</div>
					</div>
				</form>
			</div>
		</div>
		
		<!-- 영양 정보 -->
		<h3 class="row Oriposition" style="padding:30px 0px 15px 0px">영양 정보</h3>
		<div id="nutriFrame">
		
		<% for(int i=0; i<9; i++){ %>
			<div class='capsule'>
			<div class="circle"><%=food.getNutrient()[i+1] %></div>
			<div class="nutri"><%=labelList[i] %></div>
			<div class="halfCircle">
				<% 
					double dul = food.getNutrient()[i+1] / dailyNutri[i] * 100;
					String format = "#.#";
					java.text.DecimalFormat df = new java.text.DecimalFormat(format);
					out.println(df.format(dul));
				%>
				<%-- <%=food.getNutrient()[i+1] / dailyNutri[i] * 100 %> --%>%
			</div>
		</div>		
		<% } %>
		
    </div>
     <div>
    	<h3 class="row Oriposition" style="padding:30px 0px 15px 0px">추천 음식</h3>
    	<div class="row">
    		<!-- 추천음식 4개 정렬 -->
			 <c:forEach items="${recommendedFoods}" var="recommendedFood">				
				<div class='col-md-3 col-sm-6 mb-4' style="float: left;">
					<div class='hover ehover3'>
						<img class='foodImg'
							src='/Resources/${recommendedFood.fimage }' alt='${recommendedFood.fname }'>
						<div class='overlay'>
							<h2>${recommendedFood.fname }</h2>
							<button type="button" class='info'
								data-code="${recommendedFood.fcode }" data-toggle='modal'
								data-target='#modal3' onclick="location.href='/food/detail?code=${recommendedFood.fcode }'">상세보기</button>
						</div>
					</div>
				</div> 
			</c:forEach>
    	</div>
    </div> 
	</div>
	</div>
	
	<script type="text/javascript">
		var app = new Vue({
			el : '#mainFrame',
			data : {
				allergy : [],
				foodMaterial : '',
				foodNutrient : [], 
				curFcode : <%=food.getFcode() %>
			},
			mounted () {
				 axios
		          .post('/food/getFood/' + this.curFcode)
		          .then(function(response) {
		        	  app.allergy = response.data.allergy;
		        	  app.foodMaterial = response.data.foodMaterial;
		        	  app.foodNutrient = response.data.foodNutrient;
		          })
		          .catch(error => {
		            console.log(error)
		            this.errored = true
		          })
		          .finally(() => this.loading = false)
			}
		})
	</script>
	
	
	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	
	<!-- Bootstrap core JavaScript -->
	<script src="/Resources/vendor/jquery/jquery.min.js"></script>
	<script src="/Resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>