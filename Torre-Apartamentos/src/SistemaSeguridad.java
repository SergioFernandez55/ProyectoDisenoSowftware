import java.util.ArrayList;

public interface SistemaSeguridad {

void rotarCamarasDerecha(ArrayList<Integer> numerosCamara);
void rotarCamarasIzquierda(ArrayList<Integer> numerosCamara);
void centrarCamaras(ArrayList<Integer> numerosCamara);
void setSistemaAccesos(SistemaAccesos sistemaAccesos);
void setDecoradorDeSistemaAccesos(DecoradorSistemaAccesos decoradorSistemaAccesos);
void setDecoradorProxyInternet(DecoradorProxyAccesoInternet decoradorProxyInternet);
void setCentroControlCamaras(CentroControlCamaras centroControlCamaras);
void agregarCamarasCentroControl(int cantidadCamaras);
void revisarEstadoCamaras();
void registrarClienteEnCamara(int numeroCamara, String cedula);
void registrarClientesEnCamara(int numeroCamara, String... cedulasClientes);
boolean reconocePersona(String cedula);

}
