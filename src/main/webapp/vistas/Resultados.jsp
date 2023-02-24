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

body{
	
	text-align: center;
	
}

table {
	text-align: center;
}

ul {
	list-style:none;
}

</style>
</head>
<body>
	<!-- Importamos el menu -->
	<%@ include file="/vistas/menu.jsp"%>
	<div class="container">
		<br>
		<h1>RELACION DE ASIGNACION</h1>
		<br>
		<c:if test="${miModelo.alumnoSeleccionado != null}">
			<p>${miModelo.alumnoSeleccionado}</p>
			<p>${miModelo.portatilAsignado}</p>
		</c:if>	
		<c:if test="${miModelo.alumnoPoseedor != null}">
			<p>${miModelo.alumnoPoseedor}</p>
			<p>${miModelo.portatilSeleccionado}</p>
		</c:if>
			
		<br>
		<a class="btn btn-primary" href="/prestamosVista/">VOLVER AL INICIO</a>
	</div>
</body>
</html>