<%@ page import="dominio.Medico"%>
<%@ page import="dominio.Especialidad"%>
<%@ page import="daoImpl.EspecialidadDaoImpl" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.time.format.DateTimeFormatter"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario Medico</title>

	
<% 
	//Formato para fechas
	DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	//Arraylist de especialidades
	ArrayList<Especialidad> listaEspecialidades = null;
	if(request.getAttribute("especialidades")!=null)
	{
		listaEspecialidades = (ArrayList<Especialidad>)request.getAttribute("especialidades");
	}
	
	//Carga de medico
	Medico aModificar = null;
	if(request.getAttribute("medico")!=null)
	{
		aModificar = (Medico)request.getAttribute("medico");
	}
	
	//Bandera que marca si se modifica medico o si solo se esta ingresando/corrigiendo validaciones
	boolean banderaModificar = false;
	if(request.getAttribute("banderaModificar")!=null){
		banderaModificar = (boolean)request.getAttribute("banderaModificar");
	}
	
	
	
	///Validacion de DNI
	boolean emailValido = true;
	boolean usuarioValido = true;
	boolean dniValido = true;
	String mensajeError = null;
	if (request.getAttribute("mensajeError")!=null){
		mensajeError = (String)request.getAttribute("mensajeError");
		dniValido = (boolean)request.getAttribute("dniValido");
		usuarioValido = (boolean)request.getAttribute("usuarioValido");
		emailValido = (boolean)request.getAttribute("emailValido");
	}


%>	




	<!-- Script para validacion de DNI repetido -->
	<script>
    $(document).ready(function() {
        var message = "<%= mensajeError %>";

        if (message && message.trim() !== "" && message.trim() !== "null") {
            alert(message); // Display the error message in a popup
        }
    });
	</script>
	


