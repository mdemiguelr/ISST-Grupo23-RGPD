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
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
	<body> 
	<shiro:user>
    Welcome back <shiro:principal />! Click <a href="LogoutServlet">here</a> to logout.
	</shiro:user>
		
		<div class="section-top-border">
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<h3 class="mb-30">Formulario</h3>
								<form action="#">
									<div class="mt-10">
										Nombre: ${ investigador.getName() }
									
									</div>
									<div class="mt-10">
										Apellidos: ${ investigador.getApellidos() }
									</div>
									<div class="mt-10">
										Email: ${ investigador.getEmail() }
									</div>
									<div class="mt-10">
										<input type="email" name="Título de la Solicitud" placeholder="Título de la Solicitud" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Título de la Solicitud'" required class="single-input">
									</div>
									<div class="input-group-icon mt-10">
										<div class="icon"><i class="fa fa-book" aria-hidden="true"></i></div>
										<div class="form-select" id="default-select"">
											<select>
												<option value="1">E.T.S de Arquitectura</option>
												<option value="1">E.T.S de Edificación</option>
												<option value="1">E.T.S de Ingeniería Aeronáutica y del Espacio</option>
												<option value="1">E.T.S de Ingeniería Agronómica, Alimentaria y de Biosistemas</option>
												<option value="1">E.T.S de Ingeniería de Montes, Forestal y del Medio Natural</option>
												<option value="1">E.T.S de Ingenieros de Caminos, Canales y Puertos</option>
												<option value="1">E.T.S de Ingenieros de Telecomunicación</option>
												<option value="1">E.T.S de Ingenieros Navales</option>
												<option value="1">E.T.S de Ingeniería de Montes, Forestal y del Medio Natural</option>
												<option value="1">INEF</option>
												<option value="1">E.T.S de Ingeniería Civil</option>
												<option value="1">E.T.S de Ingeniería y Diseño Industrial</option>
												<option value="1">E.T.S de Ingenieros de Minas y Energía</option>
												<option value="1">E.T.S de Ingenieros Industriales</option>
												<option value="1">E.T.S de Ingenieros Informáticos</option>
												<option value="1">E.T.S de Ingeniería de Sistemas Informáticos</option>
												<option value="1">E.T.S de Ingeniería y Sistemas de Telecomunicación</option>
												<option value="1">E.T.S de Ingenieros en Topografía, Geodesia y Cartografía</option>
											</select>
										</div>
									</div>
									
									
									<div class="mt-10">
										<input type="text" name="first_name" placeholder="Departamento" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Deprtamento'" required class="single-input-primary">
									</div>

									<div class="mt-10">
										<div class="form-group">
										<input type="file" class="filestyle" data-icon="false">
 									</div>
								
								</form>
							</div>
							
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	
	</body>
</html>