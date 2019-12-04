package restaurante.fabricas;

import restaurante.productos.Producto;
import restaurante.productos.SandwichMexicano;

public class SandwichMexicanoFactory extends SandwichFactory{

	@Override
	protected Producto creaSandwich() {
		return new SandwichMexicano();
	}
}
