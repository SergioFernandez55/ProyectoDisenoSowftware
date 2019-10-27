package proyectoDomotica;
import java.util.ArrayList;


public class MediadorDispositivosInteligentes {

	ActuadorLampara lampara = new ActuadorLampara();
	ActuadorAireAcondicionado aireAcondicionado = new ActuadorAireAcondicionado();
	ActuadorAspersores aspersores = new ActuadorAspersores();
	
	public boolean ActivaLampara() {
		return lampara.activa();
	}

	public boolean ActivaAire() {
		return aireAcondicionado.activa();
	}
	
	public boolean ActivaAspersor() {
		return aspersores.activa();
	}

	public boolean activaActuador(Actuador actuador) {
		return actuador.activa();
	}
}
