package dominio;

import java.time.LocalDate;
import java.util.ArrayList;

public class Medico {
	private int id;
	private String usuario;
	private String contrasena;
	private String dni;
	private String nombre;
	private String apellido;
	private String sexo;
	private String nacionalidad;
	private LocalDate fechaNacimiento;
	private Direccion direccion;
	private String email;
	private String telefono;
	private Especialidad especialidad;
	private ArrayList<Horario> horario;



	@Override
	public String toString() {
		return "Medico [id=" + id + ", usuario=" + usuario + ", contrasena=" + contrasena + ", dni=" + dni + ", nombre="
				+ nombre + ", apellido=" + apellido + ", sexo=" + sexo + ", nacionalidad=" + nacionalidad
				+ ", direccion=" + direccion + ", email=" + email + ", telefono=" + telefono + ", especialidad="
				+ especialidad + ", horario=" + horario + "]";
	}

	public Medico(int id, String usuario, String contrasena, String dni, String nombre, String apellido, String sexo,
			String nacionalidad, LocalDate fechaNacimiento, Direccion direccion, String email, String telefono,
			Especialidad especialidad, ArrayList<Horario> horario) {
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
		this.horario = horario;
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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
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

	public ArrayList<Horario> getHorario() {
		return horario;
	}

	public void setHorario(ArrayList<Horario> horario) {
		this.horario = horario;
	}

	public Medico()
	{
		
	}
}
