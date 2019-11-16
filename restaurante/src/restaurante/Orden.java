package restaurante;

import java.util.HashMap;
import java.util.Map;

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
			buffer.append("\tDescripcion: " + linea.getDescripcion() + " | Cantidad: " + linea.getCantidad()
					+ " | Precio: " + linea.getPrecio() + "\n");
		}
		return buffer.toString();
	}

	private Orden(HashMap<Producto, LineaCompra> orden){
		this.orden = orden;
	}
	
	public Orden clonar() {
		
		HashMap<Producto, LineaCompra> copia = new HashMap<>(this.orden.size());
		
		for (Map.Entry<Producto, LineaCompra> entrada : this.orden.entrySet()) {
			LineaCompra lineaOriginal = entrada.getValue();
			LineaCompra copiaLinea = new LineaCompra(entrada.getKey());
			copiaLinea.setCantidad(lineaOriginal.getCantidad());
			copiaLinea.setDescripcion(lineaOriginal.getDescripcion());
			copiaLinea.setPrecio(lineaOriginal.getPrecio());
			copia.put(entrada.getKey(), copiaLinea);
		}
		
		return new Orden(copia);
	}	
}
