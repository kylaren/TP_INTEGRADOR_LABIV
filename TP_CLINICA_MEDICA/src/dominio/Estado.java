package dominio;

public class Estado {

	private int id;
	private String nombre;
	
	public Estado() 
	{
		
	}

	// constructor
	public Estado(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// toString 
	@Override
	public String toString() {
		return "Estado [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
