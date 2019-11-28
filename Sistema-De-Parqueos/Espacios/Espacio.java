
public abstract class Espacio {
	
	private boolean disponible = true;
	
	public boolean estaDisponible() {
		return disponible;
	}
	
	public void setOcupado() {
		this.disponible = false;
	}
	
	public void setDisponible() {
		this.disponible = true;
	}
}
