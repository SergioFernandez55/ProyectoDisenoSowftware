package restaurante;

public class ConTomate implements Producto {

	private Producto sandwich;
	
	public ConTomate(Producto sandwich) {
		this.sandwich = sandwich;
	}

	@Override
	public String getDescripcion() {
		return this.sandwich.getDescripcion() + " Adicional: Tomate";
	}
	
	@Override
	public double getPrecio() {
		return this.sandwich.getPrecio() + 0.5;
	}

}