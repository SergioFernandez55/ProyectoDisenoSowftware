
public class Tarjeta {

	private String numero;

	public Tarjeta(String numeroTarjeta) {
		this.numero = numeroTarjeta;
	}

	public String getNumero() {
		return this.numero;
	}

	// M�todo necesario para pruebas unitarias.
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
