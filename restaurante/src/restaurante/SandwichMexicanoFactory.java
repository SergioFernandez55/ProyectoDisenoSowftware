package restaurante;

public class SandwichMexicanoFactory extends SandwichFactory{

	@Override
	protected Sandwich creaSandwitch() {
		return new SandwichMexicano();
	}

}
