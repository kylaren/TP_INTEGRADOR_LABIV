<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>

<style>
.error-container {
	width: 400px;
	margin: 100px auto;
	padding: 20px;
	background-color: #f8d7da;
	border: 1px solid #f5c6cb;
	color: #721c24;
	text-align: center;
}

.error-container button {
	padding: 10px 20px;
	background-color: #dc3545;
	color: #fff;
	border: none;
	cursor: pointer;
}
</style>

</head>
<body>

	<div class="error-container">
		<h2>Error de autenticación</h2>
		<p>Las credenciales proporcionadas no son válidas.</p>
		<p>Por favor, intenta nuevamente.</p>
		<button onclick="window.location.href='MasterPage.jsp'">Volver a
			intentar</button>
	</div>

</body>
</html>