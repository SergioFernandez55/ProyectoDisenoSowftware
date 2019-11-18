import java.util.ArrayList;

public class Sistema {
	DespachadorDePiso edificio;
	
	
	public void llamarAscensor(int pisoDestino, String direccion, int cantidadPersonas) {	
		for(int i = 0; i <= cantidadPersonas; i++) {
			int ascensor = edificio.llamaAscensor(pisoDestino, direccion, cantidadPersonas);
			edificio.getAscesores().get(ascensor).agregarPasajero();
		}		
	}
	
	/*public void addAscensor(Ascensor ascensor){
		ascensores.add(ascensor);
	}*/
	
	public void dispatch(int piso){
		
	}
}
