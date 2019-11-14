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
	
	public void llamaAscensor(int pisoActual, int pisoDestino) {
		char mejorOpcion;
		int pisoMasCercano;
		Random random = new Random();
		pisoMasCercano = random.nextInt(ascensores.size());
		boolean pasajeroProximo;
		for(Ascensor ascensor : ascensores) {
			if((ascensor.getDireccion().equals("sube") && ascensor.getPisoActual() <= pisoActual)||
			(ascensor.getDireccion().equals("baja")&& ascensor.getPisoActual() >= pisoActual) ||
			(ascensor.getDireccion().equals("quieto")) ) {
				pasajeroProximo = true;				
			} else {
				pasajeroProximo = false;
			}
		}
	}
	
	public void addAscensor(Ascensor ascensor){
		ascensores.add(ascensor);
	}
}
