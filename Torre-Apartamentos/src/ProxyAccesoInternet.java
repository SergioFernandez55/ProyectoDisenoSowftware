import java.util.ArrayList;

public class ProxyAccesoInternet implements Internet{

	private ArrayList<String> sitiosWebBloqueados;
	private Internet internet;
	
	public ProxyAccesoInternet(Internet internet) {
		this.internet = internet;
	}
	
	@Override
	public SitioWeb accederSitio(String sitioWeb) {
		
		if(this.sitiosWebBloqueados.contains(sitioWeb)) {
			return new SitioNulo();
		}
		else {
			return this.internet.accederSitio(sitioWeb);
		}
	}
}

