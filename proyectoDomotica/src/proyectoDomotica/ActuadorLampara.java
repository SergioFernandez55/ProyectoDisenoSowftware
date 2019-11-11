package proyectoDomotica;

public class ActuadorLampara extends Actuador{

	public ActuadorLampara(MediadorDispositivosInteligentes mediador) {
		super(mediador);
		// TODO Auto-generated constructor stub
	}

	public void accion() {
		System.out.println("Lampara encendida");
	}

}