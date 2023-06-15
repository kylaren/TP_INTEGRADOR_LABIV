<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista de Turnos</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
	</head>
<body>
	<h1> Lista de Turnos </h1>
	<br>
	<table border="1" id="tablaMedicos" class="table table-bordered">
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
	
	
</body>
</html>