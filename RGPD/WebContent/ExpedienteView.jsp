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
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
	<header id="header" id="home">          
          <div class="container">
            <div class="row align-items-center justify-content-between d-flex">
              <div id="logo">
                <a href="index.html"><img src="img/logo.png" alt="" title="" /></a>
              </div>
              <nav id="nav-menu-container">
                <ul class="nav-menu">
                  <li class="menu-active">
                  	<form action="ExpertoServlet" method="get">
						<input type="hidden" name="email" value="${experto.email}" />
			    		<button type="submit">Mis Expedientes</button>
					</form>
                  </li>
                  <li><form action="LogoutServlet" method="get">
			    		<button type="submit">Salir</button>
					</form>
				  </li>
                 </ul>
              </nav><!-- #nav-menu-container -->            
            </div>
          </div>
        </header><!-- #header -->
		<div class="section-top-border">
            <h3 class="mb-30">Expediente</h3>
            <div class="progress-table-wrap">
              <div class="progress-table">
                
                <div class="table-row">
                  <div class="country"> Nombre </div>
                  <div class="visit">${ solicitud.getInvestigador().getNombre() }</div>
                  
                </div>
                <div class="table-row">
                  <div class="country"> Apellidos</div>
                  <div class="visit">${ solicitud.getInvestigador().getApellidos() }</div>
                  
                </div>
                <div class="table-row">
                  <div class="country"> Email</div>
                  <div class="visit">${ solicitud.getInvestigador().getEmail() }</div>
                  
                </div>
                <div class="table-row">
                  <div class="country"> Centro</div>
                  <div class="visit">${ solicitud.getEscuela() }</div>
                  
                </div>
                
                <div class="table-row">
                  <div class="country"> Departamento</div>
                  <div class="visit">${ solicitud.getDepartamento() }</div>
                  
                </div>
                <div class="table-row">
                  <div class="country"> Título de la solicitud</div>
                  <div class="visit">${ solicitud.getTitulo() }</div>
                  
                </div>
                <div class="table-row">
                  <div class="country"> Fecha de Creación</div>
                  <div class="visit">${ solicitud.getFechaCreacion() }</div>
                  
                </div>
                <div class="table-row">
                  
                  
                  <form action="ServeFileServlet" method="get">
                  		<div class="country"> Memoria</div>
                  		<div class="visit">
                  			<input type="hidden" name="id" value="${solicitud.getId()}" />
			    			<button type="submit">Descargar</button>
                  		</div>
				</form>
                </div>
                <c:if test="${solicitud.estado == 0}">
                <form action="ValidarServlet" method="post">
						<input type="hidden" name="idSol" value="${solicitud.getId()}" />
						<input type="hidden" name="email" value="${experto.getEmail()}" />
						<button type="submit" class="btn btn-outline-success">Validar</button>
				</form>
				<form action="DenegarServlet" method="post">
						<input type="hidden" name="idSol" value="${solicitud.getId()}" />
						<input type="hidden" name="email" value="${experto.getEmail()}" />
						<button type="submit" class="btn btn-outline-danger">Denegar</button>
				</form>
				</c:if>
                
              </div>
            </div>
          </div>
	
	</body>
</html>