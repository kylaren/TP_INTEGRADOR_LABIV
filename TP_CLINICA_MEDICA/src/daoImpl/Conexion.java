package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	public static Conexion instancia;
	private Connection connection;
	
	private Conexion()
	{
		try
		{

			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbclinica?useSSL=false&allowMultiQueries=true","root","root");
			this.connection.setAutoCommit(false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	

	public static Conexion getConexion()   
	{								
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			instancia = new Conexion();
			return instancia;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		instancia = null;
	}
}
