package restaurante;

public class CajaRestaurante implements Caja {
	
	private Orden orden = new Orden();
	private Memento respaldo = null;
	private Producto producto = null;

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
	
	@Override
	public void crearNuevaOrden() {
		this.orden.borrar();
		this.producto = null;
	}

	@Override
	public void addNuevaLineaDePedido() {
		
		this.respaldo = this.creaEstado();
		this.orden.addProducto(this.producto);
		this.producto = null;
	}

	@Override
	public void cancelarUltimaLineaDePedido() {
		this.restauraEstado(respaldo);
	}

	@Override
	public void addSandwichMexicano() {
		this.producto = new SandwichMexicano();
	}

	@Override
	public void addSandwichItaliano() {
		this.producto = new SandwichItaliano();
	}

	@Override
	public void addQuesoExtra() {
		this.producto = new ConQueso(this.producto);
	}

	@Override
	public void addTomateExtra() {
		this.producto = new ConTomate(this.producto);
	}

	@Override
	public void finalizarOrden() {
		// TODO Auto-generated method stub
	}

	@Override
	public void generarInforme() {
		// TODO Auto-generated method stub
	}

	@Override
	public Orden getOrden() {
		return this.orden;
	}
}
