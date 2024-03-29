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
	private TipoAscensor tipo;
		
	
	private Ascensor() {}
	
	public static class BuilderAscensorPersonas {
		private Ascensor ascensor;
		
		public BuilderAscensorPersonas(Ascensor ascensor) {
			this.ascensor = ascensor;
			this.ascensor.tipo = TipoAscensor.PASAJEROS;
		}
		
		public BuilderAscensorPersonas setMaxPasajeros(int maxPasajeros) {
			ascensor.maxPasajeros = maxPasajeros;
			return this;
		}
		
		public Ascensor build() {
			return ascensor;
		}
	}
	
	public static class BuilderAscensorCarga {
		private Ascensor ascensor;
		
		public BuilderAscensorCarga(Ascensor ascensor) {
			this.ascensor = ascensor;
			this.ascensor.tipo = TipoAscensor.CARGA;
		}
		
		public void setMaxCarga(int carga) {
			ascensor.maxPasajeros = carga;
		}
		
		public Ascensor build() {
			return ascensor;
		}
	}
	
	public static class Builder {
		private Ascensor ascensor;
		
		public Builder(){
			ascensor = new Ascensor();
		}
	
		public Builder setID(int ID) {
			ascensor.identificador = ID;
			return this;
		}
		
		public Builder setMaxPasajeros(int maxPasajeros) {
			ascensor.maxPasajeros = maxPasajeros;
			return this;
		}

		public Builder setDireccion(String direccion) {
			ascensor.direccionActual = direccion;
			return this;
		}
		
		public Builder setPisoActual(int piso) {
			ascensor.pisoActual = piso;
			return this;
		}
		
		public BuilderAscensorPersonas setTipoPersona(){
			return new Ascensor.BuilderAscensorPersonas(ascensor);
		}
		
		public BuilderAscensorCarga setTipoCarga(){
			return new Ascensor.BuilderAscensorCarga(ascensor);
		}
		
		public Ascensor build() {
			return this.ascensor;
		}
	}

	
	public TipoAscensor getTipo() {
		return tipo;
	}
	
	int getIdentificador() {
		return identificador;
	}
	
	public int getPisoActual() {
		return pisoActual;
	}
	
	public int getPasajeros() {
		return cantidadPasajeros;
	}
	
	public String getDireccion() {
		return direccionActual;
	}
	
	public int getCantidadParadas() {
		return listaDestinos.size();
	}
	
	public void addParada(Integer piso) {
		if (!listaDestinos.contains(piso)) {
			listaDestinos.add(piso);
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
