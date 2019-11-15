package restaurante;

public class ConQueso implements Sandwich {

	private Sandwich sandwich;
	private Ingrediente adicional;

	public ConQueso(Sandwich sandwich) {
		this.sandwich = sandwich;
		this.adicional = new Queso();
		this.sandwich.setPrecio(this.sandwich.getPrecio() + this.adicional.getPrecio());
		this.sandwich.addIngredienteAdicional(this.adicional);
	}

	@Override
	public String getDescripcion() {
		return this.sandwich.getDescripcion() + this.adicional.getDescripcion();
	}
	
	@Override
	public void addIngredienteAdicional(Ingrediente ingrediente) {
		this.sandwich.addIngredienteAdicional(ingrediente);
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