package Pruebas;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import Caja.Caja;
import Caja.CajaRestaurante;
import Caja.Facturador;
import Caja.LineaPedido;
import Caja.Orden;
import Decoradores.ConTomate;
import Productos.Producto;
import Productos.SandwichMexicano;

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
	public void calcularPrecio() {

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
	public void cancelarUltimaLineaDePedido() {

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

		System.out.println("Antes de cancelar la ultima linea:\n");
		facturador.imprimir(caja.getOrden());

		this.caja.cancelarUltimaLineaDePedido();
		
		System.out.println("Despues de cancelar la ultima linea:\n");
		facturador.imprimir(caja.getOrden());

		Set<String> keys = caja.getOrden().getKeys();
		assertEquals(1, keys.size());
		assertTrue("Italiano Basico + Queso Adicional + Queso Adicional + Tomate Adicional", keys.contains("Italiano Basico + Queso Adicional + Queso Adicional + Tomate Adicional"));
	}
	
	@Test
	public void crearEstadoMemento() {
	
		String llave = "Mexicano Basico + Tomate Adicional";
		
		Producto sandwich = new ConTomate((new SandwichMexicano()));
		LineaPedido linea = new LineaPedido(sandwich);
		
		this.caja.addSandwichMexicano();
		this.caja.addTomateExtra();
		this.caja.confirmarLineaDePedido();
		
		this.caja.addSandwichItaliano();
		this.caja.confirmarLineaDePedido();
		
		String descripcionLineaRespaldo = this.caja.getOrden().getLineaPedido(llave).getDescripcion();
		
		assertEquals(linea.getDescripcion(), descripcionLineaRespaldo);
	}
	
	@Test
	public void cancelarOrdenDeUnSandwich(){
		
		this.caja.addNuevaLineaDePedido();
		this.caja.addSandwichItaliano();
		this.caja.addQuesoExtra();
		this.caja.confirmarLineaDePedido();
		
		Orden orden = this.caja.getOrden();
		assertTrue(!orden.estaVacia());
		
		this.caja.cancelarUltimaLineaDePedido();
		orden = this.caja.getOrden();
		assertTrue(orden.estaVacia());
	}
}
