package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dominio.Especialidad;
import dominio.Direccion;
import dominio.Medico;
import daoImpl.MedicoDaoImpl;

/**
 * Servlet implementation class servletMedico
 */
@WebServlet("/Formularios/servletMedico")
public class servletMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DateTimeFormatter df = DateTimeFormatter .ofPattern("dd-mm-yyyy"); 
	
    public servletMedico() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//METODO AGREGAR MEDICO
	
		if(request.getParameter("btnAgregar")!=null)
		{
			MedicoDaoImpl mDao = new MedicoDaoImpl();
			
			Medico m  =  new Medico();
			Direccion md = new Direccion();
			Especialidad me = new Especialidad();
			
			String FechaNacimiento = request.getParameter("fechaNacimientoMedico");
			
			java.util.Date FechaNacUtil;
			java.sql.Date FechaNacSQL;
			try {
				FechaNacUtil = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("fechaNacimientoMedico"));
				FechaNacSQL = new java.sql.Date(FechaNacUtil.getDate());
				m.setFechaNacimiento(FechaNacSQL);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
			me.setIdEspecialidad(Integer.parseInt(request.getParameter("especialidadMedico")));
			md.setCalle(request.getParameter("calleMedico"));
			md.setCodigoPostal(request.getParameter("codigoPostalMedico"));
			md.setLocalidad(request.getParameter("localidadMedico"));
			md.setNumero(request.getParameter("numeroMedico"));
			md.setPais(request.getParameter("paisMedico"));
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
		}

	}

}
