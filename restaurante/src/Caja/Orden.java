package Caja;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Productos.Producto;

public class Orden {

	private HashMap<String, LineaPedido> orden = new HashMap<>();

	public Orden() {
	}

	public void addProducto(Producto producto) {

		if (!producto.esNulo()) {

			if (this.elProductoEstaEnLaOrden(producto)) {

				this.incrementarProductosContados(producto);
			} else {

				this.addProductoAOrden(producto);
			}
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
	
	public void borrar() {
		this.orden.clear();
	}
	
	// Constructor parametrizado. Utilizado en el m�todo clonar.
	private Orden(HashMap<String, LineaPedido> orden) {
		this.orden = orden;
	}

	public Orden clonar() {

		HashMap<String, LineaPedido> copia = new HashMap<>(this.orden.size());

		for (Map.Entry<String, LineaPedido> entrada : this.orden.entrySet()) {

			LineaPedido lineaOriginal = entrada.getValue();
			LineaPedido copiaLinea = new LineaPedido(lineaOriginal.getProducto());

			copiaLinea.setCantidad(lineaOriginal.getCantidad());
			copiaLinea.setDescripcion(lineaOriginal.getDescripcion());
			copiaLinea.setPrecio(lineaOriginal.getPrecio());

			copia.put(entrada.getKey(), copiaLinea);
		}

		return new Orden(copia);
	}

	// M�todos auxiliares privados.

	private void incrementarProductosContados(Producto producto) {

		LineaPedido linea = this.orden.get(producto.getDescripcion());
		linea.incrementa();
		this.orden.put(producto.getDescripcion(), linea);
	}

	private boolean elProductoEstaEnLaOrden(Producto producto) {

		if (this.orden.containsKey(producto.getDescripcion())) {
			return true;
		}
		return false;
	}

	private void addProductoAOrden(Producto producto) {
		this.orden.put(producto.getDescripcion(), new LineaPedido(producto));
	}

	// Este m�todo es utilizado en pruebas y debe ser eliminado.
	public HashMap<String, LineaPedido> getOrden() {
		return orden;
	}

	// Este m�todo es utilizado en pruebas y debe ser eliminado.
	public LineaPedido getLineaPedido(String key) {
		return this.orden.get(key);
	}

	// Este m�todo es utilizado en pruebas y debe ser eliminado.
	public Set<String> getKeys() {
		return this.orden.keySet();
	}
	
	// Este m�todo es utilizado en pruebas y debe ser eliminado.
	public boolean estaVacia(){
		return this.orden.isEmpty();
	}
}
