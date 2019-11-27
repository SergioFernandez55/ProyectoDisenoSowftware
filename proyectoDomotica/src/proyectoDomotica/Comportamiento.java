package proyectoDomotica;

public class Comportamiento {

	DispositivoInteligente emisor;
	Actuador receptor;
	MediadorDispositivosInteligentes mediador;
	boolean activar;
	
	public Comportamiento (	MediadorDispositivosInteligentes mediador){
		this.mediador = mediador;
	}
	
	public void setComportamiento(DispositivoInteligente emisor, Actuador receptor, boolean activo){
		this.emisor = emisor;
		this.receptor = receptor;
		this.activar = activo;
	}
	
	public boolean llamarComportamiento(DispositivoInteligente emisor, MediadorDispositivosInteligentes mediador) {
		if(this.emisor != null && this.receptor != null) {
			if(this.activar) {
			return receptor.activaDispositivo();
			}
			else {
			return receptor.desactivaDispositivo();
			}
		}
		return false;
	}
	
	public DispositivoInteligente getEmisor() {
		return this.emisor;
	}
	
	//Quitar comportamiento
}
