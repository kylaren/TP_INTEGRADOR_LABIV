package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.SQLException;

import java.util.List;

import dao.PacienteDAO;
import dominio.Paciente;

public class PacienteDaoImpl implements PacienteDAO {

	@Override
	public boolean insert(Paciente paciente) {
		
		// Establece la conexión a la base de datos
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
	    
	    try 
	    {
	        // Crea la sentencia SQL para insertar el paciente
	        String spIngresarPaciente = "CALL SP_IngresarPaciente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        CallableStatement statement = conexion.prepareCall(spIngresarPaciente);

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

	
	
	
	@Override
	public boolean update(Paciente paciente) {
		
		// Establece la conexión a la base de datos
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean exito = false;
		
		try 
		{
		    // Llama al procedimiento almacenado
		    String sp = "CALL SP_ActualizarPaciente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		    CallableStatement statement = conexion.prepareCall(sp);
		    
		    // Establece los valores de los parámetros en el procedimiento almacenado
		    statement.setInt(1, paciente.getId());
		    statement.setString(2, paciente.getDni());
		    statement.setString(3, paciente.getNombre());
		    statement.setString(4, paciente.getApellido());
		    statement.setString(5, paciente.getSexo());
		    statement.setString(6, paciente.getNacionalidad());
		    statement.setDate(7, new java.sql.Date(paciente.getFechaNacimiento().getTime()));
		    statement.setString(8, paciente.getEmail());
		    statement.setString(9, paciente.getTelefono());
		    statement.setString(10, paciente.getDireccion().getCalle());
		    statement.setString(11, paciente.getDireccion().getNumero());
		    statement.setString(12, paciente.getDireccion().getLocalidad());
		    statement.setString(13, paciente.getDireccion().getProvincia());
		    statement.setString(14, paciente.getDireccion().getPais());
		    statement.setString(15, paciente.getDireccion().getCodigoPostal());
		    
		    
		    // Ejecuta el procedimiento almacenado
		    if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				exito = true;
				System.out.println("El paciente ha sido actualizado correctamente.");
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
		return exito;    
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
