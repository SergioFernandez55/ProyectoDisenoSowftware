
public class Tarjeta {

	private String numero;

	public Tarjeta(String numeroTarjeta) {
		this.numero = numeroTarjeta;
	}

	public String getNumero() {
		return this.numero;
	}

	// Método necesario para pruebas unitarias.
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
