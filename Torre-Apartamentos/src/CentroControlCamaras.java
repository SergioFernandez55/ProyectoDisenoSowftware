import java.util.ArrayList;

public class CentroControlCamaras {
	
	private static final String ERROR_RECONOCIMIENTO = "Ninguna camara reconoce a la persona con c�dula: ";
	private ArrayList<CamaraSeguridad> camaras = new ArrayList<>();
	private ComponenteCamara seleccion;
	
	public void seleccionarUnicaCamara(int id){
		this.seleccion = new CamaraSeguridad();
	}
	
	public void crearSeleccionMultiple(){
		this.seleccion = new ConjuntoCamaras();
	}
	
	public void agregarCamaraSeleccion(CamaraSeguridad camara){
		seleccion.agregar(camara);
	}
	
	public String reconocePersona(String cedula){
		for (CamaraSeguridad camara : this.camaras) {
			if(camara.reconocePersona(cedula)){
				return Integer.toString(camara.getIdentificador());
			}
		}
		return  ERROR_RECONOCIMIENTO + cedula;
	}
	
	public ArrayList<String> cedulasReconocidas(int id){
		
		for (CamaraSeguridad camara : camaras) {
			if(camara.getIdentificador() == id){
				return camara.cedulasReconocidas();
			}
		}
		return new ArrayList<String>();
	}
}
