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

	@Override
	public void addIngredienteAdicional(Ingrediente ingrediente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPrecio(double precio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}

}