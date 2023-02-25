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
	<div class="container">
		<h1>FORMULARIO DE ALTA PORTATILES</h1>
		<br>
		<br>
		<div class="position-relative">
		<div class="position-absolute top-50 start-50 translate-middle">
			<form:form action="altaPortatil" method="POST" modelAttribute="nuevoPortatil">
 			<ul style="list-style:none">
  				<li class="form-group">
    				<form:label path="numero_identificador">NÚMERO IDENTIFICADOR:</form:label>
    				<form:input type="text" class="form-control"  path="numero_identificador" placeholder="REFERENCIA-1" required="numero_identificador"/>
  				</li>
  				<br>
  				<li class="form-group">
    				<form:label path="marca">MARCA:</form:label>
    				<form:input type="text" class="form-control"  path="marca" placeholder="Introduzca MARCA" required="marca"/>
  				</li>
  				<br>
  				<li class="form-group">
    				<form:label path="modelo">MODELO:</form:label>
    				<form:input type="text" class="form-control" path="modelo" placeholder="Introduzca MODELO" required="modelo"/>
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
	</div>
</body>
</html>