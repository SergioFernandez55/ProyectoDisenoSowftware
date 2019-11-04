import java.util.ArrayList;

public class Camara implements Camaras {
	
	private String ubicacion;
	private ArrayList<String> cedulas = new ArrayList<>();
	private String posicion;
	private int identificador;
	
	@Override
	public void agregar(Camara camara) {}

	@Override
	public void eliminar(Camara camara) {}
	
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
	
	// Método necesario para pruebas unitarias.
	public void setIdentificador(int id) {
		this.identificador = id;
	}
	
	// Método necesario para pruebas unitarias.
	public void setPersonaIdentificada(String cedula) {
		this.cedulas.add(cedula);
	}
	
	public int getIdentificador(){
		return this.identificador;
	}
	
}
