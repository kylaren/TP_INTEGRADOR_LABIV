<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1>Iniciar Sesión</h1>
	<form action="../servletLogin" method="post">
		<div class="form-group">
		
		</div>
		<label for="usuario">Usuario:</label> 
			<input id="usuario" type="text" placeholder="Ingrese su usuario" required name="usuario"><br>
		<label for="contrasena">Contraseña:</label> 
			<input id="contrasena" type="password" placeholder="Ingrese su contraseña" required name="contrasena"><br> 
		<label for="tipoUsuario">Tipo de Usuario:</label> 
			<select id="tipoUsuario" name="tipoUsuario" required>
				<option value="" selected disabled>- Seleccione tipo de usuario -</option>
				<option value="admin">Administrador</option>
				<option value="medico">Médico</option>
			</select><br> <input type="submit" value="Iniciar Sesión">
	</form>


</body>
</html>