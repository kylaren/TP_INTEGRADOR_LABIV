<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario Paciente</title>
</head>
<body>
	<h1>Agregar Paciente</h1>
	<form action= "servletMaster" method= post>
		<div class="form-group">
		
	  
	  	<!-- DNI PACIENTE -->
	  	
	  		  <div class="form-group">
			    <label for="dniPaciente">DNI del Paciente</label>
			    <input type="text" class="form-control" id="dniPaciente" >
			  </div>
				  		
	  	
	  	<!-- NOMBRE PACIENTE -->
	  			
			  <div class="form-group">
			    <label for="nombrePaciente">Nombre del Paciente</label>
			    <input type="text" class="form-control" id="nombrePaciente" >
			  </div>
				  		
	  
	  
	  	<!-- APELLIDO PACIENTE -->
	  	
			  <div class="form-group">
			    <label for="apellidoPaciente">Apellido del Paciente</label>
			    <input type="text" class="form-control" id="apellidoPaciente" >
			  </div>
				  		
	  
	  	<!-- SEXO PACIENTE -->
	  	
	  		<div class="form-group">
 		
		    <label for="sexoPaciente">Sexo del Paciente</label>
		     <select class="form-control">
	     	  <option> --- </option>
			  <option>Masculino</option>
			  <option>Femenino</option>
  	     	  <option> No Binario </option>
			</select>
 		
	  		</div>
	  
	  	<!-- NACIONALIDAD PACIENTE -->
	  	
			  <div class="form-group">
			    <label for="nacionalidadPaciente">Nacionalidad del Paciente</label>
			    <input type="text" class="form-control" id="nacionalidadPaciente" >
			  </div>
				  		
	  
	  	<!-- FECHA DE NACIMIENTO PACIENTE -->
	  	
			  <div class="form-group">
			    <label for="fechaNacPaciente">Fecha de Nacimiento del Paciente</label>
			    <input type="date" class="form-control" name="fechaNacimiento" id="fechaNacPaciente" >
			  </div>
				  		
	  	<!-- EMAIL PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="emailPaciente">Email del Paciente</label>
			    <input type="text" class="form-control" id="emailPaciente" >
		  	</div>
	  	
	  	<!-- TELEFONO PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="telefonoPaciente">Telefono del Paciente</label>
			    <input type="text" class="form-control" id="telefonoPaciente" >
		  	</div>
		  	
		<!-- CALLE PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="callePaciente">Calle del Paciente</label>
			    <input type="text" class="form-control" id="callePaciente" >
		  	</div>
	  
	  	<!-- NUMERO CASA PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="numeroPaciente">Numero de casa del Paciente</label>
			    <input type="text" class="form-control" id="numeroPaciente" >
		  	</div>
	  	
	  	<!-- LOCALIDAD PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="localidadPaciente">Localidad del Paciente</label>
			    <input type="text" class="form-control" id="localidadPaciente" >
		  	</div>
	  	
	  	<!-- PROVINCIA PACIENTE -->
	  	
	  		<div class="form-group">
			    <label for="provinciaPaciente">Provincia del Paciente</label>
			    <input type="text" class="form-control" id="provinciaPaciente" >
		  	</div>	
	  	
	  	<!-- PAIS PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="paisPaciente">Pais del Paciente</label>
			    <input type="text" class="form-control" id="paisPaciente" >
		  	</div>
		  	
		<!--  CODIGO POSTAL  PACIENTE -->
	  	
	  		<div class="form-group">
			    <label for="codigoPostalPaciente">Codigo Postal del Paciente</label>
			    <input type="text" class="form-control" id="codigoPostalPaciente" >
		  	</div>	
	  
	  		
	  			<br>
	  			<button type="submit" class="btn btn-dark" value="Agregar Paciente" name="btnAgregarPaciente">Agregar Paciente</button>
	  
	  	</div>

	  
	  <!-- ACA VER SI TOMAR VALOR DE SESION O AGREGAR DDL -->
	  

	</form>
	
	
	
	
</body>
</html>