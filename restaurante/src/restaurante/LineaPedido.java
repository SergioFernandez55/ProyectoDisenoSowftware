package restaurante;

public class LineaPedido {
	
	private Producto producto;
	private int cantidad;
	private double precio;
	private String descripcion;
	
	public LineaPedido(Producto producto) {
		this.producto = producto;
		this.cantidad = 1;
		this.precio = this.producto.getPrecio();
		this.descripcion = this.producto.getDescripcion();
	}
	
	public void incrementa() {
		++this.cantidad;
		this.precio += this.producto.getPrecio();
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}

	public Producto getProducto() {
		return producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
