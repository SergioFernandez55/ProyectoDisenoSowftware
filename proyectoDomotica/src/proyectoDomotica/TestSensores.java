package proyectoDomotica;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestSensores {

	@Test
	public void test() {

		MediadorDispositivosInteligentes mediador = new MediadorDispositivosInteligentes();
		
		ArrayList<Sensor> sensores = new ArrayList();
		ArrayList<Actuador> actuadores = new ArrayList();
		ArrayList<Comportamiento> comportamientos = new ArrayList();
		
		
		/*Cargamos lista actuadores*/
		/*actuadores.add(new ActuadorLampara(mediador));
		actuadores.add(new ActuadorAireAcondicionado(mediador));
		actuadores.add(new ActuadorAspersores(mediador));*/
		
		mediador.getDispositivos().add(new ActuadorLampara(mediador));
		mediador.getDispositivos().add(new ActuadorAireAcondicionado(mediador));
		mediador.getDispositivos().add(new ActuadorAspersores(mediador));
		
		
		/*Cargamos lista Sensores*/
		/*sensores.add(new SensorMovimiento(mediador));
		sensores.add(new SensorHumo(mediador));
		sensores.add(new SensorTemperatura(mediador));*/
		
		mediador.getDispositivos().add(new SensorMovimiento(mediador));
		mediador.getDispositivos().add(new SensorHumo(mediador));
		mediador.getDispositivos().add(new SensorTemperatura(mediador));

		mediador.getComportamientos().add(new Comportamiento(sensores.get(0), actuadores.get(0), true));
		mediador.getComportamientos().add(new Comportamiento(actuadores.get(0), actuadores.get(2),true));
		mediador.comportamientos = comportamientos;

		sensores.get(0).activaDispositivo();
		assert(actuadores.get(2).activo == true);
	}
}
