package restaurante;

import static org.junit.Assert.*;

import org.junit.Test;

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
		
		System.out.println(tripleQueso.getPrecio());
		
		caja.addProducto(italiano);
		caja.addProducto(mexicano);
		caja.addProducto(mexicanoQueso);
		caja.addProducto(dobleQueso);
		caja.addProducto(tripleQueso);
		caja.addProducto(tripleQueso);
		
	}

}
