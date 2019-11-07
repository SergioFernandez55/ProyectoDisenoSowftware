import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSistemaSeguridad {

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
		
		this.sistemaSeguridad = SistemaIntegradoSeguridad.getInstancia();
		this.sistemaSeguridad.setDecoradorDeSistemaAccesos(this.decoradorSistemaAccesos);
		this.sistemaSeguridad.setDecoradorProxyInternet(this.decoradorAccesoInternet);
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
