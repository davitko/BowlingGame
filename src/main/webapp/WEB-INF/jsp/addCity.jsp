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
<link
	href="<%=request.getContextPath()%>/resources/fonts/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">


<title>Insert title here</title>
</head>
<body>

	<header id="myCarousel" class="carousel slide"> <!-- Wrapper for Slides -->
	<div class="carousel-inner animated fadeIn">
		<div class="item active animated ">
			<!-- Set the first background image using inline CSS below. -->
			<div class="fill"
				style="background-image: url('${contextPath}/resources/img/carousel/carouselPack<c:out value="${carouselPack.index}"/>/<c:out value="${carouselPack.summer}"/>');"></div>
			<!--
            <div class="carousel-caption">
    <h2>Summer</h2>
</div>
-->
		</div>
		<div class="item animated ">
			<!-- Set the second background image using inline CSS below. -->
			<div class="fill"
				style="background-image: url('${contextPath}/resources/img/carousel/carouselPack<c:out value="${carouselPack.index}"/>/<c:out value="${carouselPack.autumn}"/>');"></div>
			<!--
                <div class="carousel-caption">
                    <h2>Autumn</h2>
                </div>
-->
		</div>
		<div class="item">
			<!-- Set the third background image using inline CSS below. -->
			<div class="fill"
				style="background-image: url('${contextPath}/resources/img/carousel/carouselPack<c:out value="${carouselPack.index}"/>/<c:out value="${carouselPack.winter}"/>');"></div>
			<!--
                <div class="carousel-caption">
                    <h2>Winter</h2>
                </div>
-->
		</div>
		<div class="item">
			<!-- Set the third background image using inline CSS below. -->
			<div class="fill"
				style="background-image: url('${contextPath}/resources/img/carousel/carouselPack<c:out value="${carouselPack.index}"/>/<c:out value="${carouselPack.spring}"/>');"></div>
			<!--
                <div class="carousel-caption">
                    <h2>Spring</h2>
                </div>
-->
		</div>
	</div>
	</header>

	<div class="weather-background animated fadeIn">
		<%--          <c:out value="${weatherBg.display}"--%>
		<%--          <c:out value="${'weather-background-hide'}"/> --%>
		<%--          <%= request.getParameter("weather-background-hide") %> --%>

		<div class="fill <c:out value="${weatherBg.display}" />"
			style="background-image:url('${contextPath}/resources/img/weather/<c:out value="${weatherBg.url}" />');"></div>

	</div>

	<div class="title animated bounceIn">
		<div class="row ">
			<div
				class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 col-xs-10 col-xs-offset-1">
				<h1>Welcome to weather map</h1>
			</div>
		</div>
	</div>

	<!-- 	<div class="informations animated bounceIn"> -->
	<!-- 		<div class="row "> -->
	<!-- 			<div class="col-lg-2 col-md-4 col-sm-6"> -->
	<!-- 				<div class="title-temperature animated bounceIn"> -->
	<!-- 					<p>4 &#8451;</p> -->
	<!-- 				</div> -->
	<!-- 			</div> -->
	<!-- 			<div class="col-lg-2 col-md-4 col-sm-6"> -->
	<!-- 				<div class="title-cityName animated bounceIn"> -->
	<!-- 					<p>Berlin</p> -->
	<!-- 				</div> -->
	<!-- 			</div> -->
	<!-- 			<div class="col-lg-2 col-md-4 col-sm-6"> -->
	<!-- 				<div class="title-time animated bounceIn"> -->
	<!-- 					<p>03 a.m.</p> -->
	<!-- 				</div> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<!-- 	</div> -->

	<!-- Page Content -->
	<div class="container-fluid ">
		<div class="addCity animated bounceIn">
			<div class="row">
				<div class="col-lg-12 col-md-12 ">
					<c:url var="addAction" value="/addCity/add"></c:url>
					<%-- <form:form action="${addAction}" commandName="warehouse" method="POST"> --%>
					<!-- 					<form role="form" -->
					<%-- 						action="${addAction}?${_csrf.parameterName}=${_csrf.token}" --%>
					<!-- 						commandName="city" method="POST"> -->
					<%-- 						<form role="form" action="${addAction}"commandName="city" method="POST"> --%>
					<form role="form" action="${addAction}" commandName="city"
						method="POST">
						<div class="row">
							<div
								class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-3 col-sm-5 col-sm-offset-2 col-xs-6">
								<div class="form-group">
									<input class="form-control addCityStyle" name="name"
										id="message" placeholder="City Name" type="text" />
									<p class="text-danger validation-messaage">
										<c:out value="${validationCity.validationMessage}" />
									</p>
								</div>
							</div>
							<div
								class="col-lg-3 col-lg-offset-1 col-md-4 col-md-offset-1 col-sm-5 col-xs-6 recommended-cities <c:if test="${validationCity.recommendedCities eq null}">hide</c:if> />">
								<h4>Maybe you mean:</h4>
								<c:forEach items="${validationCity.recommendedCities}"
									var="recommendCity">
									<a
										href="<c:url value="/addRecommendedCity/${recommendCity}" />">
										<div>${recommendCity}</div>
									</a>
								</c:forEach>

							</div>

							<div class="clearfix"></div>
							<div class="col-lg-12 text-center">
								<div id="success"></div>
								<input type="submit"
									class="btn btn-xl submit-add addWarehouseStyle" value="add" />
							</div>
						</div>
					</form>

				</div>
			</div>

		</div>
		<div class="delimiter">
			<div class="row ">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<!--                        <img src="img/line.png" class="delimiter-img">-->
					<p></p>
				</div>
			</div>
		</div>
		<div class="table-responsive">
			<div class="row table-row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<table id="example"
						class="table table-bordered table-striped table-condensed table-hover"
						cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>City</th>
								<th>Country</th>
								<th>Temperature</th>
								<th>Humidity</th>
								<th>Pressure</th>
								<th>Details</th>
								<th>Remove</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>City</th>
								<th>Country</th>
								<th>Temperature</th>
								<th>Humidity</th>
								<th>Pressure</th>
								<th>Details</th>
								<th>Remove</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${cities}" var="city">
								<tr>
									<td>${city.name}</td>
									<td>${city.country}</td>
									<td>${city.temperature}&#8451;</td>
									<td>${city.humidity}%</td>
									<td>${city.pressure}mb</td>
									<td><a href="<c:url value="/details/${city.id}" />"><button
												type="button" class="btn btn-success" aria-haspopup="true"
												aria-expanded="false">
												<i class="fa fa-info"></i>
											</button></a></td>
									<td><a href="<c:url value="/softRemove/${city.id}" />"><button
												type="button" class="btn btn-danger " aria-haspopup="true"
												aria-expanded="false">
												<i class="fa fa-trash-o"></i>
											</button></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<hr>



	</div>
	<!-- /.container -->

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
		$(document).ready(function() {
			$('[data-toggle="popover"]').popover();
		});
	</script>





</body>
</html>