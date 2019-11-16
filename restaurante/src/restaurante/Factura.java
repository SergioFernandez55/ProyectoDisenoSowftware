package restaurante;

public class Factura {
	
	private String fecha;
	private String detalle;
	private String precioTotal;
	
	public Factura(Orden orden) {
		this.setFecha( new Tiempo().getFecha());
		this.setDetalle(orden.getDetalle());
		this.setPrecioTotal(orden.getPrecioTotal());
	}
	
	public String imprimir(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append( 
				"**************************************************" + 
				"\t\t***** Restaurante Planta Baja *****\n" +
			    "Fecha: " + this.getFecha() + "\n" +
				"Detalle: \n " + this.getDetalle()+ "\n\n" +
			    "--------------------------------------------------"+
			    "Precio total: " + this.getPrecioTotal() +
				 "--------------------------------------------------" + 
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
	
	public String getDetalle() {
		return detalle;
	}
	
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	public String getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = Double.toString(precioTotal);
	}
	
	
}
