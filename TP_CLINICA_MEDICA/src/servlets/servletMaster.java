package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;




/**
 * Servlet implementation class MasterPageServlet
 */
@WebServlet("/Layout/servletMaster")
public class servletMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletMaster() {
        super();
        // TODO Auto-generated constructor stub
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
			
			//METODO PARA ASIGNAR TURNOS
			
			if(request.getParameter("master").equals("listarTurnos")) {
				String aVisitar = "listarTurnos";
				request.setAttribute("sitio", aVisitar );
				
				RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
		        rdi.forward(request, response);
			}
			
			
			//METODO PARA CARGAR ABML DE MEDICOS
			
			if(request.getParameter("master").equals("medicos")) {
				String aVisitar = "abmlMedicos";
				request.setAttribute("sitio", aVisitar );
				
				RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
		        rdi.forward(request, response);
			}
			
			
			//METODO PARA CARGAR ABML DE PACIENTES
			
			if(request.getParameter("master").equals("pacientes")) {
				String aVisitar = "abmlPacientes";
				request.setAttribute("sitio", aVisitar );
				
				RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
		        rdi.forward(request, response);
			}
			
		}
		

		
	
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());	
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
