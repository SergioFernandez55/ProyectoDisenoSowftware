package restaurante.fabricas;

import restaurante.productos.Producto;
import restaurante.productos.SandwichItaliano;

public class SandwichItalianoFactory extends SandwichFactory{

	@Override
	protected Producto creaSandwich() {
		return new SandwichItaliano();
	}
}
