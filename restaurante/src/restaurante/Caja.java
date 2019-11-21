package restaurante;

public interface Caja {

	void crearNuevaOrden();
	void addNuevaLineaDePedido();
	void cancelarUltimaLineaDePedido();
	void addSandwichMexicano();
	void addSandwichItalian();
	void addQuesoExtra();
	void addTomateExtra();
	void finalizarOrden();
	void generarInforme();
}
