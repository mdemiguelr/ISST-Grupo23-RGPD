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
            <h3 class="mb-30">Expediente ${ solicitud.getId() }</h3>
            <div class="progress-table-wrap">
              <div class="progress-table">
                
                <div class="table-row">
                  <div class="country"> Nombre </div>
                  <div class="visit">${ solicitud.getInvestigador().getName() }</div>
                  
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
                  <div class="country"> Memoria</div>
                  <div class="visit">${ solicitud.getMemoria() }</div>
                  
                </div>
                
              </div>
            </div>
          </div>
        </div>
	
	</body>
</html>