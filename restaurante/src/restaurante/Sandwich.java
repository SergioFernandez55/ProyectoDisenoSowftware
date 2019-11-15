package restaurante;

public interface Sandwich {
	String descripcion();
	void setPrecio(double precio);
	void addIngredienteAdicional(Ingrediente ingrediente);
	double getPrecio();
}
