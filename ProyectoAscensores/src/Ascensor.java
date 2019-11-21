import java.util.ArrayList;
import java.util.*;
import java.util.Vector;
import java.util.HashMap;
public class Ascensor {
	private int identificador;
	private String direccionActual = "quieto";
	private int pisoActual;
	//private Vector<Pair<Integer, Integer>> listaDestinos = new ArrayList<Integer>();
	private ArrayList<Integer> listaDestinos = new ArrayList<Integer>();
	private int pisoDestino = 1;
	private int maxPasajeros;
	private int pesoActual;
	private int pesoMax;
	private int cantidadPasajeros = 0;
	
	
	private Ascensor() {}
	
	public static class Builder {
		private Ascensor ascensor;
		
		public Ascensor build() {
			return ascensor;
		}
		
		public void setMaxPasajeros(int maxPasajeros) {
			ascensor.maxPasajeros = maxPasajeros;
		}

		public void setDireccion(String direccion) {
			ascensor.direccionActual = direccion;
		}
		
		public void setPisoActual(int piso) {
			ascensor.pisoActual = piso;
		}
}
	
	public static class BuilderAscensorPersonas {
		private Ascensor ascensor;
		
		public BuilderAscensorPersonas(Ascensor ascensor) {
			this.ascensor = ascensor;
		}
		
		public void setMaxPasajeros(int maxPasajeros) {
			ascensor.maxPasajeros = maxPasajeros;
		}
		
		public Ascensor build() {
			return ascensor;
		}
	}
	
	public static class BuilderAscensorCarga {
		private Ascensor ascensor;
		
		public BuilderAscensorCarga(Ascensor ascensor) {
			this.ascensor = ascensor;
		}
		
		public void setMaxCarga(int carga) {
			ascensor.maxPasajeros = carga;
		}
		
		public Ascensor build() {
			return ascensor;
		}
	}

	//int identificador, int pisoActual, int maxPasajeros
	
	
	public boolean getLleno() {
		if((cantidadPasajeros) > maxPasajeros) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	public int getPisoActual() {
		return pisoActual;
	}
	
	public String getDireccion() {
		return direccionActual;
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
	
	public int getCantidadParadas() {
		return listaDestinos.size();
	}
	
	public void addParada(Integer piso) {
		if (!listaDestinos.contains(piso)) {
			listaDestinos.add(piso);
		}
	}
	private void quitarParada(Integer piso) {
		Iterator<Integer> destinosIterator = listaDestinos.iterator();
		while(destinosIterator.hasNext()) {
			if(destinosIterator.next() == piso) {
				destinosIterator.remove();
				break;
			}		
		}
	}
	public void subir() {
		direccionActual = "sube";
	}
	public void bajar() {
		direccionActual = "baja";
	}
	public void detener() {
		direccionActual = "quieto";
	}
	
}
