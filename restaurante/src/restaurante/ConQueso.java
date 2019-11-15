package restaurante;

public class ConQueso implements Sandwich {

	private Sandwich sandwich;

	public ConQueso(Sandwich sandwich) {
		this.sandwich = sandwich;
	}

	@Override
	public String getDescripcion() {
		return this.sandwich.getDescripcion() + " Adicional: Queso";
	}
	
	@Override
	public double getPrecio() {
		return this.sandwich.getPrecio() + 0.75;
	}

}