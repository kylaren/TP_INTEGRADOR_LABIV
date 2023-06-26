package dominio;

import java.time.LocalTime;

public class Paciente extends Persona{
	
	private int id;
	private Especialidad especialidad;
	private DiaSemana diaAtencion;
	private LocalTime horarioAtencion;
	private Estado estado; 

	private static int cont=0;
	
	// id incremental
	public static int devuelveProximoID() {
		return cont+1;
	}

	//constructor
	public Paciente(int id, Especialidad especialidad, DiaSemana diaAtencion, LocalTime horarioAtencion,
			Estado estado) {
		super();
		cont++;
		this.id = cont;
		this.especialidad = especialidad;
		this.diaAtencion = diaAtencion;
		this.horarioAtencion = horarioAtencion;
		this.estado = estado;
	}

	// gets & sets
	public int getId() {
		return id;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", especialidad=" + especialidad + ", diaAtencion=" + diaAtencion
				+ ", horarioAtencion=" + horarioAtencion + ", estado=" + estado + "]" + super.toString();
	}
	
	
	


	
	
	

}
