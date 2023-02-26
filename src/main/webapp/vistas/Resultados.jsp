<!-- Importamos las cabeceras -->
<%@ include file="/utiles/cabeceras.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RESULTADOS</title>

<style type="text/css">

table {
	text-align: center;
}

ul {
	list-style:none;
}

</style>
</head>
<body style="background-color: lime; text-align: center;">
	<!-- Importamos el menu -->
	<%@ include file="/vistas/menu.jsp"%>
	<div class="container">
		<br>
		<h1>RELACIÓN DE ASIGNACIÓN</h1>
		<br>		
		<c:if test="${miModelo.alumnoSeleccionado != null}">
			<table class="table table-bordered">
  				<thead>
    				<tr>
      					<th colspan="2" scope="col">ASIGNACIÓN ID ALUMNO CON PORTATIL</th>
    				</tr>
  				</thead>
  				<tbody>
    					<tr>
      						<th scope="row">ALUMNO</th>
      						<td>${miModelo.alumnoSeleccionado}</td>
    					</tr>
    					<tr>
      						<th scope="row">PORTATIL</th>
      						<td>${miModelo.portatilAsignado}</td>
    					</tr>
  				</tbody>
			</table>			
		</c:if>			
		<c:if test="${miModelo.alumnoPoseedor != null}">
			<table class="table table-bordered">
  				<thead>
    				<tr>
      					<th colspan="2" scope="col">ASIGNACIÓN NÚMERO REGISTRO PORTATIL CON ALUMNO</th>
    				</tr>
  				</thead>
  				<tbody>
    				<tr>
      					<th scope="row">ALUMNO</th>
      					<td>${miModelo.alumnoPoseedor}</td>
    				</tr>
    				<tr>
      					<th scope="row">PORTATIL</th>
      					<td>${miModelo.portatilSeleccionado}</td>
    				</tr>
  				</tbody>
			</table>			
		</c:if>	
		<br>
		<a class="btn btn-primary" href="/prestamosVista/">VOLVER AL INICIO</a>
	</div>
</body>
</html>