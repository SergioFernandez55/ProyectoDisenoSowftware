package restaurante;

import static org.junit.Assert.*;

import org.junit.Test;

import restaurante.Caja.Memento;

public class PruebasRestaurante {

	@Test
	public void test() {
		
		Caja caja = new Caja();
		
		Producto italiano = new SandwichItaliano();
		Producto mexicano = new SandwichMexicano();
		Producto mexicanoQueso = new ConQueso(mexicano);
		Producto dobleQueso = new ConQueso(new ConQueso(new SandwichItaliano()));
		Producto tripleQueso = new ConQueso(new ConQueso(new ConQueso(new SandwichItaliano())));
		Producto tripleQueso2 = new ConQueso(new ConQueso(new ConQueso(new SandwichItaliano())));
		
		caja.addProducto(italiano);
		caja.addProducto(mexicano);
		caja.addProducto(mexicanoQueso);
		caja.addProducto(dobleQueso);
		
		caja.impirmirOrden();
		Memento antesTripleQueso = caja.creaEstado();
		
		caja.addProducto(tripleQueso);
		caja.addProducto(tripleQueso);
		
		caja.impirmirOrden();
		
		caja.restauraEstado(antesTripleQueso);
		caja.impirmirOrden();
		
		
	}

}
