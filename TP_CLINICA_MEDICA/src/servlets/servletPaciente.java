package servlets;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.MedicoDaoImpl;
import daoImpl.PacienteDaoImpl;
import dominio.Direccion;
import dominio.Medico;
import dominio.Paciente;


@WebServlet("/Layout/servletPaciente")
public class servletPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DateTimeFormatter df = DateTimeFormatter .ofPattern("dd-mm-yyyy"); 
	
	
	PacienteDaoImpl pdaoI = new PacienteDaoImpl();
    
    public servletPaciente() {
        super();
    }

    //FUNCIONES INTRINSECAS DEL SERVLET
    
    private void redireccionarABML(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Paciente> lista = new ArrayList<>();
		lista = pdaoI.readAll();
		request.setAttribute("listaP", lista);

		String aVisitar = "abmlPacientes";
		request.setAttribute("sitio", aVisitar );
		
		RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
        rdi.forward(request, response);
		
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//METODO PARA CARGAR FORMULARIO DE PACIENTES
		
		if(request.getParameter("master") != null) {
			
				if(request.getParameter("master").equals("formularioPaciente")) {
					
						if(request.getParameter("id")!= null) {
							// CARGA PARA MODIFICAR	
							PacienteDaoImpl pDao = new PacienteDaoImpl();
							Paciente aBuscar = pDao.buscarPaciente(Integer.parseInt(request.getParameter("id")));
							request.setAttribute("paciente", aBuscar);
							
							boolean modificar = true;
							request.setAttribute("banderaModificar", modificar);
							
							String aVisitar = "formularioPaciente";
							request.setAttribute("sitio", aVisitar);
							
							RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
							rdi.forward(request, response);
						}
						else {
							String aVisitar = "formularioPaciente";
							request.setAttribute("sitio", aVisitar );
							
							RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
							rdi.forward(request, response);
						}
				}
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//METODO PARA DAR BAJA LOGICA A UN PACIENTE
		if(request.getParameter("btnEliminar")!=null) {
			int aEliminar = Integer.parseInt(request.getParameter("btnEliminar"));
			pdaoI.delete(aEliminar);
			redireccionarABML(request, response);
		}
		
		// METODO PARA AGREGAR Y/O MODIFICAR UN PACIENTE
		
		
				
				
				if(request.getParameter("btnAgregarPaciente")!= null) {
					
					String boton = request.getParameter("btnAgregarPaciente");
					
					PacienteDaoImpl pdao = new PacienteDaoImpl();
					Paciente paciente = new Paciente();
					
					String fechaNacimientoString = request.getParameter("fechaNacimiento");
					
					LocalDate FechaNacUtil;
					
					try {
					    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					    FechaNacUtil = LocalDate.parse(fechaNacimientoString, formatter);
					    paciente.setFechaNacimiento(FechaNacUtil);
					} catch (DateTimeParseException e) {
					    e.printStackTrace();
					}
			        
					
					// setea la direccion
						Direccion direccion = new Direccion();
						direccion.setCalle(request.getParameter("callePaciente"));
						direccion.setNumero(request.getParameter("numeroPaciente"));
						direccion.setLocalidad(request.getParameter("localidadPaciente"));
						direccion.setProvincia(request.getParameter("provinciaPaciente"));
						direccion.setPais("Argentina");
						direccion.setCodigoPostal(request.getParameter("codigoPostalPaciente"));
					paciente.setDireccion(direccion);
					
					paciente.setDni(request.getParameter("dniPaciente"));
					paciente.setNombre(request.getParameter("nombrePaciente"));
					paciente.setApellido(request.getParameter("apellidoPaciente"));
					paciente.setSexo(request.getParameter("sexoPaciente"));
					paciente.setNacionalidad(request.getParameter("nacionalidadPaciente"));
					paciente.setEmail(request.getParameter("emailPaciente"));
					paciente.setTelefono(request.getParameter("telefonoPaciente"));
					 
					
					
					
				    if(boton.contains("Agregar Paciente"))
				    {
				    	//FUNCION MAGICA
				    	pdao.insert(paciente);
				    }
				    
				    else if(boton.contains("Modificar Paciente"))
				    {
				    	paciente.setId(Integer.parseInt(request.getParameter("idPaciente")));
				    	pdao.update(paciente);
				    }
					
					redireccionarABML(request, response);
				}
		
		
		
		
		
		//doGet(request, response);
	}

}
