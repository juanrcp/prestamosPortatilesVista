<!-- Importamos las cabeceras -->
<%@ include file="/utiles/cabeceras.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LISTA ALUMNOS</title>

<style type="text/css">

table {
	text-align: center;
}

ul {
	list-style:none;
}

table {

	<!-- No reconoce esto voy por aqui -->
	border-spacing: 20px;
}

</style>
</head>
<body style="background-color: lime; text-align: center;">
<!-- Importamos el menu -->
	<%@ include file="/vistas/menu.jsp"%>
	<div class="container">
		<br>
		<h1>LISTA DE ALUMNOS</h1>
		<br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">NOMBRE</th>
					<th scope="col">TELEFONO</th>
					<th scope="col">¿BORRAR?</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${miModelo.listaAlumnosDTO}" var="alumno">
					<tr>
						<td>
							<c:out value="${alumno.id_alumno}"></c:out>
						</td>
						<td>
							<c:out value="${alumno.nombre_alumno}"></c:out>
						</td>
						<td>
							<c:out value="${alumno.telefono_alumno}"></c:out>
						</td>
						<td>
							<a class="btn btn-danger" id="idSeleccionada" href="<c:url value="confirmarBorradoAlumnos/${alumno.id_alumno}"/>">BORRAR</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<br>
		<h2>CONSULTAR PORTATIL</h2>
		<h3>Introduzca el ID del Alumno para ver su Portatil asignado:</h3>
		<br>
		<form:form action="portatilDeAlumno" method="POST" modelAttribute="dtoUtil">
 			<ul style="list-style:none">
  				<li>
    				<form:label path="idSeleccionado">ID del Alumno:</form:label>
    				<form:input type="number"  path="idSeleccionado"/>
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