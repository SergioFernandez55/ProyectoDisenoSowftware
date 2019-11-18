import java.util.ArrayList;

public class Sistema {
	Edificio edificio;
	
	
	public void llamarAscensor(int pisoDestino, String direccion) {
		int ascensor = edificio.llamaAscensor(pisoDestino, direccion);
		edificio.getAscesores().get(ascensor).agregarPasajero();
	}
	
	/*public void addAscensor(Ascensor ascensor){
		ascensores.add(ascensor);
	}*/
	
	public void dispatch(int piso){
		
	}
}
