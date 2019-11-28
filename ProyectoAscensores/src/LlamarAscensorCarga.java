
public class LlamarAscensorCarga extends TemplateLlamarAscensor{
	
	public boolean checkTipo(TipoAscensor tipo) {
		if(tipo == TipoAscensor.CARGA) {
			return true;
		}
		return false;
	}
	
}
