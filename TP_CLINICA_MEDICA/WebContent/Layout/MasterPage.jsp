
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dominio.Medico"%>
    
<!DOCTYPE html >

<html>
<head>

	<!-- BOOTSTRAP -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity ="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
	<!-- datepicker -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	
	<script>
	$(document).ready(function() {
		  $('.datepicker').datepicker({
		    format: 'dd/mm/yyyy',
		    autoclose: true
		  });
		});
	</script>
		


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MasterPage</title>
</head>


<body>

	<!-- NAVBAR -->
	
	<nav class="navbar navbar-expand-lg navbar-dark text-light bg-primary" style="position:fixed; width:100%; z-index:98;">
		<div class="container-fluid">
		
			 <a class="navbar-brand"  href="#">Clinica UTN <img src="../Images/greenCross.png" width="30" height="30">  </a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
			
			  <div class="collapse navbar-collapse " id="navbarSupportedContent">
			  
			  	<!-- FORMA PARA ENVIAR METODOS AL SERVLET -->
			  	
				<!-- DEPENDIENDO DE USUARIO LOGUEADO SE MODIFICA LO MOSTRADO EN EL NAVBAR  -->
				<form class="form-inline d-flex w-100 justify-content-between" action="servletMaster" method="post">
				<%
					Medico logueado = null;
					String tipoUsuario = null;
					
					if(session.getAttribute("usuario")!=null)
					{
						logueado = (Medico) session.getAttribute("usuario");
						tipoUsuario = logueado.getEspecialidad().getNombreEspecialidad();
					}
					
					if (tipoUsuario != null && tipoUsuario.equals("Admin"))  {  
				%>
					
	    	
				    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
				      <li class="nav-item">
				        <a class="nav-link" href="servletMaster?master=asignarTurnos" type="submit" >Asignar Turnos</a>
				      </li>
				      
				      <li class="nav-item dropdown">
				        <a class="nav-link dropdown-toggle text-light" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
				          ABMLs
				        </a>
				        <div class="dropdown-menu">
				          <a class="dropdown-item" href="servletMaster?master=medicos"> ABML de Medicos </a>
				          <a class="dropdown-item" href="servletMaster?master=pacientes" > ABML de Pacientes</a>
					
				        </div>
				      </li>
				      
				      
				      </ul>
				      
		              <ul class="navbar-nav  mb-2 mb-lg-0 navbar-right">
						<li class="nav-item">
							<input class="btn btn-outline-danger text-light" type="submit" name="btnCerrarSesion" value="Cerrar Sesion">
	
	
						</li>
				    </ul>
					
				      
			   		<%
						} else if (tipoUsuario != null && !tipoUsuario.equals("Admin")) {
					%>   
					
					
				    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
				      <li class="nav-item">
				        <a class="nav-link" href="servletMaster?master=listarTurnos" type="submit" >Listar Turnos</a>
				      </li>				    
			        </ul>
				      
		            <ul class="navbar-nav  mb-2 mb-lg-0 navbar-right">
						<li class="nav-item">
							<input class="btn btn-outline-danger text-light" type="submit" name="btnCerrarSesion" value="Cerrar Sesion">
	
						</li>
				    </ul>
					
						<%
						} else {
						%>
					
				   <ul class="navbar-nav  mb-2 mb-lg-0 navbar-right justify-content-right">
						<li class="nav-item">
			     	 		 <a class="btn btn-outline-success text-light justify-content-right" href="servletMaster?master=login" >Ingresar</a>		
						</li>
				    </ul>
					
							<% } %>
				   
				 
			   </form> 		    

		  </div>

		</div>
		 
	</nav>
	
	
	
	
	<!-- CUERPO DE LA MASTER PAGE -->
	
			<br>
			<br>
		<br>
	<div style="background-color:rgba( 255, 255, 255, 0.7); margin-bottom:-20px; min-height:100vh" >
	    <br>
	    <div class=" container body-content bg-light px-5" >

			    		<br>
			    
	
	
	<% 
	String chequeo = null;
	
	if(request.getAttribute("sitio")!=null)
	{
		chequeo = (String) request.getAttribute("sitio");
		switch(chequeo){
		case "login":
			%>	
			
			<%@ include file="../Login.jsp" %>
			
			<%
			break;
			
		case "abmlMedicos":
			
			%>
			
			<%@ include file="../ABMLs/ABMLMedicos.jsp" %>
			
			<%
			break;
		case "abmlPacientes":
			
			%>
			
			<%@ include file="../ABMLs/ABMLPacientes.jsp" %>
			
			<%
			break;
		
		case "formularioMedico":
			
			%>
			
			<%@ include file="../Formularios/FormularioMedico.jsp" %>
			
			<%
			break;
			
		case "formularioPaciente":
			
			%>
			
			<%@ include file="../Formularios/FormularioPaciente.jsp" %>
			
			<%
			break;
			
		case "asignarTurnos":
			
			%>
			
		  <%@ include file="../AsignacionTurnos.jsp" %>
			
			<%
			break;
			
		case "listarTurnos":
			
			%>
			
		  <%@ include file="../ListaTurnos.jsp" %>
			
			<%
			
		default: 
			break;
			
		}
		
	}
	
			%>

	



	
	<br>
		<br>
		
		</div>
	</div>
</body>
</html>