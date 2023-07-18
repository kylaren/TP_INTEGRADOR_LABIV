package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

import java.util.List;

import dao.PacienteDAO;
import dominio.Direccion;
import dominio.Estado;
import dominio.Paciente;

public class PacienteDaoImpl implements PacienteDAO {
	
	private static final String readall = "SELECT * FROM Pacientes";
	
	Paciente paciente = new Paciente();
	
	// INSERTAR REGISTRO PACIENTE
	@Override
	public boolean insert(Paciente paciente) {
		// Establece la conexión a la base de datos
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
	    
	    try 
	    {
	        // Crea la sentencia SQL para insertar el paciente
	        String spIngresarPaciente = "CALL SP_IngresarPaciente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        CallableStatement statement = conexion.prepareCall(spIngresarPaciente);

	        // Establece los valores de los parámetros en la sentencia SQL
	        statement.setString(1, paciente.getDni());
	        statement.setString(2, paciente.getNombre());
	        statement.setString(3, paciente.getApellido());
	        statement.setString(4, paciente.getSexo());
	        statement.setString(5, paciente.getNacionalidad());
	        statement.setDate(6, java.sql.Date.valueOf(paciente.getFechaNacimiento()));
	        statement.setString(7, paciente.getEmail());
	        statement.setString(8, paciente.getTelefono());
	        
	        statement.setString(9, paciente.getDireccion().getCalle());
	        statement.setString(10, paciente.getDireccion().getNumero());
	        statement.setString(11, paciente.getDireccion().getLocalidad());
	        statement.setString(12, paciente.getDireccion().getProvincia());
	        statement.setString(13, paciente.getDireccion().getPais());
	        statement.setString(14, paciente.getDireccion().getCodigoPostal());
	        
	        System.out.println("Query: " + statement.toString());
	        
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
		}
	    return isInsertExitoso;
	}

	
	
	// ACTUALIZAR REGISTRO PACIENTE
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
		    statement.setDate(7, java.sql.Date.valueOf(paciente.getFechaNacimiento()));
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
	
	

	//ELIMINAR REGISTRO PACIENTE
	@Override
	public boolean delete(Paciente paciente_a_eliminar) {
		// Establece la conexión a la base de datos
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean exito = false;
		try
		{
			// Llama al procedimiento almacenado
			String sp = "CALL SP_EliminarPaciente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			CallableStatement statement = conexion.prepareCall(sp);
			
			// Establece los valores de los parámetros en el procedimiento almacenado
		    statement.setInt(1, paciente_a_eliminar.getId());
		    
		    // Ejecuta el procedimiento almacenado
		    if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				exito = true;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return exito;
	}

	
	
	//LISTAR REGISTROS PACIENTES
	@Override
	public ArrayList<Paciente> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				pacientes.add(getPaciente(resultSet));
			}
			resultSet.close();
			statement.close();
			conexion.cerrarConexion();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return pacientes;
	}
	
	
	private Paciente getPaciente(ResultSet resultSet) throws SQLException
	{
		  
		  String calle = resultSet.getString("calle");
		  String numero = resultSet.getString("numero");
		  String localidad = resultSet.getString("localidad");
		  String provincia = resultSet.getString("provincia");
		  String pais = resultSet.getString("pais");
		  String codigoPostal = resultSet.getString("codigo_postal");
		  String dni = resultSet.getString("dni");
		  String nombre = resultSet.getString("nombre");
		  String apellido = resultSet.getString("apellido");
		  String sexo = resultSet.getString("sexo");
		  String nacionalidad = resultSet.getString("nacionalidad");
		  LocalDate fechaNacimiento = (resultSet.getDate("fecha_nacimiento")).toLocalDate();
		  String email = resultSet.getString("email");
		  String telefono = resultSet.getString("telefono");
		  int id = resultSet.getInt("id");
		  int estado = resultSet.getInt("estado_id");
		  
		
		// Crea objeto de tipo Direccion
		  Direccion direccion = new Direccion(calle, numero, localidad, provincia, pais, codigoPostal);

		// Crea objeto de tipo Paciente y lo devuelve
		  return new Paciente(direccion, dni, nombre, apellido, sexo, nacionalidad, fechaNacimiento, email, telefono, id, estado);
	}

}
