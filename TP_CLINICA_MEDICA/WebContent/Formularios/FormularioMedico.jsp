<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<h1>Agregar Medico</h1>
	<form>
	<div class="form-group">
		
	  
	  	<!-- DNI Medico -->
	  	
	  		<div class="form-group">
			    <label for="dniMedico">DNI del Medico</label>
			    <input type="text" class="form-control" id="dniMedico" >
			  </div>
				  		
	  	
	  	<!-- NOMBRE Medico -->
	  			
			<div class="form-group">
			    <label for="nombreMedico">Nombre del Medico</label>
			    <input type="text" class="form-control" id="nombreMedico" >
			  </div>
				  		
	  
	  
	  	<!-- APELLIDO Medico -->
	  	
			<div class="form-group">
			    <label for="apellidoMedico">Apellido del Medico</label>
			    <input type="text" class="form-control" id="apellidoMedico" >
			  </div>
				  		
	  
	  	<!-- SEXO Medico -->
	  	
	  		<div class="form-group">
 		
			    <label for="sexoMedico">Sexo del Medico</label>
			     <select class="form-control">
		     	  <option> --- </option>
				  <option>Masculino</option>
				  <option>Femenino</option>
	  	     	  <option> No Binario </option>
				</select>
 		
	  		</div>
	  
	  	<!-- NACIONALIDAD Medico -->
	  	
			<div class="form-group">
			    <label for="nacionalidadMedico">Nacionalidad del Medico</label>
			    <input type="text" class="form-control" id="nacionalidadMedico" >
			  </div>
				  		
	  
	  	<!-- FECHA DE NACIMIENTO Medico -->
	  	
			<div class="form-group">
			    <label for="fechaNacMedico">Fecha de Nacimiento del Medico</label>
			    <input type="date" class="form-control" id="fechaNacMedico" >
			  </div>
				  		
	  
	  	<!-- DIRECCION Medico -->
	  
	  		<div class="form-group">
			    <label for="direccionMedico">Direccion del Medico</label>
			    <input type="text" class="form-control" id="direccionMedico" >
		  	</div>
	  
	  	<!-- LOCALIDAD Medico -->
	  
	  		<div class="form-group">
			    <label for="localidadMedico">Localidad del Medico</label>
			    <input type="text" class="form-control" id="localidadMedico" >
		  	</div>	
	  
	  
	  	<!-- PROVINCIA Medico -->
	  	
	  		<div class="form-group">
			    <label for="provinciaMedico">Localidad del Medico</label>
			    <input type="text" class="form-control" id="provinciaMedico" >
		  	</div>	
	  
	  	
	  
	  	<!-- CORREO ELECTRONICO Medico -->
	  
	  		<div class="form-group">
			    <label for="mailMedico">Correo Electronico del Medico</label>
			    <input type="email" class="form-control" id="mailMedico" >
		  	</div>	
	  
	  
	  
	  	<!-- TELEFONO Medico -->
	  
	  		<div class="form-group">
			    <label for="telMedico">Telefono del Medico</label>
			    <input type="number" class="form-control" id="telMedico" >
		  	</div>	
		  	
		<!-- ESPECIALIDAD Medico -->
			<div class="form-group">
			    <label for="especialidadMedico">Especialidad del Medico</label>
			    <select class="form-control">
		   		  <option> --- </option>
				  <option>Gastroenterologia</option>
				  <option>Dentista</option>
				</select>
			</div>
		
		<!-- DIA DE ATENCION Medico -->  
			<div class="form-group">
			    <label for="diaMedico">Dia de atencion del Medico</label>
			    <select class="form-control">
		   		  <option> --- </option>
				  <option>Lunes</option>
				  <option>Martes</option>
				  <option>Miercoles</option>
				  <option>Jueves</option>		  
				  <option>Viernes</option>
				</select>
			</div>
		
			
		<!-- HORARIO DE ATENCION Medico -->
		 
		   	 <div class="form-group">
			    <label for="exampleInputEmail1">Horario</label>
			     <select class="form-control">
				      <option> --- </option>
				  	  <option>11:00</option>
				  	  <option>12:00</option>
				  	  <option>13:00</option>
				  	  <option>14:00</option>
				  	  <option>15:00</option>
				  	  <option>16:00</option>
				  	  <option>17:00</option>
				</select>
			    
			  </div>
		 
		 
		 
	  <br>
	  <button type="submit" class="btn btn-dark">Agregar Medico</button>
	  
	  </div>


	  
	  <!-- ACA VER SI TOMAR VALOR DE SESION O AGREGAR DDL -->
	  

	</form>
	


</body>
</html>