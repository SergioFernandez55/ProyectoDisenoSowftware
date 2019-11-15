package restaurante;

import java.util.ArrayList;

public abstract class Base {
	
	private String pan;
	private String carne;
	private double precio;
	private ArrayList<Ingrediente> ingredientes = new ArrayList<>();
	
	public void setPan(String pan) {
		this.pan = pan;
	}
	
	public void setCarne(String carne) {
		this.carne = carne;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public void addIngrediente(Ingrediente ingrediente){
		this.ingredientes.add(ingrediente);
	}
	
	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	
	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public String getPan() {
		return pan;
	}
	
	public String getCarne() {
		return carne;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
