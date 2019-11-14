package proyectoDomotica;

public class SensorMovimiento extends Sensor{

	public SensorMovimiento(MediadorDispositivosInteligentes mediador) {
		super(mediador);
		// TODO Auto-generated constructor stub
	}
	
	public void resultado() {
		System.out.println("Se detecto movimiento");
	}
/*Aqui va la lógica del sensor en el método activa*/
}
 