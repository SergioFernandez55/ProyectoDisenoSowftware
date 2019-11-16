package restaurante;

import java.util.HashMap;

public class Orden {

	private HashMap<Producto, LineaCompra> orden = new HashMap<>();

	public Orden() {
	}

	public void addProducto(Producto producto) {

		if (this.orden.containsKey(producto)) {
			LineaCompra linea = this.orden.get(producto);
			linea.incrementa();
			this.orden.put(producto, linea);
		} else {
			this.orden.put(producto, new LineaCompra(producto));
		}
	}

	public double getPrecioTotal() {

		double precioTotalOrden = 0.0;

		for (LineaCompra linea : this.orden.values()) {
			precioTotalOrden += linea.getPrecio();
		}

		return precioTotalOrden;
	}
	
	public String getDetalle() {
		
		StringBuffer buffer = new StringBuffer();

		for (LineaCompra linea : this.orden.values()) {
			buffer.append("\tDescripcion: " + linea.getDescripcion() + " | Cantidad: " + linea.getCantidad() + " | Precio: " + linea.getPrecio() + "\n");
		}
		return buffer.toString();
	}
}
