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
	private String correoElectronico;
	private String telefono;
	private Direccion direccion;
	private Especialidad especialidad;
	private DiaSemana diaAtencion;
	private LocalTime horarioAtencion;
	
	///CONSTRUCTORES
	
	public Persona()
	{
		
	}
	
	public Persona(String dni, String nombre, String apellido, String sexo, String nacionalidad, Date fechaNacimiento,
			String correoElectronico, String telefono, Direccion direccion, Especialidad especialidad,
			DiaSemana diaAtencion, LocalTime horarioAtencion) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
		this.correoElectronico = correoElectronico;
		this.telefono = telefono;
		this.direccion = direccion;
		this.especialidad = especialidad;
		this.diaAtencion = diaAtencion;
		this.horarioAtencion = horarioAtencion;
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
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
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
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	public DiaSemana getDiaAtencion() {
		return diaAtencion;
	}
	public void setDiaAtencion(DiaSemana diaAtencion) {
		this.diaAtencion = diaAtencion;
	}
	public LocalTime getHorarioAtencion() {
		return horarioAtencion;
	}
	public void setHorarioAtencion(LocalTime horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo
				+ ", nacionalidad=" + nacionalidad + ", fechaNacimiento=" + fechaNacimiento + ", correoElectronico="
				+ correoElectronico + ", telefono=" + telefono + ", direccion=" + direccion + ", especialidad="
				+ especialidad + ", diaAtencion=" + diaAtencion + ", horarioAtencion=" + horarioAtencion + "]";
	}
	
	///TO STRING
	
	
	
	
	
}
