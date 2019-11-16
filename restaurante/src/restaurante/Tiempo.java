package restaurante;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Tiempo {
	
	private DateTimeFormatter formateadorFecha = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	
	public String getFecha() {
		LocalDateTime tiempoHoraActual = LocalDateTime.now();
		return this.formateadorFecha.format(tiempoHoraActual);
	}
}
