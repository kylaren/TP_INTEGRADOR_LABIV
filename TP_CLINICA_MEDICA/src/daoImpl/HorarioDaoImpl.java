package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import dominio.Especialidad;
import dominio.Horario;
import dominio.Medico;
import dao.HorarioDAO;


public class HorarioDaoImpl implements HorarioDAO {

	DateTimeFormatter df = DateTimeFormatter .ofPattern("HH:mm:ss"); 
	
	///LISTAR HORARIOS
	
	public ArrayList<Horario> listarHorariosPorMedico(int idMedico){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conexion = null;
	    
		ArrayList<Horario> lista = new ArrayList<Horario>();
		
	    try 
	    {
			conexion = Conexion.getConexion().getSQLConexion();

	        // Crea la sentencia SQL para insertar el paciente
	    	String query = "Select Id, IdMedico, Dia, Inicio, Final, Estado From Horarios WHERE IdMedico = ?";
	    	CallableStatement st = conexion.prepareCall(query);
	    	
	        st.setInt(1, idMedico);
	        
	        ResultSet rs = st.executeQuery(query);
	        
	        while(rs.next()) {
	        	boolean estado = rs.getBoolean("Estado");
	        	if(estado) {
	        		Horario aListar = new Horario();
	        		aListar.setId(rs.getInt("id"));
	        		aListar.setIdMedico(rs.getInt("IdMedico"));
	        		aListar.setDia(rs.getString("Descripcion"));
	        		aListar.setInicioJornada(LocalTime.parse(rs.getString("Inicio")));
	        		aListar.setFinalJornada(LocalTime.parse(rs.getString("Final")));
	      
	        		lista.add(aListar);
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
	
		/// AGREGAR HORARIO
		
	public boolean insertarHorario(Horario horario) {
		
		// Establece la conexión a la base de datos
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
	    
	    try 
	    {
	        // Crea la sentencia SQL para insertar el medico
	        String spIngresarPaciente = "INSERT INTO horarios (IdMedico, Dia, Inicio, Final) VALUES (?, ?, ?, ?)";
	        CallableStatement statement = conexion.prepareCall(spIngresarPaciente);

	        // Establece los valores de los parámetros en la sentencia SQL
	        statement.setInt(1, horario.getIdMedico());
	        statement.setString(2, horario.getDia());
	        statement.setString(3, (horario.getInicioJornada().toString()));
	        statement.setString(4, (horario.getFinalJornada().toString()));

	        
	     // Ejecuta la sentencia SQL
	        if(statement.executeUpdate() > 0)
	        {
				conexion.commit();
				isInsertExitoso = true;
			}
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
	    return isInsertExitoso;
		
	}
	
	public boolean borrarHorario(int idEliminar) {
		
		// Establece la conexión a la base de datos
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
	    
	    try 
	    {
	        // Crea la sentencia SQL para insertar el medico
	        String spIngresarPaciente = "UPDATE Horarios SET Estado = 0 WHERE Id = ?";
	        CallableStatement statement = conexion.prepareCall(spIngresarPaciente);

	        // Establece los valores de los parámetros en la sentencia SQL
	        statement.setInt(1, idEliminar);

	        
	     // Ejecuta la sentencia SQL
	        if(statement.executeUpdate() > 0)
	        {
				conexion.commit();
				isInsertExitoso = true;
			}
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
	    return isInsertExitoso;
		
	}
	
	
}
