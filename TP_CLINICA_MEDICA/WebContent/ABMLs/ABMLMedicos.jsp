<%@ page import="dominio.Direccion"%>
<%@ page import="dominio.Medico"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>ABML de Medicos</title>
		
	<style>
		
		#tablaWrapper{
			overflow-x:scroll;
		}
	
	</style>
	</head>
	<body>

		<h1> ABML de Medicos </h1>
		<br>
		
		<% 
			ArrayList<Medico> listaMedicos = null;
			if(request.getAttribute("listaM")!=null)
			{
				listaMedicos = (ArrayList<Medico>) request.getAttribute("listaM");
			}
			
		%>	
		
		<br>
		
		<div id=tablaWrapper>
			<table border="1" id="tablaMedicos" class="table table-bordered">
				<thead>
					<tr>
						<th>Accion</th>
						<th>ID Medico</th>
						<th>DNI</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Sexo</th>
						<th>Nacionalidad</th>
						<th>Fecha de Nacimiento</th>
						<th>Direccion</th>
						<th>Localidad</th>
						<th>Provincia</th>
						<th>Correo Electronico</th>
						<th>Telefonos</th>
						<th>Especialidad</th>
						<th>Dia de Atencion</th>
						<th>Horario de Atencion</th>

					</tr>
				</thead>
				<tbody>
			       <%  if(listaMedicos!=null)
					for(Medico m : listaMedicos) 
					{
					%>
						<tr>  
						  <%--   <form name="formulario" action="servletSeguro?idSeguro=<%=seguro.getId()%>" method="get"> --%> 
						  		<td>
									 <a href="servletMedico?master=formTurnos&id=<%=m.getId() %>"  >Modificar</a>
		 							 <a href="servletMedico?id=<%=m.getId() %>">Eliminar</a> 
								</td>
								<td><%=m.getId() %>    <input type="hidden" name="idMedico" value="<%=m.getId()%>"> </td> 
								<td><%=m.getDni() %></td>   
								<td><%=m.getNombre() %></td>
								<td><%=m.getApellido() %></td>
								<td><%=m.getNacionalidad() %></td>
								<td><%=m.getFechaNacimiento() %></td>
								<td><%=m.getDireccion().getCalle() %> &nbsp; <%=m.getDireccion().getNumero() %> </td>
								<td><%=m.getDireccion().getLocalidad() %></td> 
								<td><%=m.getDireccion().getProvincia() %></td>
								<td><%=m.getEmail() %></td>
								<td><%=m.getTelefono() %></td>
								<td><%=m.getEspecialidad().getNombreEspecialidad() %> FALTA DESARROLLAR</td>
								<td>FALTA DESARROLLAR </td>
								<td>FALTA DESARROLLAR</td> 
						<%--  </form>  --%>
						</tr>
					<%  } %>
					
			
			    </tbody>
		
			</table>
		</div>
		<br>
		<a href="href="servletMedico?master=formTurnos" class="btn btn-dark">Agregar Medico</a>
			
	
	</body>
</html>