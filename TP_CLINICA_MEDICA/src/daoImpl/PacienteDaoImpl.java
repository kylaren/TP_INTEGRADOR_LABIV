package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import dao.PacienteDAO;
import dominio.Paciente;

public class PacienteDaoImpl implements PacienteDAO {

	@Override
	public boolean insert(Paciente paciente) {
		Connection connection = null;
	    PreparedStatement statement = null;
	    try {
	        // Establece la conexión a la base de datos
	        connection = Conexion.getConexion().getSQLConexion();

	        // Crea la sentencia SQL para insertar el paciente
	        String sql = "";
	        statement = connection.prepareStatement(sql);

	        // Establece los valores de los parámetros en la sentencia SQL
	        statement.setString(1, paciente.getDni());
	        statement.setString(2, paciente.getNombre());
	        statement.setString(3, paciente.getApellido());
	        statement.setString(4, paciente.getSexo());
	        statement.setString(5, paciente.getNacionalidad());
	        statement.setDate(6, new java.sql.Date(paciente.getFechaNacimiento().getTime()));
	        statement.setString(7, paciente.getEmail());
	        statement.setString(8, paciente.getTelefono());
	        
	        statement.setString(9, paciente.getDireccion().getCalle());
	        statement.setString(10, paciente.getDireccion().getNumero());
	        statement.setString(11, paciente.getDireccion().getLocalidad());
	        statement.setString(12, paciente.getDireccion().getProvincia());
	        statement.setString(13, paciente.getDireccion().getPais());
	        statement.setString(14, paciente.getDireccion().getCodigoPostal());
	    
	        // estas hay que modificarlas porque son clases (especialidad, diaAtencion, horario y estado)
//	        statement.setString(15, paciente.getEspecialidad());
//	        statement.setString(16, paciente.getDiaAtencion());
//	        statement.setTime(17, Time.valueOf(paciente.getHorarioAtencion()));
//	        statement.setString(18, paciente.getEstado());

	        // Ejecuta la sentencia SQL 
	        int filasAfectadas = statement.executeUpdate();

	        // Verifica si la operación fue exitosa
	        return (filasAfectadas > 0);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    } 
		
	}

	@Override
	public boolean update(Paciente paciente) {
		return false;
		// falta desarrollar
		
	}

	@Override
	public boolean delete(int dni) {
		return false;
		// falta desarrollar
		
	}

	@Override
	public List<Paciente> readAll() {
		// falta desarrollar
		return null;
	}

}
