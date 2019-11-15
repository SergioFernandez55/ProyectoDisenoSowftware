package restaurante;

public class SandwichItaliano implements Sandwich{

	@Override
	public String descripcion() {
		return "Sandwich Italiano";
	}

	@Override
	public double precio() {
		return 6;
	}
}
