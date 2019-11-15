package restaurante;

public class ConQueso implements Sandwich {

	private Sandwich sandwich;

	public ConQueso(Sandwich sandwich) {
		this.sandwich = sandwich;
		Queso queso = new Queso();
		this.sandwich.setPrecio(this.sandwich.getPrecio() + 0.75);
	}

	@Override
	public String descripcion() {
		return this.sandwich.descripcion() + " con queso";
	}
	
	@Override
	public void addIngredienteAdicional(Ingrediente ingrediente) {
	}

	@Override
	public void setPrecio(double precio) {
		this.sandwich.setPrecio(precio);
	}

	@Override
	public double getPrecio() {
		return this.sandwich.getPrecio();
	}

}