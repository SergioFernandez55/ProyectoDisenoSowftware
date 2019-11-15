package restaurante;

public class ConTomate implements Sandwich {

	private Sandwich sandwich;
	
	public ConTomate(Sandwich sandwich) {
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