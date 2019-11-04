import java.util.ArrayList;

public class CentroControlCamaras {
	
	private static final String ERROR_RECONOCIMIENTO = "Ninguna camara reconoce a la persona con cédula: ";
	private ArrayList<Camara> camaras = new ArrayList<>();
	private Camaras seleccion;
	
	public void seleccionarUnicaCamara(int id){
		this.seleccion = new Camara();
	}
	
	public void crearSeleccionMultiple(){
		this.seleccion = new ConjuntoCamaras();
	}
	
	public void agregarCamaraSeleccion(Camara camara){
		seleccion.agregar(camara);
	}
	
	public String reconocePersona(String cedula){
		for (Camara camara : this.camaras) {
			if(camara.reconocePersona(cedula)){
				return Integer.toString(camara.getIdentificador());
			}
		}
		return  ERROR_RECONOCIMIENTO + cedula;
	}
	
	public ArrayList<String> cedulasReconocidas(int id){
		
		for (Camara camara : camaras) {
			if(camara.getIdentificador() == id){
				return camara.cedulasReconocidas();
			}
		}
		return new ArrayList<String>();
	}
}
