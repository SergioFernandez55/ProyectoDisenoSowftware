
public class SistemaAccesosTorre implements SistemaAccesos{

	@Override
	public void entrarAlEdificio(Tarjeta tarjeta) {
		// L�gica que valida la tarjeta.
		System.out.println("Entrada al edificio. Numero de tarjeta " + tarjeta.getNumero() + ".");
	}

	@Override
	public void salirDelEdificio(Tarjeta tarjeta) {
		// L�gica que valida la tarjeta.
		System.out.println("Salida del edificio. Numero de tarjeta " + tarjeta.getNumero() + ".");
	}

}
