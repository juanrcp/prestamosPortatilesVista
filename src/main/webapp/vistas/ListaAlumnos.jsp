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
			<th>ID</th>
			<th>NOMBRE</th>
			<th>TELEFONO</th>
			<th>¿BORRAR?</th>
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
						<a puth="idSeleccionada" href="<c:url value="borrarAlumno/${alumno.id_alumno}"/>">BORRAR</a>					
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>