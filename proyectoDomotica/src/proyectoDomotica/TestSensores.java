package proyectoDomotica;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSensores {

	@Test
	public void test() {
		ActuadorLampara lampara = new ActuadorLampara();
		ActuadorAireAcondicionado aireAcondicionado = new ActuadorAireAcondicionado();
		ActuadorAspersores aspersores = new ActuadorAspersores();
		
		SensorMovimiento sensorMov = new SensorMovimiento();
		SensorHumo sensorHumo = new SensorHumo();
		SensorTemperatura sensorTemp = new SensorTemperatura();
		
		MediadorDispositivosInteligentes mediador = new MediadorDispositivosInteligentes();
		
		assert(sensorMov.activa());
		assert(sensorHumo.activa());
		assert(sensorTemp.activa());
	}

}
