import java.util.ArrayList;

public class CamaraSeguridad implements ComponenteCamara {
	
	private String ubicacion;
	private ArrayList<String> cedulas = new ArrayList<>();
	private String posicion;
	
	private static int identificador_unico = 0;
	private int identificador = ++ identificador_unico;
	
	@Override
	public void agregar(ComponenteCamara camara) {}

	@Override
	public void eliminar(ComponenteCamara camara) {}
	
	@Override
	public void rotarDerecha() {
		this.posicion = "Derecha";
	}

	@Override
	public void rotarIzquierda() {
		this.posicion = "Izquierda";
	}

	@Override
	public void centrar() {
		this.posicion = "Centro";
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
}
