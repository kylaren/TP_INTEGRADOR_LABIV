<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<style>
		
		#tablaWrapper{
			overflow-x:scroll;
		}
	
	</style>


</head>
<body>


<h1> ABML de Pacientes </h1>
		<div id=tablaWrapper>
			<table border="1" id="tablaPacientes" class="table table-bordered">
				<thead>
					<tr>
						<th>Accion</th>
						<th>ID Paciente</th>
						<th>DNI</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Sexo</th>
						<th>Nacionalidad</th>
						<th>Fecha de Nacimiento</th>
						<th>Direccion</th>
						<th>Localidad</th>
						<th>Provincia</th>
						<th>Correo Electronico</th>
						<th>Telefono</th>

					</tr>
				</thead>
				<tbody>
					<tr>  
						<td>
							 <a href="#">Modificar</a>
 							 <a href="#">Eliminar</a> 
						</td>
						<td>1</td>
						<td>12345678</td>
						<td>Cosme</td>
						<td>Fulanito</td>
						<td>Hombre</td>
						<td>Argentina</td>
						<td>12/05/1990</td>
						<td>Calle Falsa 123</td>
						<td>San Justo</td>
						<td>Buenos Aires</td>
						<td>test@123.com</td>
						<td>01234567</td>

						
					</tr>
			    </tbody>
		
			</table>
		</div>
		<br>
		<button type="button" class="btn btn-dark">Agregar Paciente</button>
			



</body>
</html>