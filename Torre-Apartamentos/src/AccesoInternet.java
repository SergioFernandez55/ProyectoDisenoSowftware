
public class AccesoInternet implements Internet {
	
	@Override
	public SitioWeb accederSitio(String sitioWeb) {
		// Lógica de conexión a internet.
		return new SitioNormal(sitioWeb);
	}
}
