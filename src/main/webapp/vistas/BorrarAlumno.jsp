<!-- Importamos las cabeceras -->
<%@ include file="/utiles/cabeceras.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BORRAR ALUMNO</title>

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
	<br>
	<div class="container">
		<h1>CONFIRMAR BORRADO</h1>
		<h3>PARA BORRAR AL ALUMNO ESCRIBA: "BORRAR"</h3>
		<br>
		<form:form action="borraAlumno" method="POST" modelAttribute="dtoUtil">
 			<ul style="list-style:none">
  				<li>
    				<form:label path="mensajeC">¿BORRAR?:</form:label>
    				<form:input type="text"  path="mensajeC"/>
  				</li>
  				<br>
  				<li class="button">
  					<button class="btn btn-danger" type="Submit">CONFIRMAR</button>
				</li>
 			</ul>
		</form:form>
		<button type="button" class="btn btn-primary" onclick="history.back()">VOLVER A ATRAS</button>
	</div>
</body>
</html>