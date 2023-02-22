<!-- Importamos las cabeceras -->
<%@ include file="/utiles/cabeceras.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Borrar Alumno</title>
</head>
<body>
<!-- Importamos el menu -->
	<%@ include file="/vistas/menu.jsp"%>
	<br>
	<h1>LISTA DE ALUMNOS</h1>
	<br>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>NOMBRE</th>
				<th>TELEFONO</th>
				<th>¿BORRAR?</th>
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
						<a id="idSeleccionada" href="<c:url value="confirmarBorradoAlumnos/${alumno.id_alumno}"/>">BORRAR</a>
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
	<form:form action="portatilDeAlumno" method="POST" modelAttribute="idAlumno">
 		<ul>
  			<li>
    			<form:label path="">ID del Alumno:</form:label>
    			<form:input type="number"  path=""/>
  			</li>
  			<br>
  			<li class="button">
  				<button type="Submit">GUARDAR</button>
			</li>
 		</ul>
	</form:form>
</body>
</html>