package restaurante;

public class SandwichItaliano implements Sandwich{

	@Override
	public String getDescripcion() {
		return "Pan: Ciabatta Carne: Salami";
	}

	@Override
	public double getPrecio(){
		return 6.0;
	}
}
