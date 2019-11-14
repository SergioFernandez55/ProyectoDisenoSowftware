package restaurante;

import java.util.ArrayList;

public abstract class SandwichBase {
	
	private String pan;
	private String carne;
	private ArrayList<IngredienteAdicional> ingredientesAdicionales;
	
	public SandwichBase() {
	}
	
	public void agregarIngrediente(IngredienteAdicional adicional) {
	}
	
	public void removerIngrediente() {
	}
}
