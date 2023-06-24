package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Direccion;
import dominio.Paciente;

public class PacienteDAO {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "";  // AGREGAR NOMBRE DE LA BD
	
	
	// LISTAR PACIENTES
	
	public ArrayList<Paciente> obtenerPacientes(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Paciente> lista = new ArrayList<Paciente>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(""); // AGREGAR LA CONSULTA DEL PACIENTE PARA OBTENER SUS DATOS
			
			while(rs.next()) {
				
				Paciente pacienteRs = new Paciente();
				pacienteRs.setId(rs.getInt("idPaciente"));
				pacienteRs.setDni(rs.getString("dni"));
				pacienteRs.setNombre(rs.getString("nombre"));
				pacienteRs.setApellido(rs.getString("apellido"));
				pacienteRs.setSexo(rs.getString("sexo"));
				pacienteRs.setNacionalidad(rs.getString("nacionalidad"));
				pacienteRs.setFechaNacimiento(rs.getDate("fechaNacimiento"));
					Direccion direccion = new Direccion();
				    direccion.setCalle(rs.getString("calle"));
				    direccion.setNumero(rs.getString("numero"));
				    direccion.setLocalidad(rs.getString("localidad"));
				    direccion.setProvincia(rs.getString("provincia"));
				    direccion.setPais(rs.getString("pais"));
				    direccion.setCodigoPostal(rs.getString("codigoPostal"));
				pacienteRs.setDireccion(direccion);
				pacienteRs.setCorreoElectronico(rs.getString("correoElectronico"));
				pacienteRs.setTelefono(rs.getString("telefono"));
				
				lista.add(pacienteRs);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
