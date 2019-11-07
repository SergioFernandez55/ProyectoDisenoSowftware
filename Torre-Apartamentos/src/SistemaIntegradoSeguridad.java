import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

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
	
	@Override
	public void rotarCamarasDerecha(ArrayList<Integer> numerosCamara) {

		for (Integer numeroCamara : numerosCamara) {
			if (centroControlCamaras.existeCamara(numeroCamara)) {
				centroControlCamaras.agregarCamaraSeleccion(numeroCamara);
			}
		}
		centroControlCamaras.rotarCamarasDerecha();
	}

	@Override
	public void rotarCamarasIzquierda(ArrayList<Integer> numerosCamara) {
		for (Integer numeroCamara : numerosCamara) {
			if (centroControlCamaras.existeCamara(numeroCamara)) {
				centroControlCamaras.agregarCamaraSeleccion(numeroCamara);
			}
		}
		centroControlCamaras.rotarCamarasIzquierda();
	}

	@Override
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
			this.centroControlCamaras.agregarCamaraASistema(new CamaraSeguridad(generarPosicionAleatoriaCamara()));
		}
	}

	@Override
	public void setCentroControlCamaras(CentroControlCamaras centroControlCamaras) {
		this.centroControlCamaras = centroControlCamaras;
	}

	@Override
	public void revisarEstadoCamaras() {
		
		ArrayList<CamaraSeguridad> camaras = this.centroControlCamaras.getCamaras();
		
		for (CamaraSeguridad camara : camaras) {
			System.out.println(camara.getNumeroCamara() + ": " + camara.getPosicionCamara() + "\n");
		}
	}
	
	public String generarPosicionAleatoriaCamara() {
		
		int aleatorio = ThreadLocalRandom.current().nextInt(1, 4);

		if(aleatorio == 1) {
			return "Centro";
		}else if(aleatorio == 2) {
			return "Izquierda";
		}
		else {
			return "Derecha";
		}
	}

	@Override
	public boolean reconocePersona(String cedula) {
		
		String resultado = this.centroControlCamaras.reconocePersona(cedula);
		
		if(resultado.equals("Ninguna camara reconoce a la persona con cedula: " + cedula)) {
			return false;
		}
		return true;
	}

	@Override
	public void registrarClienteEnCamara(int numeroCamara, String cedula) {
		
		if(this.centroControlCamaras.existeCamara(numeroCamara)) {
			this.centroControlCamaras.registrarClienteEnCamara(numeroCamara, cedula);
		}
	}

	@Override
	public void registrarClientesEnCamara(int numeroCamara, String... cedulasClientes) {
		
		if(this.centroControlCamaras.existeCamara(numeroCamara)) {
			for (String cedula : cedulasClientes) {
				this.centroControlCamaras.registrarClienteEnCamara(numeroCamara, cedula);
			}
		}
	}
}
