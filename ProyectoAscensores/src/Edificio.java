import java.util.ArrayList;
import java.util.Random;

public class Edificio {
	private int cantidadPisos;
	private int cantidadAscensores;
	private ArrayList<Ascensor> ascensores = new ArrayList<Ascensor>();
	
	public Edificio(int pisos, int ascensores) {
		cantidadPisos = pisos;
		cantidadAscensores = ascensores;
	}
	
	//agregar restricciones
	public int llamaAscensor(int pisoDestino, String direccion) {
		int mejorOpcion = 0;
		int pisoMasCercano;
		Random random = new Random();
		pisoMasCercano = random.nextInt(ascensores.size());
		int cantidadPersonas = 0;
		
		for(int i = 0; i < ascensores.size(); ++i) {
			
			boolean aproximandoseAPasajero = false;
			boolean mismaDireccion = false;
			
			if((ascensores.get(i).getDireccion().equals("sube") && ascensores.get(i).getPisoActual() <= pisoDestino)||
			(ascensores.get(i).getDireccion().equals("baja")&& ascensores.get(i).getPisoActual() >= pisoDestino) ||
			(ascensores.get(i).getDireccion().equals("quieto")) ) {
				
				aproximandoseAPasajero = true;
				
			} else {
				
				aproximandoseAPasajero = false;
			
			}
			
			if(direccion.equals(ascensores.get(i).getDireccion()) || ascensores.get(i).getDireccion().equals("quieto")){
				mismaDireccion = true;
			}
			
			int distancia = Math.abs(pisoDestino - ascensores.get(i).getPisoActual());
			if(aproximandoseAPasajero && mismaDireccion && ascensores.get(i).getLleno() && (mejorOpcion == 0 || distancia < Math.abs(pisoDestino - ascensores.get(mejorOpcion).getPisoActual()))) {
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
	}
}
