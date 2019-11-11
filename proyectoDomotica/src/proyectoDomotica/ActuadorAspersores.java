package proyectoDomotica;

public class ActuadorAspersores extends Actuador{


	public ActuadorAspersores(MediadorDispositivosInteligentes mediador) {
		super(mediador);
		// TODO Auto-generated constructor stub
	}

	public void accion() {
		System.out.println("Aspersor tira agua");	
	}

}
