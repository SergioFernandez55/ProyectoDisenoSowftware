package restaurante;

public class SandwichItalianoFactory extends SandwichFactory{

	@Override
	protected Sandwich creaSandwitch() {
		return new SandwichItaliano();
	}

}
