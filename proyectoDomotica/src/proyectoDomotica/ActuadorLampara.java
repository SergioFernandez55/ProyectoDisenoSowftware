package proyectoDomotica;

public class ActuadorLampara extends Actuador{

	public ActuadorLampara(MediadorDispositivosInteligentes mediador) {
		super(mediador);
		// TODO Auto-generated constructor stub
	}

	public void accion() {		
		if(activo == true) {
			System.out.println("Lampara encendida");
			
		}else {
			System.out.println("Lampara apagada");
		}
	}

}