package restaurante;

import static org.junit.Assert.*;

import org.junit.Test;

import restaurante.CajaRestaurante.Memento;

public class PruebasRestaurante {

	@Test
	public void test() {
		
		Caja caja = new CajaRestaurante();
		Facturador facturador = new Facturador();
		
		caja.crearNuevaOrden();
		
		caja.addNuevaLineaDePedido();
		caja.addSandwichItaliano();
		caja.addQuesoExtra();
		caja.addQuesoExtra();
		caja.addQuesoExtra();
		caja.addTomateExtra();
		
		caja.addNuevaLineaDePedido();
		caja.addSandwichItaliano();
		caja.addQuesoExtra();
		caja.addQuesoExtra();
		caja.addQuesoExtra();
		caja.addTomateExtra();
		
		caja.addNuevaLineaDePedido();
		caja.addSandwichMexicano();
		caja.addQuesoExtra();
		caja.addTomateExtra();
		
		caja.addNuevaLineaDePedido();
		caja.addSandwichItaliano();
		caja.addTomateExtra();
		
		caja.addNuevaLineaDePedido();
		caja.addSandwichMexicano();
		
		caja.finalizarOrden();
		
		facturador.imprimir(caja.getOrden());
	}
}
