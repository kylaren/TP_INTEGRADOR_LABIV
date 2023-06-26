package dominio;

import java.sql.Date;
import java.time.LocalTime;

public abstract class Persona {
	
	private String dni;
	private String nombre;
	private String apellido;
	private String sexo;
	private String nacionalidad;
	private Date fechaNacimiento;
	private String email;
	private String telefono;
	private Direccion direccion;
	
	///CONSTRUCTORES
	
	public Persona()
	{
		
	}
	
	public Persona(String dni, String nombre, String apellido, String sexo, String nacionalidad, Date fechaNacimiento,
			String email, String telefono, Direccion direccion) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
	}


	///SETTERS AND GETTERS
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	///TO STRING
	
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo
				+ ", nacionalidad=" + nacionalidad + ", fechaNacimiento=" + fechaNacimiento + ", email=" + email
				+ ", telefono=" + telefono + ", direccion=" + direccion + "]";
	}

	
}
