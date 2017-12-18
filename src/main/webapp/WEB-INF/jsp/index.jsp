<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="weather-background-hide" value="${weatherBg.display}" />
<c:set var="weather-background-img" value="${weatherBg.url}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Weather App</title>

<!--    Font -->
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Aref+Ruqaa"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Fjalla+One"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Dosis"
	rel="stylesheet">

<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Table CSS -->
<link
	href="${contextPath}/resources/css/table/dataTables.bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${contextPath}/resources/css/full-slider.css"
	rel="stylesheet">

<!--    Animate.css-->
<link href="${contextPath}/resources/css/animate.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="<%=request.getContextPath()%>/resources/fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet">

	<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/simulation.css" rel="stylesheet">


<title>Bowling game</title>
</head>
<body>

	<header id="myCarousel" class="carousel slide"> <!-- Wrapper for Slides -->
	<div class="carousel-inner animated fadeIn">
		<div class="item active animated ">
			<!-- Set the first background image using inline CSS below. -->
			<div class="fill"
				style="background-image: url('${contextPath}/resources/img/carousel/carouselPack1/1.jpg');"></div>
		</div>
		<div class="item animated ">
			<!-- Set the second background image using inline CSS below. -->
			<div class="fill"
				style="background-image: url('${contextPath}/resources/img/carousel/carouselPack1/2.jpg');"></div>
		</div>
		<div class="item">
			<!-- Set the third background image using inline CSS below. -->
			<div class="fill"
				style="background-image: url('${contextPath}/resources/img/carousel/carouselPack1/3.jpg');"></div>
		</div>
		<div class="item">
			<!-- Set the third background image using inline CSS below. -->
			<div class="fill"
				style="background-image: url('${contextPath}/resources/img/carousel/carouselPack1/4.jpg');"></div>
		</div>
	</div>
	</header>

	<div class="weather-background animated fadeIn">
		<div class="fill <c:out value="${weatherBg.display}" />"
			style="background-image:url('${contextPath}/resources/img/weather/<c:out value="${weatherBg.url}" />');"></div>
	</div>

	<div class="title-index animated bounceIn">
		<div class="row ">
			<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 title-index-text">
				<h1>Welcome to Bowling game</h1>
			</div>
		</div>
	</div>

	<!-- Page Content -->
	<div class="container-fluid-index ">
		<div class="addCity animated bounceIn">
			<div class="row">
				<div class="col-lg-12 col-md-12 ">
							<div class="col-lg-4 col-lg-offset-2 col-md-6 col-md-offset-2 col-sm-12">
							<div class="clearfix"></div>
							<div class="col-lg-12 text-center">
									<a href="<%=request.getContextPath()%>/simulation/"/>
    <button type="button" class="btn btn-default btn-xl submit-add  add-index" aria-haspopup="true" aria-expanded="false">
		<i class="fa fa-plus-square" aria-hidden="true"></i> Start Game Simulation</button></a>
							</div>
						</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer>
	<div class="row">
		<div class="col-lg-12">
			<p>Copyright &copy; Milos Davitkovic 2017</p>
		</div>
	</div>
	<!-- /.row --> </footer>

	<!-- jQuery -->
	<script src="${contextPath}/resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

	<!-- Table JavaScript -->
	<script
		src="${contextPath}/resources/js/table/dataTables.bootstrap.min.js"></script>
	<script
		src="${contextPath}/resources/js/table/jquery.dataTables.min.js"></script>

	<!-- Script to Activate the Carousel -->
	<script>
		$(document).ready(function() {
			$('#example').DataTable();
		});
		$('.carousel').carousel({
			interval : 10000
		//changes the speed
		})
	</script>
</body>
</html>