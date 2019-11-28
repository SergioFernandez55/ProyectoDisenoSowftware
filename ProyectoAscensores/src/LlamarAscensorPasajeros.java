
public class LlamarAscensorPasajeros extends TemplateLlamarAscensor{
	
	public boolean checkTipo(TipoAscensor tipo) {
		if(tipo == TipoAscensor.PASAJEROS) {
			return true;
		}
		return false;
	}
}
