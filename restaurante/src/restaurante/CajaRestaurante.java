package restaurante;

public class CajaRestaurante implements Caja {
	
	SandwichFactory factoryMexicano = new SandwichMexicanoFactory();
	SandwichFactory factoryItaliano = new SandwichItalianoFactory();
	
	private Orden orden = new Orden();
	private Memento respaldo = null;
	private Producto producto = null;

	protected class Memento {

		private final Orden estado;

		private Memento(Orden estado) {
			this.estado = estado.clonar();
		}
	}
	
	private Memento creaEstado() {
		return new Memento(this.orden);
	}
	
	private void restauraEstado(Memento memento) {
		this.orden = memento.estado;
	}
	
	@Override
	public void crearNuevaOrden() {
		this.orden.borrar();
		this.producto = null;
		this.respaldo = null;
	}

	@Override
	public void addNuevaLineaDePedido() {
		
		//this.respaldo = this.creaEstado();
		this.producto = null;
	}

	@Override
	public void cancelarUltimaLineaDePedido() {
		this.restauraEstado(respaldo);
	}

	@Override
	public void addSandwichMexicano() {
		this.producto = factoryMexicano.crea();
	}

	@Override
	public void addSandwichItaliano() {
		this.producto = factoryItaliano.crea();
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
		this.orden.addProducto(this.producto);
	}
	
	@Override
	public Orden getOrden() {
		return this.orden;
	}

	@Override
	public void confirmarLineaDePedido() {
		this.respaldo = this.creaEstado();
		this.orden.addProducto(this.producto);
	}

	@Override
	public Orden getRespaldoDeOrden() {
		return this.respaldo.estado;
	}
	
}
