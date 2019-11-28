import java.util.ArrayList;
import java.util.List;

public class Registro {
	
	private List<String> registro = new ArrayList<>();
	
	public void agregar(String tarjeta, String tipoAcceso){
		this.registro.add(tarjeta + " " + new Tiempo().getFecha() + " " + tipoAcceso);
	}
	
	public List<String> obtener(){
		return this.registro;
	}
}