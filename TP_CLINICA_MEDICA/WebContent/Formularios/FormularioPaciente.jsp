<%@ page import="dominio.Paciente"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.time.format.DateTimeFormatter"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario Paciente</title>


<%

	//Formato para fechas
	DateTimeFormatter formatoFechaP = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	//Carga de paciente
	Paciente aModificarP = null;
	if(request.getAttribute("paciente")!=null)
	{
		aModificarP= (Paciente)request.getAttribute("paciente");
	}
	
	//Bandera que marca si se modifica paciente o si solo se esta ingresando/corrigiendo validaciones
	boolean banderaModificarP = false;
	if(request.getAttribute("banderaModificar")!=null){
		banderaModificarP = (boolean)request.getAttribute("banderaModificar");
	}
	

	
	///Validacion de DNI
	boolean emailValidoP = true;
	boolean usuarioValidoP = true;
	boolean dniValidoP = true;
	String mensajeErrorP = null;
	if (request.getAttribute("mensajeError")!=null){
		mensajeErrorP = (String)request.getAttribute("mensajeError");
		dniValidoP = (boolean)request.getAttribute("dniValido");
		usuarioValidoP = (boolean)request.getAttribute("usuarioValido");
		emailValidoP = (boolean)request.getAttribute("emailValido");
	}
	

%>	

	<!-- Script para validacion de DNI repetido -->
	<script>
    $(document).ready(function() {
        var message = "<%= mensajeErrorP %>";

        if (message && message.trim() !== "" && message.trim() !== "null") {
            alert(message); // Display the error message in a popup
        }
    });
	</script>
	


