package servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
    
    //ATRIBUTOS DEL SERVLET
    
	private MedicoDaoImpl mDao = new MedicoDaoImpl();
    
    //FUNCIONES INTRINSECAS DEL SERVLET
    
    private void redireccionarABML(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Medico> lista = new ArrayList<>();
		lista = mDao.listarMedicos();
		request.setAttribute("listaM", lista);

		String aVisitar = "abmlMedicos";
		request.setAttribute("sitio", aVisitar );
		
		RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
        rdi.forward(request, response);
		
    }


    //FUNCIONES PARA TRABAJAR CON LA PAGINA
    
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
					
					boolean modificar = true;
					request.setAttribute("banderaModificar", modificar);
					
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
		

		
		//METODO PARA DAR BAJA LOGICA A UN MEDICO
		if(request.getParameter("btnEliminar")!=null) {
			int aEliminar = Integer.parseInt(request.getParameter("btnEliminar"));
			
			mDao.borrarMedico(aEliminar);
			redireccionarABML(request, response);
		}
		
		//METODO PARA AGREGAR Y/O MODIFICAR MEDICO
	
		if(request.getParameter("btnAgregar")!=null)
		{
				String boton = request.getParameter("btnAgregar");

				//LECTURA DE FORMULARIO
			

				
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
				
				//FUNCION PARA AGREGAR MEDICO
				if (boton.contains("Agregar Medico")) 
				{
					//VALORES PARA INSERTAR QUE NO ESTAN PARA MODIFICAR
					mh.setDia(request.getParameter("diaMedico"));
					mh.setInicioJornada(LocalTime.parse(request.getParameter("inicioJornadaMedico")));
					mh.setFinalJornada(LocalTime.parse(request.getParameter("finalJornadaMedico")));
					mlh.add(mh);
					m.setHorario(mlh);
					
					//VERIFICAR DNI UNICO
					ArrayList<Medico> verificarDNI = mDao.listarMedicos();
					boolean dniValido = true;
					boolean usuarioValido = true;
					boolean emailValido = true;
					for (Medico medico : verificarDNI) {
					    if ((medico.getDni().equals(m.getDni())) || (medico.getEmail().equals(m.getEmail())) || (medico.getUsuario().equals(m.getUsuario())) ) {
					        
					    	//MANDAR MENSAJE ACLARANDO QUE SE ENCONTRO UN DNI IDENTICO
					    	String mensaje = "Se han encontrado atributos identicos en la base de datos, por favor, ingrese otros distintos. \\nAtributos identicos: ";
					    	if(medico.getDni().equals(m.getDni())) {
					    		mensaje += " DNI ";
					    		dniValido = false;
					    	}
					    	if(medico.getEmail().equals(m.getEmail())) {
					    		mensaje += " Correo Electronico ";
					    		emailValido = false;
					    	}
					    	if(medico.getUsuario().equals(m.getUsuario())) {
					    		mensaje += " Nombre de usuario ";
					    		usuarioValido = false;
					    	}

					        //VALIDACIONES A USAR EN FORMULARIO
					        request.setAttribute("dniValido", dniValido);
					        request.setAttribute("emailValido", emailValido);
					        request.setAttribute("usuarioValido", usuarioValido);
					        request.setAttribute("mensajeError", mensaje);
					        
					        //REDIRECCION A FORMULARIO					  
					        ArrayList<Especialidad> listaEspecialidades = new ArrayList<>();
							EspecialidadDaoImpl esp = new EspecialidadDaoImpl();
							listaEspecialidades = esp.listarEspecialidades();
							request.setAttribute("especialidades", listaEspecialidades);
					        
							request.setAttribute("medico", m);
							
							String aVisitar = "formularioMedico";
							request.setAttribute("sitio", aVisitar);
							
							RequestDispatcher rdi = request.getRequestDispatcher("/Layout/MasterPage.jsp");   
							rdi.forward(request, response);
							
							return;
					        
					    }
					}
					
					//FUNCION MAGICA
					mDao.insertarMedico(m);
				} 
				 //FUNCION PARA MODIFICAR MEDICO
				else if(boton.contains("Modificar Medico")) 
				{
					m.setId(Integer.parseInt(request.getParameter("idMedico")));
					mDao.actualizarMedico(m);
				}
				
				redireccionarABML(request, response);
		       
			 
			
		
		}

	}

}
