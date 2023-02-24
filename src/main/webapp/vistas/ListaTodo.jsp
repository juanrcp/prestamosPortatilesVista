<!-- Importamos las cabeceras -->
<%@ include file="/utiles/cabeceras.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODAS LAS ASIGNACIONES</title>

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
		<h1>LISTA DE ASIGNACIONES ALUMNOS-PORTÁTILES</h1>
		<br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">ASIGNACIONES</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${miModelo.listaAsignaciones}" var="alumnoPortatil">
					<tr>
						<td>
							<c:out value="${alumnoPortatil}"></c:out>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<a class="btn btn-primary" href="/prestamosVista/">VOLVER AL INICIO</a>
	</div>
</body>
</html>