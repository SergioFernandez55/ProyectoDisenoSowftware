
public class SitioNulo implements SitioWeb {

	@Override
	public String getSitio() {
		return "";
	}

	@Override
	public boolean esNulo() {
		return true;
	}
}
