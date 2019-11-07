import java.util.ArrayList;

public class CamarasComposite implements CamaraComponent {
	
	private ArrayList<CamaraComponent> camaras;

	@Override
	public void agregar(CamaraComponent camara) {
		this.camaras.add(camara);
	}

	@Override
	public void eliminar(CamaraComponent camara) {
		this.camaras.remove(camara);
	}
	
	@Override
	public void rotarDerecha() {
		for (CamaraComponent camara : camaras) {
			camara.rotarDerecha();
		}
	}

	@Override
	public void rotarIzquierda() {
		for (CamaraComponent camara : camaras) {
			camara.rotarIzquierda();
		}
	}

	@Override
	public void centrar() {
		for (CamaraComponent camara : camaras) {
			camara.centrar();
		}
	}

	@Override
	public boolean reconocePersona(String cedula) {
		for (CamaraComponent camara : camaras) {
			if(camara.reconocePersona(cedula)){
				return true;
			}
		}
		return false;
	}
}
