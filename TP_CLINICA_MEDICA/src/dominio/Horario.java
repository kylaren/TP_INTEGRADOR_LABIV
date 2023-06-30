package dominio;

import java.time.LocalTime;

public class Horario {
	
	private int id;
	private int idMedico;
	private String dia;
	private LocalTime inicioJornada;
	private LocalTime finalJornada;
	
	public Horario() {
		
	}
	
	public Horario(int id, int idMedico, String dia, LocalTime inicioJornada, LocalTime finalJornada) {
		super();
		this.id = id;
		this.idMedico = idMedico;
		this.dia = dia;
		this.inicioJornada = inicioJornada;
		this.finalJornada = finalJornada;
	}

	// GETTERS Y SETTERS
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public LocalTime getInicioJornada() {
		return inicioJornada;
	}

	public void setInicioJornada(LocalTime inicioJornada) {
		this.inicioJornada = inicioJornada;
	}

	public LocalTime getFinalJornada() {
		return finalJornada;
	}

	public void setFinalJornada(LocalTime finalJornada) {
		this.finalJornada = finalJornada;
	}

	// TO STRING

	@Override
	public String toString() {
		return "Horario [id=" + id + ", idMedico=" + idMedico + ", dia=" + dia + ", inicioJornada=" + inicioJornada
				+ ", finalJornada=" + finalJornada + "]";
	}
	
	
	
	
}
