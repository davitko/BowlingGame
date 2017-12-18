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
    <link href="${contextPath}/resources/css/simulation.css" rel="stylesheet">

<title>Simulation</title>
</head>
<body>

	<header id="myCarousel" class="carousel slide"> <!-- Wrapper for Slides -->
	<div class="carousel-inner animated fadeIn">
		<div class="item active animated ">
			<!-- Set the first background image using inline CSS below. -->
			<div class="fill"
				 style="background-image: url('${contextPath}/resources/img/carousel/carouselPack2/1.jpg');"></div>
		</div>
		<div class="item animated ">
			<!-- Set the second background image using inline CSS below. -->
			<div class="fill"
				 style="background-image: url('${contextPath}/resources/img/carousel/carouselPack2/2.jpg');"></div>
		</div>
		<div class="item">
			<!-- Set the third background image using inline CSS below. -->
			<div class="fill"
				 style="background-image: url('${contextPath}/resources/img/carousel/carouselPack2/3.jpg');"></div>
		</div>
		<div class="item">
			<!-- Set the third background image using inline CSS below. -->
			<div class="fill"
				 style="background-image: url('${contextPath}/resources/img/carousel/carouselPack2/4.jpg');"></div>
		</div>
	</div>
	</header>
	<div class="title animated bounceIn">
		<div class="row ">
			<div
				class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 col-xs-10 col-xs-offset-1">
				<h1>Welcome to bowling game simulator</h1>
			</div>
		</div>
	</div>

	<!-- Page Content -->
	<div class="container-fluid ">
		<div class="addCity animated bounceIn">
			<div class="row">
				<div class="col-lg-12 col-md-12 ">
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
						<%--<thead>--%>
							<%--<tr>--%>
								<%--<th>City</th>--%>
								<%--<th>Country</th>--%>
								<%--<th>Temperature</th>--%>
								<%--<th>Humidity</th>--%>
								<%--<th>Pressure</th>--%>
								<%--<th>Details</th>--%>
								<%--<th>Remove</th>--%>
							<%--</tr>--%>
						<%--</thead>--%>
						<%--<tfoot>--%>
							<%--<tr>--%>
								<%--<th>City</th>--%>
								<%--<th>Country</th>--%>
								<%--<th>Temperature</th>--%>
								<%--<th>Humidity</th>--%>
								<%--<th>Pressure</th>--%>
								<%--<th>Details</th>--%>
								<%--<th>Remove</th>--%>
							<%--</tr>--%>
						<%--</tfoot>--%>
						<tbody>
							<c:forEach items="${players}" var="player">
                                <tr>
                                        <td>${player.name}:</td>
                                        <c:forEach items="${player.frames}" var="frame">
                                            <td>
                                                <%--<div class="frame">--%>
                                                    <div id="upper-part" class="col-lg-12 upper-part">
                                                        <div class="col-lg-6 left-upper">
                                                                ${frame.firstThrow}
                                                        </div>
                                                        <div class="col-lg-6 right-upper">
                                                                ${frame.secondThrow}
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-12 down-part">
                                                            ${frame.currentPlayerScore}
                                                    </div>
                                                <%--</div>--%>
                                            </td>
                                        </c:forEach>
                                        <td>
                                        <div class="col-lg-12 upper-part">
                                            <div class="col-lg-6 left-upper">
                                                    ${player.extraFrame.firstThrow}
                                            </div>
                                            <div class="col-lg-6 right-upper">
                                                    ${player.extraFrame.secondThrow}
                                            </div>
                                        </div>
                                        <div class="col-lg-12 down-part">
                                                ${player.extraFrame.currentPlayerScore}
                                        </div>
                                    </td>
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
		$(document).ready(function() {
			$('[data-toggle="popover"]').popover();
		});
	</script>

</body>
</html>