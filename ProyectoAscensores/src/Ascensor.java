
public class Ascensor {
	private char identificador;
	private String direccionActual = "quieto";
	private int pisoActual;
	private int pisoDestino;
	private int maxPasajeros;
	private int cantidadPasajero;
	
	
	public void subirUnPiso() {
		
	}
	
	public void bajarUnPiso() {
		
	}
	
	public void setMaxPasajeros(int maxPasajeros) {
		this.maxPasajeros = maxPasajeros;
	}
	
	public int getMaxPasajeros() {
		return this.maxPasajeros;
	}
	
	public void agregarPasajeros() {
		++cantidadPasajero;
	}
	public void bajaPasajero() {
		--cantidadPasajero;
	}
	
	public String getDireccion() {
		return direccionActual;
	}
	
	public void setDireccion(String direccion) {
		 direccionActual = direccion;
	}
	
	public void setPisoActual(int piso) {
		pisoActual = piso;
	}
	
	public int getPisoActual() {
		return pisoActual;
	}
}
