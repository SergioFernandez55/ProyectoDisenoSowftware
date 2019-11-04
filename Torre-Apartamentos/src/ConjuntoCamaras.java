import java.util.ArrayList;

public class ConjuntoCamaras implements ComponenteCamara {
	
	private ArrayList<CamaraSeguridad> camaras;

	@Override
	public void agregar(CamaraSeguridad camara) {
		this.camaras.add(camara);
	}

	@Override
	public void eliminar(CamaraSeguridad camara) {
		this.camaras.remove(camara);
	}
	
	@Override
	public void rotarDerecha() {
		for (CamaraSeguridad camara : camaras) {
			camara.rotarDerecha();
		}
	}

	@Override
	public void rotarIzquierda() {
		for (CamaraSeguridad camara : camaras) {
			camara.rotarIzquierda();
		}
	}

	@Override
	public void centrar() {
		for (CamaraSeguridad camara : camaras) {
			camara.centrar();
		}
	}
}
