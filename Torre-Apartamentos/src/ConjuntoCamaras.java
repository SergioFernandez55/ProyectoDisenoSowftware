import java.util.ArrayList;

public class ConjuntoCamaras implements Camaras {
	
	private ArrayList<Camara> camaras;

	@Override
	public void agregar(Camara camara) {
		this.camaras.add(camara);
	}

	@Override
	public void eliminar(Camara camara) {
		this.camaras.remove(camara);
	}
	
	@Override
	public void rotarDerecha() {
		for (Camara camara : camaras) {
			camara.rotarDerecha();
		}
	}

	@Override
	public void rotarIzquierda() {
		for (Camara camara : camaras) {
			camara.rotarIzquierda();
		}
	}

	@Override
	public void centrar() {
		for (Camara camara : camaras) {
			camara.centrar();
		}
	}
}
