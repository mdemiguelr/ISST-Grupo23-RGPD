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
                <img src="images/indice_opt.png" alt="Logo" title="" />
              </div>
              <nav id="nav-menu-container">
                <ul class="nav-menu">
                  <li class="menu-active">
                  	<form action="InvestigadorServlet" method="get">
						<input type="hidden" name="email" value="${investigador.email}" />
			    		<button type="submit" >Mis Solicitudes</button>
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
			<div class="container-lista mb-1">
					
     		   <div class="list-group  mt-20">
          <form action="NuevaSolicitudServlet" method="get">
         	 <input type="hidden" name="emailInv" value="${investigador.email}" />
			 <button type="submit" class="genric-btn success-border radius" style="width:100%" >
		       <p></p>
		             <h5 class="mb-20">Todavía no ha realizado ninguna solicitud.
		            </h5>
		             <p class="mb-1">Pulse aquí para crear su primera solicitud.</p> 
		            
		                </button>
		                 </form>
		              </div>
		</c:if>
		<c:if test="${investigador.getSolRealizadas().size() != 0}">
		<div class="container-lista mb-1">
		<c:forEach items="${investigador.getSolRealizadas()}" var="soli" step="3">
		<tr>
		<td>

					
        <div class="list-group  mt-10">
          <form action="SolicitudServlet" method="get">
         	  <input type="hidden" name="email" value="${investigador.getEmail()}" />
			  <input type="hidden" name="idSol" value="${soli.getId()}" />
			 <button type="submit" class="genric-btn success-border radius" style="width:100%" >
		       <p></p>
		             <h5 class="mb-10">${ soli.getTitulo()}
		            </h5>
		            <c:if test="${soli.getEstado()==0}">
	                 <p class="mb-1">ESTADO = SOLICITUD PENDIENTE</p> 
	                </c:if>
	                <c:if test="${soli.getEstado()==1}">
	                 <p class="mb-1">ESTADO = SOLICITUD VALIDADA</p> 
	                </c:if>
	                <c:if test="${soli.getEstado()==2}">
	                 <p class="mb-1">ESTADO = SOLICITUD DENEGADA</p> 
	                </c:if>
	                <c:if test="${soli.getEstado()==3}">
	                 <p class="mb-1">ESTADO = FALTA INFORMACIÓN</p> 
	                </c:if>
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