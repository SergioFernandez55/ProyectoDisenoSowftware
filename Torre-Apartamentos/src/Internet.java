
public interface Internet {
	
	// El parámetro cantidad-maxima-accesos es necesario para las pruebas y debe ser eliminado.
	SitioWeb accederSitio(String identificadorCliente, String sitio, int cantidadMaximaAccesos);
}
