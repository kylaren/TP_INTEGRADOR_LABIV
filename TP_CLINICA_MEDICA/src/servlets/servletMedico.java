package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.TimeZone;

import dominio.Especialidad;
import daoImpl.EspecialidadDaoImpl;
import dominio.Direccion;
import dominio.Medico;
import daoImpl.MedicoDaoImpl;
import dominio.Horario;

/**
 * Servlet implementation class servletMedico
 */
@WebServlet("/Layout/servletMedico")
public class servletMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DateTimeFormatter df = DateTimeFormatter .ofPattern("dd-mm-yyyy"); 
	
    public servletMedico() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//REDIRECCION DE URLS
		
		//METODO PARA CARGAR FORMULARIO DE MEDICOS
		
		if(request.getParameter("master") != null) {
			
			if(request.getParameter("master").equals("formularioMedico")) {
				
				ArrayList<Especialidad> listaEspecialidades = new ArrayList<>();
				EspecialidadDaoImpl esp = new EspecialidadDaoImpl();
				listaEspecialidades = esp.listarEspecialidades();
				request.setAttribute("especialidades", listaEspecialidades);
				
				if(request.getParameter("id") != null) {
				// CARGA PARA MODIFICAR	
					MedicoDaoImpl mDao = new MedicoDaoImpl();
					Medico aBuscar = mDao.buscarMedico(Integer.parseInt(request.getParameter("id")));
					request.setAttribute("medico", aBuscar);
					
					String aVisitar = "formularioMedico";
					request.setAttribute("sitio", aVisitar);
					
					RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
					rdi.forward(request, response);
					
				}else {
					
				//CARGA PARA INSERTAR
					
					String aVisitar = "formularioMedico";
					request.setAttribute("sitio", aVisitar );
					
					RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
					rdi.forward(request, response);
					
				}
			}
			
			
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//METODO PARA AGREGAR Y/O MODIFICAR MEDICO
	
		if(request.getParameter("btnAgregar")!=null)
		{
			String boton = request.getParameter("btnAgregar");
			//FUNCION PARA AGREGAR MEDICO
			if (boton.equals("Agregar Medico")) {
			
				MedicoDaoImpl mDao = new MedicoDaoImpl();
				
				Medico m  =  new Medico();
				Direccion md = new Direccion();
				Especialidad me = new Especialidad();
				ArrayList<Horario> mlh = new ArrayList<>();
				Horario mh = new Horario();
				
				String FechaNacimiento = request.getParameter("fechaNacimientoMedico");
				
				LocalDate FechaNacUtil;
				
				try {
				    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				    FechaNacUtil = LocalDate.parse(FechaNacimiento, formatter);
				    m.setFechaNacimiento(FechaNacUtil);
				} catch (DateTimeParseException e) {
				    e.printStackTrace();
				}

				mh.setDia(request.getParameter("diaMedico"));
				mh.setInicioJornada(LocalTime.parse(request.getParameter("inicioJornadaMedico")));
				mh.setFinalJornada(LocalTime.parse(request.getParameter("finalJornadaMedico")));
				mlh.add(mh);
				m.setHorario(mlh);
				me.setIdEspecialidad(Integer.parseInt(request.getParameter("especialidadMedico")));
				md.setCalle(request.getParameter("calleMedico"));
				md.setCodigoPostal(request.getParameter("codigoPostalMedico"));
				md.setLocalidad(request.getParameter("localidadMedico"));
				md.setNumero(request.getParameter("numeroMedico"));
				md.setPais("Argentina");
				md.setProvincia(request.getParameter("provinciaMedico"));
				m.setApellido(request.getParameter("apellidoMedico"));
				m.setContrasena(request.getParameter("contrasenaMedico"));
				m.setDireccion(md);
				m.setDni(request.getParameter("dniMedico"));
				m.setEmail(request.getParameter("emailMedico"));
				m.setEspecialidad(me);
				m.setNacionalidad(request.getParameter("nacionalidadMedico"));
				m.setNombre(request.getParameter("nombreMedico"));
				m.setSexo(request.getParameter("sexoMedico"));
				m.setTelefono(request.getParameter("telefonoMedico"));
				m.setUsuario(request.getParameter("usuarioMedico"));
				
				mDao.insertarMedico(m);
				
				String aVisitar = "abmlMedicos";
				request.setAttribute("sitio", aVisitar );
				
				RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
		        rdi.forward(request, response);
				
			} else if(boton.equals("Modificar Medico")) {
				
			}
			
		
		}

	}

}
