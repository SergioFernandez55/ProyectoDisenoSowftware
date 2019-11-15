package restaurante;

public class SandwichMexicanoFactory extends SandwichFactory{

	@Override
	protected Producto creaSandwitch() {
		return new SandwichMexicano();
	}
}
