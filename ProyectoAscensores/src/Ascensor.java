import java.util.ArrayList;

public class Ascensor {
	private int identificador;
	private String direccionActual = "quieto";
	private int pisoActual;
	private ArrayList<Integer> listaDestinos = new ArrayList<Integer>();
	private int pisoDestino;
	private int maxPasajeros;
	private int cantidadPasajeros;
	
	
	
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
	
	public void agregarPasajero() {
		++cantidadPasajeros;
	}
	public void bajaPasajero() {
		--cantidadPasajeros;
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
	
	public boolean getLleno() {
		if(cantidadPasajeros > maxPasajeros) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
