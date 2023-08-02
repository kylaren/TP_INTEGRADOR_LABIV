<%@ page import="dominio.Direccion"%>
<%@ page import="dominio.Medico"%>
<%@ page import="dominio.Horario" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.time.LocalDate"%>
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
	

	
	
	<!-- Script para paginar tablas -->
	<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#tablaMedicos').DataTable();
		});
	</script>
	<!-- Script para paginar tablas -->
	
	<%
	//Arraylist de doctores
	ArrayList<Medico> listaMedicos = null;
	if(request.getAttribute("medicos")!=null)
	{
		listaMedicos = (ArrayList<Medico>)request.getAttribute("medicos");
	}
	
	%>
	
	</head>
	<body>

		<h1> ABML de Medicos </h1>
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
						<th>Horarios de Atencion</th>

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
									 <a href="servletMedico?master=formularioMedico&id=<%=m.getId() %>"  >
									 <button type="button" class="btn btn-link">Modificar</button>
									 </a>
									 <button type="button" class="btn btn-link" data-toggle="modal" data-target="#modalEliminar<%=m.getId()%>">
									  Eliminar
									</button>
									

									
									<!-- Modal -->

																		
									<div class="modal fade" id="modalEliminar<%=m.getId()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
									  <div class="modal-dialog">
									    <div class="modal-content">
									      <div class="modal-header">
									        <h5 class="modal-title" id="exampleModalLabel">Eliminacion del medico: <%=m.getNombre() %>&nbsp;<%=m.getApellido() %> </h5>
									        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
									          <span aria-hidden="true">&times;</span>
									        </button>
									      </div>
									      <div class="modal-body">
									      		¿Esta seguro de que desea eliminar el siguiente medico: <%=m.getNombre() %>&nbsp;<%=m.getApellido() %> ?
									      </div>
									      <div class="modal-footer">
									        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
									        <form method="post" action="servletMedico">
									        	<button type="submit" class="btn btn-danger" name="btnEliminar" value="<%=m.getId()%>">Eliminar</button>
									        </form>
									      </div>

									    </div>
									  </div>
									</div>
		 						
								</td>
								<td><%=m.getId() %>    <input type="hidden" name="idMedico" value="<%=m.getId()%>"> </td> 
								<td><%=m.getDni() %></td>   
								<td><%=m.getNombre() %></td>
								<td><%=m.getApellido() %></td>
								<td><%=m.getSexo() %></td>
								<td><%=m.getNacionalidad() %></td>
								<td><%=m.getFechaNacimiento() %></td>
								<td><%=m.getDireccion().getCalle() %> &nbsp; <%=m.getDireccion().getNumero() %> </td>
								<td><%=m.getDireccion().getLocalidad() %></td> 
								<td><%=m.getDireccion().getProvincia() %></td>
								<td><%=m.getEmail() %></td>
								<td><%=m.getTelefono() %></td>
								<td><%=m.getEspecialidad().getNombreEspecialidad() %> </td>
								<td><!-- Button trigger modal -->
									<button type="button" class="btn btn-link" data-toggle="modal" data-target="#modal<%=m.getId()%>">
									  [+]
									</button>
									

									
									<!-- Modal -->

																		
									<div class="modal fade" id="modal<%=m.getId()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
									  <div class="modal-dialog">
									    <div class="modal-content">
									      <div class="modal-header">
									        <h5 class="modal-title" id="exampleModalLabel">Horarios de <%=m.getNombre() %>&nbsp;<%=m.getApellido() %> </h5>
									        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
									          <span aria-hidden="true">&times;</span>
									        </button>
									      </div>
									      <div class="modal-body">
									      		<table>
									      			<thead>
									      				<tr>
									      					<th>Dia</th>
															<th>Inicio de Jornada</th>
															<th>Fin de Jornada</th>
									      				</tr>
									      			</thead>
									      			<tbody>
									      				<%	
											      			ArrayList<Horario> listaHorarios = m.getHorario();
											      			for(Horario h : listaHorarios){ %>
															<tr>																
																<th><%=h.getDia() %></th>
																<th><%=h.getInicioJornada() %></th>
																<th><%=h.getFinalJornada() %></th>
															</tr>
											      			<%	}											      		
											      		%>
									      			</tbody>
									      		</table>
									      
									      </div>
									      <div class="modal-footer">
									        <button type="button" data-dismiss="modal" class="btn btn-secondary">Cerrar</button>
									      </div>
									    </div>
									  </div>
									</div>
									
								</td>

						<%--  </form>  --%>
						</tr>
					<%  } %>
					
			
			    </tbody>
		
			</table>
		</div>
		<br>
		<a href="servletMedico?master=formularioMedico" class="btn btn-dark">Agregar Medico</a>
			
	
	</body>
</html>