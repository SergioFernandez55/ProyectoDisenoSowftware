package restaurante.fabricas;

import restaurante.productos.Producto;

public abstract class SandwichFactory {
	
	public Producto crea() {
		return creaSandwich();
	}
	
	protected abstract Producto creaSandwich();
}
