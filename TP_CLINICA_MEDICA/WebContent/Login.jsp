<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1>Iniciar Sesión</h1>
	<form action="LoginServlet" method="post">
		<div class="form-group">
		
		</div>
		<label for="usuario">Usuario:</label> <input id="usuario" type="text"
			placeholder="Ingrese su usuario" required name="usuario"><br>
		<label for="contrasena">Contraseña:</label> <input type="password"
			name="contrasena" id="contrasena" required><br> <label
			for="tipoUsuario">Tipo de Usuario:</label> <select name="tipoUsuario"
			id="tipoUsuario">
			<option value="admin">Administrador</option>
			<option value="medico">Médico</option>
		</select><br> <input type="submit" value="Iniciar Sesión">
	</form>


</body>
</html>