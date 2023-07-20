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
import dominio.Medico;
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
	        
	        //System.out.println("Query: " + statement.toString());
	        
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
	public boolean delete(int aEliminar) {
		// Establece la conexión a la base de datos
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean exito = false;
		try
		{
			// Llama al procedimiento almacenado
			String sp = "CALL SP_EliminarPaciente(?)";
			CallableStatement statement = conexion.prepareCall(sp);
			
			// Establece los valores de los parámetros en el procedimiento almacenado
		    statement.setInt(1, aEliminar);
		    
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

	
	
	
	
	
	//Chequea si hay Paciente repetido en el array
	private boolean esPacienteRepetido(ArrayList<Paciente> listaPacientes, int idPaciente) {
		for(Paciente p : listaPacientes) {
			if(p.getId() == idPaciente) {
				return true;
			}
		}
		return false;
	}
	
	//LISTAR REGISTROS PACIENTES
	@Override
	public ArrayList<Paciente> readAll() {
		
		
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ArrayList<Paciente> lista = new ArrayList<>();
		try 
	    {

	        // Crea la sentencia SQL para insertar el paciente

	    	String query = "SELECT PC.ID, P.Dni, P.Nombre, P.Apellido, P.Sexo, P.Nacionalidad, P.FechaNacimiento, P.Email, P.Telefono," + 
	    			"	    		      U.Calle, U.Numero, U.Localidad, U.Provincia, U.Pais, U.CodigoPostal, PC.Estado" + 
	    			"	    		      FROM Pacientes AS PC" + 
	    			"	    		      JOIN Personas AS P ON PC.IdPersona = P.Id" + 
	    			"	    		      JOIN Ubicaciones AS U ON P.IdUbicacion = U.Id";
	    	Statement st = conexion.createStatement();
		
	    	ResultSet rs = st.executeQuery(query);
		
	    	while(rs.next()) {
	    		// verifica estado
	    		if(rs.getBoolean("PC.Estado")) {
		    			//verifica si el paciente esta en el array de listado
		    			if(esPacienteRepetido(lista, rs.getInt("PC.ID")) == false) {
		    			
		    				Paciente aListar = new Paciente();
		    				Direccion direccion = new Direccion();
		    				
		    				aListar.setId(rs.getInt("PC.Id"));
		    				aListar.setDni(rs.getString("P.Dni"));
		    				aListar.setNombre(rs.getString("P.Nombre"));
		    				aListar.setApellido(rs.getString("P.Apellido"));
		    				aListar.setSexo(rs.getString("P.Sexo"));
		    				aListar.setNacionalidad(rs.getString("P.Nacionalidad"));
		    				aListar.setFechaNacimiento(rs.getDate("P.FechaNacimiento").toLocalDate());
		    				aListar.setEmail(rs.getString("P.Email"));
		    				aListar.setTelefono(rs.getString("P.Telefono"));
		    				direccion.setCalle(rs.getString("U.Calle"));
			        		direccion.setNumero(rs.getString("U.Numero"));
			        		direccion.setLocalidad(rs.getString("U.Localidad"));
			        		direccion.setProvincia(rs.getString("U.Provincia"));
			        		direccion.setPais(rs.getString("U.Pais"));
			        		direccion.setCodigoPostal(rs.getString("U.CodigoPostal"));
			        		aListar.setDireccion(direccion);
			        		
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
	
	
	public Paciente buscarPaciente(int idBusqueda) {
		
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		Paciente aDevolver = new Paciente();
		
		try {
			String query = 	"SELECT PC.ID, P.Dni, P.Nombre, P.Apellido, P.Sexo, P.Nacionalidad, P.FechaNacimiento, P.Email, P.Telefono," + 
							"	    		      U.Calle, U.Numero, U.Localidad, U.Provincia, U.Pais, U.CodigoPostal, PC.Estado" + 
							"	    		      FROM Pacientes AS PC" + 
							"	    		      JOIN Personas AS P ON PC.IdPersona = P.Id" + 
							"	    		      JOIN Ubicaciones AS U ON P.IdUbicacion = U.Id" +
							"                     WHERE PC.Id= " + String.valueOf(idBusqueda);
			
	    	Statement st = conexion.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        
	        while(rs.next()) {
	        	int idActual = rs.getInt("PC.ID");
	        	
	        	if(idActual == idBusqueda) {
	        		Direccion direccion = new Direccion();
	        		 
	        		aDevolver.setId(rs.getInt("PC.ID"));
	        		aDevolver.setDni(rs.getString("P.Dni"));
	        		aDevolver.setNombre(rs.getString("P.Nombre"));
	        		aDevolver.setApellido(rs.getString("P.Apellido"));
	        		aDevolver.setSexo(rs.getString("P.Sexo"));
	        		aDevolver.setNacionalidad(rs.getString("P.Nacionalidad"));
	        		aDevolver.setFechaNacimiento(rs.getDate("P.FechaNacimiento").toLocalDate());
	        		aDevolver.setEmail(rs.getString("P.Email"));
	        		aDevolver.setTelefono(rs.getString("P.Telefono"));
	        		
	        		direccion.setCalle(rs.getString("U.Calle"));
	        		direccion.setNumero(rs.getString("U.Numero"));
	        		direccion.setLocalidad(rs.getString("U.Localidad"));
	        		direccion.setProvincia(rs.getString("U.Provincia"));
	        		direccion.setPais(rs.getString("U.Pais"));
	        		direccion.setCodigoPostal(rs.getString("U.CodigoPostal"));
	        		aDevolver.setDireccion(direccion);
	        		
	        		break;
	        	}
	        }
	        conexion.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			return aDevolver;
	}
	

}
