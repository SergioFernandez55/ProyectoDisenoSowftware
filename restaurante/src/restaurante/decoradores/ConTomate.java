package restaurante.decoradores;

import restaurante.productos.Producto;

public class ConTomate implements Producto {

	private Producto sandwich;
	
	public ConTomate(Producto sandwich) {
		this.sandwich = sandwich;
	}

	@Override
	public String getDescripcion() {
		return this.sandwich.getDescripcion() + " + Tomate Adicional";
	}
	
	@Override
	public double getPrecio() {
		return this.sandwich.getPrecio() + 0.5;
	}

	@Override
	public boolean esNulo() {
		return false;
	}

}