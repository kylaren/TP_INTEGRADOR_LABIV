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
		    <label for="dniMedico">Contraseña</label>
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
			    <label for="dniMedico">DNI</label>
			    <input type="text" class="form-control" name="dniMedico" >
			  </div>
				  		
	  	<!-- NOMBRE Medico -->
	  			
			<div class="form-group">
			    <label for="nombreMedico">Nombre</label>
			    <input type="text" class="form-control" name="nombreMedico" >
			  </div>
				  		
	  	<!-- APELLIDO Medico -->

			<div class="form-group">
			    <label for="apellidoMedico">Apellido</label>
			    <input type="text" class="form-control" name="apellidoMedico" >
			  </div>
				  		
	  	<!-- SEXO Medico -->
	  	
	  		<div class="form-group">
 		
			    <label for="sexoMedico">Sexo</label>
			    <select name="sexoMedico" class="form-control">
					  <option value=""> --- </option>
					  <option value="M">Masculino</option>
					  <option value="F">Femenino</option>
		  	     	  <option value="X"> No Binario </option>
				</select> 
 		
	  		</div>
	  
	  	<!-- NACIONALIDAD Medico -->
	  	
			<div class="form-group">
			    <label for="nacionalidadMedico">Nacionalidad</label>
			    <input type="text" class="form-control" name="nacionalidadMedico" >
			  </div>
				  		
	  	<!-- FECHA DE NACIMIENTO Medico -->
	  	
			<div class="form-group">
			    <label for="fechaNacMedico">Fecha de Nacimiento</label>
			    <input type="date" class="form-control" name="fechaNacimientoMedico" >
			</div>
				  		
	  	<!-- CALLE Medico -->
	  
	  		<div class="form-group">
			    <label for="direccionMedico">Calle de Domicilio</label>
			    <input type="text" class="form-control" name="calleMedico" >
		  	</div>
		  	
		<!-- NUMERO DIRECCION Medico -->
		
	  
	  		<div class="form-group">
			    <label for="direccionMedico">Numero de Domicilio</label>
			    <input type="text" class="form-control" name="numeroMedico" >
		  	</div>
		  	
	  	<!-- LOCALIDAD Medico -->
	  
	  		<div class="form-group">
			    <label for="localidadMedico">Localidad</label>
			    <input type="text" class="form-control" name="localidadMedico" >
		  	</div>	
	  
	  	<!-- PROVINCIA Medico -->
	  	
	  		<div class="form-group">
			    <label for="provinciaMedico">Provincia</label>
			    <select name="provinciaMedico" class="form-control">
					  <option value=""> --- </option>
  					  <option value="Buenos Aires">Buenos Aires</option>
					  <option value="Ciudad Autonoma de Buenos Aires">Ciudad Autónoma de Buenos Aires</option>
		  	     	  <option value="Catamarca"> Catamarca </option>
					  <option value="Chaco"> Chaco </option>
					  <option value="Chubut"> Chubut </option>
					  <option value="Cordoba"> Córdoba </option>
					  <option value="Corrientes"> Corrientes </option>
					  <option value="Entre Rios"> Entre Ríos </option>
					  <option value="Formosa"> Formosa </option>
					  <option value="Jujuy"> Jujuy </option>
					  <option value="La Pampa"> La Pampa </option>
					  <option value="Mendoza"> Mendoza </option>				
					  <option value="Misiones"> Misiones </option>					  
					  <option value="Neuquen"> Neuquén </option>					  
					  <option value="Rio Negro"> Río Negro </option>					  
					  <option value="Salta"> Salta </option>					  
					  <option value="San Juan"> San Juan </option>					  
					  <option value="San Luis"> San Luis </option>
 					  <option value="Santa Cruz"> Santa Cruz </option>
 					  <option value="Santa Fe"> Santa Fe </option>
 					  <option value="Santiago del Estero"> Santiago del Estero </option>
 					  <option value="Tierra del Fuego"> Tierra del Fuego </option>
 					  <option value="Tucuman"> Tucumán </option>
				</select> 
 		
	  		</div>


	  
  	   	<!-- CODIGO POSTAL Medico -->
	  	
	  		<div class="form-group">
			    <label for="paisMedico">Codigo Postal</label>
			    <input type="text" class="form-control" name="codigoPostalMedico" >
		  	</div>	
	  	  
	  	<!-- CORREO ELECTRONICO Medico -->
	  
	  		<div class="form-group">
			    <label for="mailMedico">Correo Electronico</label>
			    <input type="email" class="form-control" name="emailMedico" >
		  	</div>	
	  
	  
	  
	  	<!-- TELEFONO Medico -->
	  
	  		<div class="form-group">
			    <label for="telMedico">Telefono</label>
			    <input type="number" class="form-control" name="telefonoMedico" >
		  	</div>	
		  	

		
		<!-- a implementar mas tarde -->
		
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
		 
		 
	  <br>
	   <input type="submit" class="btn btn-dark" name="btnAgregar" value="Agregar Medico">
	  
	  </div>


	  
	  <!-- ACA VER SI TOMAR VALOR DE SESION O AGREGAR DDL -->
	  

	</form>
	


</body>
</html>