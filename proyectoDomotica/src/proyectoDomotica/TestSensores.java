package proyectoDomotica;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestSensores {

	@Test
	public void test() {
		
		MediadorDispositivosInteligentes mediador = new MediadorDispositivosInteligentes();
		
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
	}
}
