import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class DespachadorDePiso {
	private int cantidadPisos;
	private int cantidadAscensores;
	int costoSubir;
	int costoParada;
	private int piso;
	private ArrayList<Ascensor> ascensores = new ArrayList<Ascensor>();

	public DespachadorDePiso(int pisos, int costoSubir, int costoParada) {
		this.cantidadPisos = pisos;
		this.costoSubir = costoSubir;
		this.costoParada = costoParada;
	}

	public void addAscensor(Ascensor elevador) {
		ascensores.add(elevador);
		++cantidadAscensores;
	}

	public int llamarAscensor (int pisoDestino, int pisoActual, TipoAscensor tipo) {
		if(tipo == TipoAscensor.CARGA) {
			LlamarAscensorCarga carga = new LlamarAscensorCarga();
			return carga.llamarAscensor(pisoDestino, pisoActual, ascensores);
		}
		LlamarAscensorPasajeros Pasajeros = new LlamarAscensorPasajeros();
		return Pasajeros.llamarAscensor(pisoDestino, pisoActual, ascensores);
	}
	
	public  ArrayList<Ascensor> getListaAscensores(){
		return ascensores;
	}
}
