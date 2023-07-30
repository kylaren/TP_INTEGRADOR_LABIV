package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dominio.Medico;
import daoImpl.MedicoDaoImpl;


@WebServlet("/Layout/servletLogin")
public class servletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public servletLogin() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuarioL = request.getParameter("usuario");
        String contrasenaL = request.getParameter("contrasena");
        String contextPath = request.getContextPath();

        MedicoDaoImpl mDao = new MedicoDaoImpl();
        Medico aLoguear = mDao.login(usuarioL, contrasenaL);
        
        if (aLoguear != null) {
        	
        	HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", aLoguear);
            response.sendRedirect(contextPath + "/Layout/MasterPage.jsp");	
        }
        else {
        	response.sendRedirect("error.jsp");
        }
        //IMPLEMENTAR PANTALLA DE ERROR SI NO FUNCIONA

        
		doGet(request, response);
	}

}
