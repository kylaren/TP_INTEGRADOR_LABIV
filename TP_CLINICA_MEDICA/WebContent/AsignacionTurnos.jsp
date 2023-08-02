<%@ page import="dominio.Medico"%>
<%@ page import="dominio.Paciente"%>
<%@ page import="dominio.Especialidad"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	
	<!-- Insercion de datos del servlet -->
	
	<%
	
	//Arraylist de especialidades
	ArrayList<Especialidad> listaEspecialidadesT = null;
	if(request.getAttribute("especialidades")!=null)
	{
		listaEspecialidadesT = (ArrayList<Especialidad>)request.getAttribute("especialidades");
	}
	
	//Arraylist de doctores
	ArrayList<Medico> listaMedicosT = null;
	if(request.getAttribute("medicos")!=null)
	{
		listaMedicosT = (ArrayList<Medico>)request.getAttribute("medicos");
	}
	
	//Arraylist de pacientes
	ArrayList<Paciente> listaPacientesT = null;
	if(request.getAttribute("pacientes")!=null)
	{
		listaPacientesT = (ArrayList<Paciente>)request.getAttribute("pacientes");
	}
	
	
	%>
	
</head>
<body>
	<h1> Asignacion de Turnos </h1>
	<br>
	<form method="post" action="servletTurnos">
	  <div class="form-group">
	  	

	  
		<div class="form-group">
		    <label for="especialidadTurno">Especialidad</label>
		    <select name=especialidadTurno class="form-control">
	   		  	<option> --- </option>
			    <% for(Especialidad e : listaEspecialidadesT) { %>
			      <option value="<%= e.getIdEspecialidad() %>">
			        <%= e.getNombreEspecialidad() %>: <%= e.getDescripcionEspecialidad()%>
			      </option>
			    <% } %>
			</select>
		</div>



		<div class="form-group">
		    <label for="medicoTurno">Medico</label>
		    <select name=medicoTurno class="form-control">
	   		  	<option> --- </option>
			    <% for(Medico m : listaMedicosT) { %>
			      <option value="<%= m.getId() %>">
			        <%= m.getNombre() %>&nbsp;<%= m.getApellido()%>
			      </option>
			    <% } %>
			</select>
		</div>

	  
	   	 <div class="form-group">
		    <label for="horarioTurno">Horario</label>
		     <select name="horarioTurno" class="form-control">
			      <option value=""> --- </option>
			  	  <option value="08:00">08:00</option>
			  	  <option value="09:00">09:00</option>
			  	  <option value="10:00">10:00</option>
			  	  <option value="11:00">11:00</option>
			  	  <option value="12:00">12:00</option>
			  	  <option value="13:00">13:00</option>
			  	  <option value="14:00">14:00</option>
			  	  <option value="15:00">15:00</option>
			  	  <option value="16:00">16:00</option>
			  	  <option value="17:00">17:00</option>		  		  	  
			</select>
		  </div>
	  

		<div class="form-group">
		    <label for="pacienteTurno">Paciente</label>
		    <select name=pacienteTurno class="form-control">
	   		  	<option> --- </option>
			    <% for(Paciente p : listaPacientesT) { %>
			      <option value="<%= p.getId() %>">
			        <%= p.getNombre() %>&nbsp;<%= p.getApellido() %>
			      </option>
			    <% } %>
			</select>
		</div>

	  

	  	<button type="submit" class="btn btn-dark">Confirmar Turno</button>
	  </div>
	</form>


</body>
</html>