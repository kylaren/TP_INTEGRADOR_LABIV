package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import dao.MedicoDAO;
import dominio.Medico;
import dominio.Direccion;
import dominio.Especialidad;
import dominio.Horario;
import daoImpl.HorarioDaoImpl;

public class MedicoDaoImpl implements MedicoDAO{

	//------------------------
	//---FUNCIONES PRIVADAS---
	//------------------------
	
	//Obtiene medico desde el array
	private Medico retornarMedicoEnArray(ArrayList<Medico> listaMedicos, int idMedico) {
		for(Medico m : listaMedicos) {
			if(m.getId() == idMedico) {
				return m;
			}
		}
		return null;
	}
	
	
	//Chequea si hay medico repetido en el array
	private boolean esMedicoRepetido(ArrayList<Medico> listaMedicos, int idMedico) {
		for(Medico m : listaMedicos) {
			if(m.getId() == idMedico) {
				return true;
			}
		}
		return false;
	}
	
	//------------------------
	//---FUNCIONES PUBLICAS---
	//------------------------
	
	// ACTUALIZAR MEDICOS
	
	@Override
	public boolean actualizarMedico(Medico medico) {
		// Establece la conexión a la base de datos
				Connection conexion = Conexion.getConexion().getSQLConexion();
				boolean exito = false;
				
				try 
				{
				    // Llama al procedimiento almacenado
				    String sp = "CALL SP_ActualizarMedico(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				    CallableStatement statement = conexion.prepareCall(sp);
				    
				    // Establece los valores de los parámetros en el procedimiento almacenado
				    statement.setInt(1, medico.getId());
			        statement.setString(1, medico.getDni());
			        statement.setString(2, medico.getNombre());
			        statement.setString(3, medico.getApellido());
			        statement.setString(4, medico.getSexo());
			        statement.setString(5, medico.getNacionalidad());
			        statement.setDate(6, java.sql.Date.valueOf(medico.getFechaNacimiento()));
			        statement.setString(7, medico.getEmail());
			        statement.setString(8, medico.getTelefono());
			        
			        statement.setString(9, medico.getDireccion().getCalle());
			        statement.setString(10, medico.getDireccion().getNumero());
			        statement.setString(11, medico.getDireccion().getLocalidad());
			        statement.setString(12, medico.getDireccion().getProvincia());
			        statement.setString(13, medico.getDireccion().getPais());
			        statement.setString(14, medico.getDireccion().getCodigoPostal());
			        statement.setInt(15, medico.getEspecialidad().getIdEspecialidad());
			        statement.setString(16, medico.getUsuario() );
			        statement.setString(17, medico.getContrasena());
				    
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
	
	
	
	// INSERTAR MEDICOS
	
	@Override
	public boolean insertarMedico(Medico medico) {
		
		// Establece la conexión a la base de datos
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
	    
	    try 
	    {
	        // Crea la sentencia SQL para insertar el medico
	        String spIngresarPaciente = "CALL SP_IngresarMedico(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        CallableStatement statement = conexion.prepareCall(spIngresarPaciente);

	        // Establece los valores de los parámetros en la sentencia SQL
	        statement.setString(1, medico.getDni());
	        statement.setString(2, medico.getNombre());
	        statement.setString(3, medico.getApellido());
	        statement.setString(4, medico.getSexo());
	        statement.setString(5, medico.getNacionalidad());
	        statement.setDate(6, java.sql.Date.valueOf(medico.getFechaNacimiento()));
	        statement.setString(7, medico.getEmail());
	        statement.setString(8, medico.getTelefono());
	        
	        statement.setString(9, medico.getDireccion().getCalle());
	        statement.setString(10, medico.getDireccion().getNumero());
	        statement.setString(11, medico.getDireccion().getLocalidad());
	        statement.setString(12, medico.getDireccion().getProvincia());
	        statement.setString(13, medico.getDireccion().getPais());
	        statement.setString(14, medico.getDireccion().getCodigoPostal());
	        statement.setInt(15, medico.getEspecialidad().getIdEspecialidad());
	        statement.setString(16, medico.getUsuario() );
	        statement.setString(17, medico.getContrasena());
	        statement.setString(18, medico.getHorario().get(0).getDia());
	        statement.setTime(19, java.sql.Time.valueOf(medico.getHorario().get(0).getInicioJornada()));
	        statement.setTime(20, java.sql.Time.valueOf(medico.getHorario().get(0).getFinalJornada()));
	        
	        
	        
	        
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
	
	// ELIMINAR MEDICOS
	
	@Override
	public boolean borrarMedico(int idEliminar) {
		
		
		// Establece la conexión a la base de datos
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
	    
	    try 
	    {
	        // Crea la sentencia SQL para insertar el medico
	        String spIngresarPaciente = "CALL SP_EliminarMedico(?)";
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
	

	@Override
	public ArrayList<Medico> listarMedicos(){


		
		
		Connection conexion = Conexion.getConexion().getSQLConexion();
	    
	    
		ArrayList<Medico> lista = new ArrayList<>();
		HorarioDaoImpl listaHorariaDao = new HorarioDaoImpl();
		
	    try 
	    {



	        // Crea la sentencia SQL para insertar el paciente

	    	String query = "Select M.ID, P.Dni, P.Nombre, P.Apellido, P.Sexo, P.Nacionalidad, P.FechaNacimiento, "+
	    			"U.Calle, U.Numero, U.Localidad, U.Provincia, U.Pais, U.CodigoPostal, "+
                    "P.Email, P.Telefono, E.Nombre, H.Dia, H.Inicio, H.Final FROM Medicos M "+
	    			"INNER JOIN Personas P ON M.IdPersona = P.Id "+
	    			"INNER JOIN Ubicaciones U ON P.IdUbicacion = U.Id "+
					"INNER JOIN Especialidades E ON M.IdEspecialidad = E.Id "+
                    "LEFT JOIN Horarios H ON H.IdMedico = M.Id "+
					"ORDER BY M.Id";
	    	Statement st = conexion.createStatement();

	        
	        ResultSet rs = st.executeQuery(query);
	        
	        while(rs.next()) {
	        	

	        	//Verifica si el medico esta en el array de listados
	        	if (esMedicoRepetido(lista, rs.getInt("M.ID"))) {
	        		
	        		//Si el medico ya esta en el array, va a expandir la lista de horarios de este
	        		
	        		Medico aAgregar = new Medico();
	        		Horario horarioNuevo = new Horario();
	        		aAgregar = retornarMedicoEnArray(lista, rs.getInt("M.ID"));
	        		ArrayList<Horario>listaExpandida = aAgregar.getHorario();
	        		horarioNuevo.setDia(rs.getString("H.Dia"));
	        		horarioNuevo.setInicioJornada(LocalTime.parse(rs.getString("H.Inicio")));
	        		horarioNuevo.setFinalJornada(LocalTime.parse(rs.getString("H.Final")));
				    listaExpandida.add(horarioNuevo);
				    aAgregar.setHorario(listaExpandida);
				    lista.set(lista.size() - 1, aAgregar);
	        		
	        	} else {
	        		//Si el medico no esta en el array, se lo agrega
	        		
	        		Medico aListar = new Medico();
	        		Direccion direccion = new Direccion();
	        		Especialidad especialidad = new Especialidad();
	        		ArrayList<Horario> horarioLista = new ArrayList<>();
	        		Horario horario = new Horario();
	        		aListar.setId(rs.getInt("M.ID"));
	        		aListar.setDni(rs.getString("P.Dni"));
	        		aListar.setNombre(rs.getString("P.Nombre"));
	        		aListar.setApellido(rs.getString("P.Apellido"));
	        		aListar.setSexo(rs.getString("P.Sexo"));
	        		aListar.setNacionalidad(rs.getString("P.Nacionalidad"));
	        		aListar.setFechaNacimiento(rs.getDate("P.FechaNacimiento").toLocalDate());
	        		direccion.setCalle(rs.getString("U.Calle"));
	        		direccion.setNumero(rs.getString("U.Numero"));
	        		direccion.setLocalidad(rs.getString("U.Localidad"));
	        		direccion.setProvincia(rs.getString("U.Provincia"));
	        		direccion.setPais(rs.getString("U.Pais"));
	        		direccion.setCodigoPostal(rs.getString("U.CodigoPostal"));
	        		aListar.setDireccion(direccion);
	        		aListar.setEmail(rs.getString("P.Email"));
	        		aListar.setTelefono(rs.getString("P.Telefono"));
	        		especialidad.setNombreEspecialidad(rs.getString("E.Nombre"));
	        		aListar.setEspecialidad(especialidad);
	        		horario.setDia(rs.getString("H.Dia"));
	        		if (rs.getString("H.Inicio")!= null) {
		        		horario.setInicioJornada(LocalTime.parse(rs.getString("H.Inicio")));
		        		horario.setFinalJornada(LocalTime.parse(rs.getString("H.Final")));
	        		} else {
		        		horario.setInicioJornada(LocalTime.parse("00:00"));
		        		horario.setFinalJornada(LocalTime.parse("00:00"));
	        		}

	        		horarioLista.add(horario);
	        		aListar.setHorario(horarioLista);
	        		

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
	
	/*
	// BUSCAR MEDICOS
	@Override
	public Medico buscarMedico(int idBusqueda){
		
		Medico aDevolver = new Medico();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(""); // AGREGAR LA CONSULTA DEL PACIENTE PARA OBTENER SUS DATOS
			
			while(rs.next()) {
				
				int idActual = rs.getInt("idMedico");
				
				if(idActual == idBusqueda) {
					
		
					aDevolver.setId(rs.getInt("idPaciente"));
					aDevolver.setDni(rs.getString("dni"));
					aDevolver.setNombre(rs.getString("nombre"));
					aDevolver.setApellido(rs.getString("apellido"));
					aDevolver.setSexo(rs.getString("sexo"));
					aDevolver.setNacionalidad(rs.getString("nacionalidad"));
					aDevolver.setFechaNacimiento(rs.getDate("fechaNacimiento"));
					Direccion direccion = new Direccion();
				    direccion.setCalle(rs.getString("calle"));
				    direccion.setNumero(rs.getString("numero"));
				    direccion.setLocalidad(rs.getString("localidad"));
				    direccion.setProvincia(rs.getString("provincia"));
				    direccion.setPais(rs.getString("pais"));
				    direccion.setCodigoPostal(rs.getString("codigoPostal"));
				    aDevolver.setDireccion(direccion);
				    aDevolver.setCorreoElectronico(rs.getString("correoElectronico"));
				    aDevolver.setTelefono(rs.getString("telefono"));
					
				    break;
				    
				}
				else {
					
					
				}

			}
			
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return aDevolver;
	}

	 */
	 
	 
	
}

