<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>ABML de Medicos</title>
		
	<style>
		
		#tablaWrapper{
			overflow-x:scroll;
		}
	
	</style>
	</head>
	<body>

		<h1> ABML de Medicos </h1>
		<div id=tablaWrapper>
			<table border="1" id="tablaMedicos" class="table table-bordered">
				<thead>
					<tr>
						<th>Accion</th>
						<th>ID Medico</th>
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
						<th>Telefonos</th>
						<th>Especialidad</th>
						<th>Dia de Atencion</th>
						<th>Horario de Atencion</th>

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
						<td>Testeador</td>
						<td>Lunes</td>
						<td>15:30</td>
						
					</tr>
			    </tbody>
		
			</table>
		</div>
		<br>
		<button type="button" class="btn btn-dark">Agregar Medico</button>
			
	
	</body>
</html>