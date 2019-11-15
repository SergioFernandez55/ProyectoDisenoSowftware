package restaurante;

import java.util.HashMap;

public class Caja {
	
	private HashMap< Producto, LineaCompra > orden = new HashMap<>();
	
	public class Memento {
	}
	
	public void addProducto(Producto producto) {
		
		if(this.orden.containsKey(producto)) {
			LineaCompra linea = this.orden.get(producto);
			linea.incrementa(producto);
			this.orden.put(producto, linea);
		}
		else {
			this.orden.put(producto, new LineaCompra(producto));
		}
	}
	
	public void recibirOrden(){
		// Pendiente implementar.
	}
	
	public void despacharOdenAlChef(){
		// Pendiente implementar.
	}
	
	public void cobrar(){
		// Pendiente implementar.
	}
	
	public void generarFactura(){
		// Fecha/Hora de la venta.
		// Informaci�n del producto.
		// Costo del producto.
	}
}
