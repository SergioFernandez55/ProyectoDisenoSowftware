import java.util.ArrayList;

public interface SistemaSeguridad {

void rotarCamarasDerecha(Integer... numerosCamaras);
void rotarCamarasIzquierda(Integer... numerosCamara);
void centrarCamaras(Integer... numerosCamara);
void setSistemaAccesos(SistemaAccesos sistemaAccesos);
void setDecoradorDeSistemaAccesos(DecoradorSistemaAccesos decoradorSistemaAccesos);
void setDecoradorProxyInternet(DecoradorProxyAccesoInternet decoradorProxyInternet);
void setCentroControlCamaras(CentroControlCamaras centroControlCamaras);
void agregarCamarasCentroControl(int cantidadCamaras);
void revisarEstadoCamaras();
void registrarClientesEnCamara(int numeroCamara, String... cedulasClientes);
boolean reconocePersona(String cedula);

}
