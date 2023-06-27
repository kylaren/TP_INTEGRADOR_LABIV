package dominio;


public class Paciente extends Persona{
	
	private int id;
	private Estado estado; 

	
	//constructor
	public Paciente(int id, Estado estado) {
		super();
		this.id = id;
		this.estado = estado;
	}

	
	// gets & sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	
	// toString
	@Override
	public String toString() {
		return "Paciente [id=" + id + ", estado=" + estado + "]";
	}

	
}
