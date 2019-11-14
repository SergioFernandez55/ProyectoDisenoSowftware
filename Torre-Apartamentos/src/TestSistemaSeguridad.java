import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestSistemaSeguridad {

	final int CANTIDAD_CAMARAS = 5;
	
	// --- Decorador del sistema de accesos ---
	Registro registro;
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
		
		this.accesoInternet = new AccesoInternet();
		this.bitacora = new Bitacora();
		this.proxyAccesoInternet = new ProxyAccesoInternet(this.accesoInternet);
		this.decoradorAccesoInternet = new DecoradorProxyAccesoInternet(this.proxyAccesoInternet);
		this.decoradorAccesoInternet.setBitacora(bitacora);
		
		this.centroControlCamaras = new CentroControlCamaras();
		
		this.sistemaSeguridad = SistemaIntegradoSeguridad.getInstancia();
		
		this.sistemaSeguridad.setDecoradorProxyInternet(this.decoradorAccesoInternet);
		this.sistemaSeguridad.setCentroControlCamaras(centroControlCamaras);
		
		this.sistemaSeguridad.agregarCamarasCentroControl(CANTIDAD_CAMARAS);
		
		// Registro de multiples clientes en una camara.
		this.sistemaSeguridad.registrarClientesEnCamara(2,"111111111","222222222" ,"333333333");
	}
	
	@Test
	public void validacionEstadoCamarasLuegoComando(){
		
		// Estado inicial de las cámaras.
		System.out.println("Estado inicial de las camaras:\n");
		this.sistemaSeguridad.revisarEstadoCamaras();
		
		this.sistemaSeguridad.rotarCamarasDerecha(1,3,5);
		System.out.println("Camaras 1,3,5 rotadas hacia la derecha:\n");
		this.sistemaSeguridad.revisarEstadoCamaras();
		
		this.sistemaSeguridad.centrarCamaras(1,3,5);
		System.out.println("Camaras 1,3,5 centradas:\n");
		this.sistemaSeguridad.revisarEstadoCamaras();
		
		this.sistemaSeguridad.rotarCamarasIzquierda(1,3,5);
		System.out.println("Camaras 1,3,5 rotadas hacia la izquierda:\n");
		this.sistemaSeguridad.revisarEstadoCamaras();
	}
	
	@Test
	public void validacionSistemaReconocimientoAutomatico() {
		
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
