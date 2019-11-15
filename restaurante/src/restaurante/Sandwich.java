package restaurante;

public interface Sandwich {
	String getDescripcion();
	void setPrecio(double precio);
	void addIngredienteAdicional(Ingrediente ingrediente);
	double getPrecio();
}
