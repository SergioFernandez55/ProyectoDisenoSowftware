package Caja;

public interface Caja {

	void crearNuevaOrden();
	void addNuevaLineaDePedido();
	void cancelarUltimaLineaDePedido();
	void confirmarLineaDePedido();
	void addSandwichMexicano();
	void addSandwichItaliano();
	void addQuesoExtra();
	void addTomateExtra();
	void finalizarOrden();
	Orden getOrden();
	
	// Métodos utilizados en pruebas.
	Orden getRespaldoDeOrden();
}
