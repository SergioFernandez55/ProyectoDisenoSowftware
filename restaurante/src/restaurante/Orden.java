package restaurante;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import restaurante.productos.Producto;

public class Orden {

	private HashMap<String, LineaPedido> orden = new HashMap<>();

	// Este método es utilizado en pruebas y debe ser eliminado.
	public HashMap<String, LineaPedido> getOrden() {
		return orden;
	}

	// Este método es utilizado en pruebas y debe ser eliminado.
	public LineaPedido getLineaPedido(String key) {
		return this.orden.get(key);
	}
	
	public void borrar(){
		this.orden.clear();
	}

	public Set<String> getKeys(){
		return this.orden.keySet();
	}
	
	public void addProducto(Producto producto) {
		
		if (!producto.esNulo()){
			if (this.orden.containsKey(producto.getDescripcion())) {
				LineaPedido linea = this.orden.get(producto.getDescripcion());
				linea.incrementa();
				this.orden.put(producto.getDescripcion(), linea);
			} else {
				this.orden.put(producto.getDescripcion(), new LineaPedido(producto));
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

	private Orden(HashMap<String, LineaPedido> orden){
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
}
