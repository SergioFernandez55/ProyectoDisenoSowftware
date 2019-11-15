package restaurante;

public abstract class SandwichFactory {
	
	public Sandwich crea() {
		return creaSandwitch();
	}
	
	protected abstract Sandwich creaSandwitch();
}
