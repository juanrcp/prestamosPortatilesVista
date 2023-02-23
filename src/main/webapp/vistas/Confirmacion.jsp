<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmación</title>
</head>
<body>
	<!-- Importamos el menu -->
	<%@ include file="/vistas/menu.jsp"%>
	<br>
	<div class="container">
		<h1>¡ATENCIÓN!</h1>
		<br>
		<c:if test="${miModelo.mensaje != null}">
			<h3><c:out value="${miModelo.mensaje}"></c:out></h3>
		</c:if>
		<br>
		<a href="/prestamosVista/">VOLVER AL INICIO</a>
	</div>
</body>
</html>