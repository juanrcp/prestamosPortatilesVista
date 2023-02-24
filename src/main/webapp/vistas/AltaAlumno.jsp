<!-- Importamos las cabeceras -->
<%@ include file="/utiles/cabeceras.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Marticular Alumno</title>
</head>
<body>
	<!-- Importamos el menu -->
	<%@ include file="/vistas/menu.jsp"%>
	<br>
	<div class="container">
		<h1>FORMULARIO DE MATRICULACIÓN ALUMNOS</h1>
		<br>
		<br>
		<form:form action="altaAlumno" method="POST" modelAttribute="nuevoAlumno">
 			<ul>
  				<li class="form-group">
    				<form:label path="nombre_alumno">NOMBRE COMPLETO:</form:label>
    				<form:input type="text" class="form-control" path="nombre_alumno"/>
  				</li>
  				<br>
  				<li class="form-group">
    				<form:label path="telefono_alumno">TELEFONO:</form:label>
    				<form:input type="number" class="form-control" path="telefono_alumno"/>
  				</li>
  				<br>
  				<li class="button">
  					<button type="Submit">GUARDAR</button>
				</li>
 			</ul>
		</form:form>
  		<button onclick="history.back()">VOLVER A ATRAS</button>
	</div>
</body>
</html>