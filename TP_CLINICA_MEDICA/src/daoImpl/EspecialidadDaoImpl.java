package daoImpl;

import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import dao.EspecialidadDAO;
import dominio.Especialidad;

public class EspecialidadDaoImpl implements EspecialidadDAO {

	public ArrayList<Especialidad> listarEspecialidades() {
		// Establece la conexión a la base de datos
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conexion = null;
	    
		ArrayList<Especialidad> lista = new ArrayList<Especialidad>();
		
	    try 
	    {
			conexion = Conexion.getConexion().getSQLConexion();

	        // Crea la sentencia SQL para insertar el paciente
	    	String query = "SELECT Id, Nombre, Descripcion, Estado FROM Especialidades";
	    	Statement st = conexion.createStatement();
	        
	        ResultSet rs = st.executeQuery(query);
	        
	        while(rs.next()) {
	        	boolean estado = rs.getBoolean("Estado"); 
	        	if(estado) {
	        		Especialidad aListar = new Especialidad();
	        		aListar.setIdEspecialidad(rs.getInt("id"));
	        		aListar.setNombreEspecialidad(rs.getString("Nombre"));
	        		aListar.setDescripcionEspecialidad(rs.getString("Descripcion"));	 
	        		if(aListar.getIdEspecialidad() != 4) {	        			
	        			lista.add(aListar);
	        		}
	        	}
	        }
	        conexion.close();
        
	    } 
	    catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	    return lista;
	    
	}
	
}
