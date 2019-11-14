import java.util.ArrayList;
import java.util.List;

public class Registro {
	
	private List<String> registro = new ArrayList<>();
	private Tiempo tiempo;
	
	public void agregar(String tarjeta, String tipoAcceso){
		this.registro.add(tarjeta + " " + this.tiempo.getFecha() + " " + tipoAcceso);
	}
	
	public List<String> obtener(){
		return this.registro;
	}
}