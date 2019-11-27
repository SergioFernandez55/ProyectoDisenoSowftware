

public abstract class FabricaVehiculos {

	public Vehiculo crea() {
		return creaVehiculo();
	}
	
	protected abstract Vehiculo creaVehiculo();
}
