<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista de Turnos</title>
		<style>
			#tablaWrapper{
			overflow-x:scroll;
			}
		</style>
	</head>
<body>
	<h1> Lista de Turnos </h1>
	<br>
	<div  id=tablaWrapper>
	<table border="1" id="tablaTurnos" class="table table-bordered">
				<thead>
					<tr>
						<th>Especialidad</th>
						<th>ID Medico</th>
						<th>Nombre Completo Medico</th>
						<th>Horario</th>
						<th>ID Paciente</th>
						<th>Nombre Completo Paciente</th>
						<th>Estado Turno</th>
					</tr>
				</thead>
				<tbody>
					<tr>  
						<td>Dentista</td>
						<td>6</td>
						<td>Roberto Gomez Bolaños</td>
						<td>10:00</td>
						<td>3</td>
						<td>Cosme Fulanito  <a href="#">[ i ]</a> </td>
				     	<td>
					     	<select class="form-control">
						      <option> LIBRE </option>
						  	  <option>OCUPADO</option>
						  	  <option>AUSENTE</option>
						  	  <option>PRESENTE</option>
	
							</select>
						</td>
					</tr>
			    </tbody>
		
			</table>
	
	</div>
	
	
</body>
</html>