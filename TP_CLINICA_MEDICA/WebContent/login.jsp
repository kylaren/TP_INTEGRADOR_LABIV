<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Iniciar Sesi�n</h1>
	<form action="LoginServlet" method="post">
		<label for="usuario">Usuario:</label> <input id="usuario" type="text"
			placeholder="Ingrese su usuario" required name="usuario"><br>
		<label for="contrasena">Contrase�a:</label> <input type="password"
			name="contrasena" id="contrasena" required><br> <label
			for="tipoUsuario">Tipo de Usuario:</label> <select name="tipoUsuario"
			id="tipoUsuario">
			<option value="admin">Administrador</option>
			<option value="medico">M�dico</option>
		</select><br> <input type="submit" value="Iniciar Sesi�n">
	</form>

</body>
</html>