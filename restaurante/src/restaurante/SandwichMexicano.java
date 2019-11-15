package restaurante;

public class SandwichMexicano implements Producto {

	@Override
	public String getDescripcion() {
		return "Pan: Torta Carne: Carnitas";
	}
	
	@Override
	public double getPrecio(){
		return 5.0;
	}
}
