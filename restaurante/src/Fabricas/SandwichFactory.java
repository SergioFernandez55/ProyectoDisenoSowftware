package Fabricas;

import Productos.Producto;

public abstract class SandwichFactory {
	
	public Producto crea() {
		return creaSandwich();
	}
	
	protected abstract Producto creaSandwich();
}
