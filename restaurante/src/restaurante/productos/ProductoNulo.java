package restaurante.productos;

public class ProductoNulo implements Producto {

	@Override
	public String getDescripcion() {
		return "";
	}

	@Override
	public double getPrecio() {
		return 0;
	}

	@Override
	public boolean esNulo() {
		return true;
	}
}
