package restaurante;

public class ConTomate implements Sandwich {

	private Sandwich sandwich;
	
	public ConTomate(Sandwich sandwich) {
		this.sandwich = sandwich;
	}

	@Override
	public String descripcion() {
		return this.sandwich.descripcion() + " con tomate";
	}

	@Override
	public double precio() {
		return this.sandwich.precio() + .5;
	}

}
