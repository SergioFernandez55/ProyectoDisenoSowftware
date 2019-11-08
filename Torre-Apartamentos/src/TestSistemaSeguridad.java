import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TestSistemaSeguridad {

	final int CANTIDAD_CAMARAS = 5;
	
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
		
		// Registro de multiples clientes en una camara.
		this.sistemaSeguridad.registrarClientesEnCamara(2,"111111111","222222222" ,"333333333");
	}
	
	@Test
	public void validacion_sistema_identificacion_automatico() {
		
		this.sistemaSeguridad.revisarEstadoCamaras();
		
		this.sistemaSeguridad.registrarClientesEnCamara(3, "116870476");
		assertTrue("Numero de cedula registrado en camara 3",this.sistemaSeguridad.reconocePersona("116870476"));
		assertFalse("Numero de cedula no registrado en camara 5", this.sistemaSeguridad.reconocePersona("106580325"));
	}
	
	@Test
	public void verificacion_bloqueo_internet() {
		
	}
}
