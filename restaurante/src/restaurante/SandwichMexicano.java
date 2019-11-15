package restaurante;

public class SandwichMexicano implements Sandwich {

	@Override
	public String getDescripcion() {
		return "Pan: Torta Carne: Carnitas";
	}
	
	@Override
	public double getPrecio(){
		return 5.0;
	}
}
