import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSistemaSeguridad {

	final int CANTIDAD_CAMARAS = 10;
	// --- Decorador del sistema de accesos ---
	Registro registroEntrada;
	Registro registroSalida;
	SistemaAccesos sistemaAccesos;
	DecoradorSistemaAccesos decoradorSistemaAccesos;
	
	// --- Decorador del proxy de internet ---
	Internet accesoInternet;
	ProxyAccesoInternet proxyAccesoInternet;
	Bitacora bitacora;
	DecoradorProxyAccesoInternet decoradorAccesoInternet;
	
	CentroControlCamaras centroControlCamaras;
	SistemaIntegradoSeguridad sistemaSeguridad;
	
	@Before
	public void init() {
		
		this.registroEntrada = new RegistroEntrada();
		this.registroSalida = new RegistroSalida();
		this.sistemaAccesos = new SistemaAccesosTorre();
		this.decoradorSistemaAccesos = new DecoradorSistemaAccesos(sistemaAccesos, registroEntrada);
		
		this.accesoInternet = new AccesoInternet();
		this.bitacora = new Bitacora();
		this.proxyAccesoInternet = new ProxyAccesoInternet(this.accesoInternet);
		this.decoradorAccesoInternet = new DecoradorProxyAccesoInternet(this.proxyAccesoInternet, this.bitacora);
		
		this.centroControlCamaras = new CentroControlCamaras();
		
		this.sistemaSeguridad = SistemaIntegradoSeguridad.getInstancia();
		this.sistemaSeguridad.setDecoradorDeSistemaAccesos(this.decoradorSistemaAccesos);
		this.sistemaSeguridad.setDecoradorProxyInternet(this.decoradorAccesoInternet);
		this.sistemaSeguridad.setCentroControlCamaras(centroControlCamaras);
		this.sistemaSeguridad.agregarCamarasCentroControl(CANTIDAD_CAMARAS);
	}
	
	@Test
	public void validacion_sistema_identificacion_automatico() {
	}
	
	@Test
	public void verificacion_bloque_internet() {
		
	}
}
