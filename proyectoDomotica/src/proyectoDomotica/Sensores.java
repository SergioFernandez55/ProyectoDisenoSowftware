package proyectoDomotica;

public abstract class Sensores{
	MediadorDispositivosInteligentes mediador;
	
	public boolean activa(Actuador actuador) {
		return mediador.activaActuador(actuador);
	}
	
	void setMediador(MediadorDispositivosInteligentes mediador) {
		this.mediador = mediador;
	}

}