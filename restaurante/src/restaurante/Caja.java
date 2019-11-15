package restaurante;

import java.util.HashMap;
import java.util.Map;

public class Caja {

	private HashMap<Producto, LineaCompra> orden = new HashMap<>();

	protected class Memento {

		private final HashMap<Producto, LineaCompra> estado;

		private Memento(HashMap<Producto, LineaCompra> estado) {
			
			this.estado = new HashMap<>(estado.size());
			for(Map.Entry<Producto, LineaCompra> entrada: estado.entrySet()) {
				LineaCompra lineaOriginal = entrada.getValue();
				LineaCompra copiaLinea = new LineaCompra(entrada.getKey());
				copiaLinea.setCantidad(lineaOriginal.getCantidad());
				copiaLinea.setDescripcion(lineaOriginal.getDescripcion());
				copiaLinea.setPrecio(lineaOriginal.getPrecio());
				this.estado.put(entrada.getKey(), copiaLinea);
			}
		}
	}
	
	public Memento creaEstado() {
		return new Memento(this.orden);
	}
	
	public void restauraEstado(Memento memento) {
		this.orden = memento.estado;
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
	
	public void impirmirOrden() {
		
		for(LineaCompra linea: this.orden.values()) {
			System.out.println("Descripcion: " + linea.getDescripcion() + " Cantidad: " + linea.getCantidad() + 
					"\n\t Precio: " + linea.getPrecio() + "\n");
		}
		System.out.println("------------------------------------------------\n");
		System.out.println("Total Orden: " + this.obtenerPrecioTotalOrden()  + "\n");
		System.out.println("------------------------------------------------\n");
	}
	
	public double obtenerPrecioTotalOrden() {
		
		double precioTotalOrden = 0.0;
		
		for (LineaCompra linea: this.orden.values()) {
			precioTotalOrden += linea.getPrecio();
		}
		
		return precioTotalOrden;
	}

	public void recibirOrden() {
		// Pendiente implementar.
	}

	public void despacharOdenAlChef() {
		// Pendiente implementar.
	}

	public void cobrar() {
		// Pendiente implementar.
	}

	public void generarFactura() {
		// Fecha/Hora de la venta.
		// Informaci�n del producto.
		// Costo del producto.
	}
}
