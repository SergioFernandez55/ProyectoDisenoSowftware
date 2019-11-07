package proyectoDomotica;

import java.util.ArrayList;

public class DomoticaFacade {
	MediadorDispositivosInteligentes mediador;
	
	public void agregarSensor(ArrayList<Sensor> sensores){
		for (Sensor sensor:sensores) {
			mediador.agregarDispositivo(sensor);
			System.out.println("sensorAgregado");
		}
	}
	
	public void agregarActuador(ArrayList<Actuador> actuadores) {
		for(DispositivoInteligente actuador:actuadores) {
			mediador.agregarDispositivo(actuador);
			System.out.println("actuadorAgregado");		
		}
	}
	
	public void agregarComportamiento(ArrayList<Comportamiento> comportamientos) {
		for(Comportamiento comportamiento:comportamientos) {
			mediador.agregaComportamiento(comportamiento.emisor, comportamiento.receptor, comportamiento.activar);
			System.out.println("comportamientoAgregado");	
		}
	}
	
	public void setMediador(MediadorDispositivosInteligentes mediador) {
		this.mediador = mediador;
	}
}
