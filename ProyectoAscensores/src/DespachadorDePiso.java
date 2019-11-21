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

	private int calculadorTiempos(int pisoDestino, Ascensor ascensor) {
		int tiempoLlegada = 0;
		int cantidadPisosARecorrer = Math.abs(pisoDestino - ascensor.getPisoActual());
		int cantidadParadas = ascensor.getCantidadParadas();

		tiempoLlegada = cantidadPisosARecorrer * costoSubir + cantidadParadas * costoParada;
		return tiempoLlegada;
	}

	public int llamarAscensor(int pisoDestino, int pisoActual) {
		
		int ascensorElecto = 0;
		int costoMinimo = -1;
		int costoAscensor;
		Iterator<Ascensor> ascensorIterator = ascensores.iterator();
		while(ascensorIterator.hasNext()) {
			Ascensor ascensorTemporal= ascensorIterator.next();

			if(!ascensorTemporal.getLleno()) {
				
				if(ascensorTemporal.getDireccion() == "sube" && ascensorTemporal.getPisoActual() <= pisoActual || 
						   ascensorTemporal.getDireccion() == "baja" && ascensorTemporal.getPisoActual() >= pisoActual ||
						   ascensorTemporal.getDireccion() == "quieto"  ) {
							
							//Aqui se escriben las restricciones
					if(costoMinimo < 0) {
						costoMinimo = calculadorTiempos(pisoDestino, ascensorTemporal);
					}else {
						costoAscensor = calculadorTiempos(pisoDestino, ascensorTemporal);
						if(costoMinimo < costoAscensor) {
							costoMinimo = costoAscensor;
						}
					}
				}
			}		
		return ascensorElecto;
		
	}
	
	
	
	
	/*
	//agregar restricciones
	public int llamaAscensor(int pisoDestino, String direccion, int cantidadPersonas) {
		int mejorOpcion = 0;
		Random random = new Random();
		
		for(int i = 0; i < ascensores.size(); ++i) {
			
			boolean aproximandoseAPasajero = false;
			boolean mismaDireccion = false;
			
			if((ascensores.get(i).getDireccion().equals("sube") && ascensores.get(i).getPisoActual() <= piso)||
			(ascensores.get(i).getDireccion().equals("baja")&& ascensores.get(i).getPisoActual() >= piso) ||
			(ascensores.get(i).getDireccion().equals("quieto")) ) {
				
				aproximandoseAPasajero = true;
				
			} else {
				
				aproximandoseAPasajero = false;
			
			}
			
			if(direccion.equals(ascensores.get(i).getDireccion()) || ascensores.get(i).getDireccion().equals("quieto")){
				mismaDireccion = true;
			}
			
			int distancia = Math.abs(piso - ascensores.get(i).getPisoActual());
			if(aproximandoseAPasajero && mismaDireccion && !ascensores.get(i).getLleno() && (distancia < Math.abs(pisoDestino - ascensores.get(mejorOpcion).getPisoActual()))) {
				mejorOpcion = i;
			}
			
			//Fallback
			
		}
		return mejorOpcion;
	}
	

	
	
	
	public ArrayList<Ascensor> getAscesores() {
		return ascensores;
	}
	
	public void addAscensor(Ascensor ascensor){
		ascensores.add(ascensor);
	}*/
}
