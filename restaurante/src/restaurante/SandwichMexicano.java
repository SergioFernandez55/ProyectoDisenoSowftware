package restaurante;

public class SandwichMexicano implements Sandwich{

	@Override
	public String descripcion() {
		return "Sandwich Mexicano";
	}

	@Override
	public double precio() {
		return 5;
	}
}
