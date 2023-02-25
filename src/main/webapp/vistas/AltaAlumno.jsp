<!-- Importamos las cabeceras -->
<%@ include file="/utiles/cabeceras.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MATRICULAR ALUMNO</title>

<style type="text/css">

table {
	text-align: center;
}

ul {
	list-style:none;
}

form {
	text-align: center;
	width: 450px;
	margin-top: 350px;
 
}

</style>
</head>
<body style="background-color: lime; text-align: center;">
	<!-- Importamos el menu -->
	<%@ include file="/vistas/menu.jsp"%>
	<br>
	<div class="position-relative">
		<h1>FORMULARIO DE MATRICULACIÓN ALUMNOS</h1>
		<br>
		<br>
		<div class="position-absolute top-50 start-50 translate-middle">
		<form:form action="altaAlumno" method="POST" modelAttribute="nuevoAlumno">
 			<ul>
  				<li class="form-group">
    				<form:label path="nombre_alumno">NOMBRE COMPLETO:</form:label>
    				<form:input type="text" class="form-control" path="nombre_alumno" placeholder="Nombre Apellidos"/>
  				</li>
  				<br>
  				<li class="form-group">
    				<form:label path="telefono_alumno">TELEFONO:</form:label>
    				<form:input type="number" class="form-control" path="telefono_alumno" placeholder="666951753" minlength="9" maxlength="9"/>
  				</li>
  				<br>
  				<li class="button">
  					<button class="btn btn-primary" type="Submit">GUARDAR</button>
  					<button class="btn btn-primary" type="reset">LIMPIAR</button>
				</li>
 			</ul>
		</form:form>
  		<button type="button" class="btn btn-primary" onclick="history.back()">VOLVER A ATRAS</button>
		</div>
	</div>
</body>
</html>