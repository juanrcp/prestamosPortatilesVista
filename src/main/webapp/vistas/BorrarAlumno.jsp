<!-- Importamos las cabeceras -->
<%@ include file="/utiles/cabeceras.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Importamos el menu -->
	<%@ include file="/vistas/menu.jsp"%>
	<br>
	<div class="container">
		<h1>CONFIRMAR BORRADO</h1>
		<h3>PARA BORRAR AL ALUMNO ESCRIBA: "BORRAR"</h3>
		<br>
		<form:form action="borraAlumno" method="POST" modelAttribute="dtoUtil">
 			<ul>
  				<li>
    				<form:label path="mensajeC">¿BORRAR?:</form:label>
    				<form:input type="text"  path="mensajeC"/>
  				</li>
  				<br>
  				<li class="button">
  					<button type="Submit">CONFIRMAR</button>
				</li>
 			</ul>
		</form:form>
		<button onclick="history.back()">VOLVER A ATRAS</button>
	</div>
</body>
</html>