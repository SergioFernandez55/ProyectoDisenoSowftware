package Productos;

public class SandwichMexicano implements Producto {

	@Override
	public String getDescripcion() {
		return "Mexicano Basico";
	}
	
	@Override
	public double getPrecio(){
		return 5.0;
	}

	@Override
	public boolean esNulo() {
		return false;
	}
}
