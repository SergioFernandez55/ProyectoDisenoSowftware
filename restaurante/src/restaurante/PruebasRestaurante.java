package restaurante;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class PruebasRestaurante {

	private Caja caja;
	private Facturador facturador;

	@Before
	public void init() {
		this.caja = new CajaRestaurante();
		this.facturador = new Facturador();
		this.caja.crearNuevaOrden();
	}

	@Test
	public void validarCalculoDelPrecio() {

		this.caja.addNuevaLineaDePedido();
		this.caja.addSandwichItaliano();
		this.caja.addQuesoExtra();
		this.caja.addQuesoExtra();
		this.caja.addQuesoExtra();
		this.caja.addTomateExtra();
		this.caja.confirmarLineaDePedido();

		this.caja.addNuevaLineaDePedido();
		this.caja.addSandwichItaliano();
		this.caja.addQuesoExtra();
		this.caja.addQuesoExtra();
		this.caja.addQuesoExtra();
		this.caja.addTomateExtra();
		this.caja.confirmarLineaDePedido();

		this.caja.addNuevaLineaDePedido();
		this.caja.addSandwichMexicano();
		this.caja.addQuesoExtra();
		this.caja.addTomateExtra();
		this.caja.confirmarLineaDePedido();

		this.caja.addNuevaLineaDePedido();
		this.caja.addSandwichItaliano();
		this.caja.addTomateExtra();
		this.caja.confirmarLineaDePedido();

		this.caja.addNuevaLineaDePedido();
		this.caja.addSandwichMexicano();
		this.caja.finalizarOrden();

		facturador.imprimir(caja.getOrden());

		assertTrue(this.caja.getOrden().getPrecioTotal() == 35.25);
	}

	@Test
	public void validarCancelarUltimaLineaDePedido() {

		this.caja.addNuevaLineaDePedido();
		this.caja.addSandwichItaliano();
		this.caja.addQuesoExtra();
		this.caja.addQuesoExtra();
		this.caja.addTomateExtra();
		this.caja.confirmarLineaDePedido();

		this.caja.addNuevaLineaDePedido();
		this.caja.addSandwichMexicano();
		this.caja.addQuesoExtra();
		this.caja.confirmarLineaDePedido();

		facturador.imprimir(caja.getOrden());

		this.caja.cancelarUltimaLineaDePedido();
		
		facturador.imprimir(caja.getOrden());

		Set<String> keys = caja.getOrden().getKeys();
		assertEquals(1, keys.size());
		assertTrue("Italiano Basico + Queso Adicional + Queso Adicional + Tomate Adicional", keys.contains("Italiano Basico + Queso Adicional + Queso Adicional + Tomate Adicional"));
	}

}
