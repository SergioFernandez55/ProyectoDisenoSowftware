package restaurante;

import static org.junit.Assert.*;

import org.junit.Test;

import restaurante.CajaRestaurante.Memento;

public class PruebasRestaurante {

	@Test
	public void test() {
		
		//CajaRestaurante caja = new CajaRestaurante();
		
		//Producto italiano = new SandwichItaliano();
		//Producto mexicano = new SandwichMexicano();
		//Producto dobleQueso = new ConQueso(new ConQueso(new SandwichItaliano()));
		//Producto tripleQueso = new ConQueso(new ConQueso(new ConQueso(new SandwichItaliano())));
		
		//caja.addProducto(italiano);
		//caja.addProducto(mexicano);
		//caja.addProducto(dobleQueso);
		
		//caja.imprimirFactura();
		
		//Memento antesTripleQueso = caja.creaEstado();
		//caja.addProducto(tripleQueso);
		
		//caja.imprimirFactura();
		
		//caja.restauraEstado(antesTripleQueso);
		
		//caja.imprimirFactura();
		
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
		caja.finalizarOrden();

		facturador.imprimir(caja.getOrden());
	}
}
