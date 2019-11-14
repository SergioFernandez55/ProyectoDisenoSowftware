
public class DecoradorSistemaAccesos implements SistemaAccesos {
	
	private Registro registro;
	private SistemaAccesos sistemaAccesos;
	
	public  DecoradorSistemaAccesos(SistemaAccesos sistemaAccesos) {
		this.sistemaAccesos = sistemaAccesos;
	}
	
	@Override
	public void entrarAlEdificio(Tarjeta tarjeta) {
		this.sistemaAccesos.entrarAlEdificio(tarjeta);
		this.registro.agregar(tarjeta.getNumero(), "Entrada");
	}
	
	@Override
	public void salirDelEdificio(Tarjeta tarjeta) {
		this.sistemaAccesos.salirDelEdificio(tarjeta);
		this.registro.agregar(tarjeta.getNumero(), "Salida");
	}
	
	public void setRegistro(Registro registro) {
		this.registro = registro;
	}
}