</head>
<body>



	<h1><% if(banderaModificarP){ %>Modificar Paciente<% }else{ %>Agregar Paciente<% } %></h1>
	<form method= "post" action= "servletPaciente" >
		<div class="form-group">
		
			<% if(banderaModificarP){
			%>
				
	  		<div class="form-group">
			    <label for="idPaciente">Id del Paciente</label>
			    <input type="text" class="form-control" name="idPaciente" value="<%= aModificarP.getId()%>" readonly >
		  	</div>
				
			<% } %>
		
	  
	  	<!-- DNI PACIENTE -->
	  	
	  		  <div class="form-group">
			    <label for="dniPaciente">DNI del Paciente</label>
			    <input type="text" required class="form-control <%= (!dniValidoP) ? "is-invalid" : "" %>"" value="<%= (aModificarP != null) ? aModificarP.getDni() : "" %>" name="dniPaciente" id="dniPaciente" >
			  </div>
				  		
	  	
	  	<!-- NOMBRE PACIENTE -->
	  			
			  <div class="form-group">
			    <label for="nombrePaciente">Nombre del Paciente</label>
			    <input type="text" required class="form-control" name="nombrePaciente" id="nombrePaciente" value="<%= (aModificarP != null) ? aModificarP.getNombre() : "" %>" >
			  </div>
				  		
	  
	  
	  	<!-- APELLIDO PACIENTE -->
	  	
			  <div class="form-group">
			    <label for="apellidoPaciente">Apellido del Paciente</label>
			    <input type="text" required class="form-control" name="apellidoPaciente" id="apellidoPaciente" value="<%= (aModificarP != null) ? aModificarP.getApellido() : "" %>"  >
			  </div>
				  		
	  
	  	<!-- SEXO PACIENTE -->
	  	
	  		<div class="form-group">
 		
		    <label for="sexoPaciente">Sexo del Paciente</label>
		     <select name="sexoPaciente" class="form-control">
	     	  <option value=""> --- </option>
				  <option value="M" <%= (aModificarP != null && aModificarP.getSexo().equals("M")) ? "selected" : "" %>>Masculino</option>
				  <option value="F" <%= (aModificarP != null && aModificarP.getSexo().equals("F")) ? "selected" : "" %>>Femenino</option>
	  	     	  <option value="X" <%= (aModificarP != null && aModificarP.getSexo().equals("X")) ? "selected" : "" %>> No Binario </option>
			</select>
 		
	  		</div>
	  
	  	<!-- NACIONALIDAD PACIENTE -->
	  	
			  <div class="form-group">
			    <label for="nacionalidadPaciente">Nacionalidad del Paciente</label>
			    <input type="text" required class="form-control" name="nacionalidadPaciente" id="nacionalidadPaciente" value="<%= (aModificarP != null) ? aModificarP.getNacionalidad() : "" %>" >
			  </div>
				  		
	  
	  	<!-- FECHA DE NACIMIENTO PACIENTE -->
	  	
			  <div class="form-group">
			    <label for="fechaNacPaciente">Fecha de Nacimiento del Paciente</label>
			    <input type="text" required class="form-control datepicker" name="fechaNacimiento" id="fechaNacPaciente" value="<%= (aModificarP != null) ? aModificarP.getFechaNacimiento().format(formatoFechaP) : "" %>" >
			  </div>
				  		
	  	<!-- EMAIL PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="emailPaciente">Email del Paciente</label>
			    <input type="text" required class="form-control" name="emailPaciente" id="emailPaciente"  value="<%= (aModificarP != null) ? aModificarP.getEmail(): "" %>" >
		  	</div>
	  	
	  	<!-- TELEFONO PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="telefonoPaciente">Telefono del Paciente</label>
			    <input type="text" required class="form-control" name="telefonoPaciente" id="telefonoPaciente" value="<%= (aModificarP != null) ? aModificarP.getTelefono(): "" %>" >
		  	</div>
		  	
		<!-- CALLE PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="callePaciente">Calle del Paciente</label>
			    <input type="text" required class="form-control" name="callePaciente" id="callePaciente"   value="<%= (aModificarP != null) ? aModificarP.getDireccion().getCalle() : "" %>"  >
		  	</div>
	  
	  	<!-- NUMERO CASA PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="numeroPaciente">Numero de Domicilio del Paciente</label>
			    <input type="text" required class="form-control" name="numeroPaciente" id="numeroPaciente"  value="<%= (aModificarP != null) ? aModificarP.getDireccion().getNumero() : "" %>">
		  	</div>
	  	
	  	<!-- LOCALIDAD PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="localidadPaciente">Localidad del Paciente</label>
			    <input type="text" required class="form-control" name="localidadPaciente" id="localidadPaciente" value="<%= (aModificarP != null) ? aModificarP.getDireccion().getLocalidad() : "" %>"  >	
		  	</div>
	  	
	  	<!-- PROVINCIA PACIENTE -->
	  	
	  	<div class="form-group">
			    <label for="provinciaPaciente">Provincia del Paciente</label>
			    <select name="provinciaPaciente" class="form-control">
					  <option value=""> --- </option>
  					  <option value="Buenos Aires" <%= (aModificarP != null && aModificarP.getDireccion().getProvincia().equals("Buenos Aires")) ? "selected" : "" %>>Buenos Aires</option>
					  <option value="Ciudad Autonoma de Buenos Aires" <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("Ciudad Autonoma de Buenos Aires")) ? "selected" : "" %>>Ciudad Autónoma de Buenos Aires</option>
		  	     	  <option value="Catamarca" <%= (aModificarP != null && aModificarP.getDireccion().getProvincia().equals("Catamarca")) ? "selected" : "" %>> Catamarca </option>
					  <option value="Chaco" <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("Chaco")) ? "selected" : "" %>> Chaco </option>
					  <option value="Chubut" <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("Chubut")) ? "selected" : "" %>> Chubut </option>
					  <option value="Cordoba" <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("Cordoba")) ? "selected" : "" %>> Córdoba </option>
					  <option value="Corrientes" <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("Corrientes")) ? "selected" : "" %>> Corrientes </option>
					  <option value="Entre Rios" <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("Entre Rios")) ? "selected" : "" %>> Entre Ríos </option>
					  <option value="Formosa" <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("Formosa")) ? "selected" : "" %>> Formosa </option>
					  <option value="Jujuy" <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("Jujuy")) ? "selected" : "" %>> Jujuy </option>
					  <option value="La Pampa" <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("La Pampa")) ? "selected" : "" %>> La Pampa </option>
					  <option value="Mendoza" <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("Mendoza")) ? "selected" : "" %>> Mendoza </option>				
					  <option value="Misiones" <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("Misiones")) ? "selected" : "" %>> Misiones </option>					  
					  <option value="Neuquen"  <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("Neuquen")) ? "selected" : "" %>> Neuquén </option>					  
					  <option value="Rio Negro" <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("Rio Negro")) ? "selected" : "" %>> Río Negro </option>					  
					  <option value="Salta" <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("Salta")) ? "selected" : "" %>> Salta </option>					  
					  <option value="San Juan" <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("San Juan")) ? "selected" : "" %>> San Juan </option>					  
					  <option value="San Luis" <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("San Luis")) ? "selected" : "" %>> San Luis </option>
 					  <option value="Santa Cruz" <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("Santa Cruz")) ? "selected" : "" %>> Santa Cruz </option>
 					  <option value="Santa Fe" <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("Santa Fe")) ? "selected" : "" %>> Santa Fe </option>
 					  <option value="Santiago del Estero" <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("Santiago del Estero")) ? "selected" : "" %>> Santiago del Estero </option>
 					  <option value="Tierra del Fuego" <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("Tierra del Fuego")) ? "selected" : "" %>> Tierra del Fuego </option>
 					  <option value="Tucuman" <%= (aModificarP!= null && aModificarP.getDireccion().getProvincia().equals("Tucuman")) ? "selected" : "" %>> Tucumán </option>
				</select> 
 				<label for="provinciaPaciente">
		  	
		  		</label>
	  		</div>
	  	

		<!--  CODIGO POSTAL  PACIENTE -->
	  	
	  		<div class="form-group">
			    <label for="codigoPostalPaciente">Codigo Postal del Paciente</label>
			    <input type="text" required class="form-control" name="codigoPostalPaciente" id="codigoPostalPaciente" value="<%= (aModificarP != null) ? aModificarP.getDireccion().getCodigoPostal() : "" %>"   >
		  	</div>	
	  
	  		
  			<br>
  			<input type="submit" class="btn btn-dark" name="btnAgregarPaciente" value="<% if(banderaModificarP){ %>Modificar Paciente<% }else{ %>Agregar Paciente<% } %>" >
	  
	  	</div>

	  
	  <!-- ACA VER SI TOMAR VALOR DE SESION O AGREGAR DDL -->
	  

	</form>
	
	
	
	
</body>
</html>