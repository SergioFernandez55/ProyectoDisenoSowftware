package proyectoDomotica;

public abstract class Sensor implements DispositivoInteligente{
	MediadorDispositivosInteligentes mediador;
	boolean activo;

	public Sensor(MediadorDispositivosInteligentes mediador) {
		this.mediador = mediador;
	}
	
	public boolean activaDispositivo() {
		activo = true;
		return mediador.llamarComportamiento(this);
	}
	
	void setMediador(MediadorDispositivosInteligentes mediador) {
		this.mediador = mediador;
	}
	

}