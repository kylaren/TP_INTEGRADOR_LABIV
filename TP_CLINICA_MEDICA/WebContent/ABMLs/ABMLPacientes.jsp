<%@ page import="dominio.Direccion"%>
<%@ page import="dominio.Paciente"%>
<%@ page import="daoImpl.PacienteDaoImpl"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.time.LocalDate"%>
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

	<!-- Script para paginar tablas -->
	<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#tablaPacientes').DataTable();
		});
	</script>

</head>
<body>
		<h1> ABML de Pacientes </h1>
		<br>
		<% 
			ArrayList<Paciente> listaPacientes = null;
			if(request.getAttribute("listaP")!=null)
			{
				listaPacientes = (ArrayList<Paciente>) request.getAttribute("listaP");
			}
			
		%>	
		<br>


<
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
									 <a href="servletPaciente?master=formularioPaciente&id=<%=paciente.getId() %>"  >
									 <button type="button" class="btn btn-link">Modificar</button>
									 </a>
									 <button type="button" class="btn btn-link" data-toggle="modal" data-target="#modalEliminar<%=paciente.getId()%>">
									  Eliminar
									</button>
									

									
									<!-- Modal -->

																		
									<div class="modal fade" id="modalEliminar<%=paciente.getId()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
									  <div class="modal-dialog">
									    <div class="modal-content">
									      <div class="modal-header">
									        <h5 class="modal-title" id="exampleModalLabel">Eliminacion del paciente: <%=paciente.getNombre() %>&nbsp;<%=paciente.getApellido() %> </h5>
									        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
									          <span aria-hidden="true">&times;</span>
									        </button>
									      </div>
									      <div class="modal-body">
									      		¿Esta seguro de que desea eliminar el siguiente paciente: <%=paciente.getNombre() %>&nbsp;<%=paciente.getApellido() %> ?
									      </div>
									      <div class="modal-footer">
									        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
									        <form method="post" action="servletMedico">
									        	<button type="submit" class="btn btn-danger" name="btnEliminar" value="<%=paciente.getId()%>">Eliminar</button>
									        </form>
									      </div>

									    </div>
									  </div>
									</div>
		 						
								</td>
						
						<td><%=paciente.getId() %>    <input type="hidden" name="idPaciente" value="<%=paciente.getId()%>"> </td> 
						<td><%=paciente.getDni() %></td>
						<td><%=paciente.getNombre() %></td>
						<td><%=paciente.getApellido() %></td>
						<td><%=paciente.getSexo() %></td>
						<td><%=paciente.getNacionalidad() %></td>
						<td><%=paciente.getFechaNacimiento() %></td>
						<td><%=paciente.getDireccion().getCalle() %>&nbsp; <%=paciente.getDireccion().getNumero() %></td>
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
		<a href="servletPaciente?master=formularioPaciente" class="btn btn-dark">Agregar Paciente</a>
			



</body>
</html>