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
		
		DomoticaFacade facade = new DomoticaFacade();
		facade.setMediador(mediador);
		
		Actuador lampara  = new ActuadorLampara(mediador);
		Actuador aire = new ActuadorAireAcondicionado(mediador);
		Actuador aspersor = new ActuadorAspersores(mediador);
		
		/*Cargamos lista actuadores*/
		actuadores.add(lampara);
		actuadores.add(aire);
		actuadores.add(aspersor);
		
					
		facade.agregarActuador(actuadores);
		
		mediador.getDispositivos().add(new ActuadorLampara(mediador));
		mediador.getDispositivos().add(new ActuadorAireAcondicionado(mediador));
		mediador.getDispositivos().add(new ActuadorAspersores(mediador));
		
		
		Sensor mov = new SensorMovimiento(mediador);
		
		/*Cargamos lista Sensores*/
		sensores.add(mov);
		sensores.add(new SensorHumo(mediador));
		sensores.add(new SensorTemperatura(mediador));
		facade.agregarSensor(sensores);
		
		mediador.getDispositivos().add(new SensorMovimiento(mediador));
		mediador.getDispositivos().add(new SensorHumo(mediador));
		mediador.getDispositivos().add(new SensorTemperatura(mediador));

		comportamientos.add(new Comportamiento(mov, lampara, true));
		comportamientos.add(new Comportamiento(lampara, aire,true));
		facade.agregarComportamiento(comportamientos);
		//mediador.comportamientos = comportamientos;

		//sensores.get(0).activaDispositivo();
		lampara.activaDispositivo();
		assertEquals(aire.estaActivo() ,true);
	}
}
