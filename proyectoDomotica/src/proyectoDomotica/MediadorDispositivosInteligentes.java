package proyectoDomotica;
import java.util.ArrayList;


public class MediadorDispositivosInteligentes {
	
	ArrayList<Comportamiento> comportamientos = new ArrayList<Comportamiento>();
	
	public ArrayList<Comportamiento> getComportamientos(){
		return comportamientos;
	}	
	
	public void agregaComportamiento(DispositivoInteligente emisor, Actuador receptor, boolean activar) {
		Comportamiento comportamiento = new Comportamiento(this);
		comportamiento.setComportamiento(emisor, receptor, activar);
		comportamientos.add(comportamiento);
	}
	
	public boolean llamarComportamiento(DispositivoInteligente dispositivo) {
		for (int i=0; i<comportamientos.size(); ++i) {
			if (comportamientos.get(i).getEmisor() == dispositivo) {
				comportamientos.get(i).llamarComportamiento(dispositivo, this);
			}
		}
		return true;
	}
}
