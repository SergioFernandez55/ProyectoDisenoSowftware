package restaurante;

import java.util.HashMap;
import java.util.Map;

public class Caja {
	
	private Orden orden = new Orden();

	protected class Memento {

		private final Orden estado;

		private Memento(Orden estado) {
			this.estado = estado.clonar();
		}
	}
	
	public Memento creaEstado() {
		return new Memento(this.orden);
	}
	
	public void restauraEstado(Memento memento) {
		this.orden = memento.estado;
	}

	public void addProducto(Producto producto) {
		this.orden.addProducto(producto);
	}
	
	public void imprimirFactura() {
		Factura factura = new Factura(this.orden);
		System.out.println(factura.imprimir() + "\n\n");
	}
}
