<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="background-color:rgba( 255, 255, 255, 0.7); margin-bottom:-20px; min-height:100vh" >
		<%@ include file="Header.jsp" %>
	    <br>
	    <div class=" container body-content bg-light px-5" >
	    	<br>
	    	
	    	 <!-- PANTALLA DE LOGUEO -->
	    	 
	    	<p>
			  <a class="btn btn-primary" data-toggle="collapse" href="#collapse1" role="button" aria-expanded="false" aria-controls="collapse1">
			    Pantalla de Logueo
			  </a>
			</p>
			<div class="collapse" id="collapse1">
			  <div class="card card-body">
			  	  <%@ include file="../Login.jsp" %>
			  </div>
			</div>
	    	
	    	
	    	<br>
	    	<!-- ABMLMEDICOS -->
	    	
	    	<p>
			  <a class="btn btn-primary" data-toggle="collapse" href="#collapse2" role="button" aria-expanded="false" aria-controls="collapse2">
			    ABML de Medicos
			  </a>
			</p>
			<div class="collapse" id="collapse2">
			  <div class="card card-body">
			  	  <%@ include file="../ABMLs/ABMLMedicos.jsp" %>
			  </div>
			</div>
			
			
	    	
	    	<!-- ABMLPACIENTES -->
	    	<br>
	       	<p>
		  	<a class="btn btn-primary" data-toggle="collapse" href="#collapse3" role="button" aria-expanded="false" aria-controls="collapse3">
			    ABML de Pacientes
			  </a>
			</p>
			<div class="collapse" id="collapse3">
			  <div class="card card-body">
			  	  <%@ include file="../ABMLs/ABMLPacientes.jsp" %>
			  </div>
			</div>
	    	
	    
	    	<br>
	    	
	    	<!-- ASIGNAR TURNOS -->
	    	
			  	<p>
		  	<a class="btn btn-primary" data-toggle="collapse" href="#collapse4" role="button" aria-expanded="false" aria-controls="collapse4">
			    Asignacion de Turnos
			  </a>
			</p>
			<div class="collapse" id="collapse4">
			  <div class="card card-body">
			  	  <%@ include file="../AsignacionTurnos.jsp" %>
			  </div>
			</div>
	    	
	    	<br>

			<!-- LISTAR TURNOS PARA CADA MEDICO -->
			
		  	<p>
		  	<a class="btn btn-primary" data-toggle="collapse" href="#collapse5" role="button" aria-expanded="false" aria-controls="collapse5">
			    Listado de Turnos
			  </a>
			</p>
			<div class="collapse" id="collapse5">
			  <div class="card card-body">
			  	  <%@ include file="../ListaTurnos.jsp" %>
			  </div>
			</div>
	    	
	    	<br>
			
			
			<!-- FORMULARIO MEDICOS -->
			
	    	<p>
			  <a class="btn btn-primary" data-toggle="collapse" href="#collapse6" role="button" aria-expanded="false" aria-controls="collapse6">
			    Formulario de Ingreso de Medicos
			  </a>
			</p>
			<div class="collapse" id="collapse6">
			  <div class="card card-body">
			  	  <%@ include file="../Formularios/FormularioMedico.jsp" %>
			  </div>
			</div>
			
			<!-- FORMULARIO PACIENTE -->
			<br>
			
	    	<p>
			  <a class="btn btn-primary" data-toggle="collapse" href="#collapse7" role="button" aria-expanded="false" aria-controls="collapse7">
			    Formulario de Ingreso de Pacientes
			  </a>
			</p>

			
			<div class="collapse" id="collapse7">
			  <div class="card card-body">
			  	  <%@ include file="../Formularios/FormularioPaciente.jsp" %>
			  </div>
			</div>
			<br>
	    	
	    	<!-- DESARROLLAR FUNCION QUE PERMITA CAMBIAR ESTE SITIO EN SERVLETS  -->


		</div>
		
	</div>
</body>
</html>