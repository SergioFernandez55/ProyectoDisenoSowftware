package restaurante;

public class SandwichItaliano implements Producto {

	@Override
	public String getDescripcion() {
		return "Italiano Basico";
	}

	@Override
	public double getPrecio(){
		return 6.0;
	}
}
