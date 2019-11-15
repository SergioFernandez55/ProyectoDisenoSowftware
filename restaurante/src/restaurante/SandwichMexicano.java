package restaurante;

public class SandwichMexicano extends BaseMexicano implements Sandwich {

	@Override
	public String descripcion() {
		return this.getPan() +  " " + getCarne();
	}
	
	@Override
	public void addIngredienteAdicional(Ingrediente ingrediente) {
		this.addIngrediente(ingrediente);
	}
	
	@Override
	public double getPrecio(){
		return this.getPrecio();
	}
	
	@Override
	public void setPrecio(double precio){
		this.setPrecio(precio);
	}
	
}
