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
	<h1>CONFIRMAR BORRADO</h1>
	<h3>PARA BORRAR AL ALUMNO ESCRIBA: "BORRAR"</h3>
	<br>
	<form:form action="borrarAlumno" method="POST" modelAttribute="mensajeC">
 		<ul>
  			<li>
    			<form:label path="">¿BORRAR?:</form:label>
    			<form:input type="text"  path=""/>
  			</li>
  			<br>
  			<li class="button">
  				<button type="Submit">CONFIRMAR</button>
			</li>
 		</ul>
	</form:form>
</body>
</html>