import java.util.ArrayList;

public class CamaraSeguridad implements CamaraComponent {
	
	private ArrayList<String> cedulas = new ArrayList<>();
	private String posicionCamara;
	
	private static int identificador_unico = 0;
	private int identificador = ++ identificador_unico;
	
	public CamaraSeguridad(String posicionCamara) {
		this.posicionCamara = posicionCamara;
	}
	
	@Override
	public void agregar(CamaraComponent camara) {}

	@Override
	public void eliminar(CamaraComponent camara) {}
	
	@Override
	public void rotarDerecha() {
		this.posicionCamara = "Derecha";
	}

	@Override
	public void rotarIzquierda() {
		this.posicionCamara = "Izquierda";
	}

	@Override
	public void centrar() {
		this.posicionCamara = "Centro";
	}
	
	public boolean reconocePersona(String cedula) {
		return this.cedulas.contains(cedula);
	}
	
	public ArrayList<String> cedulasReconocidas(){
		return this.cedulas;
	}
	
	// M�todo necesario para pruebas unitarias.
	public void setNumeroCamara(int id) {
		this.identificador = id;
	}
	
	// M�todo necesario para pruebas unitarias.
	public void setPersonaIdentificada(String cedula) {
		this.cedulas.add(cedula);
	}
	
	public int getNumeroCamara(){
		return this.identificador;
	}
	
	public String getPosicionCamara() {
		return this.posicionCamara;
	}
}
