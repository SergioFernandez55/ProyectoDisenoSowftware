import java.util.ArrayList;
import java.util.Iterator;

public abstract class TemplateLlamarAscensor {

	int costoSubir = 1;
	int costoParada = 2;
	
	
	private int calculadorTiempos(int pisoDestino, Ascensor ascensor) {
		int tiempoLlegada = 0;
		int cantidadPisosARecorrer = Math.abs(pisoDestino - ascensor.getPisoActual());
		int cantidadParadas = ascensor.getCantidadParadas();

		tiempoLlegada = cantidadPisosARecorrer * costoSubir + cantidadParadas * costoParada;
		return tiempoLlegada;
	}
	
	abstract boolean checkTipo(TipoAscensor tipo);

	public final int llamarAscensor(int pisoDestino, int pisoActual, ArrayList<Ascensor> ascensores) {
		
		int ascensorElecto = 0;
		int costoMinimo = -1;
		int costoAscensor;
		Iterator<Ascensor> ascensorIterator = ascensores.iterator();
		while(ascensorIterator.hasNext()) {
			
			Ascensor ascensorTemporal= ascensorIterator.next();
				
				if(ascensorTemporal.getDireccion() == "sube" && ascensorTemporal.getPisoActual() <= pisoActual || 
						   ascensorTemporal.getDireccion() == "baja" && ascensorTemporal.getPisoActual() >= pisoActual ||
						   ascensorTemporal.getDireccion() == "quieto") {
					
					if(checkTipo(ascensorTemporal.getTipo())) {
						
						if(costoMinimo < 0) {
							costoMinimo = calculadorTiempos(pisoDestino, ascensorTemporal);
							ascensorElecto = ascensorTemporal.getIdentificador();
						}else {
							
							costoAscensor = calculadorTiempos(pisoDestino, ascensorTemporal);
							if(costoMinimo < costoAscensor) {
								costoMinimo = ascensorTemporal.getIdentificador();
								ascensorElecto = ascensorTemporal.getIdentificador();
							}
						}
					}
				}
			}		
		
		return ascensorElecto;
	}
}
