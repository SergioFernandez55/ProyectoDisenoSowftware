package restaurante;

public class Tomate implements Ingrediente {

	@Override
	public double getPrecio() {
		return 0.50;
	}

	@Override
	public String getDescripcion() {
		return "Tomate";
	}

}
