<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Agregar Paciente</h1>
	<div class="form-group">
		<form>
	  
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
			    <input type="date" class="form-control" id="fechaNacPaciente" >
			  </div>
				  		
	  
	  	<!-- DIRECCION PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="direccionPaciente">Direccion del Paciente</label>
			    <input type="text" class="form-control" id="direccionPaciente" >
		  	</div>
	  
	  	<!-- LOCALIDAD PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="localidadPaciente">Localidad del Paciente</label>
			    <input type="text" class="form-control" id="localidadPaciente" >
		  	</div>	
	  
	  
	  	<!-- PROVINCIA PACIENTE -->
	  	
	  		<div class="form-group">
			    <label for="provinciaPaciente">Localidad del Paciente</label>
			    <input type="text" class="form-control" id="provinciaPaciente" >
		  	</div>	
	  
	  	
	  
	  	<!-- CORREO ELECTRONICO PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="mailPaciente">Correo Electronico del Paciente</label>
			    <input type="email" class="form-control" id="mailPaciente" >
		  	</div>	
	  
	  
	  
	  	<!-- TELEFONO PACIENTE -->
	  
	  		<div class="form-group">
			    <label for="telPaciente">Telefono del Paciente</label>
			    <input type="number" class="form-control" id="telPaciente" >
		  	</div>	
	  <br>
	  <button type="submit" class="btn btn-dark">Agregar Paciente</button>
	  
	  </div>


	  
	  <!-- ACA VER SI TOMAR VALOR DE SESION O AGREGAR DDL -->
	  

	</form>
	
	
	
	
</body>
</html>