package restaurante;

public class LineaCompra {
	
	private Producto producto;
	private int cantidad;
	private double precio;
	private String descripcion;
	
	public LineaCompra(Producto producto) {
		this.producto = producto;
		this.cantidad = 1;
		this.precio = this.producto.getPrecio();
		this.descripcion = this.producto.getDescripcion();
	}
	
	public void incrementa(Producto producto) {
		++this.cantidad;
		this.precio += producto.getPrecio();
	}

}
