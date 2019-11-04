package proyectoDomotica;

public class ActuadorAireAcondicionado extends Actuador{
	
	
	public ActuadorAireAcondicionado(MediadorDispositivosInteligentes mediador) {
		super(mediador);
		// TODO Auto-generated constructor stub
	}

	public void accion() {
		System.out.println("Enfria");		
	}
	
}
