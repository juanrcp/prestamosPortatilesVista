<!-- Importamos las cabeceras -->
<%@ include file="/utiles/cabeceras.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro Usuario</title>

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
		<h1>FORMULARIO DE REGISTRO DE USUARIOS</h1>
		<br>
		<br>
		<div class="position-absolute top-50 start-50 translate-middle">
		<form:form action="altaUsuario" method="POST" modelAttribute="nuevoUsuario">
 			<ul>
  				<li class="form-group">
    				<form:label path="nombre_Usuario">NOMBRE USUARIO:</form:label>
    				<form:input type="text" class="form-control" path="nombre_Usuario" placeholder="Usuario" required="nombre_Usuario" minlength="5" maxlength="10" pattern="[a-zA-Z]+"/>
  				</li>
  				<br>
  				<li class="form-group">
    				<form:label path="clave_Usuario">CONTRASEÑA:</form:label>
    				<form:input type="password" class="form-control" path="clave_Usuario" placeholder="Contraseña" required="clave_Usuario" minlength="9" maxlength="9"/>
  				</li>
  				<br>
  				<li class="form-group">    				
    				<form:select path="rol_usuario" class="form-select" aria-label="Default select example" required="rol_usuario">
    					 <option selected value="null">ESCOJA EL ROL DESEADO:</option>
    					<option value="ADMINISTRADOR">ADMINISTRADOR</option>
    					<option value="GESTOR">GESTOR</option>
    				</form:select>
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