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
<link href="${contextPath}/resources/css/style.css" rel="stylesheet">

<!--    Animate.css-->
<link href="${contextPath}/resources/css/animate.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="<%=request.getContextPath()%>/resources/fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet">

</head>
<body>

	<div class="weather-background animated fadeIn">
		<div class="fill <c:out value="${weatherBg.display}" />"
			style="background-image:url('${contextPath}/resources/img/weather/<c:out value="${weatherBg.url}" />');"></div>
	</div>

	<div class="detail-title animated bounceIn">
		<h1>
			<c:out value="${detailCity.name}" />
		</h1>
	</div>

	<div class="informations animated bounceIn">
		<div class="row ">
			<div class="col-lg-4 col-md-6 col-sm-7">
				<div class="title-temperature-details animated bounceIn">
					<p>
						<c:out value="${detailCity.temperature}" />
						&#8451;
					</p>
				</div>
			</div>
			<div class="col-lg-1 col-md-1 col-sm-1">
				<div class="title-time animated bounceIn"></div>
			</div>
			<div class="col-lg-4 col-md-5 col-sm-4">
				<div class="title-time-details animated bounceIn">
					<p>
						Humidity:
						<c:out value="${detailCity.humidity}" />
						%
					</p>
					<p>
						Pressure:
						<c:out value="${detailCity.pressure}" />
						mb
					</p>
					<p>
						<c:out value="${cityTimes.dateTime}" /> GMT0
					</p>
				</div>
			</div>

		</div>
	</div>

	<div class="row details-buttons">
		<div class=col-lg-3>
			<a href="<c:url value="/refresh/${detailCity.id}" />">
			<button type="button" class="btn btn-default btn-xl back-btn"
				aria-haspopup="true" aria-expanded="false">
				<i class="fa fa-refresh" aria-hidden="true"></i>
			</button>
			</a>
		</div>
		<div class=col-lg-3>
			<a href="<%=request.getContextPath()%>/addCity" />
			<button type="button" class="btn btn-default btn-xl back-btn"
				aria-haspopup="true" aria-expanded="false">
				<i class="fa fa-chevron-left" aria-hidden="true"></i> Back
			</button>
			</a>
		</div>
	</div>







	<!-- Footer -->
	<footer>
	<div class="row">
		<div class="col-lg-12">
			<p>Copyright &copy; Milos Davitkovic 2016</p>
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