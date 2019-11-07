import java.io.Serializable;
import java.util.ArrayList;

public class SistemaIntegradoSeguridad implements Serializable {

	public enum Posicion {

	}

	private static SistemaIntegradoSeguridad instancia;

	private CentroControlCamaras centroControlCamaras = new CentroControlCamaras();
	private SistemaAccesos sistemaAccesos = new SistemaAccesosTorre();
	private Registro registroEntrada = new RegistroEntrada();
	private Registro registroSalida = new RegistroSalida();
	private DecoradorSistemaAccesosTorre decoradorSistemaAccesos;

	private SistemaIntegradoSeguridad() {
	}

	public synchronized static SistemaIntegradoSeguridad getInstancia() {
		if (instancia == null) {
			instancia = new SistemaIntegradoSeguridad();
		}
		return instancia;
	}

	public void crearCamaras(int cantidadCamaras) {

	}

	public void rotarCamarasDerecha(ArrayList<Integer> numerosCamara) {

		for (Integer numeroCamara : numerosCamara) {
			if (centroControlCamaras.existeCamara(numeroCamara)) {
				centroControlCamaras.agregarCamaraSeleccion(numeroCamara);
			}
		}
		centroControlCamaras.rotarCamarasDerecha();
	}

	public void rotarCamarasIzquierda(ArrayList<Integer> numerosCamara) {
		for (Integer numeroCamara : numerosCamara) {
			if (centroControlCamaras.existeCamara(numeroCamara)) {
				centroControlCamaras.agregarCamaraSeleccion(numeroCamara);
			}
		}
		centroControlCamaras.rotarCamarasIzquierda();
	}

	public void centrarCamaras(ArrayList<Integer> numerosCamara) {
		for (Integer numeroCamara : numerosCamara) {
			if (centroControlCamaras.existeCamara(numeroCamara)) {
				centroControlCamaras.agregarCamaraSeleccion(numeroCamara);
			}
		}
		centroControlCamaras.centrarCamaras();
	}

	public void setSistemaAccesos(SistemaAccesos sistemaAccesos) {
		this.sistemaAccesos = sistemaAccesos;
	}
	
	public void set(SistemaAccesos sistemaAccesos) {
		this.sistemaAccesos = sistemaAccesos;
	}
	
	public void set(SistemaAccesos sistemaAccesos) {
		this.sistemaAccesos = sistemaAccesos;
	}
	
	public void setSistemaAccesos(SistemaAccesos sistemaAccesos) {
		this.sistemaAccesos = sistemaAccesos;
	}

}
