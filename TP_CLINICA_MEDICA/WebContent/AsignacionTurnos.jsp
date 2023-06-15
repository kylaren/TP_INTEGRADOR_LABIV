<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> Asignacion de Turnos </h1>
	<br>
	<form>
	  <div class="form-group">
	  	
	  	<!-- ACA VA UN DDL -->
	  
	    <label for="exampleInputEmail1">Especialidad</label>
	    <select class="form-control">
   		  <option> --- </option>
		  <option>Gastroenterologia</option>
		  <option>Dentista</option>
		</select>


	  </div>
	  <div class="form-group">
	  
	  <!-- ACA VER SI TOMAR VALOR DE SESION O AGREGAR DDL -->
	  
	    <label for="exampleInputPassword1">Medico</label>
	     <select class="form-control">
     	  <option> --- </option>
		  <option>Dr Favaloro</option>
		  <option>Dr Peralta</option>
		</select>

	  </div>
	  
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
	  

	  <div class="form-group">
	    <label for="exampleInputEmail1">Paciente</label>
		<select class="form-control">
		      <option> --- </option>
		  	  <option> Esteban Quito </option>
		  	  <option> Jimi Hendrix </option>
		  	  <option> Señor Enfermo </option>  	  
		</select>


	  </div>
	  

	  <button type="submit" class="btn btn-dark">Confirmar Turno</button>
	</form>


</body>
</html>