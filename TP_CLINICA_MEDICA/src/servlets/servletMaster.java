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
import dominio.Turno;
import dominio.Especialidad;
import daoImpl.MedicoDaoImpl;
import daoImpl.PacienteDaoImpl;
import daoImpl.TurnoDaoImpl;
import daoImpl.EspecialidadDaoImpl;




@WebServlet("/Layout/servletMaster")
public class servletMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	TurnoDaoImpl tDao = new TurnoDaoImpl();
	MedicoDaoImpl mDao = new MedicoDaoImpl();
	PacienteDaoImpl pDao = new PacienteDaoImpl();
	EspecialidadDaoImpl eDao= new EspecialidadDaoImpl();
	
    
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
				
				//1. Asignar valores para DDL
				
				ArrayList<Medico> listaM = new ArrayList<>();
				listaM = mDao.listarMedicos();
				
				ArrayList<Paciente> listaP = new ArrayList<>();
				listaP = pDao.readAll();
				
				ArrayList<Especialidad> listaE = new ArrayList<>();
				listaE = eDao.listarEspecialidades();
				
				//2. Mandar informacion a la pagina
				
				request.setAttribute("especialidades", listaE);
				request.setAttribute("medicos", listaM);
				request.setAttribute("pacientes", listaP);
				
				String aVisitar = "asignarTurnos";
				request.setAttribute("sitio", aVisitar );
				
				RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
		        rdi.forward(request, response);
			}
			
			//METODO PARA LISTAR TURNOS
			
			if(request.getParameter("master").equals("listarTurnos")) {
				
				ArrayList<Turno> lista = new ArrayList<>();
				lista = tDao.listarTurnos();
				
				request.setAttribute("listaT", lista);
				
				String aVisitar = "listarTurnos";
				request.setAttribute("sitio", aVisitar );
				
				RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
		        rdi.forward(request, response);
			}
			
		// MEDICOS
			
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
			
				//METODO PARA CARGAR ABML DE PACIENTES
				
				if(request.getParameter("master").equals("pacientes")) {
					
					ArrayList<Paciente> lista = new ArrayList<>();
					lista = pDao.readAll();
					

					
					request.setAttribute("listaP", lista);
					
					String aVisitar = "abmlPacientes";
					request.setAttribute("sitio", aVisitar );
					
					RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
			        rdi.forward(request, response);
				}
		

			
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());	
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
       if(request.getParameter("btnCerrarSesion").equals("Cerrar Sesion")) {
        	HttpSession session = request.getSession();
	       	session.invalidate();
			RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
	        rdi.forward(request, response);
       }
        
	}
}