</head>
<body>



	<h1><% if(banderaModificar){ %>Modificar Medico<% }else{ %>Agregar Medico<% } %></h1>
	<form method="post" action="servletMedico">
	<div class="form-group">
		
		
		<% if(banderaModificar){
		%>
			
  		<div class="form-group">
		    <label for="idMedico">Id del Usuario</label>
		    <input type="text" class="form-control" name="idMedico" value="<%= aModificar.getId()%>" readonly >
	  	</div>
			
		<% } %>
			
		
		
	  	<!-- USUARIO Medico -->
	  
  		<div class="form-group">
		    <label for="usuarioMedico">Nombre de Usuario</label>
		    <input type="text" required class="form-control <%= (!usuarioValido) ? "is-invalid" : "" %>" name="usuarioMedico" value="<%= (aModificar != null) ? aModificar.getUsuario() : "" %>" >
	  		<label for="usuarioMedico"><% if(!usuarioValido){ %>
	  			Usuario registrado en el sistema 
	  		<% } %></label>
	  	</div>
  
	   	<!-- CONTRASENA Medico -->
	  
  		<div class="form-group">
		    <label for="contrasenaMedico">Contraseña</label>
		    <input type="password" required  class="form-control" name="contrasenaMedico" value="<%= (aModificar != null) ? aModificar.getContrasena() : "" %>">
			<label for="contrasenaMedico">

	  		</label>
	  	</div>
  
  		<!-- ESPECIALIDAD Medico -->
		<div class="form-group">
		    <label for="especialidadMedico">Especialidad del Medico</label>
		    <select name=especialidadMedico class="form-control">
	   		  	<option> --- </option>
			    <% for(Especialidad e : listaEspecialidades) { %>
			      <option value="<%= e.getIdEspecialidad() %>" <%= (aModificar != null && aModificar.getEspecialidad().getNombreEspecialidad() == e.getNombreEspecialidad()) ? "selected" : "" %>>
			        <%= e.getNombreEspecialidad() %>: <%= e.getDescripcionEspecialidad()%>
			      </option>
			    <% } %>
			</select>
			<label for="especialidadMedico">

	  		</label>
			
		</div>
	  
	  	<!-- DNI Medico -->
	  	
	  		<div class="form-group">
			    <label for="dniMedico">DNI</label>
			    <input type="text" required class="form-control <%= (!dniValido) ? "is-invalid" : "" %>" name="dniMedico" value="<%= (aModificar != null) ? aModificar.getDni() : "" %>">
				<label for="dniMedico">
					<% if(!usuarioValido){ %>
		  				DNI registrado en el sistema 
			  	
			  		<% } %>
		  		</label>
			
			</div>
				  		
	  	<!-- NOMBRE Medico -->
	  			
			<div class="form-group">
			    <label for="nombreMedico">Nombre</label>
			    <input type="text" required class="form-control" name="nombreMedico" value="<%= (aModificar != null) ? aModificar.getNombre() : "" %>" >
			  	<label for="nombreMedico">

	  			</label>
			  </div>
			  
				  		
	  	<!-- APELLIDO Medico -->

			<div class="form-group">
			    <label for="apellidoMedico">Apellido</label>
			    <input type="text" required class="form-control" name="apellidoMedico" value="<%= (aModificar != null) ? aModificar.getApellido() : "" %>" >
				<label for="apellidoMedico">

	  			</label>
			</div>
				  		
	  	<!-- SEXO Medico -->
	  	
	  		<div class="form-group">
 		
			    <label for="sexoMedico">Sexo</label>
			    <select name="sexoMedico" class="form-control">
					  <option value=""> --- </option>
					  <option value="M" <%= (aModificar != null && aModificar.getSexo().equals("M")) ? "selected" : "" %>>Masculino</option>
					  <option value="F" <%= (aModificar != null && aModificar.getSexo().equals("F")) ? "selected" : "" %>>Femenino</option>
		  	     	  <option value="X" <%= (aModificar != null && aModificar.getSexo().equals("X")) ? "selected" : "" %>> No Binario </option>
				</select> 
 				<label for="sexoMedico">
	
		  		</label>
	  		</div>
	  
	  	<!-- NACIONALIDAD Medico -->
	  	
			<div class="form-group">
			    <label for="nacionalidadMedico">Nacionalidad</label>
			    <input type="text" required class="form-control" name="nacionalidadMedico" value="<%= (aModificar != null) ? aModificar.getNacionalidad() : "" %>" >
				<label for="nacionalidadMedico">
		
	  			</label>
			</div>
				  		
	  	<!-- FECHA DE NACIMIENTO Medico -->
	  	
			<div class="form-group">
			    <label for="fechaNacMedico">Fecha de Nacimiento</label>
			    <input type="text" required class="form-control datepicker" name="fechaNacimientoMedico" value="<%= (aModificar != null) ? aModificar.getFechaNacimiento().format(formatoFecha) : "" %>">
				<label for="fechaNacMedico">
		  		
	  			</label>
			</div>
				  		
	  	<!-- CALLE Medico -->
	  
	  		<div class="form-group">
			    <label for="direccionMedico">Calle de Domicilio</label>
			    <input type="text" required class="form-control" name="calleMedico" value="<%= (aModificar != null) ? aModificar.getDireccion().getCalle() : "" %>"  >
		  		<label for="calleMedico">
		 
	  			</label>
		  	</div>
		  	
		<!-- NUMERO DIRECCION Medico -->
		
	  
	  		<div class="form-group">
			    <label for="direccionMedico">Numero de Domicilio</label>
			    <input type="text" required class="form-control" name="numeroMedico" value="<%= (aModificar != null) ? aModificar.getDireccion().getNumero() : "" %>"  >
	  			<label for="numeroMedico">
	
	  			</label>
		  	</div>
		  	
	  	<!-- LOCALIDAD Medico -->
	  
	  		<div class="form-group">
			    <label for="localidadMedico">Localidad</label>
			    <input type="text" class="form-control" required name="localidadMedico" value="<%= (aModificar != null) ? aModificar.getDireccion().getLocalidad() : "" %>"  >
		  		<label for="localidadMedico">
		  	
	  			</label>
		  	</div>	
	  
	  	<!-- PROVINCIA Medico -->
	  	
	  		<div class="form-group">
			    <label for="provinciaMedico">Provincia</label>
			    <select name="provinciaMedico" class="form-control">
					  <option value=""> --- </option>
  					  <option value="Buenos Aires" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("Buenos Aires")) ? "selected" : "" %>>Buenos Aires</option>
					  <option value="Ciudad Autonoma de Buenos Aires" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("Ciudad Autonoma de Buenos Aires")) ? "selected" : "" %>>Ciudad Autónoma de Buenos Aires</option>
		  	     	  <option value="Catamarca" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("Catamarca")) ? "selected" : "" %>> Catamarca </option>
					  <option value="Chaco" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("Chaco")) ? "selected" : "" %>> Chaco </option>
					  <option value="Chubut" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("Chubut")) ? "selected" : "" %>> Chubut </option>
					  <option value="Cordoba" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("Cordoba")) ? "selected" : "" %>> Córdoba </option>
					  <option value="Corrientes" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("Corrientes")) ? "selected" : "" %>> Corrientes </option>
					  <option value="Entre Rios" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("Entre Rios")) ? "selected" : "" %>> Entre Ríos </option>
					  <option value="Formosa" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("Formosa")) ? "selected" : "" %>> Formosa </option>
					  <option value="Jujuy" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("Jujuy")) ? "selected" : "" %>> Jujuy </option>
					  <option value="La Pampa" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("La Pampa")) ? "selected" : "" %>> La Pampa </option>
					  <option value="Mendoza" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("Mendoza")) ? "selected" : "" %>> Mendoza </option>				
					  <option value="Misiones" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("Misiones")) ? "selected" : "" %>> Misiones </option>					  
					  <option value="Neuquen"  <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("Neuquen")) ? "selected" : "" %>> Neuquén </option>					  
					  <option value="Rio Negro" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("Rio Negro")) ? "selected" : "" %>> Río Negro </option>					  
					  <option value="Salta" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("Salta")) ? "selected" : "" %>> Salta </option>					  
					  <option value="San Juan" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("San Juan")) ? "selected" : "" %>> San Juan </option>					  
					  <option value="San Luis" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("San Luis")) ? "selected" : "" %>> San Luis </option>
 					  <option value="Santa Cruz" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("Santa Cruz")) ? "selected" : "" %>> Santa Cruz </option>
 					  <option value="Santa Fe" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("Santa Fe")) ? "selected" : "" %>> Santa Fe </option>
 					  <option value="Santiago del Estero" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("Santiago del Estero")) ? "selected" : "" %>> Santiago del Estero </option>
 					  <option value="Tierra del Fuego" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("Tierra del Fuego")) ? "selected" : "" %>> Tierra del Fuego </option>
 					  <option value="Tucuman" <%= (aModificar != null && aModificar.getDireccion().getProvincia().equals("Tucuman")) ? "selected" : "" %>> Tucumán </option>
				</select> 
 				<label for="provinciaMedico">
		  	
		  		</label>
	  		</div>


	  
  	   	<!-- CODIGO POSTAL Medico -->
	  	
	  		<div class="form-group">
			    <label for="paisMedico">Codigo Postal</label>
			    <input type="text" required class="form-control" name="codigoPostalMedico" value="<%= (aModificar != null) ? aModificar.getDireccion().getCodigoPostal() : "" %>" >
	  			<label for="codigoPostalMedico">
		  
		  		</label>
		  	</div>	
	  	  
	  	<!-- CORREO ELECTRONICO Medico -->
	  
	  		<div class="form-group">
			    <label for="mailMedico">Correo Electronico</label>
			    <input type="email" required class="form-control <%= (!emailValido) ? "is-invalid" : "" %>" name="emailMedico" value="<%= (aModificar != null) ? aModificar.getEmail(): "" %>" >
		  		<label for="mailMedico">
		  	
		  		</label>
		  	</div>	
	  
	  
	  
	  	<!-- TELEFONO Medico -->
	  
	  		<div class="form-group">
			    <label for="telMedico">Telefono</label>
			    <input type="number" required class="form-control" name="telefonoMedico" value="<%= (aModificar != null) ? aModificar.getTelefono(): "" %>" >
		  		<label for="telefonoMedico">
		  		
		  		</label>
		  	</div>	
		  	

		
		<!-- a implementar mas tarde -->
	
		
		<% if(!banderaModificar){
			%>
			
				
		<!-- DIA DE ATENCION Medico -->  
			<div class="form-group">
			    <label for="diaMedico">Dia de atencion del Medico</label>
			    <select name="diaMedico" class="form-control">
		   		  <option value=""> --- </option>
				  <option value="Lunes">Lunes</option>
				  <option value="Martes">Martes</option>
				  <option value="Miercoles">Miercoles</option>
				  <option value="Jueves">Jueves</option>		  
				  <option value="Viernes">Viernes</option>
				</select>
			</div>
		
			<!-- HORARIO DE INICIO DE JORNADA	 Medico -->
		 
		   	 <div class="form-group">
			    <label for="inicioJornadaMedico">Inicio de Jornada</label>
			     <select name="inicioJornadaMedico" class="form-control">
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
		 
 		<!-- HORARIO DE FIN DE JORNADA	 Medico -->
		 
		   	 <div class="form-group">
			    <label for="finalJornadaMedico">Fin de Jornada</label>
			     <select name="finalJornadaMedico" class="form-control">
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
		 
			
		<% } %>
			
		
		 
	  <br>
	   <input type="submit" class="btn btn-dark" name="btnAgregar" value="<% if(banderaModificar){ %>Modificar Medico<% }else{ %>Agregar Medico<% } %>">
	  
	  </div>


	  
	  <!-- ACA VER SI TOMAR VALOR DE SESION O AGREGAR DDL -->
	  

	</form>
	


</body>
</html>