package proyectoDomotica;

public class SensorHumo extends Sensor{

	public SensorHumo(MediadorDispositivosInteligentes mediador) {
		super(mediador);
		// TODO Auto-generated constructor stub
	}
	
	public void resultado() {
		System.out.println("Se detecto humo");
	}
	/*Aqui va la logica del sensor en el metodo activa*/
	
}
