package restaurante;

import java.util.ArrayList;

public abstract class SandwichBase {
	
	private String pan;
	private String carne;
	private ArrayList<Ingrediente> ingredientesAdicionales;
	
	public SandwichBase() {
	}
	
	public void agregarIngrediente(Ingrediente adicional) {
	}
	
	public void removerIngrediente() {
	}
}
