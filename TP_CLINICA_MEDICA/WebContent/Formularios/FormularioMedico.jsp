<%@ page import="dominio.Medico"%>
<%@ page import="dominio.Especialidad"%>
<%@ page import="daoImpl.EspecialidadDaoImpl" %>
<%@ page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 

	ArrayList<Especialidad> listaEspecialidades = null;
	EspecialidadDaoImpl esp = new EspecialidadDaoImpl();
	listaEspecialidades = esp.listarEspecialidades();
%>	


	<h1>Agregar Medico</h1>
	<form method="post" action="servletMedico">
	<div class="form-group">
		
	  	<!-- USUARIO Medico -->
	  
  		<div class="form-group">
		    <label for="dniMedico">Nombre de Usuario</label>
		    <input type="text" class="form-control" name="usuarioMedico" >
	  	</div>
  
	   	<!-- USUARIO Medico -->
	  
  		<div class="form-group">
		    <label for="dniMedico">Contraseña de Usuario</label>
		    <input type="password" class="form-control" name="contrasenaMedico" >
	  	</div>
  
  		<!-- ESPECIALIDAD Medico -->
		<div class="form-group">
		    <label for="especialidadMedico">Especialidad del Medico</label>
		    <select name=especialidadMedico class="form-control">
	   		  	<option> --- </option>
				<%
					for(Especialidad e : listaEspecialidades){
						out.println(e.formatoDDL());
					}
				
				%>
			</select>
		</div>
	  
	  	<!-- DNI Medico -->
	  	
	  		<div class="form-group">
			    <label for="dniMedico">DNI del Medico</label>
			    <input type="text" class="form-control" name="dniMedico" >
			  </div>
				  		
	  	<!-- NOMBRE Medico -->
	  			
			<div class="form-group">
			    <label for="nombreMedico">Nombre del Medico</label>
			    <input type="text" class="form-control" name="nombreMedico" >
			  </div>
				  		
	  	<!-- APELLIDO Medico -->

			<div class="form-group">
			    <label for="apellidoMedico">Apellido del Medico</label>
			    <input type="text" class="form-control" name="apellidoMedico" >
			  </div>
				  		
	  	<!-- SEXO Medico -->
	  	
	  		<div class="form-group">
 		
			    <label for="sexoMedico">Sexo del Medico</label>
			    <select name="sexoMedico" class="form-control">
					  <option value=""> --- </option>
					  <option value="M">Masculino</option>
					  <option value="F">Femenino</option>
		  	     	  <option value="X"> No Binario </option>
				</select> 
 		
	  		</div>
	  
	  	<!-- NACIONALIDAD Medico -->
	  	
			<div class="form-group">
			    <label for="nacionalidadMedico">Nacionalidad del Medico</label>
			    <input type="text" class="form-control" name="nacionalidadMedico" >
			  </div>
				  		
	  	<!-- FECHA DE NACIMIENTO Medico -->
	  	
			<div class="form-group">
			    <label for="fechaNacMedico">Fecha de Nacimiento del Medico</label>
			    <input type="date" class="form-control" name="fechaNacimientoMedico" >
			</div>
				  		
	  	<!-- CALLE Medico -->
	  
	  		<div class="form-group">
			    <label for="direccionMedico">Calle de Domicilio del Medico</label>
			    <input type="text" class="form-control" name="calleMedico" >
		  	</div>
		  	
		<!-- NUMERO DIRECCION Medico -->
		
	  
	  		<div class="form-group">
			    <label for="direccionMedico">Numero de Domicilio del Medico</label>
			    <input type="text" class="form-control" name="numeroMedico" >
		  	</div>
		  	
	  	<!-- LOCALIDAD Medico -->
	  
	  		<div class="form-group">
			    <label for="localidadMedico">Localidad del Medico</label>
			    <input type="text" class="form-control" name="localidadMedico" >
		  	</div>	
	  
	  	<!-- PROVINCIA Medico -->
	  	
	  		<div class="form-group">
			    <label for="provinciaMedico">Provincia del Medico</label>
			    <input type="text" class="form-control" name="provinciaMedico" >
		  	</div>	
	  
	   	<!-- PAIS Medico -->
	  	
	  		<div class="form-group">
			    <label for="paisMedico">Pais de Residencia del Medico</label>
			    <input type="text" class="form-control" name="paisMedico" >
		  	</div>	
	  
  	   	<!-- CODIGO POSTAL Medico -->
	  	
	  		<div class="form-group">
			    <label for="paisMedico">Codigo Postal del Medico</label>
			    <input type="text" class="form-control" name="codigoPostalMedico" >
		  	</div>	
	  	  
	  	<!-- CORREO ELECTRONICO Medico -->
	  
	  		<div class="form-group">
			    <label for="mailMedico">Correo Electronico del Medico</label>
			    <input type="email" class="form-control" name="emailMedico" >
		  	</div>	
	  
	  
	  
	  	<!-- TELEFONO Medico -->
	  
	  		<div class="form-group">
			    <label for="telMedico">Telefono del Medico</label>
			    <input type="number" class="form-control" name="telefonoMedico" >
		  	</div>	
		  	

		
		<!-- a implementar mas tarde -->
		
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
	   <input type="submit" class="btn btn-dark" name="btnAgregar" value="Agregar Medico">
	  
	  </div>


	  
	  <!-- ACA VER SI TOMAR VALOR DE SESION O AGREGAR DDL -->
	  

	</form>
	


</body>
</html>