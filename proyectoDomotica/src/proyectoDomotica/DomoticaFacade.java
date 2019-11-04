package proyectoDomotica;

import java.util.ArrayList;

public class DomoticaFacade {
	MediadorDispositivosInteligentes mediador;
	
	public void agregarSensor(ArrayList<Sensor> sensores){
		for (Sensor sensor:sensores) {
			mediador.agregarDispositivo(sensor);
		}
	}
	
	public void agregarActuador(ArrayList<Actuador> actuadores) {
		for (Actuador actuador:actuadores) {
			mediador.agregarDispositivo(actuador);
		}
	}
	
	public void agregarComportamiento(ArrayList<Comportamiento> comportamientos) {
		for(Comportamiento comportamiento:comportamientos) {
			mediador.agregaComportamiento(comportamiento.emisor, comportamiento.receptor, comportamiento.activar);
		}
	}
	
	public void setMediador(MediadorDispositivosInteligentes mediador) {
		this.mediador = mediador;
	}
}
