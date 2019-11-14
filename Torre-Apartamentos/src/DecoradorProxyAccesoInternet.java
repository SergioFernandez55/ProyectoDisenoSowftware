
public class DecoradorProxyAccesoInternet implements Internet {

	private ProxyAccesoInternet proxyAccesoInternet;
	private Bitacora bitacoraClientes;

	public DecoradorProxyAccesoInternet(ProxyAccesoInternet proxyInternet) {
		this.proxyAccesoInternet = proxyInternet;
	}

	// El parámetro cantidad-maxima-accesos es necesario para las pruebas y debe ser
	// eliminado.
	@Override
	public SitioWeb accederSitio(String identificadorCliente, String sitio, int cantidadMaximaAccesos) {
		SitioWeb sitioCliente = this.proxyAccesoInternet.accederSitio(identificadorCliente, sitio, cantidadMaximaAccesos);

		if (!sitioCliente.esNulo()) {
			int cantidadAccesos = this.bitacoraClientes.actualizar(identificadorCliente);
			if (cantidadAccesos > cantidadMaximaAccesos) {
				return new SitioNulo();
			}
		}
		return sitioCliente;
	}
}
