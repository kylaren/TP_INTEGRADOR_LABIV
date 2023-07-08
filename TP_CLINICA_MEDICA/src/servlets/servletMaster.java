package servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.RequestDispatcher;

import dominio.Direccion;
import dominio.Medico;
import dominio.Paciente;
import daoImpl.MedicoDaoImpl;
import daoImpl.PacienteDaoImpl;




@WebServlet("/Layout/servletMaster")
public class servletMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	MedicoDaoImpl mDao = new MedicoDaoImpl();
	PacienteDaoImpl pdaoI = new PacienteDaoImpl();
	
    
    public servletMaster() {
        super();
    }

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		if (request.getParameter("master")!=null) {
			
			
			//METODO PARA CARGAR PAGINA DE LOGIN
			
			if(request.getParameter("master").equals("login")) {
				String aVisitar = "login";
				request.setAttribute("sitio", aVisitar );
				
				RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
		        rdi.forward(request, response);
			}
			
			//METODO PARA ASIGNAR TURNOS
			
			if(request.getParameter("master").equals("asignarTurnos")) {
				String aVisitar = "asignarTurnos";
				request.setAttribute("sitio", aVisitar );
				
				RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
		        rdi.forward(request, response);
			}
			
			//METODO PARA LISTAR TURNOS
			
			if(request.getParameter("master").equals("listarTurnos")) {
				String aVisitar = "listarTurnos";
				request.setAttribute("sitio", aVisitar );
				
				RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
		        rdi.forward(request, response);
			}
			
			
			//METODO PARA CARGAR ABML DE MEDICOS
			
			
			
			if(request.getParameter("master").equals("medicos")) {
				
				ArrayList<Medico> lista = new ArrayList<>();
				lista = mDao.listarMedicos();
				
				request.setAttribute("listaM", lista);
				
				String aVisitar = "abmlMedicos";
				request.setAttribute("sitio", aVisitar );
				
				RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
		        rdi.forward(request, response);
			}
			
			
	// PACIENTES
			
			//METODO PARA CARGAR UN PACIENTE
			
			if(request.getParameter("master").equals("agregarPaciente")) {
				String aVisitar = "formularioPaciente";
				request.setAttribute("sitio", aVisitar );
				
				RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
		        rdi.forward(request, response);
			}
			
			
			
			//METODO PARA LISTAR PACIENTES
			
			if(request.getParameter("master").equals("abmlPacientes")) {
				ArrayList<Paciente> lista= (ArrayList<Paciente>) pdaoI.readAll();
				
				request.setAttribute("listaP", lista);
				
				RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
		        rdi.forward(request, response);
			}
			
			
		}
		

		
	
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());	
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
//        if(request.getParameter("btnCerrarSesion").equals("Cerrar Sesion")) {
//         	HttpSession session = request.getSession();
//        	session.invalidate();
//			RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
//	        rdi.forward(request, response);
//        }
        
        
     // BOTON AGREGAR PACIENTE 
		
		if(request != null && request.getParameter("btnAgregarPaciente")!= null) {
			PacienteDaoImpl pdao = new PacienteDaoImpl();
			
			Paciente paciente = new Paciente();
			
			String fechaNacimientoString = request.getParameter("fechaNacimiento");
			// Convierte la fecha de String a java.sql.Date
	        java.sql.Date fechaNacimiento = null;
	        try {
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            java.util.Date utilFechaNacimiento = sdf.parse(fechaNacimientoString);
	            fechaNacimiento = new java.sql.Date(utilFechaNacimiento.getTime());
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        
			
			// setea la direccion
				Direccion direccion = new Direccion();
				direccion.setCalle(request.getParameter("callePaciente"));
				direccion.setNumero(request.getParameter("numeroPaciente"));
				direccion.setLocalidad(request.getParameter("localidadPaciente"));
				direccion.setProvincia(request.getParameter("provinciaPaciente"));
				direccion.setPais(request.getParameter("paisPaciente"));
				direccion.setCodigoPostal(request.getParameter("codigoPostalPaciente"));
			paciente.setDireccion(direccion);
			
			paciente.setDni(request.getParameter("dniPaciente"));
			paciente.setNombre(request.getParameter("nombrePaciente"));
			paciente.setApellido(request.getParameter("apellidoPaciente"));
			paciente.setSexo(request.getParameter("sexoPaciente"));
			paciente.setNacionalidad(request.getParameter("nacionalidadPaciente"));
			paciente.setFechaNacimiento(fechaNacimiento);
			paciente.setEmail(request.getParameter("emailPaciente"));
			paciente.setTelefono(request.getParameter("telefonoPaciente"));
			// seteo el estado 1 (visible)
			paciente.setEstado(1); 
			
			
			
			pdao.insert(paciente);
			
			
			
//			String aVisitar = "formularioPaciente";
//			request.setAttribute("sitio", aVisitar );
			
			RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
	        rdi.forward(request, response);
		}
        
	}

}
