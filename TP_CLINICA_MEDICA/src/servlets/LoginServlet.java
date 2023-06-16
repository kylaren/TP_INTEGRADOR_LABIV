package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        String tipoUsuario = request.getParameter("tipoUsuario");
        String contextPath = request.getContextPath();

        
        if (usuario.equals("admin") && contrasena.equals("admin123") && tipoUsuario.equals("admin")) {
            HttpSession session = request.getSession();
            session.setAttribute("tipoUsuario", "admin");
            response.sendRedirect(contextPath + "/Layout/MasterPage.jsp"); // Redirige a página de administrador
        }
        else if (usuario.equals("medico") && contrasena.equals("medico123") && tipoUsuario.equals("medico")) {
            HttpSession session = request.getSession();
            session.setAttribute("tipoUsuario", "medico");
            response.sendRedirect("medico.jsp"); // Redirige a página de médico
        }
        else {
            response.sendRedirect("error.jsp");
        }
		
		doGet(request, response);
	}

}
