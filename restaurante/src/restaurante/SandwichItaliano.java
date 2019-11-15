package restaurante;

public class SandwichItaliano extends BaseItaliano implements Sandwich{

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