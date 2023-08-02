package dominio;

import java.time.LocalDate;


public class Turno {
	private int id;
	private Medico medico;
	private Paciente paciente;
	private Horario horario;
	private int estado;
	
	@Override
	public String toString() {
		return "Turno [id=" + id + ", medico=" + medico + ", paciente=" + paciente + ", horario=" + horario
				+ ", estado=" + estado + "]";
	}

	public Turno() {
		
	}
	
	public Turno(int id, Medico medico, Paciente paciente, Horario horario, int estado) {
		super();
		this.id = id;
		this.medico = medico;
		this.paciente = paciente;
		this.horario = horario;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
