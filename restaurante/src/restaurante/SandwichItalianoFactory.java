package restaurante;

public class SandwichItalianoFactory extends SandwichFactory{

	@Override
	protected Producto creaSandwitch() {
		return new SandwichItaliano();
	}
}
