package proyectoDomotica;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestSensores {
	MediadorDispositivosInteligentes mediador;
	Actuador lampara;
	Actuador aire;
	Actuador aspersor;
	Sensor movimiento;
	Sensor temperatura;
	Sensor humo;
	
	@Before
	public void init() {
		this.mediador = new MediadorDispositivosInteligentes();
		
		this.lampara  = new ActuadorLampara(mediador);
		this.aire = new ActuadorAireAcondicionado(mediador);
		this.aspersor = new ActuadorAspersores(mediador);
		
		this.movimiento = new SensorMovimiento(mediador);
		this.temperatura = new SensorTemperatura(mediador);
		this.humo = new SensorHumo(mediador);
	}
	
	@Test
	public void testBefore(){
		mediador.agregaComportamiento(temperatura, aire, true);
		
		assertEquals(movimiento.estaActivo() ,false);
		assertEquals(aire.estaActivo() ,false);
	}
	
	@Test
	public void testActivarActuador() {
		mediador.agregaComportamiento(movimiento, lampara, true);
		
		movimiento.activaDispositivo();
		assertEquals(lampara.estaActivo(),true);
	}
	
	@Test
	public void testAccionesEnCadena(){
		
		mediador.agregaComportamiento(temperatura, aire, true);
		mediador.agregaComportamiento(aire, aspersor, true);
		mediador.agregaComportamiento(aire, lampara, false);
		
		temperatura.activaDispositivo();
		assertEquals(aspersor.estaActivo(),true);
		assertEquals(lampara.estaActivo(),false);
	}
	
	@Test
	public void testDesactivarDispositivos() {
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
