package proyectoDomotica;

public class ActuadorAireAcondicionado extends Actuador{
	
	
	public ActuadorAireAcondicionado(MediadorDispositivosInteligentes mediador) {
		super(mediador);
		// TODO Auto-generated constructor stub
	}

	public void accion() {
		if(activo == true) {
			System.out.println("Aire acondicionado enfria");
			
		}else {
			System.out.println("Aire acondicionado apagado");
		}
	}
}
