package restaurante;

public class SandwichMexicano implements Producto {

	@Override
	public String getDescripcion() {
		return "Mexicano Basico";
	}
	
	@Override
	public double getPrecio(){
		return 5.0;
	}
}
