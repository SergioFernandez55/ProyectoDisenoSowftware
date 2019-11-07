import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<CamaraSeguridad> camaras = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++) {
			camaras.add(new CamaraSeguridad());
		}
		
		for (CamaraSeguridad camara : camaras) {
			System.out.println(camara.getNumeroCamara());
		}
		
	}
}
