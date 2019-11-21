package restaurante;

public class Facturador {
	
	private String fecha;
	
	public void imprimir(Orden orden){
		
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
		
		System.out.println(buffer.toString());
	}

	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
