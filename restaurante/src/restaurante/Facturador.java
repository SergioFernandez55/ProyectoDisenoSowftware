package restaurante;

public class Facturador {
	
	private String fecha;
	
	public Facturador() {
	}
	
	public String imprimir(Orden orden){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append( 
				"**************************************************\n" + 
				"\t\tRestaurante Planta Baja\n" +
			    "Fecha: " + new Tiempo().getFecha() + "\n" +
				"Detalle: \n " + orden.getDetalle()+ "\n\n" +
			    "--------------------------------------------------\n" +
			    "Precio total: " + orden.getPrecioTotal() + "\n" +
				 "--------------------------------------------------\n" + 
				"**************************************************\n" 
		);
		
		return buffer.toString();
	}

	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
