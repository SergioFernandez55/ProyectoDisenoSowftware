package proyectoDomotica;

public class SensorTemperatura extends Sensor{

	public SensorTemperatura(MediadorDispositivosInteligentes mediador) {
		super(mediador);
		// TODO Auto-generated constructor stub
	}
	
	public void resultado() {
		System.out.println("Se detecta temperatura alta");
	}
	/*Aqui va la lógica del sensor en el método activa*/
}
