import java.io.Serializable;
import java.util.ArrayList;

public class SistemaIntegradoSeguridad implements Serializable, SistemaSeguridad {

	private static final long serialVersionUID = 1L;
	private static SistemaIntegradoSeguridad instancia;

	private CentroControlCamaras centroControlCamaras = new CentroControlCamaras();
	private SistemaAccesos sistemaAccesos = new SistemaAccesosTorre();
	private Registro registroEntrada = new RegistroEntrada();
	private Registro registroSalida = new RegistroSalida();
	private DecoradorSistemaAccesos decoradorSistemaAccesos;
	private DecoradorProxyAccesoInternet decoradorProxyInternet;

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

	@Override
	public void setDecoradorProxyInternet(DecoradorProxyAccesoInternet decoradorProxyInternet) {
		this.decoradorProxyInternet = decoradorProxyInternet;
	}

	@Override
	public void setSistemaAccesos(SistemaAccesos sistemaAccesos) {
		this.sistemaAccesos = sistemaAccesos;
	}

	@Override
	public void setDecoradorDeSistemaAccesos(DecoradorSistemaAccesos decoradorSistemaAccesos) {
		this.decoradorSistemaAccesos = decoradorSistemaAccesos;
	}

	@Override
	public void agregarCamarasCentroControl(int cantidadCamaras) {
		for(int i = 1; i <= cantidadCamaras; ++i) {
			this.centroControlCamaras.agregarCamaraASistema(new CamaraSeguridad());
		}
	}

}
