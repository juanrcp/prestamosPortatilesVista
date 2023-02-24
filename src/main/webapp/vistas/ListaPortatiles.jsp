<!-- Importamos las cabeceras -->
<%@ include file="/utiles/cabeceras.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LISTA PORTÁTILES</title>

<style type="text/css">

table {
	text-align: center;
}

ul {
	list-style:none;
}

</style>
</head>
<body  style="background-color: lime; text-align: center;">
	<!-- Importamos el menu -->
	<%@ include file="/vistas/menu.jsp"%>
	<div class="container">
		<br>
		<h1>LISTA DE PORTATILES</h1>
		<br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="row">CODIGO DE REGISTRO</th>
					<th scope="row">MARCA</th>
					<th scope="row">MODELO</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${miModelo.listaPortatilesDTO}" var="portatil">
					<tr>
						<td>
							<c:out value="${portatil.numero_identificador}"></c:out>
						</td>
						<td>
							<c:out value="${portatil.marca}"></c:out>
						</td>
						<td>
							<c:out value="${portatil.modelo}"></c:out>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<br>
		<h2>CONSULTAR ALUMNO</h2>
		<h3>Introduzca el CÓDIGO IDENTIFICADOR del Portatil para ver a que Alumno ha sido asignado:</h3>
		<br>
		<form:form action="alumnodePortatil" method="POST" modelAttribute="dtoUtil">
	 		<ul style="list-style:none">
	  			<li>
	    			<form:label path="mensajeC">CODIGO REFERENCIA PORTATIL:</form:label>
	    			<form:input type="text"  path="mensajeC"/>
	  			</li>
	  			<br>
	  			<li class="button">
	  				<button class="btn btn-primary" type="Submit">CONSULTAR</button>
				</li>
	 		</ul>
		</form:form>
	</div>
</body>
</html>