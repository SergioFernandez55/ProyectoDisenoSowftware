package proyectoDomotica;
import java.util.ArrayList;


public class MediadorDispositivosInteligentes {
	
	ArrayList<DispositivoInteligente> dispositivos = new ArrayList();
	
	ArrayList<Comportamiento> comportamientos = new ArrayList();
	
	ActuadorLampara lampara = new ActuadorLampara(this);
	ActuadorAireAcondicionado aireAcondicionado = new ActuadorAireAcondicionado(this);
	ActuadorAspersores aspersores = new ActuadorAspersores(this);

	public void agregarDispositivo(DispositivoInteligente dispositivo) {
		dispositivos.add(dispositivo);
	}
	
	
	public void agregaComportamiento(DispositivoInteligente emisor, Actuador receptor, boolean activar) {
		if(dispositivos.contains(emisor) && dispositivos.contains(receptor)) {
			Comportamiento comportamiento = new Comportamiento(this);
			comportamiento.setComportamiento(emisor, receptor, activar);
			comportamientos.add(comportamiento);
		}
	}
	
	public boolean llamarComportamiento(DispositivoInteligente dispositivo) {
		for (int i=0; i<comportamientos.size(); ++i) {
			if (comportamientos.get(i).getEmisor() == dispositivo) {
				System.out.println("mediador");
				comportamientos.get(i).llamarComportamiento(dispositivo, this);
			}
		}
		return true;
	}
}
