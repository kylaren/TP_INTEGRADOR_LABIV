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
</head>
<body>



	<h1>Agregar Paciente</h1>
	<form method= "post" action= "servletPaciente" >
		<div class="form-group">
		
	  
	  	<!-- DNI PACIENTE -->
	  	
	  		  <div class="form-group">
			    <label for="dniPaciente">DNI del Paciente</label>
			    <input type="text" class="form-control" name="dniPaciente" id="dniPaciente" >
			  </div>
				  		
	  	
	  	<!-- NOMBRE PACIENTE -->
	  			
			  <div class="form-group">
			    <label for="nombrePaciente">Nombre del Paciente</label>
			    <input type="text" class="form-control" name="nombrePaciente" id="nombrePaciente" >
			  </div>
				  		
	  
	  
	  	<!-- APELLIDO PACIENTE -->
	  	
			  <div class="form-group">
			    <label for="apellidoPaciente">Apellido del Paciente</label>
			    <input type="text" class="form-control" name="apellidoPaciente" id="apellidoPaciente" >
			  </div>
				  		
	  
	  	<!-- SEXO PACIENTE -->
	  	
	  		<div class="form-group">
 		
		    <label for="sexoPaciente">Sexo del Paciente</label>
		     <select name="sexoPaciente" class="form-control">
	     	  <option value=""> --- </option>
			  <option value="M">Masculino</option>
			  <option value="F">Femenino</option>
  	     	  <option value="X"> No Binario </option>
			</select>
 		
	  		</div>
	  
	  	<!-- NACIONALIDAD PACIENTE -->
	  	
			  <div class="form-group">
			    <label for="nacionalidadPaciente">Nacionalidad del Paciente</label>
			    <input type="text" class="form-control" name="nacionalidadPaciente" id="nacionalidadPaciente" >
			  </div>
				  		
	  
	  	<!-- FECHA DE NACIMIENTO PACIENTE -->
	  	
			  <div class="form-group">
			    <label for="fechaNacPaciente">Fecha de Nacimiento del Paciente</label>
			    <input type="text" class="form-control datepicker" name="fechaNacimiento" id="fechaNacPaciente" >
			  </div>
				  		
	  	<!-- EMAIL PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="emailPaciente">Email del Paciente</label>
			    <input type="text" class="form-control" name="emailPaciente" id="emailPaciente" >
		  	</div>
	  	
	  	<!-- TELEFONO PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="telefonoPaciente">Telefono del Paciente</label>
			    <input type="text" class="form-control" name="telefonoPaciente" id="telefonoPaciente" >
		  	</div>
		  	
		<!-- CALLE PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="callePaciente">Calle del Paciente</label>
			    <input type="text" class="form-control" name="callePaciente" id="callePaciente" >
		  	</div>
	  
	  	<!-- NUMERO CASA PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="numeroPaciente">Numero de casa del Paciente</label>
			    <input type="text" class="form-control" name="numeroPaciente" id="numeroPaciente" >
		  	</div>
	  	
	  	<!-- LOCALIDAD PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="localidadPaciente">Localidad del Paciente</label>
			    <input type="text" class="form-control" name="localidadPaciente" id="localidadPaciente" >
		  	</div>
	  	
	  	<!-- PROVINCIA PACIENTE -->
	  	
	  		<div class="form-group">
			    <label for="provinciaPaciente">Provincia del Paciente</label>
			    <input type="text" class="form-control" name="provinciaPaciente" id="provinciaPaciente" >
		  	</div>	
	  	
	  	<!-- PAIS PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="paisPaciente">Pais del Paciente</label>
			    <input type="text" class="form-control" name="paisPaciente" id="paisPaciente" >
		  	</div>
		  	
		<!--  CODIGO POSTAL  PACIENTE -->
	  	
	  		<div class="form-group">
			    <label for="codigoPostalPaciente">Codigo Postal del Paciente</label>
			    <input type="text" class="form-control" name="codigoPostalPaciente" id="codigoPostalPaciente" >
		  	</div>	
	  
	  		
  			<br>
  			<input type="submit" class="btn btn-dark" name="btnAgregarPaciente" value="Agregar Paciente" >
	  
	  	</div>

	  
	  <!-- ACA VER SI TOMAR VALOR DE SESION O AGREGAR DDL -->
	  

	</form>
	
	
	
	
</body>
</html>