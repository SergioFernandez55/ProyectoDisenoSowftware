package proyectoDomotica;

public abstract class Actuador implements DispositivoInteligente{

	MediadorDispositivosInteligentes mediador;
	boolean activo;

	public Actuador(MediadorDispositivosInteligentes mediador) {
		this.mediador = mediador;
		activo = false;
	}
	
	public final boolean activaDispositivo() {
		activo = true;
		accion();
		return mediador.llamarComportamiento(this);
	}
	
	public boolean desactivaDispositivo() {
		activo = false;
		accion();
		return mediador.llamarComportamiento(this);
	}
	
	abstract void accion();

	void setMediador(MediadorDispositivosInteligentes mediador) {
		this.mediador = mediador;
	}
	
	public boolean estaActivo()
	{
		return activo;
	}
}
