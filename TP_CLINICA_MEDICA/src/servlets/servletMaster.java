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
					lista = pdaoI.readAll();
					

					
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
