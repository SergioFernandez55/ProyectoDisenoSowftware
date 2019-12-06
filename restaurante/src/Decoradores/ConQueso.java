package Decoradores;

import Productos.Producto;

public class ConQueso implements Producto {

	private Producto sandwich;

	public ConQueso(Producto sandwich) {
		this.sandwich = sandwich;
	}

	@Override
	public String getDescripcion() {
		return this.sandwich.getDescripcion() + " + Queso Adicional";
	}
	
	@Override
	public double getPrecio() {
		return this.sandwich.getPrecio() + 0.75;
	}

	@Override
	public boolean esNulo() {
		return false;
	}

}