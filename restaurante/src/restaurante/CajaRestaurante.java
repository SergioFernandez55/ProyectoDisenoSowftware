package restaurante;

import java.util.HashMap;
import java.util.Map;

public class CajaRestaurante implements Caja {
	
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

	@Override
	public void crearNuevaOrden() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNuevaLineaDePedido() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelarUltimaLineaDePedido() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSandwichMexicano() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSandwichItalian() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addQuesoExtra() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTomateExtra() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizarOrden() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generarInforme() {
		// TODO Auto-generated method stub
		
	}
}
