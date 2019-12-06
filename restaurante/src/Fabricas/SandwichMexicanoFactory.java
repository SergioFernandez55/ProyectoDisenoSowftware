package Fabricas;

import Productos.Producto;
import Productos.SandwichMexicano;

public class SandwichMexicanoFactory extends SandwichFactory{

	@Override
	protected Producto creaSandwich() {
		return new SandwichMexicano();
	}
}
