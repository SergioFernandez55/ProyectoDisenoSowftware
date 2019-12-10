package proyectoDomotica;

public class SensorTemperatura extends Sensor{

	public SensorTemperatura(MediadorDispositivosInteligentes mediador) {
		super(mediador);
		// TODO Auto-generated constructor stub
	}
	
	public void resultado() {
		System.out.println("Se detecta temperatura alta");
	}
	
	public void reaccionarTemperatura(double temperatura) {
		if(temperatura > 45) {
			this.activo = true;
		}
		else
			this.activo = false;
	}
	/*Aqui va la lógica del sensor en el método activa*/
}
