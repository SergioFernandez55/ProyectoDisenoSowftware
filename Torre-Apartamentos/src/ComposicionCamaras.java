import java.util.ArrayList;

public class ComposicionCamaras implements ComponenteCamara {
	
	private ArrayList<ComponenteCamara> camaras;

	@Override
	public void agregar(ComponenteCamara camara) {
		this.camaras.add(camara);
	}

	@Override
	public void eliminar(ComponenteCamara camara) {
		this.camaras.remove(camara);
	}
	
	@Override
	public void rotarDerecha() {
		for (ComponenteCamara camara : camaras) {
			camara.rotarDerecha();
		}
	}

	@Override
	public void rotarIzquierda() {
		for (ComponenteCamara camara : camaras) {
			camara.rotarIzquierda();
		}
	}

	@Override
	public void centrar() {
		for (ComponenteCamara camara : camaras) {
			camara.centrar();
		}
	}

	@Override
	public boolean reconocePersona(String cedula) {
		for (ComponenteCamara camara : camaras) {
			if(camara.reconocePersona(cedula)){
				return true;
			}
		}
		return false;
	}
}
