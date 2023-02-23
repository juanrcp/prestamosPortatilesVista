<!-- Importamos las cabeceras -->
<%@ include file="/utiles/cabeceras.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultados</title>
</head>
<body>
	<!-- Importamos el menu -->
	<%@ include file="/vistas/menu.jsp"%>
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
	
	
	<a href="prestamosVista/index">VOLVER AL INDEX</a>

</body>
</html>