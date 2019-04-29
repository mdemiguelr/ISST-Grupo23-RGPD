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
                  	<form action="InvestigadorServlet" method="get">
						<input type="hidden" name="email" value="${investigador.email}" />
			    		<button type="submit">Mis Solicitudes</button>
					</form>
                  </li>
                  <li>
                  	<form action="NuevaSolicitudServlet" method="get">
						<input type="hidden" name="emailInv" value="${investigador.email}" />
			    		<button type="submit">Nueva Solicitud</button>
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
        <c:if test="${investigador.getSolRealizadas().size() == 0}">
			<p> Todavía no ha realizado ninguna solicitud, si desea crear una pulse en 'Nueva Solicitud'</p>
		</c:if>
		<c:if test="${investigador.getSolRealizadas().size() != 0}">
		<div class="container-lista">
		<c:forEach items="${investigador.getSolRealizadas()}" var="soli" step="3">
		<tr>
		<td>
		
					
        <div class="list-group">
          <form action="SolicitudServlet" method="get">
         	  <input type="hidden" name="email" value="${investigador.getEmail()}" />
			  <input type="hidden" name="idSol" value="${soli.getId()}" />
			  <button type="submit">
		             <div class="d-flex w-100 justify-content-between list-group-item list-group-item-action">
		             <h5 class="mb-1">${ soli.getTitulo() }</h5>
		             </div>
            </button>
          </form>
        </div>
        </td>
        </tr>
        </c:forEach>  
      </div>
      </c:if>
	</body>
</html>