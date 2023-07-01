<%@ page import="dominio.Paciente"%>
<%@ page import="daoImpl.PacienteDaoImpl"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Pacientes</title>

	<style>
		
		#tablaWrapper{
			overflow-x:scroll;
		}
	
	</style>


</head>
<body>

<a href="MasterPage.jsp"> Inicio</a> <a href="servletMaster?opc=1"> Agregar paciente </a> <a href="servletMaster?param=1"> Listar pacientes</a>
<br><br>
<b>"pacientes de la base de datos"</b>
<br><br>
<% 
	ArrayList<Paciente> listaPacientes = null;
	if(request.getAttribute("listaP")!=null)
	{
		listaPacientes = (ArrayList<Paciente>) request.getAttribute("listaP");
	}
	
%>	


<h1> ABML de Pacientes </h1>
<br>
		<div id=tablaWrapper>
			<table border="1" id="tablaPacientes" class="table table-bordered">
				<thead>
					<tr>
						<th>Accion</th>
						<th>ID Paciente</th>
						<th>DNI</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Sexo</th>
						<th>Nacionalidad</th>
						<th>Fecha de Nacimiento</th>
						<th>Direccion</th>
						<th>Nacionalidad</th>
						<th>Correo Electronico</th>
						<th>Telefono</th>

					</tr>
				</thead>
				<tbody>
				<%  if(listaPacientes!=null)
						for(Paciente paciente : listaPacientes) 
						{
						%>
					<tr>  
					<%--   <form name="formulario" action="servletMaster?idPaciente=<%=paciente.getId()%>" method="get"> --%> 
						<td>
							 <a href="#">Modificar</a>
 							 <a href="#">Eliminar</a> 
						</td>
						
						<td><%=paciente.getId() %>    <input type="hidden" name="idPaciente" value="<%=paciente.getId()%>"> </td> 
						<td><%=paciente.getDni() %></td>
						<td><%=paciente.getNombre() %></td>
						<td><%=paciente.getApellido() %></td>
						<td><%=paciente.getSexo() %></td>
						<td><%=paciente.getNacionalidad() %></td>
						<td><%=paciente.getFechaNacimiento() %></td>
						<td><%=paciente.getDireccion() %></td>
						<td><%=paciente.getNacionalidad() %></td>
						<td><%=paciente.getEmail() %></td>
						<td><%=paciente.getTelefono() %></td>

					<%--  </form>  --%>
					</tr>
				<%  } %>
			    </tbody>
		
			</table>
		</div>
		<br>
		<button type="button" class="btn btn-dark">Agregar Paciente</button>
			



</body>
</html>