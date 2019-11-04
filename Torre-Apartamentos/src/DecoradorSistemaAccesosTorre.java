
public class DecoradorSistemaAccesosTorre implements SistemaAccesos {
	
	private Registro registro;
	private SistemaAccesos sistemaAccesos;
	
	public  DecoradorSistemaAccesosTorre(SistemaAccesos sistemaAccesos, Registro registro) {
		this.sistemaAccesos = sistemaAccesos;
		this.registro = registro;
	}
	
	@Override
	public void entrarAlEdificio(Tarjeta tarjeta) {
		this.sistemaAccesos.entrarAlEdificio(tarjeta);
		this.registro.agregar(tarjeta.getNumero());
	}
	
	@Override
	public void salirDelEdificio(Tarjeta tarjeta) {
		this.sistemaAccesos.salirDelEdificio(tarjeta);
		this.registro.agregar(tarjeta.getNumero());
	}
}
