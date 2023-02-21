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
	<h1>FORMULARIO DE ALTA PORTATILES</h1>
	<br>
	<br>
	<form:form action="altaPortatil" method="POST" modelAttribute="nuevoPortatil">
 		<ul>
  			<li>
    			<form:label path="numero_identificador">NÚMERO IDENTIFICADOR:</form:label>
    			<form:input type="text"  path="numero_identificador"/>
  			</li>
  			<br>
  			<li>
    			<form:label path="marca">MARCA:</form:label>
    			<form:input type="text"  path="marca"/>
  			</li>
  			<br>
  			<li>
    			<form:label path="modelo">MODELO:</form:label>
    			<form:input type="text"  path="modelo"/>
  			</li>
  			<br>
  			<li class="button">
  				<button type="Submit">GUARDAR</button>
			</li>
 		</ul>
	</form:form>
</body>
</html>