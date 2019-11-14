package proyectoDomotica;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestSensores {

	@Test
	public void test() {
		//Test sensor-actuador actuador-actuador 
		/*MediadorDispositivosInteligentes mediador = new MediadorDispositivosInteligentes();
		
		Actuador lampara  = new ActuadorLampara(mediador);
		Actuador aire = new ActuadorAireAcondicionado(mediador);
		Actuador aspersor = new ActuadorAspersores(mediador);
		
		Sensor movimiento = new SensorMovimiento(mediador);
		Sensor temperatura = new SensorTemperatura(mediador);
		Sensor humo = new SensorHumo(mediador);
		
		mediador.agregaComportamiento(movimiento, lampara, true);
		mediador.agregaComportamiento(movimiento, aspersor, true);
		mediador.agregaComportamiento(temperatura, aire, true);
		mediador.agregaComportamiento(humo, aspersor, true);
		mediador.agregaComportamiento(humo, aire, false);
		mediador.agregaComportamiento(lampara, aire, true);
		

		mediador.llamarComportamiento(movimiento);
		mediador.llamarComportamiento(humo);
		assertEquals(aire.estaActivo() ,false);
		*/
		//Test
		
		
		MediadorDispositivosInteligentes mediador = new MediadorDispositivosInteligentes();
		
		Actuador lampara  = new ActuadorLampara(mediador);
		Actuador aire = new ActuadorAireAcondicionado(mediador);
		Actuador aspersor = new ActuadorAspersores(mediador);
		
		Sensor movimiento = new SensorMovimiento(mediador);
		Sensor temperatura = new SensorTemperatura(mediador);
		Sensor humo = new SensorHumo(mediador);
		
		
		
		mediador.agregaComportamiento(temperatura, aire, true);
		
		//Test Before de Sensor y Actuador
		assertEquals(movimiento.estaActivo() ,false);
		assertEquals(aire.estaActivo() ,false);

		//Test Sensor activa actuador
		
		mediador.agregaComportamiento(movimiento, lampara, true);
		
		movimiento.activaDispositivo();
		assertEquals(lampara.estaActivo(),true);
		
		//Test acciones en cadena
		
		mediador.agregaComportamiento(temperatura, aire, true);
		mediador.agregaComportamiento(aire, aspersor, true);
		mediador.agregaComportamiento(aire, lampara, false);
		
		temperatura.activaDispositivo();
		assertEquals(aspersor.estaActivo(),true);
		assertEquals(lampara.estaActivo(),false);
		
		
		//Test Desactivar dispositivos
		lampara.desactivaDispositivo();
		aire.desactivaDispositivo();
		aspersor.desactivaDispositivo();
		movimiento.desactivaDispositivo();
		humo.desactivaDispositivo();
		temperatura.desactivaDispositivo();
		
		assertEquals(aire.estaActivo(),false);
		assertEquals(movimiento.estaActivo(),false);
	}
}
