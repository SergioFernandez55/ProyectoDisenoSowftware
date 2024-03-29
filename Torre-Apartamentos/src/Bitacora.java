import java.util.HashMap;

public class Bitacora {
	
	private HashMap<String, Integer> bitacoraClientes = new HashMap<String, Integer>();
	
	public int actualizar(String identificadorCliente) {
		
		if(this.bitacoraClientes.containsKey(identificadorCliente)) {
			this.bitacoraClientes.put(identificadorCliente, this.bitacoraClientes.get(identificadorCliente) + 1);
		}
		else {
			this.bitacoraClientes.put(identificadorCliente, 1);
		}
		
		return this.bitacoraClientes.get(identificadorCliente); // Devuelve la cantidad de accesos del cliente.
	}
}
