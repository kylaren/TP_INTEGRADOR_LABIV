package dominio;

import java.sql.Date;

public class Medico {
	private int id;
	private String usuario;
	private String contrasena;
	private String dni;
	private String nombre;
	private String apellido;
	private String sexo;
	private String nacionalidad;
	private Date fechaNacimiento;
	private Direccion direccion;
	private String email;
	private String telefono;
	private Especialidad especialidad;

	


	@Override
	public String toString() {
		return "Medico [id=" + id + ", usuario=" + usuario + ", contrasena=" + contrasena + ", dni=" + dni + ", nombre="
				+ nombre + ", apellido=" + apellido + ", sexo=" + sexo + ", nacionalidad=" + nacionalidad
				+ ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + ", email="
				+ email + ", telefono=" + telefono + ", especialidad=" + especialidad + " ]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getContrasena() {
		return contrasena;
	}



	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}



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



	public Direccion getDireccion() {
		return direccion;
	}



	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
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



	public Especialidad getEspecialidad() {
		return especialidad;
	}



	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}



	public Medico(int id, String usuario, String contrasena, String dni, String nombre, String apellido, String sexo,
			String nacionalidad, Date fechaNacimiento, Direccion direccion, String email, String telefono,
			Especialidad especialidad) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.especialidad = especialidad;
	}



	public Medico()
	{
		
	}
	
	
	
	

}
