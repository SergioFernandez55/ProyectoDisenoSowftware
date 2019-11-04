
public class SitioNormal implements SitioWeb {

	private String sitio;
	
	public SitioNormal(String sitio) {
		this.sitio = sitio;
	}
	
	@Override
	public String getSitio() {
		return this.sitio;
	}

	@Override
	public boolean esNulo() {
		return false;
	}
}
