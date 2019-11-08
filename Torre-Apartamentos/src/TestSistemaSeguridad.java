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
	public void validacionSistemaVerificacionAutomatico() {
		
		this.sistemaSeguridad.registrarClientesEnCamara(3, "116870476");
		assertTrue("Numero de cedula registrado en camara 3",this.sistemaSeguridad.reconocePersona("116870476"));
		assertFalse("Numero de cedula no registrado en camara 5", this.sistemaSeguridad.reconocePersona("106580325"));
	}
	
	@Test
	public void validacionBloqueoInternetPorCantidadMaximaSitios() {
		
		final int CANTIDAD_MAXIMA_ACCESOS = 2;
		
		// Intento de primer acceso.
		SitioWeb sitio = this.decoradorAccesoInternet.accederSitio("116870476", "www.ecci.ucr.ac.cr", CANTIDAD_MAXIMA_ACCESOS);
		assertFalse("Sitio accedido: www.ecci.ucr.ac.cr", sitio.esNulo());
		
		// Intento de segundo acceso.
		sitio = this.decoradorAccesoInternet.accederSitio("116870476", "www.youtube.com", CANTIDAD_MAXIMA_ACCESOS);
		assertFalse("Sitio accedido: www.youtube.com", sitio.esNulo());
		
		
		// Intento de tercer acceso.
		sitio = this.decoradorAccesoInternet.accederSitio("116870476", "www.netflix.com", CANTIDAD_MAXIMA_ACCESOS);
		assertTrue("Sitio accedido: www.netflix.com", sitio.esNulo());
	}
	
	@Test
	public void validacionBloqueoPorSitioWebEnListaNegra(){
		
		final int CANTIDAD_MAXIMA_ACCESOS = 5;
		
		this.proxyAccesoInternet.agregarSitioWebAListaNegra("www.netflix.com");
		
		// Intento de acceso a sitio web no bloqueado.
		SitioWeb sitio = this.decoradorAccesoInternet.accederSitio("116870476", "www.ecci.ucr.ac.cr", CANTIDAD_MAXIMA_ACCESOS);
		assertFalse("Sitio accedido: www.ecci.ucr.ac.cr", sitio.esNulo());
		
		// Intento de accesso a sitio web bloqueado.
		sitio = this.decoradorAccesoInternet.accederSitio("116870476", "www.netflix.com", CANTIDAD_MAXIMA_ACCESOS);
		assertTrue("Sitio accedido: www.netflix.com", sitio.esNulo());
	}
}
