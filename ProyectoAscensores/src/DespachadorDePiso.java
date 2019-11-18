import java.util.ArrayList;
import java.util.Random;

public class DespachadorDePiso {
	private int cantidadPisos;
	private int cantidadAscensores;
	private int piso;
	private ArrayList<Ascensor> ascensores = new ArrayList<Ascensor>();
	
	public DespachadorDePiso(int pisos, int ascensores) {
		cantidadPisos = pisos;
		cantidadAscensores = ascensores;
	}
	
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
	
	public int calculadorTiempos(int pisoDestino, Ascensor ascensor) {
		int tiempoLlegada = 0;
		int cantidadPisosARecorrer = Math.abs(pisoDestino - ascensor.getPisoActual());
		//cantidadParadas = cantidadParadas
		
		
		return tiempoLlegada;
	}
	
	
	
	public ArrayList<Ascensor> getAscesores() {
		return ascensores;
	}
	
	public void addAscensor(Ascensor ascensor){
		ascensores.add(ascensor);
	}
}
