package Productos;

public class SandwichItaliano implements Producto {

	@Override
	public String getDescripcion() {
		return "Italiano Basico";
	}

	@Override
	public double getPrecio(){
		return 6.0;
	}

	@Override
	public boolean esNulo() {
		return false;
	}
}
