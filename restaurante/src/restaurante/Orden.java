package restaurante;

import java.util.HashMap;
import java.util.Map;

public class Orden {

	private HashMap<Producto, LineaPedido> orden = new HashMap<>();

	public Orden() {
	}
	
	public void borrar(){
		this.orden.clear();
	}

	public void addProducto(Producto producto) {

		if (this.orden.containsKey(producto)) {
			LineaPedido linea = this.orden.get(producto);
			linea.incrementa();
			this.orden.put(producto, linea);
		} else {
			this.orden.put(producto, new LineaPedido(producto));
		}
	}

	public double getPrecioTotal() {

		double precioTotalOrden = 0.0;

		for (LineaPedido linea : this.orden.values()) {
			precioTotalOrden += linea.getPrecio();
		}

		return precioTotalOrden;
	}

	public String getDetalle() {

		StringBuffer buffer = new StringBuffer();

		for (LineaPedido linea : this.orden.values()) {
			buffer.append("\tDescripcion: " + linea.getDescripcion() + " | Cantidad: " + linea.getCantidad()
					+ " | Precio: " + linea.getPrecio() + "\n");
		}
		return buffer.toString();
	}

	private Orden(HashMap<Producto, LineaPedido> orden){
		this.orden = orden;
	}
	
	public Orden clonar() {
		
		HashMap<Producto, LineaPedido> copia = new HashMap<>(this.orden.size());
		
		for (Map.Entry<Producto, LineaPedido> entrada : this.orden.entrySet()) {
			LineaPedido lineaOriginal = entrada.getValue();
			LineaPedido copiaLinea = new LineaPedido(entrada.getKey());
			copiaLinea.setCantidad(lineaOriginal.getCantidad());
			copiaLinea.setDescripcion(lineaOriginal.getDescripcion());
			copiaLinea.setPrecio(lineaOriginal.getPrecio());
			copia.put(entrada.getKey(), copiaLinea);
		}
		
		return new Orden(copia);
	}	
}
