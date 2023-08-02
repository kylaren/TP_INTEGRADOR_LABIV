package daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import dao.TurnoDAO;
import dominio.Especialidad;
import dominio.Horario;
import dominio.Medico;
import dominio.Paciente;
import dominio.Turno;

public class TurnoDaoImpl implements TurnoDAO{

	// REGISTRAR TURNOS
	public boolean registrarTurno(Turno turno) {
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try {
			
	
			LocalDate FechaUtil = null;
			
			try {
			    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			    FechaUtil = LocalDate.parse(turno.getHorario().getDia(), formatter);
			} catch (DateTimeParseException e) {
			    e.printStackTrace();
			}
			
			
			String query = "INSERT INTO Turnos (IdMedico, IdPaciente, Horario, Fecha, Estado) VALUES ( "
					+ Integer.toString(turno.getMedico().getId()) + " , "+ Integer.toString(turno.getPaciente().getId()) 
					+ " , '" + turno.getHorario().getInicioJornada().toString() + "' , '" + java.sql.Date.valueOf(FechaUtil).toString() + "', 1)";
					
					
			Statement st = conexion.createStatement();
	        int rowsAffected = st.executeUpdate(query);
	        
	        // Check if the insertion was successful
	        if (rowsAffected > 0) {
	            conexion.commit(); // Commit the transaction
	            conexion.close();
	            return true;
	        } else {
	            conexion.rollback(); // Rollback the transaction if the insertion failed
	            conexion.close();
	            return false;
	        }

	        
		} catch(SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
				return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
		}
	}
	
	// ACTUALIZAR TURNOS
	public boolean actualizarTurno(int estado, int id) {
		
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try {
			
			String query = "UPDATE Turnos" + 
					"Set Estado = " + Integer.toString(estado) +
					"WHERE Id = " + Integer.toString(id);
			
			Statement st = conexion.createStatement();
			 int rowsAffected = st.executeUpdate(query);
		        
		        // Check if the insertion was successful
		        if (rowsAffected > 0) {
		            conexion.commit(); // Commit the transaction
		            conexion.close();
		            return true;
		        } else {
		            conexion.rollback(); // Rollback the transaction if the insertion failed
		            conexion.close();
		            return false;
		        }
	        
		} catch(SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
				return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
		}

	}
	
	
	// LISTAR TURNOS
	@Override
	public ArrayList<Turno> listarTurnos(){

		Connection conexion = Conexion.getConexion().getSQLConexion();
		ArrayList<Turno> lista = new ArrayList<>();
	
	    try 
	    {

	        // Crea la sentencia SQL para insertar el paciente

	    	String query = "SELECT T.Id, E.Nombre, Pe1.Nombre NombreMedico, Pe1.Apellido ApellidoMedico, Pe2.Nombre NombrePaciente, Pe2.Apellido ApellidoPaciente, T.Fecha, T.Horario, T.Estado FROM Turnos T \r\n" + 
	    			"INNER JOIN Medicos M ON M.Id = T.IdMedico\r\n" + 
	    			"INNER JOIN Pacientes Pa ON Pa.Id = T.IdPaciente\r\n" + 
	    			"INNER JOIN Personas Pe1 ON Pe1.Id = M.IdPersona\r\n" + 
	    			"INNER JOIN Personas Pe2 ON Pe2.Id = Pa.IdPersona\r\n" + 
	    			"INNER JOIN Especialidades E ON M.IdEspecialidad = E.Id;";
	    	
	    	Statement st = conexion.createStatement();

	        
	        ResultSet rs = st.executeQuery(query);
	        
	        while(rs.next()) {
	        	//VERIFICACION DE ESTADO
	        
		        	
		        		
	        		Turno aListar = new Turno();
	        		Medico m = new Medico();
	        		Paciente p = new Paciente();
	        		Horario h = new Horario();
	        		Especialidad e = new Especialidad();
	        		
	        		e.setNombreEspecialidad(rs.getString("E.Nombre"));
	     	        		
	        		m.setNombre(rs.getString("NombreMedico"));
	        		m.setApellido(rs.getString("ApellidoMedico"));
	        		m.setEspecialidad(e);
	        		
	        		p.setNombre(rs.getString("NombrePaciente"));
	        		p.setApellido(rs.getString("ApellidoPaciente"));

	        		h.setInicioJornada(LocalTime.parse(rs.getString("T.Horario")));
	        		h.setDia(rs.getDate("T.Fecha").toString());
	        		
	        		aListar.setEstado(rs.getInt("T.Estado"));
	        		aListar.setHorario(h);
	        		aListar.setMedico(m);
	        		aListar.setPaciente(p);

	        		lista.add(aListar);
	        	
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
