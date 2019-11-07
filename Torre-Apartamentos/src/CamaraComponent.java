
public interface CamaraComponent {
	
	void agregar(CamaraComponent camara);
	void eliminar(CamaraComponent camara);
	void rotarDerecha();
	void rotarIzquierda();
	void centrar();
	boolean reconocePersona(String cedula);
}
