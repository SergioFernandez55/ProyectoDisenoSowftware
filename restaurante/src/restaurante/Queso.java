package restaurante;

public class Queso implements Ingrediente {
	
	@Override
	public double getPrecio() {
		return 0.75;
	}

	@Override
	public String getDescripcion() {
		return "Queso";
	}
}
