package restaurante;

public class ConQueso implements Sandwich {

	private Sandwich sandwich;

	public ConQueso(Sandwich sandwich) {
		this.sandwich = sandwich;
	}

	@Override
	public String descripcion() {
		return this.sandwich.descripcion() + " con queso";
	}

	@Override
	public double precio() {
		return this.sandwich.precio() + .75;
	}
}