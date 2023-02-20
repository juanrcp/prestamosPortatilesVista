<!-- Importamos las cabeceras -->
<%@ include file="/utiles/cabeceras.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title></title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  		<a class="navbar-brand" href="index.jsp">PRESTAMOS PORTATILES</a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>
  		<div class="collapse navbar-collapse" id="navbarNav">
    		<ul class="navbar-nav">
      			<li class="nav-item active">
        			<a class="nav-link" href="<c:url value="navegacionFormularioAltaAlumno"/>">Matricular a un Alumno</a>
      			</li>
      			<li class="nav-item">
        			<a class="nav-link" href="<c:url value="mostrarAlumnos"/>">Dar de Baja a un Alumno</a>
      			</li>
      			<li class="nav-item">
        			<a class="nav-link" href="#">Alta de Portátil</a>
      			</li>
      			<li class="nav-item">
        			<a class="nav-link disabled" href="#">Consulta Portátil Asignado a un Alumno</a>
      			</li>
      			<li class="nav-item">
        			<a class="nav-link disabled" href="#">Consulta Alumno Asignado a un Portátil</a>
      			</li>
      			<li class="nav-item">
        			<a class="nav-link disabled" href="#">Ver todos los Alumnos con su asignación de Portátil</a>
      			</li>
    		</ul>
 	 	</div>
	</nav>
</body>
</html>