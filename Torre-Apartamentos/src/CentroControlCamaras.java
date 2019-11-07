import java.util.ArrayList;

public class CentroControlCamaras {
	
	private static final String ERROR_RECONOCIMIENTO = "Ninguna camara reconoce a la persona con cedula: ";
	private ArrayList<CamaraSeguridad> camaras = new ArrayList<>();
	private ComponenteCamara seleccion;
	
	
	public void agregarCamaraASistema(CamaraSeguridad camara) {
		this.camaras.add(camara);
	}
	
	public CentroControlCamaras() {
		this.seleccion = new ComposicionCamaras();
	}
	
	public boolean existeCamara(int numeroCamara) {
		for (CamaraSeguridad camara : this.camaras) {
			if(camara.getNumeroCamara() == numeroCamara) {
				return true;
			}
		}
		return false;
	}
	
	public void rotarCamarasDerecha() {
		this.seleccion.rotarDerecha();
	}
	
	public void rotarCamarasIzquierda() {
		this.seleccion.rotarIzquierda();
	}
	
	public void centrarCamaras() {
		this.seleccion.centrar();
	}
	
	public void seleccionarUnicaCamara(int numeroCamara){
		for (CamaraSeguridad camara : camaras) {
			if(camara.getNumeroCamara() == numeroCamara) {
				this.seleccion = camara;
			}
		}
	}
	
	public void crearSeleccionMultiple(){
		this.seleccion = new ComposicionCamaras();
	}
	
	public  ArrayList<CamaraSeguridad> getCamaras(){
		return this.camaras;
	}
	
	public void agregarCamaraSeleccion(int numeroCamara){
		
		for (CamaraSeguridad camara : camaras) {
			if(camara.getNumeroCamara() == numeroCamara) {
				seleccion.agregar(camara);
				break;
			}
		}	
	}
	
	public String reconocePersona(String cedula){
		for (CamaraSeguridad camara : this.camaras) {
			if(camara.reconocePersona(cedula)){
				return Integer.toString(camara.getNumeroCamara());
			}
		}
		return  ERROR_RECONOCIMIENTO + cedula;
	}
	
	public ArrayList<String> cedulasReconocidas(int id){
		
		for (CamaraSeguridad camara : camaras) {
			if(camara.getNumeroCamara() == id){
				return camara.cedulasReconocidas();
			}
		}
		return new ArrayList<String>();
	}
}
