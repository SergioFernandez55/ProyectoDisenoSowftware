import java.util.ArrayList;
import java.util.List;

public abstract class Registro {
	
	private List<String> registro = new ArrayList<>();
	private Tiempo tiempo;
	
	public void agregar(String tarjeta){
		this.registro.add(tarjeta + " " + this.tiempo.getFecha() + " " + tipoAcceso());
	}
	
	public List<String> obtener(){
		return this.registro;
	}
	
	public abstract String tipoAcceso();
}