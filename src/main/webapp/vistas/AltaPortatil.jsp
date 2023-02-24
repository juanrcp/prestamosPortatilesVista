<!-- Importamos las cabeceras -->
<%@ include file="/utiles/cabeceras.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ALTA PORTATIL</title>

<style type="text/css">

body{
	
	text-align: center;
	
}

table {
	text-align: center;
}

ul {
	list-style:none;
}

form {
	text-align: center;
	margin-left: 30%;
	width: 400px;
}

</style>
</head>
<body>
	<!-- Importamos el menu -->
	<%@ include file="/vistas/menu.jsp"%>
	<br>
	<div class="container">
		<h1>FORMULARIO DE ALTA PORTATILES</h1>
		<br>
		<br>
		<div class="formulario">
			<form:form action="altaPortatil" method="POST" modelAttribute="nuevoPortatil">
 			<ul style="list-style:none">
  				<li class="form-group">
    				<form:label path="numero_identificador">NÚMERO IDENTIFICADOR:</form:label>
    				<form:input type="text" class="form-control"  path="numero_identificador" placeholder="REFERENCIA-1"/>
  				</li>
  				<br>
  				<li class="form-group">
    				<form:label path="marca">MARCA:</form:label>
    				<form:input type="text" class="form-control"  path="marca" placeholder="Introduzca MARCA"/>
  				</li>
  				<br>
  				<li class="form-group">
    				<form:label path="modelo">MODELO:</form:label>
    				<form:input type="text" class="form-control" path="modelo" placeholder="Introduzca MODELO"/>
  				</li>
  				<br>
  				<li class="button">
  					<button class="btn btn-primary" type="Submit">GUARDAR</button>
				</li>
 			</ul>
		</form:form>
		</div>
		<button type="button" class="btn btn-primary" onclick="history.back()">VOLVER A ATRAS</button>
	</div>
</body>
</html>