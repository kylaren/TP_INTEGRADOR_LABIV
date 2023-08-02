package servlets;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.TurnoDaoImpl;
import dominio.Direccion;
import dominio.Especialidad;
import dominio.Horario;
import dominio.Medico;
import dominio.Paciente;
import dominio.Turno;

/**
 * Servlet implementation class servletTurnos
 */
@WebServlet("/Layout/servletTurnos")
public class servletTurnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	TurnoDaoImpl tDao = new TurnoDaoImpl();

    public servletTurnos() {
        super();
        // TODO Auto-generated constructor stub
    }

	// REDIRECCIONAR A ABML DESPUES DE CARGAR ALGO EN LA DB
	
    private void redireccionarABML(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Turno> lista = new ArrayList<>();
		lista = tDao.listarTurnos();
		request.setAttribute("listaT", lista);

		String aVisitar = "listarTurnos";
		request.setAttribute("sitio", aVisitar );
		
		RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
        rdi.forward(request, response);
		
    }
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//METODO PARA CARGAR TURNOS EN BASE DE DATOS
		if(request.getParameter("btnConfirmar")!=null) {
			
			//LECTURA DEL FORMULARIO
			
			Turno aRegistrar = new Turno();
			Medico m  =  new Medico();
			Paciente p = new Paciente();
			Horario h = new Horario();
			
			m.setId(Integer.parseInt(request.getParameter("medicoTurno")));
			p.setId(Integer.parseInt(request.getParameter("pacienteTurno")));
			h.setInicioJornada(LocalTime.parse(request.getParameter("horarioTurno")));
			h.setDia(request.getParameter("fechaTurno"));
			
			aRegistrar.setEstado(1);
			aRegistrar.setHorario(h);
			aRegistrar.setMedico(m);
			aRegistrar.setPaciente(p);
			
			//REGISTRAR EN DB
			

			tDao.registrarTurno(aRegistrar);
			
			
		}
		
		doGet(request, response);
	}

}
