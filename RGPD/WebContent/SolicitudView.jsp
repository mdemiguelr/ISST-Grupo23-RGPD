<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<title>RGPD</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">

<link rel="stylesheet" href="css/linearicons.css">
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/nice-select.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/main.css">

<script type="text/javascript"
	src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap-filestyle.min.js"> </script>
<!--===============================================================================================-->
</head>
<body>
	<header id="header" id="home">

		<div class="container">
			<div class="row align-items-center justify-content-between d-flex">
				<div id="logo">
					<a href="index.html"><img src="img/logo.png" alt="" title="" /></a>
				</div>
				<nav id="nav-menu-container">
					<ul class="nav-menu">
						<li class="menu-active">
							<form action="InvestigadorServlet" method="get">
								<input type="hidden" name="email" value="${investigador.email}" />
								<button type="submit">Mis Solicitudes</button>
							</form>
						</li>
						<li>
							<form action="NuevaSolicitudServlet" method="get">
								<input type="hidden" name="emailInv"
									value="${investigador.email}" />
								<button type="submit">Nueva Solicitud</button>
							</form>
						</li>
						<li><form action="LogoutServlet" method="get">
								<button type="submit">Salir</button>
							</form></li>
					</ul>
				</nav>
				<!-- #nav-menu-container -->
			</div>
		</div>
	</header>
	<!-- #header -->
	<div class="section-top-border">
		<div class="row">
			<div class="col-lg-12 col-md-12">
				<h3 class="mb-30">Formulario</h3>
				<div class="mt-10">Nombre: ${ investigador.getNombre() }</div>
				<div class="mt-10">Apellidos: ${ investigador.getApellidos() }
				</div>
				<div class="mt-10">Email: ${ investigador.getEmail() }</div>
				<form action="CrearSolicitudServlet" method="post"
					enctype="multipart/form-data">

					<div class="mt-10">
						<input type="text" name="titulo"
							placeholder="Título de la Solicitud"
							onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'Título de la Solicitud'" required
							class="single-input">
					</div>
					<div class="input-group-icon mt-10">
						<div class="icon">
							<i class="fa fa-book" aria-hidden="true"></i>
						</div>
						<div class="form-select" id="default-select">
							<select name="escuela">
								<option value="1">E.T.S de Arquitectura</option>
								<option value="2">E.T.S de Edificación</option>
								<option value="3">E.T.S de Ingeniería Aeronáutica y del
									Espacio</option>
								<option value="4">E.T.S de Ingeniería Agronómica,
									Alimentaria y de Biosistemas</option>
								<option value="5">E.T.S de Ingeniería de Montes,
									Forestal y del Medio Natural</option>
								<option value="6">E.T.S de Ingenieros de Caminos,
									Canales y Puertos</option>
								<option value="7">E.T.S de Ingenieros de
									Telecomunicación</option>
								<option value="8">E.T.S de Ingenieros Navales</option>
								<option value="9">E.T.S de Ingeniería de Montes,
									Forestal y del Medio Natural</option>
								<option value="10">INEF</option>
								<option value="11">E.T.S de Ingeniería Civil</option>
								<option value="12">E.T.S de Ingeniería y Diseño
									Industrial</option>
								<option value="13">E.T.S de Ingenieros de Minas y
									Energía</option>
								<option value="14">E.T.S de Ingenieros Industriales</option>
								<option value="15">E.T.S de Ingenieros Informáticos</option>
								<option value="16">E.T.S de Ingeniería de Sistemas
									Informáticos</option>
								<option value="17">E.T.S de Ingeniería y Sistemas de
									Telecomunicación</option>
								<option value="18">E.T.S de Ingenieros en Topografía,
									Geodesia y Cartografía</option>
							</select>
						</div>
					</div>

					<div class="mt-10">
						<input type="text" name="departamento" placeholder="Departamento"
							onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'Departamento'" required
							class="single-input-primary">
					</div>

					<div class="mt-10">

						<input type="file" name="file" class="filestyle" data-icon="false"
							class="genric-btn info radius">
					</div>
					<div class="container border-top-generic">
						<div class="button-group-area"></div>
					</div>

					<input type="hidden" name="emailInv"
						value="${investigador.getEmail()}" />
					<button type="submit" class="genric-btn info-border radius">Enviar</button>

				</form>


				<form action="InvestigadorServlet" method="get">

					<button type="submit" class="genric-btn info-border radius">Cancelar</button>

				</form>
			</div>

		</div>

		<script src="js/vendor/jquery-2.2.4.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
			integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
			crossorigin="anonymous"></script>
		<script src="js/vendor/bootstrap.min.js"></script>
		<script type="text/javascript"
			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
		<script src="js/easing.min.js"></script>
		<script src="js/hoverIntent.js"></script>
		<script src="js/superfish.min.js"></script>
		<script src="js/jquery.ajaxchimp.min.js"></script>
		<script src="js/jquery.magnific-popup.min.js"></script>
		<script src="js/owl.carousel.min.js"></script>
		<script src="js/jquery.sticky.js"></script>
		<script src="js/jquery.nice-select.min.js"></script>
		<script src="js/parallax.min.js"></script>
		<script src="js/mail-script.js"></script>
		<script src="js/main2.js"></script>
</body>
</html>