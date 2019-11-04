import java.io.Serializable;

public class SistemaIntegradoSeguridad implements Serializable {

	private static SistemaIntegradoSeguridad instancia;
	
	private CentroControlCamaras centroControlCamaras = new CentroControlCamaras();
	private SistemaAccesos sistemaAccesos = new SistemaAccesosTorre();
	private Registro registroEntrada = new RegistroEntrada();
	private Registro registroSalida = new RegistroSalida();
	private DecoradorSistemaAccesosTorre decoradorSistemaAccesos; // Cómo hacer que decore ambos tipos de registro?
	
	private SistemaIntegradoSeguridad(){	
	}
	
	public synchronized static SistemaIntegradoSeguridad getInstancia(){
		if(instancia == null){
			instancia = new SistemaIntegradoSeguridad();
		}
		return instancia;
	}
	
	public void guardarAcceso(){
	}
	
	public void guardarSalida(){
	}
	
	
	
	
	
	
	
	
	
	
	
}
