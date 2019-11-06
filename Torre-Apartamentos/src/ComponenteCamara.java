
public interface ComponenteCamara {
	
	void agregar(ComponenteCamara camara);
	void eliminar(ComponenteCamara camara);
	void rotarDerecha();
	void rotarIzquierda();
	void centrar();
	boolean reconocePersona(String cedula);
}
