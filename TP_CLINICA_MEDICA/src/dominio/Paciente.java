package dominio;

import java.sql.Date;

public class Paciente extends Persona{
	
	private int id;
	private int estado; 

	
	//constructor
	
	
	public Paciente(Direccion direccion,String dni, String nombre, String apellido, String sexo, String nacionalidad, Date fechaNacimiento,
			String email, String telefono, int id, int estado) 
	{	
		super(direccion, dni, nombre, apellido, sexo, nacionalidad, fechaNacimiento, email, telefono);
		this.id = id;
		this.estado = estado;
	}

	
	public Paciente() {
		
	}


	// gets & sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	
	// toString
	@Override
	public String toString() {
		return "Paciente [id=" + id + ", estado=" + estado + "]" + super.toString(); // agrega los campos de la clase abstracta persona que también tiene el metodo toString();
	}

	
}