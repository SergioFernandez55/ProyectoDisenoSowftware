import java.util.ArrayList;

public interface SistemaSeguridad {

void rotarCamarasDerecha(ArrayList<Integer> numerosCamara);
void rotarCamarasIzquierda(ArrayList<Integer> numerosCamara);
void centrarCamaras(ArrayList<Integer> numerosCamara);
void setSistemaAccesos(SistemaAccesos sistemaAccesos);
void setDecoradorDeSistemaAccesos(DecoradorSistemaAccesos decoradorSistemaAccesos);
void setDecoradorProxyInternet(DecoradorProxyAccesoInternet decoradorProxyInternet);
void agregarCamarasCentroControl(int cantidadCamaras);
}
