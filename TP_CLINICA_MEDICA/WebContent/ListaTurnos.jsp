<%@ page import="java.util.ArrayList"%>
<%@ page import="dominio.Turno"%>
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
		<%
		ArrayList<Turno> listaTurnos = null;
		if(request.getAttribute("listaT")!=null)
		{
			listaTurnos = (ArrayList<Turno>)request.getAttribute("listaT");
		}
		%>
		
	</head>
<body>
	<h1> Lista de Turnos </h1>
	<br>
	<div  id=tablaWrapper>
	<table border="1" id="tablaTurnos" class="table table-bordered">
				<thead>
					<tr>
						<th>Especialidad</th>
						<th>Nombre Completo Medico</th>
						<th>Fecha y Horario</th>
						<th>Nombre Completo Paciente</th>
						<th>Estado Turno</th>
					</tr>
				</thead>
				<tbody>
					<%  if(listaTurnos!=null)
						for(Turno t : listaTurnos) 
						{
						%>
						<tr>  
							<td><%= t.getMedico().getEspecialidad().getNombreEspecialidad() %></td>
							<td><%= t.getMedico().getNombre() %>&nbsp;<%= t.getMedico().getApellido() %></td>
							<td><%= t.getHorario().getDia() %>&nbsp;<%= t.getHorario().getInicioJornada() %></td>
							<td><%= t.getPaciente().getNombre() %>&nbsp;<%= t.getPaciente().getApellido() %> </td>
					     	<td>
						     	<select class="form-control">
							      <option> LIBRE </option>
							  	  <option>OCUPADO</option>
							  	  <option>AUSENTE</option>
							  	  <option>PRESENTE</option>
		
								</select>
							</td>
						</tr>
					<%  } %>
			    </tbody>
		
			</table>
	
	</div>
	
	
</body>
</html>