package proyectoDomotica;

public abstract class Sensor implements DispositivoInteligente{
	MediadorDispositivosInteligentes mediador;
	boolean activo;

	public Sensor(MediadorDispositivosInteligentes mediador) {
		this.mediador = mediador;
		activo = false;
	}
	
	public boolean activaDispositivo() {
		activo = true;
		resultado();
		return mediador.llamarComportamiento(this);
	}
	
	void setMediador(MediadorDispositivosInteligentes mediador) {
		this.mediador = mediador;
	}
	
	public boolean desactivaDispositivo() {
		activo = false;
		return activo;
	}
	
	public boolean estaActivo() {
		return activo;
	}

	abstract void resultado();
}