package dominio;

public class Direccion {

	private String calle;
	private String numero;
	private String localidad;
	private String provincia;
	private String pais;
	private String codigoPostal;
	
	public Direccion()
	{
		
	}
	
	public Direccion(String calle, String numero, String localidad, String provincia, String pais,
			String codigoPostal) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
		this.provincia = provincia;
		this.pais = pais;
		this.codigoPostal = codigoPostal;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	public void setDireccion(String calle, String numero, String localidad, String provincia, String pais, String codigoPostal) {
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
		this.provincia = provincia;
		this.pais = pais;
		this.codigoPostal = codigoPostal;
		
	}

	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", numero=" + numero + ", localidad=" + localidad + ", provincia="
				+ provincia + ", pais=" + pais + ", codigoPostal=" + codigoPostal + "]";
	}
	
	
	
	
	
}
