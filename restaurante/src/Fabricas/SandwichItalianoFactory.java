package Fabricas;

import Productos.Producto;
import Productos.SandwichItaliano;

public class SandwichItalianoFactory extends SandwichFactory{

	@Override
	protected Producto creaSandwich() {
		return new SandwichItaliano();
	}
}
