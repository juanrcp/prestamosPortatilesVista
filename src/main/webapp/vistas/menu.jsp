<!-- Importamos las cabeceras -->
<%@ include file="/utiles/cabeceras.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">

body{
	
	text-align: center;
	
}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title></title>
</head>
<body style="text-align: center;">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  		<a class="navbar-brand" style="margin-left: 5%;" href="/prestamosVista/">PRESTAMOS PORTÁTILES</a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>
  		<div class="collapse navbar-collapse" id="navbarNav">
    		<ul class="navbar-nav">
      			<li class="nav-item active">
        			<a class="nav-link" href="/prestamosVista/navegacionFormularioAltaAlumno">MATRÍCULAR A UN ALUMNO</a>
      			</li>
      			<li class="nav-item">
      				<!-- Con esta forma concatenamos pero las rutas pueden fallar asi que mejor usamos rutas absolutas en el menu
        			<a class="nav-link" href="<c:url value="mostrarAlumnos"/>">LISTA DE ALUMNOS</a>
      				 -->
        			<a class="nav-link" href="/prestamosVista/mostrarAlumnos">LISTA DE ALUMNOS</a>
      			</li>
      			<li class="nav-item">
        			<a class="nav-link" href="/prestamosVista/navegacionFormularioAltaPortatil">ALTA DE PORTÁTILES</a>
      			</li>
      			<li class="nav-item">
        			<a class="nav-link" href="/prestamosVista/mostrarPortatiles">LISTA DE PORTÁTILES</a>
      			</li>
      			<li class="nav-item">
        			<a class="nav-link" href="/prestamosVista/mostrarTodo">RELACIÓN ALUMNOS Y PORTÁTILES ASIGNADOS</a>
      			</li>
      			<li class="nav-item">
        			<a class="nav-link" href="/prestamosVista/login">LOGIN</a>
      			</li>
      			<c:if test="${miModelo.rol != null}">
      			<li class="nav-item">
        			<a class="nav-link" href="/prestamosVista/Logout">CERRAR SESIÓN</a>
      			</li>
      			</c:if>
    		</ul>
 	 	</div>
	</nav>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>