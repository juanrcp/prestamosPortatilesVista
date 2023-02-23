<!-- Importamos las cabeceras -->
<%@ include file="/utiles/cabeceras.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<title></title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  		<a class="navbar-brand" href="index.jsp">PRESTAMOS PORTÁTILES</a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>
  		<div class="collapse navbar-collapse" id="navbarNav">
    		<ul class="navbar-nav">
      			<li class="nav-item active">
        			<a class="nav-link" href="<c:url value="navegacionFormularioAltaAlumno"/>">MATRÍCULAR A UN ALUMNO</a>
      			</li>
      			<li class="nav-item">
        			<a class="nav-link" href="<c:url value="mostrarAlumnos"/>">LISTA DE ALUMNOS</a>
      			</li>
      			<li class="nav-item">
        			<a class="nav-link" href="<c:url value="navegacionFormularioAltaPortatil"/>">ALTA DE PORTÁTILES</a>
      			</li>
      			<li class="nav-item">
        			<a class="nav-link" href="<c:url value="mostrarPortatiles"/>">LISTA DE PORTÁTILES</a>
      			</li>
      			<li class="nav-item">
        			<a class="nav-link" href="#">RELACIÓN ALUMNOS Y PORTÁTILES ASIGNADOS</a>
      			</li>
    		</ul>
 	 	</div>
	</nav>
</body>
</html>