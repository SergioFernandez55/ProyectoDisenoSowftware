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
	
	public void llamaAscensor(int pisoDestino, String direccion) {
		int mejorOpcion = -1;
		int pisoMasCercano;
		Random random = new Random();
		pisoMasCercano = random.nextInt(ascensores.size());
		for(Ascensor ascensor : ascensores) {
			
			boolean aproximandoseAPasajero;
			boolean mismaDireccion;
			
			if((ascensor.getDireccion().equals("sube") && ascensor.getPisoActual() <= pisoDestino)||
			(ascensor.getDireccion().equals("baja")&& ascensor.getPisoActual() >= pisoDestino) ||
			(ascensor.getDireccion().equals("quieto")) ) {
				
				aproximandoseAPasajero = true;
				
			} else {
				
				aproximandoseAPasajero = false;
			
			}
			
			if(direccion.equals(ascensor.getDireccion()) || ascensor.getDireccion().equals("quieto")){
				mismaDireccion = true;
			}
			
			int distancia = Math.abs(pisoDestino - ascensor.getPisoActual());
			if(aproximandoseAPasajero && mismaDireccion && (mejorOpcion == -1 || distancia < Math.abs(pisoDestino - )))
		}
	}
	
	public void addAscensor(Ascensor ascensor){
		ascensores.add(ascensor);
	}
}
