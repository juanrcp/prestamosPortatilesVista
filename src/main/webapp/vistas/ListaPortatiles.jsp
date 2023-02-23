<!-- Importamos las cabeceras -->
<%@ include file="/utiles/cabeceras.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LISTA PORTATILES</title>
</head>
<body>
	<!-- Importamos el menu -->
	<%@ include file="/vistas/menu.jsp"%>
	<div class="container">
		<br>
		<h1>LISTA DE PORTATILES</h1>
		<br>
		<table>
			<thead>
				<tr>
					<th>CODIGO DE REGISTRO</th>
					<th>MARCA</th>
					<th>MODELO</th>
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
		<h3>Introduzca el NUMERO IDENTIFICADOR del Portatil para ver a que Alumno ha sido asignado:</h3>
		<br>
		<form:form action="alumnodePortatil" method="POST" modelAttribute="dtoUtil">
	 		<ul>
	  			<li>
	    			<form:label path="mensajeC">CODIGO REFERENCIA PORTATIL:</form:label>
	    			<form:input type="text"  path="mensajeC"/>
	  			</li>
	  			<br>
	  			<li class="button">
	  				<button type="Submit">CONSULTAR</button>
				</li>
	 		</ul>
		</form:form>
	</div>
</body>
</html>