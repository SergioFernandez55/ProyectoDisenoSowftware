
public class DecoradorSistemaAccesos implements SistemaAccesos {
	
	private Registro registro;
	private SistemaAccesos sistemaAccesos;
	
	public  DecoradorSistemaAccesos(SistemaAccesos sistemaAccesos, Registro registro) {
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
	
	public void setRegistro(Registro registro) {
		this.registro = registro;
	}
}
