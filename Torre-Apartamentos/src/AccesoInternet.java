
public class AccesoInternet implements Internet {
	
	// El parámetro cantidad-maxima-accesos es necesario para las pruebas y debe ser eliminado.
	@Override
	public SitioWeb accederSitio(String identificadorCliente, String sitio, int cantidadMaximaAccesos) {
		// Lógica de conexión a internet.
		return new SitioNormal(sitio);
	}
}
