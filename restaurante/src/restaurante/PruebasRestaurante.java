package restaurante;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import restaurante.CajaRestaurante.Memento;

public class PruebasRestaurante {

	private Caja caja;
	private Facturador facturador;

	@Before
	public void init() {
		this.caja = new CajaRestaurante();
		this.facturador = new Facturador();
	}

	@Test
	public void validarCalculoDelPrecio() {
		
		this.caja.crearNuevaOrden();

		this.caja.addNuevaLineaDePedido();
		this.caja.addSandwichItaliano();
		this.caja.addQuesoExtra();
		this.caja.addQuesoExtra();
		this.caja.addQuesoExtra();
		this.caja.addTomateExtra();

		this.caja.addNuevaLineaDePedido();
		this.caja.addSandwichItaliano();
		this.caja.addQuesoExtra();
		this.caja.addQuesoExtra();
		this.caja.addQuesoExtra();
		this.caja.addTomateExtra();

		this.caja.addNuevaLineaDePedido();
		this.caja.addSandwichMexicano();
		this.caja.addQuesoExtra();
		this.caja.addTomateExtra();

		this.caja.addNuevaLineaDePedido();
		this.caja.addSandwichItaliano();
		this.caja.addTomateExtra();

		this.caja.addNuevaLineaDePedido();
		this.caja.addSandwichMexicano();

		this.caja.finalizarOrden();
		
		facturador.imprimir(caja.getOrden());
		
		assertTrue(this.caja.getOrden().getPrecioTotal() == 35.25);
	}
}
