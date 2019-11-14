package proyectoDomotica;

public class ActuadorAspersores extends Actuador{


	public ActuadorAspersores(MediadorDispositivosInteligentes mediador) {
		super(mediador);
		// TODO Auto-generated constructor stub
	}

	public void accion() {		
		if(activo == true) {
			System.out.println("Aspersor tira agua");
			
		}else {
			System.out.println("Aspersor apagado");
		}
	}

}
