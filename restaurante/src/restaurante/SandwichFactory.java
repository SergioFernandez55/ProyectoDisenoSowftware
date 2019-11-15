package restaurante;

public abstract class SandwichFactory {
	
	public Producto crea() {
		return creaSandwitch();
	}
	
	protected abstract Producto creaSandwitch();
}
