import java.util.ArrayList;

public class ProxyAccesoInternet implements Internet{

	private ArrayList<String> sitiosWebBloqueados = new ArrayList<String>();
	private Internet internet;
	
	public ProxyAccesoInternet(Internet internet) {
		this.internet = internet;
	}
	
	// El parámetro cantidad-maxima-accesos es necesario para las pruebas y debe ser eliminado.
	@Override
	public SitioWeb accederSitio(String identificadorCliente, String sitio, int cantidadMaximaAccesos) {
		if(this.sitiosWebBloqueados.contains(sitio)) {
			return new SitioNulo();
		}
		else {
			return this.internet.accederSitio(identificadorCliente, sitio, cantidadMaximaAccesos);
		}
	}
	
	public void agregarSitioWebAListaNegra(String sitio){
		this.sitiosWebBloqueados.add(sitio);
	}
}

